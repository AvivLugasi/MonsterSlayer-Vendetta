package data.gameSettings;

import javax.swing.*;
import java.awt.*;

public class GameSettingsMacros {

    public static final String GAME_TITLE = "Monster Slayer - Vendetta";

    public static final int FRAME_EXTENDED_STATE = JFrame.MAXIMIZED_BOTH;

    public static final boolean FRAME_RESIZABLE = false;

    public static final int FRAME_DEFAULT_CLOSE_OP = JFrame.EXIT_ON_CLOSE;

    public static final Color MAIN_FRAME_PANEL_BACKGROUND_COLOR = Color.BLACK;

    public static final  int DEFAULT_ENTITY_TILE_SIZE = 96;

    public static final int ENVIRONMENT_TILE_SIZE = 16;

    public static final int MAX_SCREEN_COL = 84;
    public static final int MAX_SCREEN_ROW = 60;

    public static final int FPS = 60;

    public static final long NANO = 1000000000;

    public static final long NANO_TO_MILI = 1000000;

    public static final double DRAW_INTERVAL = (double) NANO / FPS; // draw on the screen every 0.016667 seconds

    public static final String PROJECT_PATH = System.getProperty("user.dir");

    public static final String ASSETS_DIR = PROJECT_PATH + "\\src\\src\\view\\assets";
}
