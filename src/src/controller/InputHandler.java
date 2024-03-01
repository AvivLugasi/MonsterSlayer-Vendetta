package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * implements  java.awt.event.keylistener for handling user inputs
 */
public class InputHandler implements KeyListener {

    /**
     * flags for movements key events
     */
    private boolean isUp, isDown, isLeft, isRight;

    /**
     * Initialize the input handler
     */
    public InputHandler(){
    }

    public boolean getUp(){
        return this.isUp;
    }

    public boolean getDown(){
        return this.isDown;
    }

    public boolean getRight(){
        return this.isRight;
    }

    public boolean getLeft(){
        return this.isLeft;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * handle user key pressed events such as:<br>
     * - movements events<br>
     * @param e (KeyEvent)
     */
    @Override
    public void keyPressed(KeyEvent e) {
        handlePlayerMovementPressed(e.getKeyCode());
    }


    /**
     * handle user key released events such as:<br>
     * - movements events<br>
     * @param e (KeyEvent)
     */
    @Override
    public void keyReleased(KeyEvent e) {
        handlePlayerMovementReleased(e.getKeyCode());
    }

    /**
     * handle user movements start events<br>
     * - W and UP<br>
     * - S and DOWN<br>
     * - D and RIGHT<br>
     * - A and LEFT<br>
     * @param code (int) - the code of the key that is pressed
     */
    private void handlePlayerMovementPressed(int code){
        switch(code){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if(!this.isDown){
                    this.isUp = true;
                }
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if(!this.isLeft){
                    this.isRight = true;
                }
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if(!this.isUp){
                    this.isDown = true;
                }
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if(!this.isRight){
                    this.isLeft = true;
                }
                break;
        }
    }

    /**
     * handle user movements end events<br>
     * - W and UP<br>
     * - S and DOWN<br>
     * - D and RIGHT<br>
     * - A and LEFT<br>
     * @param code (int) - the code of the key that is pressed
     */
    private void handlePlayerMovementReleased(int code){
        switch(code){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                this.isUp = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                this.isRight = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                this.isDown = false;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                this.isLeft = false;
                break;
        }
    }
}
