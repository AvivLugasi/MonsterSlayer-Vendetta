package data.gameSettings;

import static data.gameSettings.GameSettingsMacros.*;

public class PlayerSettingsMacros {

    public static final int PLAYER_TILE_SIZE = 96;

    public static final int INITIAL_PLAYER_HEALTH = 100;

    public static final int INITIAL_PLAYER_SPEED = 7;

    public static final int INITIAL_PLAYER_ENERGY = 100;

    public static final String PLAYER_ASSETS_DIR = ASSETS_DIR + "\\entities\\Player\\Sprites\\Player";

    public static final String PLAYER_ASSETS_STATIC_DIR = PLAYER_ASSETS_DIR + "\\Idle";

    public static final String PLAYER_ARMORED_STATIC_STAND_RIGHT_PREFIX = PLAYER_ASSETS_STATIC_DIR + "\\Player_Idle_Right_";

    public static final String PLAYER_ARMORED_STATIC_STAND_LEFT_PREFIX = PLAYER_ASSETS_STATIC_DIR + "\\Player_Idle_Left_";

    public static final String PLAYER_ASSETS_MOVEMENT_DIR = PLAYER_ASSETS_DIR + "\\Run";

    public static final String PLAYER_ARMORED_MOVEMENT_RIGHT_PREFIX = PLAYER_ASSETS_MOVEMENT_DIR + "\\HeroKnight_Run_Right_";

    public static final String PLAYER_ARMORED_MOVEMENT_LEFT_PREFIX = PLAYER_ASSETS_MOVEMENT_DIR + "\\HeroKnight_Run_Left_";

    public static final int STATIC_SPRITES_NUM_RIGHT = 8;

    public static final int STATIC_SPRITES_NUM_LEFT = 10;

    public static final int MOVEMENT_SPRITES_NUM = 10;
}
