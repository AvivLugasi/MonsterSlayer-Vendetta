package model.environment;

import java.awt.image.BufferedImage;

/**
 * This Class represents a basic Tile object,
 * which can be a dynamic entity like player, enemy etc.
 * Or something static like a part of map's environment
 */
public class Tile {
    /**
     * Tile's x coordinates on the screen
     */
    private int positionX;

    /**
     * Tile's y coordinates on the screen
     */
    private int positionY;

    /**
     * Tile width on the screen
     */
    private final int width;

    /**
     * Tile height on the screen
     */
    private final int height;

    /**
     * Flag for whether an entity collided with this tile
     */
    private boolean collision;

    /**
     * Current image of the tile
     */
    private BufferedImage image;

    public Tile(int x,
                int y,
                int width,
                int height){
        this.positionX = x;
        this.positionY = y;
        this.width = width;
        this.height = height;
        this.collision = false;
    }

    public Tile(int x,
                int y,
                int width,
                int height,
                BufferedImage image){
        this.positionX = x;
        this.positionY = y;
        this.width = width;
        this.height = height;
        this.collision = false;
        this.image = image;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        // TODO: add validations before setting position, throw exception if not
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        // TODO: add validations before setting position, throw exception if not
        this.positionY = positionY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
