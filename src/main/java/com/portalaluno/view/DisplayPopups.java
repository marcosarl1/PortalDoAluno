package com.portalaluno.view;

import javax.swing.JOptionPane;

public interface DisplayPopups {

    default void displayError(String errorMsg) {
        JOptionPane.showMessageDialog(null, errorMsg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    default void displaySuccess(String successMsg) {
        JOptionPane.showMessageDialog(null, successMsg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    default void displayWarning(String warningMsg) {
        JOptionPane.showMessageDialog(null, warningMsg, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
    
    default int displayConfirmation(String confirmMsg) {
        String[] options = {"Sim", "Não"};
        return JOptionPane.showOptionDialog(null, confirmMsg, "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    }
}
