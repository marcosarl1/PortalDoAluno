package com.portalaluno;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.UIManager;

import com.portalaluno.view.Home;

public class PortalDoAluno {

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("theme");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
                
        EventQueue.invokeLater(() -> new Home().setVisible(true));
    }
}
