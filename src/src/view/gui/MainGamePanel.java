package view.gui;

import java.awt.*;

public class MainGamePanel extends GamePanel{
    public MainGamePanel(Color BackGround) {
        super(BackGround);
    }

    @Override
    public void run() {
        while(this.getPanelThread() != null){
            System.out.println("game is running");
        }
    }

    @Override
    public void update() {
        
    }

    @Override
    public void paintComponent() {

    }
}
