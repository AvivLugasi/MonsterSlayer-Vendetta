package model.entities;

import static data.gameSettings.GameSettingsMacros.*;
import static data.gameSettings.GameSettingsMacros.DEFAULT_TILE_SIZE;
import static data.gameSettings.PlayerSettingsMacros.*;
import static data.gameSettings.PlayerSettingsMacros.PLAYER_TILE_SIZE;

public class Entity {
    /**
     * Entity's x coordinates on the screen
     */
    private int positionX;

    /**
     * Entity's y coordinates on the screen
     */
    private int positionY;

    /**
     * Entity's tile width on the screen
     */
    private final int width;

    /**
     * Entity's tile height on the screen
     */
    private final int height;

    /**
     * Entity's health
     */
    private int health;

    /**
     * Entity's speed - define how fast it changes position on the screen
     */
    private int speed;

    /**
     * Initialize the Entity
     */
    public Entity(int x,
                  int y,
                  int health,
                  int speed,
                  int width,
                  int height){
        this.positionX = x;
        this.positionY = y;
        this.health = health;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public void setPositionX(int x){
        // TODO: add validations before setting position, throw exception if not
        this.positionX = x;
    }

    public void setPositionY(int y){
        // TODO: add validations before setting position, throw exception if not
        this.positionY = y;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void setHealth(int heath){
        // TODO: add validations before setting Health, throw exception if not
        this.health = heath;
    }

    public int getHealth(){
        return this.health;
    }

    public void setSpeed(int speed){
        // TODO: add validations before setting speed, throw exception if not
        this.speed = speed;
    }

    public int getSpeed(){
        return this.speed;
    }

    public int getPositionX(){
        return this.positionX;
    }

    public int getPositionY(){
        return this.positionY;
    }
}
