/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.PublisherBO;
import DataAccess.PublisherDA;
import DataAccess.SubTopicDA;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_Publisher extends javax.swing.JFrame {
    
    DefaultTableModel tblModel;
    List<PublisherDA> aListPublisherDA = new ArrayList<PublisherDA>();
    PublisherBO aPublisherBO = new PublisherBO();
    PublisherDA aPublisherDA = new PublisherDA();
    int position;

    public fraTsk_Publisher() {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_Publisher_Load();
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
            java.util.logging.Logger.getLogger(fraTsk_Publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Publisher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void fraTsk_Publisher_Load(){
        tblModel = (DefaultTableModel) tblPublisher.getModel();
        tblModel.getDataVector().removeAllElements();
        aListPublisherDA = aPublisherBO.SelectAll();
        for(PublisherDA temp:aListPublisherDA){
            tblModel.insertRow(tblModel.getRowCount(), new Object[]{temp.getName(), temp.getAddress(),temp.getPhoneNumber()});
        }
    }
    
    public void diaEditPublisher_Load(int position){
        this.diaEditPublisher.setLocationRelativeTo(null);
        this.position = position;
        diaEditPublisher.setVisible(true);
        txtName.setText(aListPublisherDA.get(this.position).getName());
        txtAddress.setText(aListPublisherDA.get(this.position).getAddress());
        txtPhoneNumber.setText(aListPublisherDA.get(this.position).getPhoneNumber());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diaEditPublisher = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        diaEditPublisher_btnEdit = new javax.swing.JButton();
        txtPhoneNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        diaEditPublisher_btnExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPublisher = new javax.swing.JTable();
        btnInsert = new javax.swing.JButton();
        sefSearch = new org.jdesktop.swingx.JXSearchField();

        diaEditPublisher.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        diaEditPublisher.setTitle("Sửa nhà xuất bản");
        diaEditPublisher.setMinimumSize(new java.awt.Dimension(329, 217));
        diaEditPublisher.setResizable(false);

        diaEditPublisher_btnEdit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        diaEditPublisher_btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_UpdateEdit.png"))); // NOI18N
        diaEditPublisher_btnEdit.setText("Cập nhật");
        diaEditPublisher_btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaEditPublisher_btnEditActionPerformed(evt);
            }
        });

        jLabel1.setText("Tên");

        jLabel2.setText("Địa chỉ");

        jLabel3.setText("Số điện thoại");

        diaEditPublisher_btnExit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        diaEditPublisher_btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        diaEditPublisher_btnExit.setText("Thoát");
        diaEditPublisher_btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaEditPublisher_btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(diaEditPublisher_btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(diaEditPublisher_btnExit)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress)
                            .addComponent(txtPhoneNumber))
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaEditPublisher_btnEdit)
                    .addComponent(diaEditPublisher_btnExit))
                .addGap(89, 89, 89))
        );

        javax.swing.GroupLayout diaEditPublisherLayout = new javax.swing.GroupLayout(diaEditPublisher.getContentPane());
        diaEditPublisher.getContentPane().setLayout(diaEditPublisherLayout);
        diaEditPublisherLayout.setHorizontalGroup(
            diaEditPublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        diaEditPublisherLayout.setVerticalGroup(
            diaEditPublisherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhà xuất bản");

        tblPublisher.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblPublisher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Địa chỉ", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPublisher.setToolTipText("Click đúp chuột để chỉnh sửa");
        tblPublisher.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblPublisher.setRowHeight(25);
        tblPublisher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPublisherMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPublisher);

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_Insert.png"))); // NOI18N
        btnInsert.setText("Thêm nhà xuất bản");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        sefSearch.setToolTipText("");
        sefSearch.setPrompt("Tìm nhà xuất bản");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sefSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsert)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(sefSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
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

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try{
            fraTsk_Publisher_InsertPublisher afraTsk_Publisher_InsertPublisher = new fraTsk_Publisher_InsertPublisher(this);
            afraTsk_Publisher_InsertPublisher.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Publisher.btnInsertActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void tblPublisherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPublisherMouseClicked
        try{
            if(evt.getClickCount() == 2 && !evt.isConsumed()){
                if (JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa nhà xuất bản này?", "Sửa nhà xuất bản", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.diaEditPublisher_Load(tblPublisher.getSelectedRow());
                    return;
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Publisher.tblPublisherMouseClicked\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblPublisherMouseClicked

    private void diaEditPublisher_btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaEditPublisher_btnEditActionPerformed
        try{
            aListPublisherDA.get(this.position).setName(txtName.getText());
            aListPublisherDA.get(this.position).setAddress(txtAddress.getText());
            aListPublisherDA.get(this.position).setPhoneNumber(txtPhoneNumber.getText());
            if(aPublisherBO.Update(aListPublisherDA.get(this.position))){
                JOptionPane.showMessageDialog(this, "Sửa nhà xuất bản thành công", "Sửa nhà xuất bản", JOptionPane.INFORMATION_MESSAGE);
                this.diaEditPublisher.setVisible(false);
                this.diaEditPublisher.dispose();
                this.fraTsk_Publisher_Load();
            }else{
                JOptionPane.showMessageDialog(this, "Không thành công", "Sửa nhà xuất bản", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Publisher_InsertPublisher.btnInsertActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_diaEditPublisher_btnEditActionPerformed

    private void diaEditPublisher_btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaEditPublisher_btnExitActionPerformed
        try{
            this.diaEditPublisher.setVisible(false);
            this.diaEditPublisher.dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Publisher.diaEditPublisher_btnExitActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_diaEditPublisher_btnExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JDialog diaEditPublisher;
    private javax.swing.JButton diaEditPublisher_btnEdit;
    private javax.swing.JButton diaEditPublisher_btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXSearchField sefSearch;
    private javax.swing.JTable tblPublisher;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
