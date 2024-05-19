package com.portalaluno.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;

public class ChkboxTbl extends JCheckBox implements TableCellRenderer {

    private final JTable tbl;
    private final int column;

    public ChkboxTbl(JTable tbl, int column) {
        this.tbl = tbl;
        this.column = column;
        init();
    }

    private void init() {
        putClientProperty(FlatClientProperties.STYLE, "background:$Table.background");
        setHorizontalAlignment(SwingConstants.CENTER);

        tbl.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int col = tbl.columnAtPoint(e.getPoint());
                    if (col == column) {
                        putClientProperty(FlatClientProperties.SELECTED_STATE, null);
                        setSelected(!isSelected());
                        selectedTblRow(isSelected());
                    }
                }
            }
        });

        tbl.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == column) {
                    checkRow();
                }
            }
        });
    }

    private void checkRow() {
        if (tbl.getRowCount() == 0) {
            return;
        }

        Boolean initValue = getBooleanValueAt(0, column);
        if (initValue == null) {
            putClientProperty(FlatClientProperties.SELECTED_STATE, FlatClientProperties.SELECTED_STATE_INDETERMINATE);
            tbl.getTableHeader().repaint();
            return;
        }

        for (int i = 1; i < tbl.getRowCount(); i++) {
            Boolean v = getBooleanValueAt(i, column);
            if (v == null || !initValue.equals(v)) {
                putClientProperty(FlatClientProperties.SELECTED_STATE, FlatClientProperties.SELECTED_STATE_INDETERMINATE);
                tbl.getTableHeader().repaint();
                return;
            }
        }

        putClientProperty(FlatClientProperties.SELECTED_STATE, null);
        setSelected(initValue);
        tbl.getTableHeader().repaint();
    }

    private Boolean getBooleanValueAt(int row, int column) {
        Object value = tbl.getValueAt(row, column);
        return value instanceof Boolean ? (Boolean) value : null;
    }

    private void selectedTblRow(boolean selected) {
        for (int i = 0; i < tbl.getRowCount(); i++) {
            tbl.setValueAt(selected, i, column);
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setColor(UIManager.getColor("TableHeader.bottomSeparatorColor"));
        float size = UIScale.scale(1f);
        g2.fill(new Rectangle2D.Float(0, getHeight() - size, getWidth(), size));
        g2.dispose();
        super.paintComponent(graphics);
    }
}
