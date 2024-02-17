package controller;

import model.Player;

import java.awt.*;

public class PlayerController {

    private Player player;

    private InputHandler inputHandler;


    public PlayerController(InputHandler inputHandler){
        this.player = new Player();
        this.inputHandler = inputHandler;
    }

    public void update(){
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
