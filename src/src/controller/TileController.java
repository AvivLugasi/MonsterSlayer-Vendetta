package controller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.opencsv.CSVReader;
import controller.interfaces.EntityController;
import controller.interfaces.RenderedObject;
import data.gameSettings.GameSettingsMacros;
import data.mapSettings.SwampTiles;
import model.entities.Entity;
import model.environment.Tile;
import view.GamePanel;
import view.Utils;

import static data.gameSettings.GameSettingsMacros.ASSETS_DIR;

public class TileController implements RenderedObject {
    private ArrayList<Tile> tiles;

    private GamePanel gamePanel;

    public Utils utils = new Utils();

    public TileController(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        setTiles(SwampTiles.getTestCodeMap(), ASSETS_DIR + "\\environment\\tests\\testMap1.csv");
    }

    public void setTiles(HashMap<Integer, String>codeTileMap, String mapFilePath){
        ArrayList<Tile> tiles = new ArrayList<>();
        int x = 0, y = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(mapFilePath))) {
            String line;
            while ((line = br.readLine()) != null && y < this.gamePanel.getSCREEN_HEIGHT()) {
                String[] values = line.split(",");
                for (String num : values) {
                    int tileCode = Integer.parseInt(num.trim());
                    String tileFilePath = codeTileMap.get(tileCode);
                    BufferedImage tileImage = this.utils.getImage(tileFilePath);
                    Tile tile = new Tile(x,
                                         y,
                                         GameSettingsMacros.ENVIRONMENT_TILE_SIZE,
                                         GameSettingsMacros.ENVIRONMENT_TILE_SIZE,
                                         tileImage);
                    tiles.add(tile);
                    x+=this.gamePanel.getTILE_SIZE();
                    if(x >= this.gamePanel.getSCREEN_WIDTH()){
                        x = 0;
                        y+=this.gamePanel.getTILE_SIZE();
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        for(int i = 0; i < codedMap.size() && y < this.gamePanel.getSCREEN_HEIGHT(); i++){
//            for(int j = 0; j < codedMap.get(i).size(); j++){
//                String tileFilePath = codeTileMap.get(codedMap.get(i).get(j));
//                BufferedImage tileImage = this.utils.getImage(tileFilePath);
//                Tile tile = new Tile(x,
//                                     y,
//                                     GameSettingsMacros.ENVIRONMENT_TILE_SIZE,
//                                     GameSettingsMacros.ENVIRONMENT_TILE_SIZE,
//                                     tileImage);
//                tiles.add(tile);
//                x+=this.gamePanel.getTILE_SIZE();
//                if(x >= this.gamePanel.getSCREEN_WIDTH()){
//                    x = 0;
//                    y+=this.gamePanel.getTILE_SIZE();
//                }
//            }
//        }
        this.tiles = tiles;
    }

    @Override
    public void update() {

    }

    @Override
    public void paintComponent(Graphics2D graphics2D) {
        try {
            this.draw(graphics2D);
        } catch(IllegalArgumentException e){
            System.out.println("Expected to get Graphics2D instance");
        }
    }

    private void draw(Graphics2D graphics2D) {
        for(Tile tile: this.tiles){
            this.utils.draw(graphics2D, tile);
        }
    }
}
