package com.portalaluno.view;

import com.formdev.flatlaf.FlatClientProperties;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        init();
    }

    private void init() {
        lblTitle.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +10");
        
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:25;" 
                + "background:$Table.background");
        tblStudents.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
                + "height:30;"
                + "hoverBackground:null;"
                + "pressedBackground:null;"
                + "separatorColor:$TableHeader.background;"
                + "font:bold");
        tblStudents.putClientProperty(FlatClientProperties.STYLE, ""
                + "rowHeight:30;"
                + "showHorizontalLines:true;"
                + "intercellSpacing:0,1;"
                + "cellFocusColor:$TableHeader.hoverBackground;"
                + "selectionBackground:$TableHeader.hoverBackground;"
                + "selectionForeground:$Table.foreground;");
        tblStudents.getColumnModel().getColumn(0).setHeaderRenderer(new ChkboxTbl(tblStudents, 0));
        tblStudents.getTableHeader().setDefaultRenderer(new TblHeader(tblStudents));
        scrollTbl.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
                + "trackArc:999;"
                + "trackInsets:3,3,3,3;"
                + "thumbInsets:3,3,3,3;");
        txtSearch.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:10;");
        txtSearch.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, ""
                + "Pesquisar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scrollTbl = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        bttnDelete = new javax.swing.JButton();
        bttnEdit = new javax.swing.JButton();
        bttnAdd = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollTbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "SELECIONAR", "NOME", "E-MAIL", "CURSO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.getTableHeader().setReorderingAllowed(false);
        scrollTbl.setViewportView(tblStudents);
        if (tblStudents.getColumnModel().getColumnCount() > 0) {
            tblStudents.getColumnModel().getColumn(0).setMaxWidth(50);
            tblStudents.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblStudents.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblStudents.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        bttnDelete.setText("Apagar");

        bttnEdit.setText("Editar");

        bttnAdd.setText("Adicionar");

        lblTitle.setText("Portal do Aluno");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttnDelete)
                .addGap(9, 9, 9))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bttnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTbl, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(60, 60, 60))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60))
        );

        setBounds(0, 0, 1040, 776);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAdd;
    private javax.swing.JButton bttnDelete;
    private javax.swing.JButton bttnEdit;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollTbl;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}