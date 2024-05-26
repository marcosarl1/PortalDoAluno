package com.portalaluno.view;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;

public class TblHeader implements TableCellRenderer{
    
    private final TableCellRenderer oldHeaderRenderer;

    public TblHeader(JTable table) {
        this.oldHeaderRenderer = table.getTableHeader().getDefaultRenderer();
        table.getDefaultRenderer(Object.class);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) oldHeaderRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(getAlignment(column));
        return label;
    }
    
    protected int getAlignment(int column){
        if (column == 0){
            return SwingUtilities.CENTER;
        }
        
        return SwingUtilities.LEADING;
    }
}
