/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.MemberTypeBO;
import DataAccess.MemberTypeDA;
import javax.swing.JOptionPane;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_MemberType_Insert extends javax.swing.JFrame {

    public MemberTypeBO aMemberTypeBO = new MemberTypeBO();
    public fraTsk_MemberType afraTsk_MemberType = new fraTsk_MemberType();

    public fraTsk_MemberType_Insert() {
        initComponents();
        this.SetLookAndFeel();
    }
    
    public fraTsk_MemberType_Insert(fraTsk_MemberType Input) {
        initComponents();
        this.SetLookAndFeel();
        this.afraTsk_MemberType = Input;
    }

    public void SetLookAndFeel() {
        this.setLocationRelativeTo(null);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fraTsk_MemberType_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_MemberType_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_MemberType_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_MemberType_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLimitBook = new javax.swing.JTextField();
        txtLimitTime = new javax.swing.JTextField();
        txtExtendTime = new javax.swing.JTextField();
        txtExtendNumber = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm loại thẻ bạn đọc");

        jLabel1.setText("Tên");

        jLabel2.setText("Số quyển");

        jLabel3.setText("Số ngày");

        jLabel4.setText("Số ngày gia hạn");

        jLabel5.setText("Số lần gia hạn");

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login_Ok.png"))); // NOI18N
        btnInsert.setText("Thêm loại");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnInsert)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtExtendNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExtendTime, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLimitTime, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLimitBook, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLimitBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLimitTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtExtendTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtExtendNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnInsert)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            if (txtName.getText() == "" || txtLimitBook.getText() == "" || txtLimitTime.getText() == "" || txtExtendTime.getText() == ""
                    || txtExtendNumber.getText() == "") {

                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin", "Thêm loại thẻ bạn đọc", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    MemberTypeDA aMemberTypeDA = new MemberTypeDA();
                    aMemberTypeDA.setName(txtName.getText());
                    aMemberTypeDA.setLimitBook(Integer.parseInt(txtLimitBook.getText()));
                    aMemberTypeDA.setLimitDay(Integer.parseInt(txtLimitTime.getText()));
                    aMemberTypeDA.setExtendDay(Integer.parseInt(txtExtendTime.getText()));
                    aMemberTypeDA.setExtendNumber(Integer.parseInt(txtExtendNumber.getText()));
                    if (aMemberTypeBO.Insert(aMemberTypeDA)) {
                        this.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Thêm loại thẻ bạn đọc thành công", "Thêm loại thẻ bạn đọc", JOptionPane.INFORMATION_MESSAGE);
                        this.afraTsk_MemberType.MemberTypeTable_Load();
                    }else{
                        JOptionPane.showMessageDialog(this, "Không thành công", "Thêm loại thẻ bạn đọc", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Số quyển, số ngày, số ngày gia hạn, số lần gia hạn phải là một số.", "Thêm sách", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_MemberType_Insert.btnInsertActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtExtendNumber;
    private javax.swing.JTextField txtExtendTime;
    private javax.swing.JTextField txtLimitBook;
    private javax.swing.JTextField txtLimitTime;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
