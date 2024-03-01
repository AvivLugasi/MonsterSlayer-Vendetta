package controller;

import model.entities.Entity;
import model.entities.Player;
import model.entities.enums.EntityDirections;
import view.Utils;
import controller.interfaces.EntityController;

import java.awt.*;

import static data.gameSettings.GameSettingsMacros.*;
import static data.gameSettings.PlayerSettingsMacros.*;
import static model.entities.enums.EntityDirections.*;

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
            this.player.setDirection(RIGHT);
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
            System.out.println("Expected to get Graphics2D instance");
        }
    }

    private void draw(Graphics2D graphics2D){
        this.utils.draw(graphics2D, this);
    }

    @Override
    public Entity getEntity() {
        return this.player;
    }

    public String getAnimations(){
        String animationsPath;
        animationsPath = getMovementAnimations();
        return animationsPath;
    }

    private String getMovementAnimations(){
        if (this.player.getStatic()) {
            switch (this.player.getDirection()) {
                case UP:
                case RIGHT:
                    return getMovementsPathStatics(RIGHT);
                case LEFT:
                case DOWN:
                    return getMovementsPathStatics(LEFT);
            }
        } else {
            switch (this.player.getDirection()) {
                case UP:
                case RIGHT:
                    return getMovementsPathDynamic(RIGHT);
                case LEFT:
                case DOWN:
                    return getMovementsPathDynamic(LEFT);
            }
        }
        return null;
    }

    private String getMovementsPathStatics(EntityDirections direction){
        if(this.player.spriteID >= STATIC_SPRITES_NUM_RIGHT || this.player.spriteID >= STATIC_SPRITES_NUM_LEFT){
            this.player.spriteID = 0;
        }
        if(direction == RIGHT){
            this.player.spriteNum = STATIC_SPRITES_NUM_RIGHT;
            return PLAYER_ARMORED_STATIC_STAND_RIGHT_PREFIX;
        }
        this.player.spriteNum = STATIC_SPRITES_NUM_LEFT;
        return PLAYER_ARMORED_STATIC_STAND_LEFT_PREFIX;
    }

    private String getMovementsPathDynamic(EntityDirections direction){
        if(this.player.spriteID >= MOVEMENT_SPRITES_NUM){
            this.player.spriteID = 0;
        }
        this.player.spriteNum = MOVEMENT_SPRITES_NUM;
        if(direction == RIGHT){
            return PLAYER_ARMORED_MOVEMENT_RIGHT_PREFIX;
        }
        return PLAYER_ARMORED_MOVEMENT_LEFT_PREFIX;
    }
}
