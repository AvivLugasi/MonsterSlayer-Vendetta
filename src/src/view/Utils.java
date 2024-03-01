package view;

import model.entities.Entity;
import controller.interfaces.EntityController;
import view.gui.interfaces.PanelOnFrame;

import static data.gameSettings.GameSettingsMacros.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Utils class for the view package, handle various of gui methods
 */
public class Utils {

    /**
     * creates a basic frame using data.GameSettings attributes
     * @param title (String) - the title of the frame
     * @return frame (JFrame) the  created frame
     */
    public static JFrame createBaseFrame(String title){
        JFrame frame = new JFrame(title);

        // Set the frame location to middle
        frame.setLocationRelativeTo(null);

        frame.setResizable(FRAME_RESIZABLE);

        // Create a panel to hold content
        JPanel panel = new JPanel();
        panel.setBackground(MAIN_FRAME_PANEL_BACKGROUND_COLOR); // Set panel background color

        // Set default close operation
        frame.setDefaultCloseOperation(FRAME_DEFAULT_CLOSE_OP);

        // Make the frame visible
        frame.setVisible(true);
        return frame;
    }

    /**
     * basic game loop, update and repaint a panel with
     * a rate of data.gameSettings.FPS(currently 60 fps)
     * @param entity (ObjectOnPanel) - implements the view.gui.interfaces.ObjectOnBoard interface
     */
    public static void run(PanelOnFrame entity){
        double nextDrawTime = System.nanoTime() + DRAW_INTERVAL;
        while(entity.getPanelThread().isAlive()){
            entity.update();
            Component component = (Component) entity;
            component.repaint();
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

    public BufferedImage getImage(String path){
        BufferedImage image = null;
        try{
            File file = new File(path);
            image = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println(path);
            e.printStackTrace();
        }
        return image;
    }

    public void draw(Graphics2D graphics2D, EntityController entityController){
        String animationPath = entityController.getAnimations();
        Entity entity = entityController.getEntity();
        String animationPathCopy = animationPath + entity.spriteID + ".png";
        entity.setSpriteNum();
        entity.setImage(this.getImage(animationPathCopy));
        graphics2D.drawImage(entity.getImage(),
                entity.getPositionX(),
                entity.getPositionY(),
                entity.getWidth(),
                entity.getHeight(), null);
    }
}
