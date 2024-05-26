package com.portalaluno.view;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JOptionPane;

import java.sql.SQLException;

import com.portalaluno.dao.StudentDAO;
import com.portalaluno.model.Student;
import javax.swing.UIManager;

public class EditStudent extends javax.swing.JDialog implements DisplayPopups{
    
    private final Home home;
    private final StudentDAO studentDAO;
    private final int id;

    public EditStudent(Home home, int id) {
        super(home, "Editar Aluno", true);
        this.home = home;
        this.studentDAO = new StudentDAO();
        this.id = id;
        initComponents();
        init();
        loadStudent();
    }

    private void init() {
        lbltitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font: +7");
        UIManager.put("Component.arrow", "triangle");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCourse = new javax.swing.JLabel();
        cbxCourse = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        bttnCancel = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblName.setLabelFor(txtName);
        lblName.setText("Nome:");

        lblEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblEmail.setLabelFor(txtEmail);
        lblEmail.setText("E-mail");

        lblCourse.setLabelFor(cbxCourse);
        lblCourse.setText("Curso");
        lblCourse.setToolTipText("");

        cbxCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Técnico em Desenvolvimento de Sistemas", "Técnico em Informática para Internet", "Técnico em Informática", "Técnico em Jogos Digitais" }));

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        bttnCancel.setText("Cancelar");
        bttnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnCancelActionPerformed(evt);
            }
        });

        lbltitle.setFont(lbltitle.getFont().deriveFont(lbltitle.getFont().getSize()+6f));
        lbltitle.setText("Editar Aluno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCourse)
                            .addComponent(lblEmail)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bttnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbxCourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lbltitle)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbltitle)
                .addGap(22, 22, 22)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        setSize(new java.awt.Dimension(500, 400));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bttnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_bttnCancelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String name = txtName.getText();
        String email = txtEmail.getText();
        String course = cbxCourse.getSelectedItem().toString();

        if (name.isEmpty() || email.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Preencha todos os campos!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);
        
        StudentDAO studentDAO = new StudentDAO();
        
        try{
            studentDAO.insertStudent(student);
            JOptionPane.showMessageDialog(this, "Aluno adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            home.refreshTbl();
            dispose();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar aluno:" + e.getErrorCode(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void loadStudent(){
        try {
            Student student = studentDAO.getStudentById(id);
            txtName.setText(student.getName());
            txtEmail.setText(student.getEmail());
            
            String studentCourse = student.getCourse();
            for (int i = 0; i <= cbxCourse.getItemCount(); i++){
                String course = (String) cbxCourse.getItemAt(i);
                if (course.equals(studentCourse)) {
                    cbxCourse.setSelectedIndex(i);
                    break;
                }
            }
        } catch (SQLException e) {
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton bttnCancel;
    private javax.swing.JComboBox<String> cbxCourse;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
