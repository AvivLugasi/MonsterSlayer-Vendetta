package controller;

import model.entities.Entity;
import model.entities.Player;
import model.entities.enums.EntityDirections;
import view.Utils;
import view.gui.interfaces.EntityController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static data.gameSettings.GameSettingsMacros.*;
import static data.gameSettings.PlayerSettingsMacros.*;

/**
 * Control the model.Player class status and paints it
 */
public class PlayerController implements EntityController {

    /**
     * Entity of the model.Player class
     */
    private final Player player;

    /**
     * input handler for handling user inputs from the gamePanel instance that uses this controller
     */
    private final InputHandler inputHandler;

    public Utils utils = new Utils();


    /**
     * initialize the Controller
     * @param inputHandler (InputHandler) - input handler for handling user inputs
     */
    public PlayerController(InputHandler inputHandler){
        // setting default position at the center of the screen
        int x = (DEFAULT_TILE_SIZE*MAX_SCREEN_COL/2)-DEFAULT_TILE_SIZE/2;
        int y = (DEFAULT_TILE_SIZE*MAX_SCREEN_ROW/2)-DEFAULT_TILE_SIZE/2;
        this.player = new Player(x, y, INITIAL_PLAYER_HEALTH, INITIAL_PLAYER_SPEED, PLAYER_TILE_SIZE, PLAYER_TILE_SIZE);
        this.inputHandler = inputHandler;
    }

    /**
     * Update status of the player
     */
    public void update(){
        handleMovement();
    }

    /**
     * update the player position on the screen.
     * listen to the following keys:
     * - W and UP<br>
     * - S and DOWN<br>
     * - D and RIGHT<br>
     * - A and LEFT<br>
     */
    private void handleMovement(){
        int current_x = this.player.getPositionX();
        int current_y = this.player.getPositionY();
        int speed = this.player.getSpeed();
        // we assume the player isn't static, if no movement key was pressed then
        // we will set isStatic = false
        this.player.setStatic(false);
        if(this.inputHandler.getUp()){
            this.player.setPositionY(current_y - speed);
            this.player.setDirection(EntityDirections.UP);
        }else if(this.inputHandler.getLeft()){
            this.player.setPositionX(current_x - speed);
            this.player.setDirection(EntityDirections.LEFT);
        }else if(this.inputHandler.getDown()){
            this.player.setPositionY(current_y + speed);
            this.player.setDirection(EntityDirections.DOWN);
        }else if(this.inputHandler.getRight()){
            this.player.setPositionX(current_x + speed);
            this.player.setDirection(EntityDirections.RIGHT);
        } else{
            this.player.setStatic(true);
        }
    }

    /**
     * paint the player entity on the screen based on the updated status
     * @param graphics2D
     */
    public void paintComponent(Graphics2D graphics2D){
        try {
            this.draw(graphics2D);
            graphics2D.dispose();
        } catch(IllegalArgumentException e){
            //System.out.println("Expected to get Graphics2D instance");
        }
    }

    private void draw(Graphics2D graphics2D){
        this.utils.draw(graphics2D, this);
    }

    @Override
    public Entity getEntity() {
        return this.player;
    }

    public ArrayList<String> getAnimations(){
        ArrayList<String> animationsPathsList = null;
        switch(this.player.getDirection()){
            case UP:
                animationsPathsList = new ArrayList<>(Arrays.asList(PLAYER_ARMORED_STATIC_STAND_UP));
                break;
            case DOWN:
                animationsPathsList = new ArrayList<>(Arrays.asList(PLAYER_ARMORED_STATIC_STAND_DOWN));
                break;
            case LEFT:
                animationsPathsList = new ArrayList<>(Arrays.asList(PLAYER_ARMORED_STATIC_STAND_LEFT));
                break;
            case RIGHT:
                animationsPathsList = new ArrayList<>(Arrays.asList(PLAYER_ARMORED_STATIC_STAND_RIGHT));
                break;
        }
        return animationsPathsList;
    }

}
