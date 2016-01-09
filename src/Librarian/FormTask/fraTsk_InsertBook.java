/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.*;
import DataAccess.*;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_InsertBook extends javax.swing.JFrame {

    private File file;

    BookDA aBookDA = new BookDA();
    BookBO aBookBO = new BookBO();

    AuthorBookDA aAuthorBookDA = new AuthorBookDA();
    AuthorBookBO aAuthorBookBO = new AuthorBookBO();

    SubTopicBookDA aSubTopicBookDA = new SubTopicBookDA();
    SubTopicBookBO aSubTopicBookBO = new SubTopicBookBO();

    List<PublisherDA> aListPublisherDA = new ArrayList<PublisherDA>();
    PublisherBO aPublisherBO = new PublisherBO();

    List<AuthorDA> aListAuthorDA = new ArrayList<AuthorDA>();
    AuthorBO aAuthorBO = new AuthorBO();

    List<TopicDA> aListTopicDA = new ArrayList<TopicDA>();
    TopicBO aTopicBO = new TopicBO();

    List<SubTopicDA> aListSubTopicDA = new ArrayList<SubTopicDA>();
    SubTopicBO aSubTopicBO = new SubTopicBO();

    List<Integer> aListCheckedAuthor = new ArrayList<Integer>();
    List<Integer> aListCheckedSubTopic = new ArrayList<Integer>();

    DefaultTableModel tblModel_Author;
    DefaultTableModel tblModel_SubTopic;
    
    private fraTsk_Main afraTsk_Main = new fraTsk_Main();

    public fraTsk_InsertBook() {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_InsertBook_Load();
        this.AuthorTable_Load();
    }
    
    public fraTsk_InsertBook(fraTsk_Main Input) {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_InsertBook_Load();
        this.AuthorTable_Load();
        this.afraTsk_Main = Input;
    }

    public void fraTsk_InsertBook_Load() {
        tblModel_Author = (DefaultTableModel) tblAuthor.getModel();
        tblModel_SubTopic = (DefaultTableModel) tblSubTopic.getModel();
        aListPublisherDA = aPublisherBO.SelectAll();
        for (PublisherDA temp : aListPublisherDA) {
            cbbPublisher.addItem(temp.getName());
        }
        aListTopicDA = aTopicBO.SelectAll();
        this.SubTopicTable_Load(aListTopicDA.get(0).getIDTopic());
        for (TopicDA temp : aListTopicDA) {
            cbbTopic.addItem(temp.getName());
        }
    }

    public void AuthorTable_Load() {
        String Gender;
        tblModel_Author = (DefaultTableModel) tblAuthor.getModel();
        aListAuthorDA = aAuthorBO.SelectAll();
        for (AuthorDA temp : aListAuthorDA) {
            if (temp.isGender()) {
                Gender = "Nam";
            } else {
                Gender = "Nữ";
            }
            tblModel_Author.insertRow(tblModel_Author.getRowCount(),
                    new Object[]{
                        false,
                        temp.getName(),
                        temp.getPseudonym(),
                        Gender,
                        String.valueOf(temp.getBirthday()),
                        temp.getAddress(),
                        temp.getDescription()
                    });
        }
    }

    public void SubTopicTable_Load(int IDTopic) {
        tblModel_SubTopic.getDataVector().removeAllElements();
        aListSubTopicDA = aSubTopicBO.Select_ByIDTopic(IDTopic);
        for (SubTopicDA temp : aListSubTopicDA) {
            if (aListCheckedSubTopic.isEmpty()) {
                tblModel_SubTopic.insertRow(tblModel_SubTopic.getRowCount(), new Object[]{false, temp.getName(), temp.getDescription()});
            } else {
                if (aListCheckedSubTopic.contains(temp.getIDSubTopic())) {
                    tblModel_SubTopic.insertRow(tblModel_SubTopic.getRowCount(), new Object[]{true, temp.getName(), temp.getDescription()});
                } else {
                    tblModel_SubTopic.insertRow(tblModel_SubTopic.getRowCount(), new Object[]{false, temp.getName(), temp.getDescription()});
                }
            }
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
            java.util.logging.Logger.getLogger(fraTsk_InsertBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_InsertBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_InsertBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_InsertBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

    public int GetSelectedIDPublisher() {
        for (PublisherDA temp : aListPublisherDA) {
            if (temp.getName() == cbbPublisher.getSelectedItem().toString()) {
                return temp.getIDPublisher();
            }
        }
        return 0;
    }

    public int GetSelectedIDTopic() {
        for (TopicDA temp : aListTopicDA) {
            if (temp.getName() == cbbTopic.getSelectedItem().toString()) {
                return temp.getIDTopic();
            }
        }
        return 0;
    }

    public void CheckedIDAuthor_Load() {
        for (int i = 0; i < tblAuthor.getRowCount(); i++) {
            if ((Boolean) tblAuthor.getValueAt(i, 0)) {
                aListCheckedAuthor.add(aListAuthorDA.get(i).getIDAuthor());
            }
        }
    }

    public void CheckedIDSubTopic_Load() {
        for (int i = 0; i < tblSubTopic.getRowCount(); i++) {
            if ((Boolean) tblSubTopic.getValueAt(i, 0)) {
                if (!aListCheckedSubTopic.contains(aListSubTopicDA.get(i).getIDSubTopic())) {
                    aListCheckedSubTopic.add(aListSubTopicDA.get(i).getIDSubTopic());
                }
            } else {
                if (aListCheckedSubTopic.contains(aListSubTopicDA.get(i).getIDSubTopic())) {
                    aListCheckedSubTopic.remove((Object) aListSubTopicDA.get(i).getIDSubTopic());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fchBrowseImage = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtPage = new javax.swing.JTextField();
        txtCoverSizeWidth = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        btnBrowseImage = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbbPublisher = new javax.swing.JComboBox();
        txtPublishDate = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAuthor = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbbTopic = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSubTopic = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtCoverSizeHeight = new javax.swing.JTextField();

        fchBrowseImage.setCurrentDirectory(new java.io.File("C:\\"));
            fchBrowseImage.setDialogTitle("Chọn ảnh cho sách");

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Thêm sách");
            setMinimumSize(new java.awt.Dimension(990, 605));

            jLabel1.setText("Tên sách");

            jLabel2.setText("Số trang");

            jLabel3.setText("Năm xuất bản");

            jLabel4.setText("Chiều cao bìa");

            jLabel6.setText("Số lượng");

            txtName.setFocusAccelerator('1');

            txtPage.setFocusAccelerator('2');

            jLabel10.setText("Ảnh");

            lblImage.setMaximumSize(new java.awt.Dimension(178, 145));

            btnBrowseImage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnBrowseImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search2.png"))); // NOI18N
            btnBrowseImage.setText("Duyệt ảnh");
            btnBrowseImage.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnBrowseImageActionPerformed(evt);
                }
            });

            btnInsert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login_Ok.png"))); // NOI18N
            btnInsert.setText("Thêm sách");
            btnInsert.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnInsertActionPerformed(evt);
                }
            });

            jLabel11.setText("Nhà xuất bản");

            txtPublishDate.setFocusAccelerator('3');

            tblAuthor.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Chọn", "Tên", "Bút danh", "Giới tính", "Năm sinh", "Địa chỉ", "Miêu tả"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    true, false, false, false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tblAuthor.setRowHeight(25);
            jScrollPane1.setViewportView(tblAuthor);
            if (tblAuthor.getColumnModel().getColumnCount() > 0) {
                tblAuthor.getColumnModel().getColumn(0).setResizable(false);
                tblAuthor.getColumnModel().getColumn(0).setPreferredWidth(20);
            }

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
            );

            jTabbedPane1.addTab("Tác giả", jPanel2);

            jLabel8.setText("Chủ đề");

            cbbTopic.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cbbTopicActionPerformed(evt);
                }
            });

            tblSubTopic.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Chọn", "Chủ điểm", "Miêu tả"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    true, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tblSubTopic.setRowHeight(25);
            jScrollPane2.setViewportView(tblSubTopic);
            if (tblSubTopic.getColumnModel().getColumnCount() > 0) {
                tblSubTopic.getColumnModel().getColumn(0).setMinWidth(45);
                tblSubTopic.getColumnModel().getColumn(0).setPreferredWidth(45);
                tblSubTopic.getColumnModel().getColumn(0).setMaxWidth(45);
            }

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel8)
                    .addGap(18, 18, 18)
                    .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(436, Short.MAX_VALUE))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbbTopic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
            );

            jTabbedPane1.addTab("Chủ đề", jPanel3);

            jLabel7.setText("Chiều rộng bìa");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsert)
                    .addGap(41, 41, 41))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(jLabel11))
                            .addGap(13, 13, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPage, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPublishDate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCoverSizeWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCoverSizeHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                            .addComponent(jTabbedPane1)
                            .addGap(14, 14, 14))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnBrowseImage)
                                .addComponent(jLabel10))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtPublishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCoverSizeWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtCoverSizeHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGap(23, 23, 23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addGap(24, 24, 24)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(btnBrowseImage)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsert)
                    .addGap(32, 32, 32))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1)
                    .addGap(99, 99, 99))
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

    private void btnBrowseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseImageActionPerformed
        try {
            fchBrowseImage = new JFileChooser();
            fchBrowseImage.setDialogTitle("Chọn ảnh cho sách");
            fchBrowseImage.setMultiSelectionEnabled(false);
            fchBrowseImage.setFileFilter(new FileTypeFilter(".gif", "GIF"));
            fchBrowseImage.setFileFilter(new FileTypeFilter(".png", "PNG"));
            fchBrowseImage.setFileFilter(new FileTypeFilter(".jpg", "JPG"));
            int result = fchBrowseImage.showOpenDialog(null);
            if (result == fchBrowseImage.APPROVE_OPTION) {
                file = fchBrowseImage.getSelectedFile();
                ImageIcon format = new ImageIcon(file.getAbsolutePath());
                Image img = format.getImage().getScaledInstance(122, 176, Image.SCALE_SMOOTH);
                lblImage.setIcon(new ImageIcon(img));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_InsertBook.btnBrowseImageActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBrowseImageActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            this.CheckedIDAuthor_Load();
            this.CheckedIDSubTopic_Load();
            if (txtName.getText() == "" || txtPage.getText() == "" || txtPublishDate.getText() == "" || txtCoverSizeWidth.getText() == ""
                    || txtCoverSizeHeight.getText() == "" || txtQuantity.getText() == "" || file == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin sách", "Thêm sách", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    aBookDA.setName(txtName.getText());
                    aBookDA.setPage(Integer.parseInt(txtPage.getText()));
                    aBookDA.setPublishDate(Integer.parseInt(txtPublishDate.getText()));
                    aBookDA.setCoverSizeWidth(Float.valueOf(txtCoverSizeWidth.getText()));
                    aBookDA.setCoverSizeHeight(Float.valueOf(txtCoverSizeHeight.getText()));
                    aBookDA.setQuantity(Integer.parseInt(txtQuantity.getText()));
                    aBookDA.setExistingNumber(Integer.parseInt(txtQuantity.getText()));
                    aBookDA.setImage(this.CovertFile(file.getAbsolutePath()));
                    aBookDA.setIDPublisher(this.GetSelectedIDPublisher());
                    if (aBookBO.Insert(aBookDA)) {
                        int IDBook = aBookBO.SelectLast_IDBook();
                        for (int temp : aListCheckedAuthor) {
                            aAuthorBookDA = new AuthorBookDA(IDBook, temp);
                            aAuthorBookBO.Insert(aAuthorBookDA);
                        }
                        for(int temp:aListCheckedSubTopic){
                            aSubTopicBookDA = new SubTopicBookDA(temp, IDBook);
                            aSubTopicBookBO.Insert(aSubTopicBookDA);
                        }
                        this.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Thêm sách thành công", "Thêm sách", JOptionPane.INFORMATION_MESSAGE);
                        this.afraTsk_Main.BookList_Load();
                    } else {
                        JOptionPane.showMessageDialog(this, "Không thành công", "Thêm sách", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Số trang, Năm xuất bản, kích thước bìa phải là một số.", "Thêm sách", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_InsertBook.btnInsertActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void cbbTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTopicActionPerformed
        this.CheckedIDSubTopic_Load();
        this.SubTopicTable_Load(this.GetSelectedIDTopic());
    }//GEN-LAST:event_cbbTopicActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseImage;
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox cbbPublisher;
    private javax.swing.JComboBox cbbTopic;
    private javax.swing.JFileChooser fchBrowseImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTable tblAuthor;
    private javax.swing.JTable tblSubTopic;
    private javax.swing.JTextField txtCoverSizeHeight;
    private javax.swing.JTextField txtCoverSizeWidth;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPage;
    private javax.swing.JTextField txtPublishDate;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
