/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import BusinessLogic.AccountSystemBO;
import BusinessLogic.AuthorBO;
import BusinessLogic.AuthorBookBO;
import BusinessLogic.BookBO;
import BusinessLogic.LibraryBO;
import BusinessLogic.UserSystemBO;
import DataAccess.AccountSystemDA;
import DataAccess.AuthorBookDA;
import DataAccess.AuthorDA;
import DataAccess.BookDA;
import DataAccess.LibraryDA;
import DataAccess.UserSystemDA;
import Librarian.Control.uc_Book;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_Main extends javax.swing.JFrame {

    BookDA aBookDA = new BookDA();
    BookBO aBookBO = new BookBO();
    List<BookDA> aListBookDA = new ArrayList<>();
    WrapLayout aWrapLayout = new WrapLayout(FlowLayout.LEFT, 33, 15);
    int IDUserSystem;

    public fraTsk_Main() {
        initComponents();
        this.SetLookAndFeel();
        this.BookList_Load();
    }

    public fraTsk_Main(int Input) {
        initComponents();
        this.SetLookAndFeel();
        this.BookList_Load();
        this.IDUserSystem = Input;
        this.InfoMenu_Load();
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
            java.util.logging.Logger.getLogger(fraTsk_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void InfoMenu_Load() {
        UserSystemBO aUserSystemBO = new UserSystemBO();
        UserSystemDA aUserSystemDA = new UserSystemDA();
        LibraryBO aLibraryBO = new LibraryBO();
        LibraryDA aLibraryDA = new LibraryDA();
        aUserSystemDA = aUserSystemBO.Select_ByIDUserSystem(this.IDUserSystem).get(0);
        lblInfoMenu_UserSystemName.setText(aUserSystemDA.getName());
        lblInfoMenu_UserSystemPosition.setText(aUserSystemDA.getPosition());
        aLibraryDA = aLibraryBO.SelectAll().get(0);
        ImageIcon format = new ImageIcon(aLibraryDA.getImage());
        Image img = format.getImage().getScaledInstance(218, 146, Image.SCALE_SMOOTH);
        lblInfoMenu_Image.setIcon(new ImageIcon(img));
        String libraryName = "Thư viện " + aLibraryDA.getName();
        lblInfoMenu_LibraryName.setText(libraryName);
    }

    public void BookList_Load() {
        panFlowBook.removeAll();
        panFlowBook.setLayout(aWrapLayout);
        aListBookDA = aBookBO.SelectAll();
        for (int i = aListBookDA.size() - 1; i > 0; i--) {
            uc_Book anuc_Book = new uc_Book(aListBookDA.get(i));
            panFlowBook.add(anuc_Book);
        }
    }

//    public void panInfoBook_Load(int x, int y){
//        BookDA aBookDA = new BookDA();
//    
//        AuthorDA aAuthorDA = new AuthorDA();
//        AuthorBO aAuthorBO = new AuthorBO();
//        List<AuthorDA> aListAuthorDA = new ArrayList<AuthorDA>();
//
//        AuthorBookDA aAuthorBookDA = new AuthorBookDA();
//        AuthorBookBO aAuthorBookBO = new AuthorBookBO();
//        List<AuthorBookDA> aListAuthorBookDA = new ArrayList<AuthorBookDA>();
//    
//        String authorName = "";
//        aListAuthorBookDA = aAuthorBookBO.Select_ByIDBook(aBookDA.getIDBook());
//        for(AuthorBookDA temp:aListAuthorBookDA){
//            authorName += aAuthorBO.Select_ByIDAuthor(temp.getIDAuthor()).get(0) + "; ";
//        }
//        lblBookName.setText(aBookDA.getName());
//        lblAuthorName.setText(authorName);
//        lblExistingNumber.setText(String.valueOf(aBookDA.getExistingNumber()));
//        panInfoBook.setLocation(x, y);
//        panInfoBook.setVisible(true);
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panInfoBook = new javax.swing.JPanel();
        lblExistingNumber = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAuthorName = new javax.swing.JLabel();
        lblBookName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        btnBorrowBook = new javax.swing.JButton();
        btnListBorrow = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnManageBoook = new javax.swing.JButton();
        btnImportBook = new javax.swing.JButton();
        btnProvider = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnTopic = new javax.swing.JButton();
        btnAuthor = new javax.swing.JButton();
        btnPublisher = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnCustomer = new javax.swing.JButton();
        btnMemberType = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnUserSystem = new javax.swing.JButton();
        btnAccountSystem = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnLibraryInfo = new javax.swing.JButton();
        panInfoMenu = new javax.swing.JPanel();
        lblInfoMenu_Image = new javax.swing.JLabel();
        lblInfoMenu_LibraryName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblInfoMenu_UserSystemName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblInfoMenu_UserSystemPosition = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panFlowBook = new javax.swing.JPanel();

        jLabel3.setText("Hiện có:");

        jLabel2.setText("Tác giả:");

        jLabel1.setText("Sách:");

        javax.swing.GroupLayout panInfoBookLayout = new javax.swing.GroupLayout(panInfoBook);
        panInfoBook.setLayout(panInfoBookLayout);
        panInfoBookLayout.setHorizontalGroup(
            panInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInfoBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblBookName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAuthorName, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(lblExistingNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addContainerGap())
        );
        panInfoBookLayout.setVerticalGroup(
            panInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInfoBookLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBookName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(panInfoBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblExistingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thư viện");
        setBackground(new java.awt.Color(235, 236, 239));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationByPlatform(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        jTabbedPane1.setBackground(new java.awt.Color(235, 236, 239));
        jTabbedPane1.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jSplitPane1.setBackground(new java.awt.Color(235, 236, 239));
        jSplitPane1.setDividerLocation(210);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(346, 82));

        jPanel3.setBackground(new java.awt.Color(235, 236, 239));
        jPanel3.setPreferredSize(new java.awt.Dimension(210, 71));

        btnBorrowBook.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrowBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_BorrowBook.png"))); // NOI18N
        btnBorrowBook.setText("Mượn sách");
        btnBorrowBook.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnBorrowBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrowBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowBookActionPerformed(evt);
            }
        });

        btnListBorrow.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnListBorrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_ExtendBook.png"))); // NOI18N
        btnListBorrow.setText("DS Mượn sách");
        btnListBorrow.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnListBorrow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnListBorrow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnListBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListBorrowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBorrowBook, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListBorrow, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBorrowBook, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
            .addComponent(btnListBorrow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jPanel5.setBackground(new java.awt.Color(235, 236, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(700, 71));

        btnManageBoook.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnManageBoook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_Book.png"))); // NOI18N
        btnManageBoook.setText("Quản lý sách");
        btnManageBoook.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnManageBoook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnManageBoook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnManageBoook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageBoookActionPerformed(evt);
            }
        });

        btnImportBook.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnImportBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_ImportBook.png"))); // NOI18N
        btnImportBook.setText("Nhập sách");
        btnImportBook.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnImportBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImportBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImportBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportBookActionPerformed(evt);
            }
        });

        btnProvider.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnProvider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_Provider.png"))); // NOI18N
        btnProvider.setText("NCC sách");
        btnProvider.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnProvider.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProvider.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProviderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnManageBoook, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImportBook, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(435, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnImportBook, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
            .addComponent(btnProvider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnManageBoook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel5);

        jTabbedPane1.addTab("Quản lý sách", jSplitPane1);

        jPanel2.setBackground(new java.awt.Color(235, 236, 239));

        btnTopic.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTopic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_Topic.png"))); // NOI18N
        btnTopic.setText("Chủ đề");
        btnTopic.setToolTipText("");
        btnTopic.setAlignmentX(0.5F);
        btnTopic.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnTopic.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTopic.setHideActionText(true);
        btnTopic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTopic.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTopicActionPerformed(evt);
            }
        });

        btnAuthor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAuthor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_Author.png"))); // NOI18N
        btnAuthor.setText("Tác giả");
        btnAuthor.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnAuthor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAuthor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuthorActionPerformed(evt);
            }
        });

        btnPublisher.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPublisher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_Publisher.png"))); // NOI18N
        btnPublisher.setText("Nhà xuất bản");
        btnPublisher.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnPublisher.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPublisher.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublisherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTopic, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(652, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAuthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPublisher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTopic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý biên mục", jPanel2);

        jPanel4.setBackground(new java.awt.Color(235, 236, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(944, 82));

        btnCustomer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_Member.png"))); // NOI18N
        btnCustomer.setText("Bạn đọc");
        btnCustomer.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        btnMemberType.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnMemberType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_MemberType.png"))); // NOI18N
        btnMemberType.setText("Loại bạn đọc");
        btnMemberType.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnMemberType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMemberType.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMemberType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMemberType, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(748, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnMemberType, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý bạn đọc", jPanel4);

        jPanel1.setBackground(new java.awt.Color(235, 236, 239));

        btnUserSystem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUserSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_UserSystem.png"))); // NOI18N
        btnUserSystem.setText("Nhân viên");
        btnUserSystem.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnUserSystem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUserSystem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUserSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserSystemActionPerformed(evt);
            }
        });

        btnAccountSystem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAccountSystem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_Account.png"))); // NOI18N
        btnAccountSystem.setText("Tài khoản");
        btnAccountSystem.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnAccountSystem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAccountSystem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAccountSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountSystemActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Main_Logout.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnLibraryInfo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLibraryInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Library.png"))); // NOI18N
        btnLibraryInfo.setText("Thông tin thư viện");
        btnLibraryInfo.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        btnLibraryInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLibraryInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLibraryInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUserSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccountSystem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLibraryInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 533, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUserSystem, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
            .addComponent(btnAccountSystem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLibraryInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quản lý hệ thống", jPanel1);

        panInfoMenu.setBackground(new java.awt.Color(235, 236, 239));
        panInfoMenu.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        lblInfoMenu_Image.setMaximumSize(new java.awt.Dimension(218, 146));
        lblInfoMenu_Image.setMinimumSize(new java.awt.Dimension(218, 146));

        lblInfoMenu_LibraryName.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        lblInfoMenu_LibraryName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel4.setText("Xin chào:");

        lblInfoMenu_UserSystemName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setText("Chức vụ:");

        lblInfoMenu_UserSystemPosition.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout panInfoMenuLayout = new javax.swing.GroupLayout(panInfoMenu);
        panInfoMenu.setLayout(panInfoMenuLayout);
        panInfoMenuLayout.setHorizontalGroup(
            panInfoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInfoMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panInfoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panInfoMenuLayout.createSequentialGroup()
                        .addGroup(panInfoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panInfoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInfoMenu_UserSystemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInfoMenu_UserSystemPosition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panInfoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblInfoMenu_LibraryName, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInfoMenu_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        panInfoMenuLayout.setVerticalGroup(
            panInfoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panInfoMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblInfoMenu_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblInfoMenu_LibraryName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panInfoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblInfoMenu_UserSystemName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panInfoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblInfoMenu_UserSystemPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowRightShadow(false);
        jScrollPane1.setBorder(dropShadowBorder1);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panFlowBook.setBackground(new java.awt.Color(235, 236, 239));

        javax.swing.GroupLayout panFlowBookLayout = new javax.swing.GroupLayout(panFlowBook);
        panFlowBook.setLayout(panFlowBookLayout);
        panFlowBookLayout.setHorizontalGroup(
            panFlowBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 695, Short.MAX_VALUE)
        );
        panFlowBookLayout.setVerticalGroup(
            panFlowBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panFlowBook);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panInfoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panInfoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowBookActionPerformed
        try {
            fraTsk_BorrowBook afraTsk_BorrowBook = new fraTsk_BorrowBook();
            afraTsk_BorrowBook.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnBorrowBookActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrowBookActionPerformed

    private void btnManageBoookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageBoookActionPerformed
        try {
            // Tam thoi
            fraTsk_InsertBook afraTsk_InsertBook = new fraTsk_InsertBook(this);
            afraTsk_InsertBook.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnManageBoookActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnManageBoookActionPerformed

    private void btnImportBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportBookActionPerformed
        try {
            JOptionPane.showMessageDialog(this, "Chức năng này hiện đang xây dựng.", "Đang cập nhật", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnImportBookActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnImportBookActionPerformed

    private void btnProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProviderActionPerformed
        try {
            JOptionPane.showMessageDialog(this, "Chức năng này hiện đang xây dựng.", "Đang cập nhật", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnProviderActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnProviderActionPerformed

    private void btnTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTopicActionPerformed
        try {
            fraTsk_Topic afraTsk_Topic = new fraTsk_Topic();
            afraTsk_Topic.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnTopicActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTopicActionPerformed

    private void btnAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuthorActionPerformed
        try {
            fraTsk_Author afraTsk_Author = new fraTsk_Author();
            afraTsk_Author.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnAuthorActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAuthorActionPerformed

    private void btnPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublisherActionPerformed
        try {
            fraTsk_Publisher afraTsk_Publisher = new fraTsk_Publisher();
            afraTsk_Publisher.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnPublisherActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPublisherActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        try {
            fraTsk_Customer afraTsk_Customer = new fraTsk_Customer();
            afraTsk_Customer.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnCustomerActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnMemberTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberTypeActionPerformed
        try {
            fraTsk_MemberType afraTsk_MemberType = new fraTsk_MemberType();
            afraTsk_MemberType.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnMemberTypeActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMemberTypeActionPerformed

    private void btnUserSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserSystemActionPerformed
        try {
            fraTsk_UserSystem afraTsk_UserSystem = new fraTsk_UserSystem();
            afraTsk_UserSystem.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnUserSystemActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUserSystemActionPerformed

    private void btnAccountSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountSystemActionPerformed
        try {
            JOptionPane.showMessageDialog(this, "Chức năng này hiện đang xây dựng.", "Đang cập nhật", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnAccountSystemActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAccountSystemActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất", "Đăng xuất", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                fraTsk_Login afraTsk_Login = new fraTsk_Login();
                afraTsk_Login.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnLogoutActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLibraryInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryInfoActionPerformed
        try {
            fraTsk_LibraryInfo afraTsk_LibraryInfo = new fraTsk_LibraryInfo(this);
            afraTsk_LibraryInfo.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnLibraryInfoActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLibraryInfoActionPerformed

    private void btnListBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListBorrowActionPerformed
        try {
            fraTsk_ExtendBorrow afraTsk_ExtendBorrow = new fraTsk_ExtendBorrow();
            afraTsk_ExtendBorrow.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_Main.btnExtendBorrowActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnListBorrowActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccountSystem;
    private javax.swing.JButton btnAuthor;
    private javax.swing.JButton btnBorrowBook;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnImportBook;
    private javax.swing.JButton btnLibraryInfo;
    private javax.swing.JButton btnListBorrow;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnManageBoook;
    private javax.swing.JButton btnMemberType;
    private javax.swing.JButton btnProvider;
    private javax.swing.JButton btnPublisher;
    private javax.swing.JButton btnTopic;
    private javax.swing.JButton btnUserSystem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblAuthorName;
    private javax.swing.JLabel lblBookName;
    private javax.swing.JLabel lblExistingNumber;
    private javax.swing.JLabel lblInfoMenu_Image;
    private javax.swing.JLabel lblInfoMenu_LibraryName;
    private javax.swing.JLabel lblInfoMenu_UserSystemName;
    private javax.swing.JLabel lblInfoMenu_UserSystemPosition;
    private javax.swing.JPanel panFlowBook;
    private javax.swing.JPanel panInfoBook;
    private javax.swing.JPanel panInfoMenu;
    // End of variables declaration//GEN-END:variables
}
