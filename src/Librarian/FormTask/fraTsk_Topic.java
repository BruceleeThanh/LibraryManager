/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.SubTopicBO;
import BusinessLogic.TopicBO;
import DataAccess.SubTopicDA;
import DataAccess.TopicDA;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_Topic extends javax.swing.JFrame {

    List<TopicDA> aListTopicDA = new ArrayList<TopicDA>();
    TopicBO aTopicBO = new TopicBO();
    
    List<SubTopicDA> aListSubTopicDA = new ArrayList<SubTopicDA>();
    SubTopicBO aSubTopicBO = new SubTopicBO();
    
    int positionSubTopic;
    
    DefaultTableModel tblModel;
    
    public fraTsk_Topic() {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_Topic_Load();
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
            java.util.logging.Logger.getLogger(fraTsk_Topic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Topic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Topic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Topic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void fraTsk_Topic_Load(){
        tblModel = (DefaultTableModel) tblSubTopic.getModel();
        aListTopicDA = aTopicBO.SelectAll();
        SubTopicTable_Load(aListTopicDA.get(0).getIDTopic());
        for(TopicDA temp:aListTopicDA){
            cbbTopic.addItem(temp.getName());
        }
    }

    public void SubTopicTable_Load(int IDTopic){
        tblModel.getDataVector().removeAllElements();
        aListSubTopicDA = aSubTopicBO.Select_ByIDTopic(IDTopic);
        for(SubTopicDA temp:aListSubTopicDA){
            tblModel.insertRow(tblModel.getRowCount(), new Object[]{temp.getName(), temp.getDescription()});
        }
    }
    
    public void diaEditSubTopic_Load(int Position){
        this.positionSubTopic = Position;
        this.diaEditSubTopic.setLocationRelativeTo(null);
        this.diaEditSubTopic.setVisible(true);
        diaEditSubTopic_txtName.setText(aListSubTopicDA.get(Position).getName());
        diaEditSubTopic_txtDescription.setText(aListSubTopicDA.get(Position).getDescription());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diaEditSubTopic = new javax.swing.JDialog();
        btnCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        diaEditSubTopic_txtName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        diaEditSubTopic_txtDescription = new javax.swing.JTextArea();
        btnUpdateSubTopic = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnInsertSubTopic = new javax.swing.JButton();
        cbbTopic = new javax.swing.JComboBox();
        btnInsertTopic = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSubTopic = new javax.swing.JTable();

        diaEditSubTopic.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        diaEditSubTopic.setTitle("Sửa chủ điểm");
        diaEditSubTopic.setMinimumSize(new java.awt.Dimension(517, 320));

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        btnCancel.setText("Thoát");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Chủ điểm");

        jLabel2.setText("Miêu tả");

        diaEditSubTopic_txtDescription.setColumns(20);
        diaEditSubTopic_txtDescription.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        diaEditSubTopic_txtDescription.setLineWrap(true);
        diaEditSubTopic_txtDescription.setRows(5);
        diaEditSubTopic_txtDescription.setWrapStyleWord(true);
        jScrollPane2.setViewportView(diaEditSubTopic_txtDescription);

        btnUpdateSubTopic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUpdateSubTopic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_UpdateEdit.png"))); // NOI18N
        btnUpdateSubTopic.setText("Cập nhật");
        btnUpdateSubTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSubTopicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diaEditSubTopicLayout = new javax.swing.GroupLayout(diaEditSubTopic.getContentPane());
        diaEditSubTopic.getContentPane().setLayout(diaEditSubTopicLayout);
        diaEditSubTopicLayout.setHorizontalGroup(
            diaEditSubTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaEditSubTopicLayout.createSequentialGroup()
                .addGroup(diaEditSubTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(diaEditSubTopicLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(diaEditSubTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(diaEditSubTopicLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2))
                            .addGroup(diaEditSubTopicLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(diaEditSubTopic_txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 223, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaEditSubTopicLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdateSubTopic)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        diaEditSubTopicLayout.setVerticalGroup(
            diaEditSubTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaEditSubTopicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diaEditSubTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(diaEditSubTopic_txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diaEditSubTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(diaEditSubTopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdateSubTopic))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnInsertSubTopic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInsertSubTopic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_Insert2.png"))); // NOI18N
        btnInsertSubTopic.setText("Thêm mới chủ điểm");
        btnInsertSubTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertSubTopicActionPerformed(evt);
            }
        });

        cbbTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTopicActionPerformed(evt);
            }
        });

        btnInsertTopic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnInsertTopic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Topic_Insert.png"))); // NOI18N
        btnInsertTopic.setText("Thêm mới chủ đề");
        btnInsertTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertTopicActionPerformed(evt);
            }
        });

        tblSubTopic.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(), null));
        tblSubTopic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chủ điểm", "Miêu tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSubTopic.setToolTipText("Click đúp chuột để sửa");
        tblSubTopic.setColumnSelectionAllowed(true);
        tblSubTopic.setRowHeight(25);
        tblSubTopic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubTopicMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSubTopic);
        tblSubTopic.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (tblSubTopic.getColumnModel().getColumnCount() > 0) {
            tblSubTopic.getColumnModel().getColumn(0).setMinWidth(200);
            tblSubTopic.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnInsertTopic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertSubTopic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertTopic)
                    .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsertSubTopic)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
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

    private void cbbTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTopicActionPerformed
        for(TopicDA temp:aListTopicDA){
            if(temp.getName() == cbbTopic.getSelectedItem().toString()){
                SubTopicTable_Load(temp.getIDTopic());
                break;
            }
        }
        
    }//GEN-LAST:event_cbbTopicActionPerformed

    private void btnInsertTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertTopicActionPerformed
        try{
            fraTsk_Topic_InsertTopic afraTsk_Topic_InsertTopic = new fraTsk_Topic_InsertTopic();
            afraTsk_Topic_InsertTopic.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Topic.btnInsertTopicActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertTopicActionPerformed

    private void btnInsertSubTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertSubTopicActionPerformed
        try{
            fraTsk_Topic_InsertSubTopic afraTsk_Topic_InsertSubTopic = new fraTsk_Topic_InsertSubTopic();
            afraTsk_Topic_InsertSubTopic.setVisible(true);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Topic.btnInsertSubTopicActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertSubTopicActionPerformed

    private void tblSubTopicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubTopicMouseClicked
        try{
            if(evt.getClickCount() == 2 && !evt.isConsumed()){
                if (JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa chủ điểm này", "Sửa chủ điểm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    this.diaEditSubTopic_Load(tblSubTopic.getSelectedRow());
                    return;
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Topic.tblSubTopicMouseClicked\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblSubTopicMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try{
            this.diaEditSubTopic.setVisible(false);
            this.diaEditSubTopic.dispose();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Topic.btnCancelActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateSubTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSubTopicActionPerformed
        try{
            aListSubTopicDA.get(positionSubTopic).setName(diaEditSubTopic_txtName.getText());
            aListSubTopicDA.get(positionSubTopic).setDescription(diaEditSubTopic_txtDescription.getText());
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn sửa chủ điểm này", "Sửa chủ điểm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if(aSubTopicBO.Update(aListSubTopicDA.get(positionSubTopic))){
                    JOptionPane.showMessageDialog(this, "Sửa chủ điểm thành công", "Sửa chủ điểm", JOptionPane.INFORMATION_MESSAGE);
                    this.diaEditSubTopic.setVisible(false);
                    this.diaEditSubTopic.dispose();
                    this.fraTsk_Topic_Load();
                }else{
                    JOptionPane.showMessageDialog(this, "Không thành công", "Sửa chủ điểm", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                this.diaEditSubTopic.setVisible(false);
                this.diaEditSubTopic.dispose();
                this.fraTsk_Topic_Load();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Topic.btnUpdateSubTopicActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateSubTopicActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnInsertSubTopic;
    private javax.swing.JButton btnInsertTopic;
    private javax.swing.JButton btnUpdateSubTopic;
    private javax.swing.JComboBox cbbTopic;
    private javax.swing.JDialog diaEditSubTopic;
    private javax.swing.JTextArea diaEditSubTopic_txtDescription;
    private javax.swing.JTextField diaEditSubTopic_txtName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSubTopic;
    // End of variables declaration//GEN-END:variables
}
