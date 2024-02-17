package controller;

import model.Player;

import java.awt.*;

/**
 * Control the model.Player class status and paints it
 */
public class PlayerController{

    /**
     * Entity of the model.Player class
     */
    private Player player;

    /**
     * input handler for handling user inputs from the gamePanel instance that uses this controller
     */
    private InputHandler inputHandler;


    /**
     * initialize the Controller
     * @param inputHandler (InputHandler) - input handler for handling user inputs
     */
    public PlayerController(InputHandler inputHandler){
        this.player = new Player();
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
