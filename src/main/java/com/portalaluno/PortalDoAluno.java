package com.portalaluno;

import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.portalaluno.view.Home;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.UIManager;

public class PortalDoAluno {

    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        FlatRobotoFont.install();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        EventQueue.invokeLater(() -> {
            Home home = new Home();
            home.setLocationRelativeTo(null);
            home.setVisible(true);   
        });
    }
}
