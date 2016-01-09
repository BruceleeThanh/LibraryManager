/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.Control;

import BusinessLogic.AuthorBO;
import BusinessLogic.AuthorBookBO;
import DataAccess.AuthorBookDA;
import DataAccess.AuthorDA;
import DataAccess.BookDA;
import Librarian.FormTask.fraTsk_BorrowBook;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Brucelee Thanh
 */
public class uc_Book extends javax.swing.JPanel {

    BookDA aBookDA = new BookDA();

    AuthorDA aAuthorDA = new AuthorDA();
    AuthorBO aAuthorBO = new AuthorBO();
    List<AuthorDA> aListAuthorDA = new ArrayList<AuthorDA>();

    AuthorBookDA aAuthorBookDA = new AuthorBookDA();
    AuthorBookBO aAuthorBookBO = new AuthorBookBO();
    List<AuthorBookDA> aListAuthorBookDA = new ArrayList<AuthorBookDA>();

    public uc_Book(BookDA Input) {
        initComponents();
        this.aBookDA = Input;
        ImageIcon format = new ImageIcon(this.aBookDA.getImage());
        Image img = format.getImage().getScaledInstance(138, 200, Image.SCALE_SMOOTH);
        lblImage.setIcon(new ImageIcon(img));
    }

    public void diaInfoBook_Load() {
        String authorName = "";
        lblBookName.setText("");
        lblAuthorName.setText("");
        lblExistingNumber.setText("");
        aListAuthorBookDA = aAuthorBookBO.Select_ByIDBook(aBookDA.getIDBook());
        for (AuthorBookDA temp : aListAuthorBookDA) {
            authorName += aAuthorBO.Select_ByIDAuthor(temp.getIDAuthor()).get(0).getName() + "; ";
        }
        lblBookName.setText(aBookDA.getName());
        lblAuthorName.setText(authorName);
        lblExistingNumber.setText(String.valueOf(aBookDA.getExistingNumber()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diaInfoBook = new javax.swing.JDialog();
        lblExistingNumber = new javax.swing.JLabel();
        lblAuthorName = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnDetail = new javax.swing.JButton();
        btnBorrowBook = new javax.swing.JButton();
        lblImage = new javax.swing.JLabel();

        diaInfoBook.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        diaInfoBook.setAlwaysOnTop(true);
        diaInfoBook.setFocusTraversalPolicyProvider(true);
        diaInfoBook.setMinimumSize(new java.awt.Dimension(313, 181));
        diaInfoBook.setResizable(false);

        jLabel4.setText("Sách:");

        jLabel5.setText("Tác giả:");

        jLabel6.setText("Hiện có:");

        btnDetail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/detail.png"))); // NOI18N
        btnDetail.setText("Chi tiết");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        btnBorrowBook.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrowBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/getBook.png"))); // NOI18N
        btnBorrowBook.setText("Mượn sách");
        btnBorrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout diaInfoBookLayout = new javax.swing.GroupLayout(diaInfoBook.getContentPane());
        diaInfoBook.getContentPane().setLayout(diaInfoBookLayout);
        diaInfoBookLayout.setHorizontalGroup(
            diaInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaInfoBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diaInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(diaInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblBookName, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(lblAuthorName, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(lblExistingNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, diaInfoBookLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnBorrowBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDetail)
                .addGap(23, 23, 23))
        );
        diaInfoBookLayout.setVerticalGroup(
            diaInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(diaInfoBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(diaInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(lblBookName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(diaInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(lblAuthorName, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(diaInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblExistingNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(diaInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetail)
                    .addComponent(btnBorrowBook))
                .addContainerGap())
        );

        setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        lblImage.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        this.diaInfoBook_Load();
        if (width - evt.getXOnScreen() < 313 && height - evt.getYOnScreen() < 181) {
            this.diaInfoBook.setLocation(evt.getXOnScreen() - 313, evt.getYOnScreen() - 181);
        }
        if (width - evt.getXOnScreen() < 313 && height - evt.getYOnScreen() >= 181) {
            this.diaInfoBook.setLocation(evt.getXOnScreen() - 313, evt.getYOnScreen());
        }
        if (width - evt.getXOnScreen() >= 313 && height - evt.getYOnScreen() < 181) {
            this.diaInfoBook.setLocation(evt.getXOnScreen(), evt.getYOnScreen() - 181);
        }
        if (width - evt.getXOnScreen() >= 313 && height - evt.getYOnScreen() >= 181) {
            this.diaInfoBook.setLocation(evt.getXOnScreen(), evt.getYOnScreen());
        }

        this.diaInfoBook.setVisible(true);
    }//GEN-LAST:event_lblImageMouseClicked

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        this.diaInfoBook.setVisible(false);
        JOptionPane.showMessageDialog(this, "Chức năng này hiện đang xây dựng.", "Đang cập nhật", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDetailActionPerformed

    private void btnBorrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowBookActionPerformed
        try {
            this.diaInfoBook.setVisible(false);
            fraTsk_BorrowBook afraTsk_BorrowBook = new fraTsk_BorrowBook();
            afraTsk_BorrowBook.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.uc_Book.btnBorrowBookActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrowBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrowBook;
    private javax.swing.JButton btnDetail;
    private javax.swing.JDialog diaInfoBook;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAuthorName;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblExistingNumber;
    private javax.swing.JLabel lblImage;
    // End of variables declaration//GEN-END:variables

}
