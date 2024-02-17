package view.gui;

import static data.gameSettings.GameSettingsMacros.*;
import javax.swing.*;

public class Utils {

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

}
