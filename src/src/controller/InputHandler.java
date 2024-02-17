package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    private boolean isUp, isDown, isLeft, isRight;

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

    @Override
    public void keyPressed(KeyEvent e) {
        handlePlayerMovementPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        handlePlayerMovementReleased(e.getKeyCode());
    }

    private void handlePlayerMovementPressed(int code){
        switch(code){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                this.isUp = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                this.isDown = true;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                this.isLeft = true;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                this.isRight = true;
                break;
        }
    }

    private void handlePlayerMovementReleased(int code){
        switch(code){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                this.isUp = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                this.isDown = false;
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                this.isLeft = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                this.isRight = false;
                break;
        }
    }
}
