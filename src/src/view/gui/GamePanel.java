package view.gui;

import javax.swing.*;

import controller.InputHandler;
import controller.PlayerController;
import view.Utils;
import view.gui.interfaces.PanelOnFrame;

import java.awt.*;

import static data.gameSettings.GameSettingsMacros.*;

/**
 * Represents the game screen
 */
public class GamePanel extends JPanel implements  Runnable, PanelOnFrame {

    // game screen settings
    /**
     * The tile size on the panel
     */
    public final int TILE_SIZE;

    /**
     * the screen width = MAX_SCREEN_COL * TILE_SIZE
     */
    public final int SCREEN_WIDTH;

    /**
     * the screen height = MAX_SCREEN_ROW * TILE_SIZE
     */
    public final int SCREEN_HEIGHT;

    /**
     * The thread of the panel, when alive actions can
     * be executed concurrently
     */
    private Thread panelThread;

    /**
     * Handler of user input
     */
    private InputHandler inputHandler;

    /**
     * Communicate with the model.Player class and uses inputHandler for updating
     * and painting player status on the panel
     */
    PlayerController playerController;

    /**
     * Initialize the GamePanel
     * @param BackGround (Color) - the background color of the screen
     */
    public GamePanel(Color BackGround){
        this.TILE_SIZE = DEFAULT_TILE_SIZE; // 96X96 pixel entity
        this.SCREEN_WIDTH = MAX_SCREEN_COL * TILE_SIZE; // 1344
        this.SCREEN_HEIGHT = MAX_SCREEN_ROW * TILE_SIZE; // 960
        this.setBackground(BackGround);
        // set panel general assets status
        this.setAssetsStatus();
    }

    /**
     * Initialize the GamePanel
     * @param BackGround (Color) - the background color of the screen
     * @param tileSize (int) - the basic size of a size on the screen
     * @param screenWidth (int) - the width of the screen
     * @param screenHeight (int) - the height of the screen
     */
    public GamePanel(Color BackGround, int tileSize, int screenWidth, int screenHeight){
        this.TILE_SIZE = tileSize;
        this.SCREEN_WIDTH = screenWidth;
        this.SCREEN_HEIGHT = screenHeight;
        this.setBackground(BackGround);
        // set panel general assets status
        this.setAssetsStatus();
    }

    private void setAssetsStatus(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setDoubleBuffered(true);
        this.playerController = new PlayerController(this.inputHandler);
        this.inputHandler = new InputHandler();
        this.addKeyListener(this.inputHandler);
        this.setFocusable(true);
        this.playerController = new PlayerController(this.inputHandler);
    }

    public void startPanelThread(){
        this.panelThread = new Thread(this);
        this.panelThread.start();
    }

    public Thread getPanelThread(){
        return this.panelThread;
    }

    /**
     * Start the game loop of the panel
     * uses the implementation of view.Utils.run().
     */
    @Override
    public void run(){
        Utils.run(this);
    }

    /**
     * Update the status of the entities on the screen
     */
    public void update(){
        this.playerController.update();
    }

    /**
     * paint the status of the entities on the screen
     * @param graphics (Graphics) - instance of the java.awt.graphics class
     */
    public void paintComponent(Graphics graphics){
        try {
            super.paintComponent(graphics);
            Graphics2D graphics2D = (Graphics2D) graphics;
            this.playerController.paintComponent(graphics2D);
            graphics.dispose();
        } catch(IllegalArgumentException e){
            System.out.println("Expected to get Graphics2D instance");
        }
    }
}
