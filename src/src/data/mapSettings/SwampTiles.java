package data.mapSettings;

import java.util.ArrayList;
import java.util.HashMap;

import static data.gameSettings.GameSettingsMacros.ASSETS_DIR;

public class SwampTiles {

    public static final String SWAMP_TILES_PATH = ASSETS_DIR + "\\environment\\tiles\\SwampTiles";
    public static final String SWAMP_TILES_WATER1 = SWAMP_TILES_PATH + "\\Water_1_16x16.png";
    public static final String SWAMP_TILES_WATER2 = SWAMP_TILES_PATH + "\\Water_2_16x16.png";
    public static final String SWAMP_TILES_WATER3 = SWAMP_TILES_PATH + "\\Water_3_16x16.png";
    public static final String SWAMP_TILES_TREE1 = SWAMP_TILES_PATH + "\\Tree_1_16x16.png";
    public static final String SWAMP_TILES_TREE2 = SWAMP_TILES_PATH + "\\Tree_2_16x16.png";
    public static final String SWAMP_TILES_TREE3 = SWAMP_TILES_PATH + "\\Tree_3_16x16.png";
    public static final String SWAMP_TILES_TREE4 = SWAMP_TILES_PATH + "\\Tree_4_16x16.png";
    public static final String SWAMP_TILES_TREE5 = SWAMP_TILES_PATH + "\\Tree_5_16x16.png";
    public static final String SWAMP_TILES_TREE6 = SWAMP_TILES_PATH + "\\Tree_6a_16x16.png";
    public static final String SWAMP_TILES_TREE7 = SWAMP_TILES_PATH + "\\Tree_6b_16x16.png";
    public static final String SWAMP_TILES_GRASS1 = SWAMP_TILES_PATH + "\\Grass_1_16x16.png";
    public static final String SWAMP_TILES_GRASS2 = SWAMP_TILES_PATH + "\\Grass_2_16x16.png";
    public static final String SWAMP_TILES_GRASS3 = SWAMP_TILES_PATH + "\\Grass_3_16x16.png";
    public static final String SWAMP_TILES_GRASS4 = SWAMP_TILES_PATH + "\\Grass_4_16x16.png";
    public static final String SWAMP_TILES_BUSH1 = SWAMP_TILES_PATH + "\\Bush_3b_16x16.png";
    public static final String SWAMP_TILES_BUSH2 = SWAMP_TILES_PATH + "\\Bush_3a_16x16.png";
    public static final String SWAMP_TILES_BUSH3 = SWAMP_TILES_PATH + "\\Bush_2_16x16.png";
    public static final String SWAMP_TILES_MUSHROOM = SWAMP_TILES_PATH + "\\Mushroom_1_16x16.png";

    public static HashMap<Integer, TilePathCollisionPair> getTestCodeMap(){
        HashMap<Integer, TilePathCollisionPair> codeTileMap = new HashMap<>();
        codeTileMap.put(1, new TilePathCollisionPair(SWAMP_TILES_WATER1, true));
        codeTileMap.put(2, new TilePathCollisionPair(SWAMP_TILES_WATER2, true));
        codeTileMap.put(3, new TilePathCollisionPair(SWAMP_TILES_WATER3, true));
        codeTileMap.put(4, new TilePathCollisionPair(SWAMP_TILES_TREE1, true));
        codeTileMap.put(5, new TilePathCollisionPair(SWAMP_TILES_TREE2, true));
        codeTileMap.put(6, new TilePathCollisionPair(SWAMP_TILES_TREE3, true));
        codeTileMap.put(7, new TilePathCollisionPair(SWAMP_TILES_TREE4, true));
        codeTileMap.put(8, new TilePathCollisionPair(SWAMP_TILES_TREE5, true));
        codeTileMap.put(9, new TilePathCollisionPair(SWAMP_TILES_TREE6, true));
        codeTileMap.put(10, new TilePathCollisionPair(SWAMP_TILES_TREE7, true));
        codeTileMap.put(11, new TilePathCollisionPair(SWAMP_TILES_GRASS1, false));
        codeTileMap.put(12, new TilePathCollisionPair(SWAMP_TILES_BUSH1, true));
        codeTileMap.put(13, new TilePathCollisionPair(SWAMP_TILES_BUSH2, true));
        codeTileMap.put(14, new TilePathCollisionPair(SWAMP_TILES_BUSH3, true));
        codeTileMap.put(15, new TilePathCollisionPair(SWAMP_TILES_MUSHROOM, false));
        codeTileMap.put(16, new TilePathCollisionPair(SWAMP_TILES_GRASS2, false));
        codeTileMap.put(17, new TilePathCollisionPair(SWAMP_TILES_GRASS3, false));
        codeTileMap.put(18, new TilePathCollisionPair(SWAMP_TILES_GRASS4, false));

        return codeTileMap;
    }
}
