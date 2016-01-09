/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.AuthorBO;
import DataAccess.AuthorDA;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_Author extends javax.swing.JFrame {

    DefaultTableModel tblModel;
    List<AuthorDA> aListAuthorDA = new ArrayList<AuthorDA>();
    AuthorBO aAuthorBO = new AuthorBO();
    int position;

    public fraTsk_Author() {
        initComponents();
        this.SetLookAndFeel();
        this.AuthorTable_Load();
    }

    public void AuthorTable_Load() {
        String Gender;
        tblModel = (DefaultTableModel) tblAuthor.getModel();
        tblModel.getDataVector().removeAllElements();
        aListAuthorDA = aAuthorBO.SelectAll();
        for (AuthorDA temp : aListAuthorDA) {
            if (temp.isGender()) {
                Gender = "Nam";
            } else {
                Gender = "Nữ";
            }
            tblModel.insertRow(tblModel.getRowCount(),
                    new Object[]{
                        temp.getName(),
                        temp.getPseudonym(),
                        Gender,
                        String.valueOf(temp.getBirthday()),
                        temp.getAddress(),
                        temp.getDescription()
                    });
        }
    }

    public void diaEditAuthor_Load(int position) {
        this.diaEditAuthor.setLocationRelativeTo(null);
        this.position = position;
        txtName.setText(aListAuthorDA.get(this.position).getName());
        txtPseudonym.setText(aListAuthorDA.get(this.position).getPseudonym());
        txtAddress.setText(aListAuthorDA.get(this.position).getAddress());
        txtDescription.setText(aListAuthorDA.get(this.position).getDescription());
        dtpBirthday.setDate(aListAuthorDA.get(this.position).getBirthday());
        if (aListAuthorDA.get(this.position).isGender()) {
            rdbGender_Man.setSelected(true);
        } else {
            rdbGender_Woman.setSelected(true);
        }
        this.diaEditAuthor.setVisible(true);

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
            java.util.logging.Logger.getLogger(fraTsk_Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diaEditAuthor = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        dtpBirthday = new org.jdesktop.swingx.JXDatePicker();
        txtPseudonym = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdbGender_Man = new javax.swing.JRadioButton();
        rdbGender_Woman = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnEditAuthor = new javax.swing.JButton();
        btgGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuthor = new javax.swing.JTable();
        btnInsertAuthor = new javax.swing.JButton();
        sefSearch = new org.jdesktop.swingx.JXSearchField();

        diaEditAuthor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        diaEditAuthor.setTitle("Sửa thông tin tác giả");
        diaEditAuthor.setMinimumSize(new java.awt.Dimension(560, 250));

        jLabel1.setText("Tên");

        jLabel2.setText("Bút danh");

        jLabel4.setText("Năm sinh");

        jLabel6.setText("Địa chỉ");

        jLabel3.setText("Giới tính");

        btgGender.add(rdbGender_Man);
        rdbGender_Man.setText("Nam");

        btgGender.add(rdbGender_Woman);
        rdbGender_Woman.setText("Nữ");

        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtDescription);

        jLabel7.setText("Miêu tả");

        btnEditAuthor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEditAuthor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_UpdateEdit.png"))); // NOI18N
        btnEditAuthor.setText("Cập nhật");
        btnEditAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diaEditAuthorLayout = new javax.swing.GroupLayout(diaEditAuthor.getContentPane());
        diaEditAuthor.getContentPane().setLayout(diaEditAuthorLayout);
        diaEditAuthorLayout.setHorizontalGroup(
            diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaEditAuthorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditAuthor)
                    .addGroup(diaEditAuthorLayout.createSequentialGroup()
                        .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(diaEditAuthorLayout.createSequentialGroup()
                                .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(diaEditAuthorLayout.createSequentialGroup()
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel3))
                                    .addGroup(diaEditAuthorLayout.createSequentialGroup()
                                        .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(dtpBirthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                .addComponent(txtPseudonym, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, diaEditAuthorLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(72, 72, 72)))
                        .addGap(28, 28, 28)
                        .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(diaEditAuthorLayout.createSequentialGroup()
                                .addComponent(rdbGender_Man)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdbGender_Woman))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        diaEditAuthorLayout.setVerticalGroup(
            diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaEditAuthorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(rdbGender_Man)
                    .addComponent(rdbGender_Woman))
                .addGap(18, 18, 18)
                .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(diaEditAuthorLayout.createSequentialGroup()
                        .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPseudonym, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(dtpBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(diaEditAuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnEditAuthor)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tác giả");

        tblAuthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Bút danh", "Giới tính", "Năm sinh", "Địa chỉ", "Miêu tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAuthor.setToolTipText("Click đúp chuột để sửa");
        tblAuthor.setColumnSelectionAllowed(true);
        tblAuthor.setRowHeight(25);
        tblAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAuthorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAuthor);
        tblAuthor.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btnInsertAuthor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInsertAuthor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_Insert.png"))); // NOI18N
        btnInsertAuthor.setText("Thêm tác giả");
        btnInsertAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertAuthorActionPerformed(evt);
            }
        });

        sefSearch.setToolTipText("");
        sefSearch.setPrompt("Tìm tác giả");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sefSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsertAuthor)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertAuthor)
                    .addComponent(sefSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertAuthorActionPerformed
        try {
            fraTsk_Author_InsertAuthor afraTsk_Author_InsertAuthor = new fraTsk_Author_InsertAuthor(this);
            afraTsk_Author_InsertAuthor.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Author.btnInsertAuthorActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertAuthorActionPerformed

    private void btnEditAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAuthorActionPerformed
        try {
            AuthorDA aAuthorDA = new AuthorDA();
            if (txtName.getText() == "" || txtPseudonym.getText() == "" || dtpBirthday.getDate() == null || txtAddress.getText() == ""
                    || txtDescription.getText() == "") {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Sửa tác giả", JOptionPane.ERROR_MESSAGE);
            } else {
                aListAuthorDA.get(this.position).setName(txtName.getText());
                aListAuthorDA.get(this.position).setPseudonym(txtPseudonym.getText());
                if (rdbGender_Man.isSelected()) {
                    aListAuthorDA.get(this.position).setGender(true);
                }
                if (rdbGender_Woman.isSelected()) {
                    aListAuthorDA.get(this.position).setGender(false);
                }
                aListAuthorDA.get(this.position).setBirthday(dtpBirthday.getDate());
                aListAuthorDA.get(this.position).setAddress(txtAddress.getText());
                aListAuthorDA.get(this.position).setDescription(txtDescription.getText());
                if (aAuthorBO.Update(aListAuthorDA.get(this.position))) {
                    this.diaEditAuthor.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Sửa tác giả thành công", "Sửa tác giả", JOptionPane.INFORMATION_MESSAGE);
                    this.AuthorTable_Load();
                } else {
                    JOptionPane.showMessageDialog(this, "Không thành công", "Sửa tác giả", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Autho_InsertAuthor.btnInsertAuthorActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEditAuthorActionPerformed

    private void tblAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAuthorMouseClicked
        try {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                if (JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa tác giả này?", "Sửa tác giả", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.diaEditAuthor_Load(tblAuthor.getSelectedRow());
                    return;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Author.tblAuthorMouseClicked\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblAuthorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JButton btnEditAuthor;
    private javax.swing.JButton btnInsertAuthor;
    private javax.swing.JDialog diaEditAuthor;
    private org.jdesktop.swingx.JXDatePicker dtpBirthday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdbGender_Man;
    private javax.swing.JRadioButton rdbGender_Woman;
    private org.jdesktop.swingx.JXSearchField sefSearch;
    private javax.swing.JTable tblAuthor;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPseudonym;
    // End of variables declaration//GEN-END:variables
}
