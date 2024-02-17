package view.gui;

import javax.swing.*;

import controller.InputHandler;
import controller.PlayerController;

import java.awt.*;

import static data.gameSettings.GameSettingsMacros.*;

public class GamePanel extends JPanel implements  Runnable{

    // game screen settings
    public final int TILE_SIZE;

    public final int SCREEN_WIDTH;

    public final int SCREEN_HEIGHT;

    private Thread panel_thread;

    private InputHandler inputHandler;

    PlayerController playerController;

    public GamePanel(Color BackGround){
        this.TILE_SIZE = DEFAULT_TILE_SIZE; // 96X96 pixel entity
        this.SCREEN_WIDTH = MAX_SCREEN_COL * TILE_SIZE; // 1344
        this.SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE; // 960
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BackGround);
        this.setDoubleBuffered(true);
        this.inputHandler = new InputHandler();
        this.addKeyListener(this.inputHandler);
        this.setFocusable(true);
        this.playerController = new PlayerController(this.inputHandler);
    }

    public GamePanel(Color BackGround, int tileSize, int screenWidth, int screenHeight){
        this.TILE_SIZE = tileSize;
        this.SCREEN_WIDTH = screenWidth;
        this.SCREEN_HEIGHT = screenHeight;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BackGround);
        this.setDoubleBuffered(true);
        this.playerController = new PlayerController(this.inputHandler);
        this.inputHandler = new InputHandler();
        this.addKeyListener(this.inputHandler);
        this.setFocusable(true);
    }

    public void startPanelThread(){
        this.panel_thread = new Thread(this);
        this.panel_thread.start();
    }

    public Thread getPanelThread(){
        return this.panel_thread;
    }
    @Override
    public void run(){
        double nextDrawTime = System.nanoTime() + DRAW_INTERVAL;
        while(this.panel_thread.isAlive()){
            this.update();
            this.repaint();
            try{
                double ramainingTime = nextDrawTime - System.nanoTime();
                ramainingTime = ramainingTime / NANO_TO_MILI;
                ramainingTime = ramainingTime < 0 ? 0: ramainingTime;
                Thread.sleep((long) ramainingTime);
                nextDrawTime += DRAW_INTERVAL;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        this.playerController.update();
    }
    public void paintComponent(Graphics graphics){
        try {
            super.paintComponent(graphics);
            Graphics2D graphics2D = (Graphics2D) graphics;
            this.playerController.paintComponent(graphics2D);
            graphics2D.dispose();
        } catch(IllegalArgumentException e){
            System.out.println("Expected to get Graphics2D instance");
        }
    }
}
