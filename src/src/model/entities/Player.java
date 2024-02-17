package model.entities;

import static data.gameSettings.PlayerSettingsMacros.*;

/**
 * represents the player
 */
public class Player extends Entity {

    /**
     * Player's energy - define player's ability to perform strength consuming cations
     */
    private int energy;

    /**
     * Initialize the player
     */
    public Player(int x, int y, int health, int speed, int width, int height){
        super(x, y, health, speed, width, height);
        this.energy = INITIAL_PLAYER_ENERGY;
    }

    public int setEnergy(int energy){
        // TODO: add validations before setting energy, throw exception if not
        return this.energy = energy;
    }

    public int getEnergy(){
        return this.energy;
    }
}
