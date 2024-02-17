import view.GamePanel;
import view.Utils;
import javax.swing.*;

import static data.gameSettings.GameSettingsMacros.*;

public class MainApplication {
    public static void main(String[] args) {
        JFrame mainWindow = Utils.createBaseFrame(GAME_TITLE);
        GamePanel mainPanel = new GamePanel(MAIN_FRAME_PANEL_BACKGROUND_COLOR);
        mainWindow.add(mainPanel);
        mainWindow.pack();
        mainPanel.startPanelThread();
        mainPanel.requestFocus();
    }
}