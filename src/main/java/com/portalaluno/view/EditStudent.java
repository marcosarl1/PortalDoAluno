package com.portalaluno.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.portalaluno.dao.CourseDAO;

import java.sql.SQLException;

import com.portalaluno.dao.StudentDAO;
import com.portalaluno.model.Course;
import com.portalaluno.model.Student;
import java.util.List;

public class EditStudent extends javax.swing.JDialog implements DisplayPopups {

    private final Home home;
    private final StudentDAO studentDAO;
    private final CourseDAO courseDAO;
    private final int id;

    public EditStudent(Home home, int id) {
        super(home, "Editar Aluno", true);
        this.home = home;
        this.studentDAO = new StudentDAO();
        this.courseDAO = new CourseDAO();
        this.id = id;
        initComponents();
        init();
        loadCourse();
    }

    private void init() {
        lbltitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font: +7");
        txtName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, ""
                + "Digite o nome completo");
        txtEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, ""
                + "Digite o endereço de e-mail");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCourse = new javax.swing.JLabel();
        cbxCourse = new javax.swing.JComboBox();
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
        Course courseid = (Course) cbxCourse.getSelectedItem();

        if (name.isEmpty() || email.isEmpty() || courseid == null) {
            displayWarning("Preencha todos os campos!");
            return;
        }

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setCourseId(courseid);

        try {
            studentDAO.editStudent(student);
            displaySuccess("Aluno atualizado com sucesso.");
            home.refreshTbl();
            dispose();
        } catch (Exception e) {
            displayError("Erro ao atualizar aluno:" + e.getMessage());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    protected void loadStudent(int id){
        try {
            Student student = studentDAO.getStudentById(id);
            txtName.setText(student.getName());
            txtEmail.setText(student.getEmail());
            cbxCourse.setSelectedItem(student.getCourseId());
            
        } catch (Exception e) {
            displayError("Erro ao carregar aluno: " + e.getMessage());
            dispose();
        }
    }
    
    private void loadCourse() {
        try {
            List<Course> courseNames = courseDAO.getAllCourses();
            cbxCourse.removeAllItems();
            for (Course c : courseNames) {
                cbxCourse.addItem(c);
            }
        } catch (SQLException ex) {
            displayError("Erro ao carregar cursos: " + ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton bttnCancel;
    private javax.swing.JComboBox cbxCourse;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
