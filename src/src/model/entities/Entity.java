package model.entities;

import model.entities.enums.EntityDirections;
import model.interfaces.DynamicStatus;
import java.awt.image.BufferedImage;

public abstract class Entity implements DynamicStatus{
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
     * Entity Direction
     */
    private EntityDirections direction;

    /**
     * whether the entity is static
     */
    private boolean isStatic;

    /**
     * Current image of the entity
     */
    private BufferedImage image;

    /**
     * control when to replace image
     */
    public int spriteCounter = 0;

    /**
     * amount of sprites of the current movement
     */
    public int spriteNum = 0;

    /**
     * sprite image serial number
     */
    public int spriteID = 0;

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
        this.direction = EntityDirections.RIGHT;
        this.isStatic = true;
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

    public EntityDirections getDirection(){
        return this.direction;
    }

    public void setDirection(EntityDirections direction){
        this.direction = direction;
    }

    public void setStatic(boolean isStatic){
        this.isStatic = isStatic;
    }

    public boolean getStatic(){
        return this.isStatic;
    }

    public BufferedImage getImage(){
        return this.image;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    public void setSpriteNum() {
        this.spriteCounter++;
        if (this.spriteCounter % 7 == 0) {
            this.spriteID++;
        }
        if (this.spriteID >= this.spriteNum) {
            this.spriteID = 0;
        }
    }

}
