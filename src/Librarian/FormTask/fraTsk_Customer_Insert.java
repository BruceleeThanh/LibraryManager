/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.CustomerBO;
import BusinessLogic.MemberCardBO;
import BusinessLogic.MemberTypeBO;
import DataAccess.CustomerDA;
import DataAccess.MemberCardDA;
import DataAccess.MemberTypeDA;
import java.awt.Image;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_Customer_Insert extends javax.swing.JFrame {

    private File file;

    fraTsk_Customer afraTsk_Customer = new fraTsk_Customer();

    CustomerBO aCustomerBO = new CustomerBO();
    CustomerDA aCustomerDA = new CustomerDA();

    MemberCardBO aMemberCardBO = new MemberCardBO();
    MemberCardDA aMemberCardDA = new MemberCardDA();

    MemberTypeBO aMemberTypeBO = new MemberTypeBO();
    List<MemberTypeDA> aListMemberTypeDA = new ArrayList<MemberTypeDA>();

    public fraTsk_Customer_Insert() {
        initComponents();
        this.SetLookAndFeel();
    }

    public fraTsk_Customer_Insert(fraTsk_Customer Input) {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_Customer_Insert_Load();
        this.afraTsk_Customer = Input;
    }

    public void fraTsk_Customer_Insert_Load() {
        aListMemberTypeDA = aMemberTypeBO.SelectAll();
        cbbMem_Type.removeAllItems();
        for (MemberTypeDA temp : aListMemberTypeDA) {
            cbbMem_Type.addItem(temp.getName());
        }
        rdbGender_Man.setSelected(true);
        Date toDay = new Date();
        dtpCus_CreateDate.setDate(toDay);
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
            java.util.logging.Logger.getLogger(fraTsk_Customer_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Customer_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Customer_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Customer_Insert.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        btgGender = new javax.swing.ButtonGroup();
        fchBrowseImage = new javax.swing.JFileChooser();
        panMemberCard = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCard_AddressCustomer = new javax.swing.JTextArea();
        txtCard_NameLib = new javax.swing.JLabel();
        txtCard_NameCustomer = new javax.swing.JLabel();
        txtCard_BirthdayCustomer = new javax.swing.JLabel();
        txtCard_IdentifyCustomer = new javax.swing.JLabel();
        txtCard_EndDate = new javax.swing.JLabel();
        txtCard_Type = new javax.swing.JLabel();
        lblCard_Image = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCus_Name = new javax.swing.JTextField();
        txtCus_Address = new javax.swing.JTextField();
        txtCus_Identify = new javax.swing.JTextField();
        txtCus_PhoneNumber = new javax.swing.JTextField();
        dtpCus_Birthday = new org.jdesktop.swingx.JXDatePicker();
        rdbGender_Man = new javax.swing.JRadioButton();
        rdbGender_Woman = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblMem_Image = new javax.swing.JLabel();
        btnBrowseImage = new javax.swing.JButton();
        dtpCus_CreateDate = new org.jdesktop.swingx.JXDatePicker();
        dtpCus_EndDate = new org.jdesktop.swingx.JXDatePicker();
        cbbMem_Type = new javax.swing.JComboBox();
        btnInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm bạn đọc");
        setResizable(false);

        panMemberCard.setLayout(null);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtCard_AddressCustomer.setColumns(20);
        txtCard_AddressCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCard_AddressCustomer.setForeground(new java.awt.Color(51, 0, 0));
        txtCard_AddressCustomer.setLineWrap(true);
        txtCard_AddressCustomer.setRows(5);
        txtCard_AddressCustomer.setWrapStyleWord(true);
        txtCard_AddressCustomer.setAutoscrolls(false);
        txtCard_AddressCustomer.setBorder(null);
        jScrollPane2.setViewportView(txtCard_AddressCustomer);

        panMemberCard.add(jScrollPane2);
        jScrollPane2.setBounds(80, 170, 160, 60);

        txtCard_NameLib.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCard_NameLib.setForeground(new java.awt.Color(51, 0, 0));
        panMemberCard.add(txtCard_NameLib);
        txtCard_NameLib.setBounds(100, 0, 140, 30);

        txtCard_NameCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCard_NameCustomer.setForeground(new java.awt.Color(51, 0, 0));
        panMemberCard.add(txtCard_NameCustomer);
        txtCard_NameCustomer.setBounds(60, 70, 180, 30);

        txtCard_BirthdayCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCard_BirthdayCustomer.setForeground(new java.awt.Color(51, 0, 0));
        panMemberCard.add(txtCard_BirthdayCustomer);
        txtCard_BirthdayCustomer.setBounds(100, 100, 140, 30);

        txtCard_IdentifyCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCard_IdentifyCustomer.setForeground(new java.awt.Color(51, 0, 0));
        panMemberCard.add(txtCard_IdentifyCustomer);
        txtCard_IdentifyCustomer.setBounds(80, 130, 160, 30);

        txtCard_EndDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCard_EndDate.setForeground(new java.awt.Color(51, 0, 0));
        panMemberCard.add(txtCard_EndDate);
        txtCard_EndDate.setBounds(270, 200, 90, 20);

        txtCard_Type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCard_Type.setForeground(new java.awt.Color(51, 0, 0));
        panMemberCard.add(txtCard_Type);
        txtCard_Type.setBounds(290, 10, 80, 30);
        panMemberCard.add(lblCard_Image);
        lblCard_Image.setBounds(250, 43, 100, 130);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/MemberCard_small.png"))); // NOI18N
        jLabel1.setOpaque(true);
        panMemberCard.add(jLabel1);
        jLabel1.setBounds(0, 0, 390, 245);

        jLabel9.setText("Tên");

        jLabel10.setText("Ngày sinh");

        jLabel11.setText("Giới tính");

        jLabel12.setText("Địa chỉ");

        jLabel13.setText("CMND");

        jLabel14.setText("Số điện thoại");

        txtCus_Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCus_NameFocusLost(evt);
            }
        });
        txtCus_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCus_NameActionPerformed(evt);
            }
        });

        txtCus_Address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCus_AddressFocusLost(evt);
            }
        });
        txtCus_Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCus_AddressActionPerformed(evt);
            }
        });

        txtCus_Identify.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCus_IdentifyFocusLost(evt);
            }
        });
        txtCus_Identify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCus_IdentifyActionPerformed(evt);
            }
        });

        dtpCus_Birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpCus_BirthdayActionPerformed(evt);
            }
        });

        btgGender.add(rdbGender_Man);
        rdbGender_Man.setText("Nam");

        btgGender.add(rdbGender_Woman);
        rdbGender_Woman.setText("Nữ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCus_PhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(txtCus_Identify, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(txtCus_Address, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(txtCus_Name)
                        .addComponent(dtpCus_Birthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbGender_Man)
                        .addGap(18, 18, 18)
                        .addComponent(rdbGender_Woman)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCus_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(dtpCus_Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbGender_Man)
                        .addComponent(rdbGender_Woman))
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCus_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCus_Identify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCus_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin bạn đọc", jPanel1);

        jLabel15.setText("Loại thẻ");

        jLabel16.setText("Ngày cấp");

        jLabel17.setText("Ngày hết hạn");

        jLabel18.setText("Ảnh");

        btnBrowseImage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBrowseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search2.png"))); // NOI18N
        btnBrowseImage.setText("Duyệt ảnh");
        btnBrowseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseImageActionPerformed(evt);
            }
        });

        dtpCus_EndDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpCus_EndDateActionPerformed(evt);
            }
        });

        cbbMem_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMem_TypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dtpCus_CreateDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(dtpCus_EndDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbMem_Type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBrowseImage)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addComponent(lblMem_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbbMem_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(dtpCus_CreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(dtpCus_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrowseImage))
                    .addComponent(lblMem_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông tin thẻ", jPanel2);

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login_Ok.png"))); // NOI18N
        btnInsert.setText("Thêm bạn đọc");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panMemberCard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(panMemberCard, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsert)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                Image img = format.getImage().getScaledInstance(135, 178, Image.SCALE_SMOOTH);
                lblMem_Image.setIcon(new ImageIcon(img));
                Image img1 = format.getImage().getScaledInstance(100, 130, Image.SCALE_SMOOTH);
                lblCard_Image.setIcon(new ImageIcon(img1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Customer_Insert.btnBrowseImageActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBrowseImageActionPerformed

    private void txtCus_NameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCus_NameFocusLost
        txtCard_NameCustomer.setText(txtCus_Name.getText());
    }//GEN-LAST:event_txtCus_NameFocusLost

    private void txtCus_AddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCus_AddressFocusLost
        txtCard_AddressCustomer.setText(txtCus_Address.getText());
    }//GEN-LAST:event_txtCus_AddressFocusLost

    private void txtCus_IdentifyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCus_IdentifyFocusLost
        txtCard_IdentifyCustomer.setText(txtCus_Identify.getText());
    }//GEN-LAST:event_txtCus_IdentifyFocusLost

    private void dtpCus_BirthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpCus_BirthdayActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(dtpCus_Birthday.getDate());
        txtCard_BirthdayCustomer.setText(date);
    }//GEN-LAST:event_dtpCus_BirthdayActionPerformed

    private void dtpCus_EndDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpCus_EndDateActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(dtpCus_EndDate.getDate());
        txtCard_EndDate.setText(date);
    }//GEN-LAST:event_dtpCus_EndDateActionPerformed

    private void cbbMem_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMem_TypeActionPerformed
        txtCard_Type.setText(cbbMem_Type.getSelectedItem().toString());
    }//GEN-LAST:event_cbbMem_TypeActionPerformed

    private void txtCus_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCus_NameActionPerformed
        txtCard_NameCustomer.setText(txtCus_Name.getText());
    }//GEN-LAST:event_txtCus_NameActionPerformed

    private void txtCus_AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCus_AddressActionPerformed
        txtCard_AddressCustomer.setText(txtCus_Address.getText());
    }//GEN-LAST:event_txtCus_AddressActionPerformed

    private void txtCus_IdentifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCus_IdentifyActionPerformed
        txtCard_IdentifyCustomer.setText(txtCus_Identify.getText());
    }//GEN-LAST:event_txtCus_IdentifyActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            if (txtCus_Name.getText() == "" || txtCus_Address.getText() == "" || txtCus_Identify.getText() == "" || txtCus_PhoneNumber.getText() == ""
                    || dtpCus_Birthday.getDate() == null || dtpCus_EndDate.getDate() == null || dtpCus_CreateDate.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Thêm bạn đọc", JOptionPane.ERROR_MESSAGE);
            } else {
                Date toDay = new Date();
                if(dtpCus_Birthday.getDate().before(toDay)){
                    if (dtpCus_CreateDate.getDate().before(dtpCus_EndDate.getDate())) {
                        aCustomerDA = new CustomerDA();
                        aCustomerDA.setName(txtCus_Name.getText());
                        aCustomerDA.setAddress(txtCus_Address.getText());
                        aCustomerDA.setIdentify(txtCus_Identify.getText());
                        aCustomerDA.setPhoneNumber(txtCus_PhoneNumber.getText());
                        aCustomerDA.setBirthday(dtpCus_Birthday.getDate());
                        if (rdbGender_Man.isSelected()) {
                            aCustomerDA.setGender(true);
                        } else {
                            aCustomerDA.setGender(false);
                        }
                        aCustomerDA.setStatus(1);
                        if (aCustomerBO.Insert(aCustomerDA)) {
                            int IDCustomer = aCustomerBO.SelectLast_IDCustomer();
                            int IDMemberType = 0;
                            for (MemberTypeDA temp : aListMemberTypeDA) {
                                if (temp.getName() == cbbMem_Type.getSelectedItem().toString()) {
                                    IDMemberType = temp.getIDMemberType();
                                    break;
                                }
                            }
                            aMemberCardDA = new MemberCardDA();
                            aMemberCardDA.setIDCustomer(IDCustomer);
                            aMemberCardDA.setIDMemberType(IDMemberType);
                            aMemberCardDA.setCreateDate(dtpCus_CreateDate.getDate());
                            aMemberCardDA.setEndDate(dtpCus_EndDate.getDate());
                            aMemberCardDA.setImage(this.CovertFile(file.getAbsolutePath()));
                            aMemberCardDA.setStatus(1);
                            if (aMemberCardBO.Insert(aMemberCardDA)) {
                                this.setVisible(false);
                                JOptionPane.showMessageDialog(this, "Thêm bạn đọc và thẻ bạn đọc thành công", "Thêm bạn đọc", JOptionPane.INFORMATION_MESSAGE);
                                this.afraTsk_Customer.CustomerTable_Load();
                            } else {
                                JOptionPane.showMessageDialog(this, "Không thành công", "Thêm thẻ bạn đọc", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Không thành công", "Thêm bạn đọc", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "Ngày cấp thẻ phải trước ngày hết hạn.", "Thêm bạn đọc", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Ngày sinh phải trước ngày hiện tại.", "Thêm bạn đọc", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Customer_Insert.btnInsertActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JButton btnBrowseImage;
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox cbbMem_Type;
    private org.jdesktop.swingx.JXDatePicker dtpCus_Birthday;
    private org.jdesktop.swingx.JXDatePicker dtpCus_CreateDate;
    private org.jdesktop.swingx.JXDatePicker dtpCus_EndDate;
    private javax.swing.JFileChooser fchBrowseImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCard_Image;
    private javax.swing.JLabel lblMem_Image;
    private javax.swing.JPanel panMemberCard;
    private javax.swing.JRadioButton rdbGender_Man;
    private javax.swing.JRadioButton rdbGender_Woman;
    private javax.swing.JTextArea txtCard_AddressCustomer;
    private javax.swing.JLabel txtCard_BirthdayCustomer;
    private javax.swing.JLabel txtCard_EndDate;
    private javax.swing.JLabel txtCard_IdentifyCustomer;
    private javax.swing.JLabel txtCard_NameCustomer;
    private javax.swing.JLabel txtCard_NameLib;
    private javax.swing.JLabel txtCard_Type;
    private javax.swing.JTextField txtCus_Address;
    private javax.swing.JTextField txtCus_Identify;
    private javax.swing.JTextField txtCus_Name;
    private javax.swing.JTextField txtCus_PhoneNumber;
    // End of variables declaration//GEN-END:variables
}
