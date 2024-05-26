package com.portalaluno;

import java.awt.EventQueue;

import com.portalaluno.view.Home;
import com.portalaluno.view.UISettings;

public class PortalDoAluno {

    public static void main(String[] args) {
        UISettings.setupUI();
        EventQueue.invokeLater(() -> new Home().setVisible(true));
    }
}
