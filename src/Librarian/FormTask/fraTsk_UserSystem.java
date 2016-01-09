/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.UserSystemBO;
import DataAccess.CustomerDA;
import DataAccess.UserSystemDA;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_UserSystem extends javax.swing.JFrame {

    DefaultTableModel tblModel;
    List<UserSystemDA> aListUserSystemDA = new ArrayList<UserSystemDA>();
    UserSystemBO aUserSystemBO = new UserSystemBO();
    
    public fraTsk_UserSystem() {
        initComponents();
        this.SetLookAndFeel();
        this.UserSystemTalbe_Load();
    }

    public void SetLookAndFeel(){
        this.setLocationRelativeTo(null);
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fraTsk_UserSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_UserSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_UserSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_UserSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void UserSystemTalbe_Load(){
        String Gender;
        tblModel = (DefaultTableModel) tblUserSystem.getModel();
        tblModel.getDataVector().removeAllElements();
        aListUserSystemDA = aUserSystemBO.SelectAll();
        for (UserSystemDA temp : aListUserSystemDA) {
            if (temp.isGender()) {
                Gender = "Nam";
            } else {
                Gender = "Nữ";
            }
            tblModel.insertRow(tblModel.getRowCount(),
                    new Object[]{
                        temp.getName(),
                        Gender,
                        String.valueOf(temp.getBirthday()),
                        temp.getAddress(),
                        temp.getIdentify(),
                        temp.getPhoneNumber(),
                        String.valueOf(temp.getJoinDate()),
                        temp.getPosition()
                    });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUserSystem = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách người dùng");

        tblUserSystem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Giới tính", "Ngày sinh", "Địa chỉ", "CMND", "SĐT", "Ngày tham gia", "Chức vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUserSystem.setToolTipText("Click đúp chuột để sửa người dùng này");
        tblUserSystem.setRowHeight(25);
        tblUserSystem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserSystemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUserSystem);

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search2.png"))); // NOI18N
        btnSearch.setText("Tìm kiếm");

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_Insert.png"))); // NOI18N
        btnInsert.setText("Thêm người sử dụng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 447, Short.MAX_VALUE)
                .addComponent(btnInsert)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnInsert))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserSystemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserSystemMouseClicked
        try {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                if (JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa người dùng này không?", "Sửa người dùng", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    //this.diaEditCustomer_Load(tblUserSystem.getSelectedRow());
                    return;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Customer.tblCustomerMouseClicked\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblUserSystemMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUserSystem;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
