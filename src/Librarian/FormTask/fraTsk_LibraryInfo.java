/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.LibraryBO;
import DataAccess.LibraryDA;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_LibraryInfo extends javax.swing.JFrame {

    File file;
    fraTsk_Main afraTsk_Main = new fraTsk_Main();
    List<LibraryDA> aListLibraryDA = new ArrayList<LibraryDA>();
    LibraryBO aLibraryBO = new LibraryBO();

    public fraTsk_LibraryInfo() {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_LibraryInfo_Load();
    }

    public fraTsk_LibraryInfo(fraTsk_Main Input) {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_LibraryInfo_Load();
        this.afraTsk_Main = Input;
    }

    public void fraTsk_LibraryInfo_Load() {
        aListLibraryDA = aLibraryBO.SelectAll();
        txtName.setText(aListLibraryDA.get(0).getName());
        txtAddress.setText(aListLibraryDA.get(0).getAddress());
        txtPhoneNumber.setText(aListLibraryDA.get(0).getPhoneNumber());
        txtDescription.setText(aListLibraryDA.get(0).getDescription());
        if (aListLibraryDA.get(0).getImage() != null) {
            ImageIcon format = new ImageIcon(aListLibraryDA.get(0).getImage());
            Image img = format.getImage().getScaledInstance(309, 205, Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(img));
        }
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
            java.util.logging.Logger.getLogger(fraTsk_LibraryInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_LibraryInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_LibraryInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_LibraryInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public byte[] CovertFile(String fileName) {
        FileInputStream aFileInputStream = null;
        File aFile = new File(fileName);
        byte[] bFile = new byte[(int) aFile.length()];
        try {
            aFileInputStream = new FileInputStream(file);
            aFileInputStream.read(bFile);
            aFileInputStream.close();
        } catch (Exception ex) {
            bFile = null;
        }
        return bFile;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchBrowseImage = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        btnBrowseImage = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông tin Thư viện");
        setMinimumSize(new java.awt.Dimension(821, 398));
        setResizable(false);

        jLabel1.setText("Tên");

        jLabel2.setText("Địa chỉ");

        jLabel3.setText("Số điện thoại");

        jLabel4.setText("Miêu tả");

        jLabel5.setText("Ảnh");

        btnBrowseImage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBrowseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        btnBrowseImage.setText("Duyệt ảnh");
        btnBrowseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseImageActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescription);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_UpdateEdit.png"))); // NOI18N
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdate)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAddress)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhoneNumber)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBrowseImage))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBrowseImage))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseImageActionPerformed
        try {
            fchBrowseImage.setDialogTitle("Chọn ảnh thẻ");
            fchBrowseImage.setMultiSelectionEnabled(false);
            fchBrowseImage.setFileFilter(new FileTypeFilter(".gif", "GIF"));
            fchBrowseImage.setFileFilter(new FileTypeFilter(".png", "PNG"));
            fchBrowseImage.setFileFilter(new FileTypeFilter(".jpg", "JPG"));
            int result = fchBrowseImage.showOpenDialog(null);
            if (result == fchBrowseImage.APPROVE_OPTION) {
                file = fchBrowseImage.getSelectedFile();
                ImageIcon format = new ImageIcon(file.getAbsolutePath());
                Image img = format.getImage().getScaledInstance(309, 205, Image.SCALE_SMOOTH);
                lblImage.setIcon(new ImageIcon(img));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_LibraryInfo.btnBrowseImageActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBrowseImageActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (txtName.getText() == "" || txtAddress.getText() == "" || txtPhoneNumber.getText() == "") {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Sửa bạn đọc", JOptionPane.ERROR_MESSAGE);
            } else {
                LibraryDA aLibraryDA = new LibraryDA();
                aLibraryDA.setIDLibrary(aListLibraryDA.get(0).getIDLibrary());
                aLibraryDA.setName(txtName.getText());
                aLibraryDA.setAddress(txtAddress.getText());
                aLibraryDA.setPhoneNumber(txtPhoneNumber.getText());
                aLibraryDA.setDescription(txtDescription.getText());
                if (this.file == null) {
                    aLibraryDA.setImage(this.aListLibraryDA.get(0).getImage());
                } else {
                    aLibraryDA.setImage(this.CovertFile(this.file.getAbsolutePath()));
                }
                if (aLibraryBO.Update(aLibraryDA)) {
                    this.setVisible(false);
                    this.afraTsk_Main.InfoMenu_Load();
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin thư viện thành công", "Thông tin thư viện", JOptionPane.INFORMATION_MESSAGE);
//                    this.afraTsk_Main.CustomerTable_Load();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thành công", "Thông tin thư viện", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_LibraryInfo.btnUpdateActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseImage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JFileChooser fchBrowseImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
