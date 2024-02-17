package model;

import static data.gameSettings.GameSettingsMacros.*;
import static data.gameSettings.PlayerSettingsMacros.*;
import static data.gameSettings.PlayerSettingsMacros.INITIAL_PLAYER_ENERGY;

/**
 * represents the player
 */
public class Player {

    /**
     * Player's x coordinates on the screen
     */
    private int positionX;

    /**
     * Player's y coordinates on the screen
     */
    private int positionY;

    /**
     * Player's tile width on the screen
     */
    private final int width;

    /**
     * Player's tile height on the screen
     */
    private final int height;

    /**
     * Player's health
     */
    private int health;

    /**
     * Player's speed - define how fast it changes position on the screen
     */
    private int speed;

    /**
     * Player's energy - define player's ability to perform strength consuming cations
     */
    private int energy;

    /**
     * Initialize the player
     */
    public Player(){
        // setting default position at the center of the screen
        this.positionX = (DEFAULT_TILE_SIZE*MAX_SCREEN_COL/2)-DEFAULT_TILE_SIZE/2;
        this.positionY = (DEFAULT_TILE_SIZE*MAX_SCREEN_ROW/2)-DEFAULT_TILE_SIZE/2;
        this.health = INITIAL_PLAYER_HEALTH;
        this.speed = INITIAL_PLAYER_SPEED;
        this.energy = INITIAL_PLAYER_ENERGY;
        this.width = PLAYER_TILE_SIZE;
        this.height = PLAYER_TILE_SIZE;
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

    public void setEnergy(int energy){
        // TODO: add validations before setting energy, throw exception if not
        this.energy = energy;
    }

    public int getEnergy(){
        return this.energy;
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