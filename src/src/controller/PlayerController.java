package controller;

import model.entities.Player;

import java.awt.*;

import static data.gameSettings.GameSettingsMacros.*;
import static data.gameSettings.PlayerSettingsMacros.*;

/**
 * Control the model.Player class status and paints it
 */
public class PlayerController{

    /**
     * Entity of the model.Player class
     */
    private final Player player;

    /**
     * input handler for handling user inputs from the gamePanel instance that uses this controller
     */
    private final InputHandler inputHandler;


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

        if(this.inputHandler.getUp()){
            this.player.setPositionY(current_y - speed);
        }else if(this.inputHandler.getLeft()){
            this.player.setPositionX(current_x - speed);
        }else if(this.inputHandler.getDown()){
            this.player.setPositionY(current_y + speed);
        }else if(this.inputHandler.getRight()){
            this.player.setPositionX(current_x + speed);
        }
    }

    /**
     * paint the player entity on the screen based on the updated status
     * @param graphics2D
     */
    public void paintComponent(Graphics2D graphics2D){
        try {
            graphics2D.setColor(Color.white);
            graphics2D.fillRect(this.player.getPositionX(),
                    this.player.getPositionY(),
                    this.player.getWidth(),
                    this.player.getHeight());
            graphics2D.dispose();
        } catch(IllegalArgumentException e){
            System.out.println("Expected to get Graphics2D instance");
        }
    }

}
