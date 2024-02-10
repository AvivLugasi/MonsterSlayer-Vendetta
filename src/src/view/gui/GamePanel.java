package view.gui;

import javax.swing.*;

import data.gameSettings.GameSettingsMacros;

import java.awt.*;

public abstract class GamePanel extends JPanel implements  Runnable{

    // game screen settings
    public final int TILE_SIZE;

    public final int SCREEN_WIDTH;

    public final int SCREEN_HEIGHT;

    private Thread panel_thread;

    public GamePanel(Color BackGround){
        this.TILE_SIZE = GameSettingsMacros.DEFAULT_TILE_SIZE; // 48X48 pixel entity
        this.SCREEN_WIDTH = GameSettingsMacros.MAX_SCREEN_COL * TILE_SIZE; // 1152
        this.SCREEN_HEIGHT = GameSettingsMacros.MAX_SCREEN_ROW * TILE_SIZE; // 768
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BackGround);
        this.setDoubleBuffered(true);
    }

    public GamePanel(Color BackGround, int tileSize, int screenWidth, int screenHeight){
        this.TILE_SIZE = tileSize;
        this.SCREEN_WIDTH = screenWidth;
        this.SCREEN_HEIGHT = screenHeight;
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BackGround);
        this.setDoubleBuffered(true);
    }

    public void startPanelThread(){
        this.panel_thread = new Thread(this);
        this.panel_thread.start();
    }

    public Thread getPanelThread(){
        return this.panel_thread;
    }
    @Override
    abstract public void run();
    abstract public void update();
    abstract public void paintComponent();
}
