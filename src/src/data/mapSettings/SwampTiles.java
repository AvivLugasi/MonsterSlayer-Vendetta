package data.mapSettings;

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

    public static HashMap<Integer, String> getTestCodeMap(){
        HashMap<Integer, String> codeTileMap = new HashMap<>();
        codeTileMap.put(1, SWAMP_TILES_WATER1);
        codeTileMap.put(2, SWAMP_TILES_WATER2);
        codeTileMap.put(3, SWAMP_TILES_WATER3);
        codeTileMap.put(4, SWAMP_TILES_TREE1);
        codeTileMap.put(5, SWAMP_TILES_TREE2);
        codeTileMap.put(6, SWAMP_TILES_TREE3);
        codeTileMap.put(7, SWAMP_TILES_TREE4);
        codeTileMap.put(8, SWAMP_TILES_TREE5);
        codeTileMap.put(9, SWAMP_TILES_TREE6);
        codeTileMap.put(10, SWAMP_TILES_TREE7);
        codeTileMap.put(11, SWAMP_TILES_GRASS1);

        return codeTileMap;
    }
}
