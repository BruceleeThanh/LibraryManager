/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import javax.swing.table.DefaultTableModel;
import DataAccess.*;
import BusinessLogic.*;
import Librarian.Entity.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_ExtendBorrow extends javax.swing.JFrame {

    DefaultTableModel tblModelBorrowBook;
    DefaultTableModel tblModelBorrowBookDetail;
    List<BorrowBookDA> aListBorrowBookDA = new ArrayList<BorrowBookDA>();
    List<BorrowBookDetailDA> aListBorrowBookDetailDA = new ArrayList<BorrowBookDetailDA>();
    BookBO aBookBO = new BookBO();
    BorrowBookBO aBorrowBookBO = new BorrowBookBO();
    BorrowBookDetailBO aBorrowBookDetailBO = new BorrowBookDetailBO();
    CustomerBO aCustomerBO = new CustomerBO();
    MemberCardBO aMemberCardBO = new MemberCardBO();
    List<BorrowBookEN> aListBorrowBookEN = new ArrayList<BorrowBookEN>();

    int positionBorrowBook = 0;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public fraTsk_ExtendBorrow() {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_ExtendBorrow_Load();
    }

    public void fraTsk_ExtendBorrow_Load() {
        Date toDay = new Date();
        aListBorrowBookEN = new ArrayList<BorrowBookEN>();
        for (BorrowBookDA temp : aBorrowBookBO.SelectAll()) {
            BorrowBookEN aBorrowBookEN = new BorrowBookEN(temp);
            aBorrowBookEN.setaListBorrowBookDetailDA();
            aBorrowBookEN.setAllOfExtend();
            if (aBorrowBookEN.getaListBorrowBookDetailDA().get(0).getActualReturn().after(toDay)) {
                aListBorrowBookEN.add(aBorrowBookEN);
            }
        }
        this.ListBorrowBookTable_Load();
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
            java.util.logging.Logger.getLogger(fraTsk_ExtendBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_ExtendBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_ExtendBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_ExtendBorrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void ListBorrowBookTable_Load() {
        tblModelBorrowBook = (DefaultTableModel) tblListBorrowBook.getModel();
        tblModelBorrowBook.getDataVector().removeAllElements();
        for (BorrowBookEN temp : aListBorrowBookEN) {
            CustomerDA aCustomerDA = new CustomerDA();
            MemberCardDA aMemberCardDA = new MemberCardDA();
            aMemberCardDA = aMemberCardBO.Select_ByIDMemberCard(temp.getIDMemberCard()).get(0);
            aCustomerDA = aCustomerBO.Select_ByIDCustomer(aMemberCardDA.getIDCustomer()).get(0);
            tblModelBorrowBook.insertRow(tblModelBorrowBook.getRowCount(),
                    new Object[]{
                        String.valueOf(aMemberCardDA.getIDMemberCard()),
                        aCustomerDA.getName(),
                        aCustomerDA.getPhoneNumber(),
                        dateFormat.format(temp.getBorrowDate()),
                        dateFormat.format(temp.getaListBorrowBookDetailDA().get(0).getPlanReturn()),
                        String.valueOf(temp.getQuantity())
                    });
        }
        tblListBorrowBook.clearSelection();
    }

    public void diaBorrowBookDetail_Load(int position) {
        this.positionBorrowBook = position;
        tblModelBorrowBookDetail = (DefaultTableModel) tblBorrowBookDetail.getModel();
        tblModelBorrowBookDetail.getDataVector().removeAllElements();
        for (BorrowBookDetailDA temp : aListBorrowBookEN.get(positionBorrowBook).getaListBorrowBookDetailDA()) {
            BookDA aBookDA = new BookDA();
            aBookDA = aBookBO.Select_ByIDBook(temp.getIDBook()).get(0);
            tblModelBorrowBookDetail.insertRow(tblModelBorrowBookDetail.getRowCount(),
                    new Object[]{
                        String.valueOf(aBookDA.getIDBook()),
                        aBookDA.getName(),
                        dateFormat.format(aListBorrowBookEN.get(positionBorrowBook).getBorrowDate()),
                        dateFormat.format(temp.getPlanReturn()),
                        aListBorrowBookEN.get(positionBorrowBook).getExtendActual(),
                        aListBorrowBookEN.get(positionBorrowBook).getExtendNumber(),
                        temp.getFee()
                    });
        }
        this.diaBorrowBookDetail.setLocationRelativeTo(null);
        this.diaBorrowBookDetail.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diaBorrowBookDetail = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBorrowBookDetail = new javax.swing.JTable();
        btnExtend = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        sefSearchExtendBorrow = new org.jdesktop.swingx.JXSearchField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListBorrowBook = new javax.swing.JTable();
        sefSearch = new org.jdesktop.swingx.JXSearchField();

        diaBorrowBookDetail.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        diaBorrowBookDetail.setTitle("Chi tiết mượn sách");
        diaBorrowBookDetail.setMinimumSize(new java.awt.Dimension(829, 481));

        tblBorrowBookDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Ngày mượn", "Ngày trả dự kiến", "Số lần đã gia hạn", "Số lần được gia hạn", "Phí phát sinh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBorrowBookDetail.setRowHeight(25);
        jScrollPane2.setViewportView(tblBorrowBookDetail);

        btnExtend.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExtend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login_Ok.png"))); // NOI18N
        btnExtend.setText("Gia hạn");
        btnExtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtendActionPerformed(evt);
            }
        });

        btnReturn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Exit.png"))); // NOI18N
        btnReturn.setText("Trả sách");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        sefSearchExtendBorrow.setToolTipText("");
        sefSearchExtendBorrow.setPrompt("Tìm kiếm");

        javax.swing.GroupLayout diaBorrowBookDetailLayout = new javax.swing.GroupLayout(diaBorrowBookDetail.getContentPane());
        diaBorrowBookDetail.getContentPane().setLayout(diaBorrowBookDetailLayout);
        diaBorrowBookDetailLayout.setHorizontalGroup(
            diaBorrowBookDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaBorrowBookDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sefSearchExtendBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(diaBorrowBookDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExtend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        diaBorrowBookDetailLayout.setVerticalGroup(
            diaBorrowBookDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaBorrowBookDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diaBorrowBookDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExtend)
                    .addComponent(sefSearchExtendBorrow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách mượn sách");

        tblListBorrowBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thẻ", "Tên bạn đọc", "SĐT", "Ngày mượn", "Ngày trả dự kiến", "Số lượng mượn"
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
        tblListBorrowBook.setToolTipText("Click đúp chuột để xem chi tiết");
        tblListBorrowBook.setRowHeight(25);
        tblListBorrowBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListBorrowBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListBorrowBook);

        sefSearch.setToolTipText("");
        sefSearch.setPrompt("Tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sefSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sefSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListBorrowBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListBorrowBookMouseClicked
        try {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                this.diaBorrowBookDetail_Load(tblListBorrowBook.getSelectedRow());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_BorrowBook.tblCustomerMouseClicked\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblListBorrowBookMouseClicked

    private void btnExtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtendActionPerformed
        try {
            if (!aListBorrowBookEN.get(this.positionBorrowBook).checkExtendLimit()) {
                for (BorrowBookDetailDA temp : aListBorrowBookEN.get(this.positionBorrowBook).getaListBorrowBookDetailDA()) {
                    Calendar aCalendar = Calendar.getInstance();
                    aCalendar.setTime(temp.getPlanReturn());
                    aCalendar.add(Calendar.DATE, aListBorrowBookEN.get(this.positionBorrowBook).getExtendDay());
                    temp.setPlanReturn(aCalendar.getTime());
                    temp.setActualReturn(aCalendar.getTime());
                    if (aBorrowBookDetailBO.Update(temp)) {
                        this.diaBorrowBookDetail.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Gia hạn sách thành công", "Gia hạn sách", JOptionPane.INFORMATION_MESSAGE);
                        this.fraTsk_ExtendBorrow_Load();
                        this.diaBorrowBookDetail_Load(this.positionBorrowBook);
                    } else {
                        JOptionPane.showMessageDialog(this, "Không thành công", "Gia hạn sách", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Vượt quá số lần gia hạn", "Gia hạn sách", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_BorrowBook.btnExtendActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExtendActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        try {
            Date toDay = new Date();
            for (BorrowBookDetailDA temp : aListBorrowBookEN.get(this.positionBorrowBook).getaListBorrowBookDetailDA()) {
                    temp.setActualReturn(toDay);
                    BookDA aBookDA = new BookDA();
                    aBookDA = aBookBO.Select_ByIDBook(temp.getIDBook()).get(0);
                    aBookDA.setExistingNumber(aBookDA.getExistingNumber() + 1);
                    if (aBorrowBookDetailBO.Update(temp) && aBookBO.Update(aBookDA)) {
                        this.diaBorrowBookDetail.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Trả sách thành công", "Trả sách", JOptionPane.INFORMATION_MESSAGE);
                        this.diaBorrowBookDetail.setVisible(false);
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "Không thành công", "Trả sách", JOptionPane.ERROR_MESSAGE);
                    }
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_BorrowBook.btnReturnActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReturnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExtend;
    private javax.swing.JButton btnReturn;
    private javax.swing.JDialog diaBorrowBookDetail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXSearchField sefSearch;
    private org.jdesktop.swingx.JXSearchField sefSearchExtendBorrow;
    private javax.swing.JTable tblBorrowBookDetail;
    private javax.swing.JTable tblListBorrowBook;
    // End of variables declaration//GEN-END:variables
}
