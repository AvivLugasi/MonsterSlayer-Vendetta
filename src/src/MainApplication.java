import view.gui.GamePanel;
import view.gui.MainGamePanel;
import view.gui.Utils;
import javax.swing.*;
import data.gameSettings.GameSettingsMacros;

public class MainApplication {
    public static void main(String[] args) {
        JFrame mainWindow = Utils.createBaseFrame(GameSettingsMacros.GAME_TITLE);
        MainGamePanel mainPanel = new MainGamePanel(GameSettingsMacros.MAIN_FRAME_PANEL_BACKGROUND_COLOR);
        mainWindow.add(mainPanel);
        mainWindow.pack();
        mainPanel.startPanelThread();
    }
}