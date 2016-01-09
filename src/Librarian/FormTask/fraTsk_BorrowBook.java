/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import DataAccess.*;
import BusinessLogic.*;
import Librarian.Entity.BorrowBookEN;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_BorrowBook extends javax.swing.JFrame {

    DefaultTableModel tblModel_Customer;
    DefaultTableModel tblModel_BookStore;
    DefaultTableModel tblModel_CartBook;

    List<BookDA> aListBookStore = new ArrayList<BookDA>();
    List<BookDA> aListCartBook = new ArrayList<BookDA>();
    List<MemberCardDA> aListMemberCardDA = new ArrayList<MemberCardDA>();

    CustomerDA aCus_Borrow = new CustomerDA();
    MemberTypeDA aMemberTypeDA = new MemberTypeDA();

    CustomerBO aCustomerBO = new CustomerBO();
    BookBO aBookBO = new BookBO();
    MemberCardBO aMemberCardBO = new MemberCardBO();
    MemberTypeBO aMemberTypeBO = new MemberTypeBO();
    AuthorBookBO aAuthorBookBO = new AuthorBookBO();
    AuthorBO aAuthorBO = new AuthorBO();
    PublisherBO aPublisherBO = new PublisherBO();
    BorrowBookBO aBorrowBookBO = new BorrowBookBO();
    BorrowBookDetailBO aBorrowBookDetailBO = new BorrowBookDetailBO();

    int positionMemberCard = 0;

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public fraTsk_BorrowBook() {
        initComponents();
        this.SetLookAndFeel();
        this.fraTsk_BorrowBook_Load();
    }

    public void fraTsk_BorrowBook_Load() {
        aListBookStore = aBookBO.SelectAll();
        aListMemberCardDA = aMemberCardBO.SelectAll();
        this.CustomerTable_Load();
        this.BookStoreTable_Load();
        Date toDay = new Date();
        lblCartBook_BorrowDate.setText(dateFormat.format(toDay));

        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(toDay);
        aCalendar.add(Calendar.DATE, 7);  // number of days to add
        lblCartBook_ReturnDate.setText(dateFormat.format(aCalendar.getTime()));
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
            java.util.logging.Logger.getLogger(fraTsk_BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void CustomerTable_Load() {
        String Gender;
        tblModel_Customer = (DefaultTableModel) tblCustomer.getModel();
        tblModel_Customer.getDataVector().removeAllElements();
        for (MemberCardDA temp : aListMemberCardDA) {
            CustomerDA aCustomerDA = new CustomerDA();
            aCustomerDA = aCustomerBO.Select_ByIDCustomer(temp.getIDCustomer()).get(0);
            if (aCustomerDA.isGender()) {
                Gender = "Nam";
            } else {
                Gender = "Nữ";
            }
            tblModel_Customer.insertRow(tblModel_Customer.getRowCount(),
                    new Object[]{
                        String.valueOf(temp.getIDMemberCard()),
                        aCustomerDA.getName(),
                        String.valueOf(aCustomerDA.getBirthday()),
                        Gender,
                        aCustomerDA.getAddress(),
                        aCustomerDA.getIdentify(),
                        aCustomerDA.getPhoneNumber()
                    });
        }
    }

    public void BookStoreTable_Load() {
        tblModel_BookStore = (DefaultTableModel) tblBookStore.getModel();
        tblModel_BookStore.getDataVector().removeAllElements();
        for (BookDA tempBook : aListBookStore) {
            String authorName = "";
            List<AuthorBookDA> aListAuthorBookDA = new ArrayList<AuthorBookDA>();
            aListAuthorBookDA = aAuthorBookBO.Select_ByIDBook(tempBook.getIDBook());
            for (AuthorBookDA tempAuthorBook : aListAuthorBookDA) {
                authorName += aAuthorBO.Select_ByIDAuthor(tempAuthorBook.getIDAuthor()).get(0).getName() + "; ";
            }

            tblModel_BookStore.insertRow(tblModel_BookStore.getRowCount(),
                    new Object[]{
                        String.valueOf(tempBook.getIDBook()),
                        tempBook.getName(),
                        authorName,
                        aPublisherBO.Select_ByIDPublisher(tempBook.getIDPublisher()).get(0).getName(),
                        String.valueOf(tempBook.getPublishDate()),
                        String.valueOf(tempBook.getPage()),
                        String.valueOf(tempBook.getExistingNumber())
                    });
        }
        tblBookStore.clearSelection();
    }

    public void CartBookTable_Load() {
        tblModel_CartBook = (DefaultTableModel) tblCartBook.getModel();
        tblModel_CartBook.getDataVector().removeAllElements();
        for (BookDA tempBook : aListCartBook) {
            String authorName = "";
            List<AuthorBookDA> aListAuthorBookDA = new ArrayList<AuthorBookDA>();
            aListAuthorBookDA = aAuthorBookBO.Select_ByIDBook(tempBook.getIDBook());
            for (AuthorBookDA tempAuthorBook : aListAuthorBookDA) {
                authorName += aAuthorBO.Select_ByIDAuthor(tempAuthorBook.getIDAuthor()).get(0).getName() + "; ";
            }

            tblModel_CartBook.insertRow(tblModel_CartBook.getRowCount(),
                    new Object[]{
                        String.valueOf(tempBook.getIDBook()),
                        tempBook.getName(),
                        authorName,
                        aPublisherBO.Select_ByIDPublisher(tempBook.getIDPublisher()).get(0).getName(),
                        String.valueOf(tempBook.getPublishDate()),
                        String.valueOf(tempBook.getPage()),
                        String.valueOf(tempBook.getExistingNumber())
                    });
        }
        tblCartBook.clearSelection();
    }

    public void CartBookTable_GetIn(int position) {
        if (aListBookStore.get(position).getExistingNumber() > 0) {
            BookDA aBookDA = new BookDA();
            aBookDA = aListBookStore.get(position);
            if (aMemberTypeDA.getName() != null) {
                if (this.aMemberTypeDA.getLimitBook() > aListCartBook.size()) {
                    aListCartBook.add(aBookDA);
                    aListBookStore.remove(aBookDA);
                    this.CartBookTable_Load();
                    this.BookStoreTable_Load();
                } else {
                    JOptionPane.showMessageDialog(this, "Loại thẻ " + this.aMemberTypeDA.getName() + " chỉ được mượn tối đa "
                            + aMemberTypeDA.getLimitBook() + " cuốn sách.", "Mượn sách", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chọn người mượn trước khi chọn sách.", "Mượn sách", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sách này hiện đã được mượn hết.", "Mượn sách", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void CartBookTable_GoOut(int position) {
        BookDA aBookDA = new BookDA();
        aBookDA = aListCartBook.get(position);
        aListCartBook.remove(aBookDA);
        aListBookStore.add(aBookDA);
        if (aListCartBook.isEmpty()) {
            ((DefaultTableModel) tblCartBook.getModel()).removeRow(0);
            lblCartBook_Image.setIcon(null);
        }
        this.CartBookTable_Load();
        this.BookStoreTable_Load();
    }

    public void CustomerInfo_Load(int position) {
        Date toDay = new Date();
        if (aListMemberCardDA.get(position).getEndDate().after(toDay)) {
            if(!this.checkBorrowedCustomer(aListMemberCardDA.get(position))){
                this.positionMemberCard = position;
                CustomerDA aCustomerDA = new CustomerDA();
                aCustomerDA = aCustomerBO.Select_ByIDCustomer(aListMemberCardDA.get(this.positionMemberCard).getIDCustomer()).get(0);
                aMemberTypeDA = aMemberTypeBO.Select_ByIDMemberType(aListMemberCardDA.get(this.positionMemberCard).getIDMemberType()).get(0);
                lblCus_Name.setText(aCustomerDA.getName());
                lblCus_Birthday.setText(dateFormat.format(aCustomerDA.getBirthday()));
                lblCus_Address.setText(aCustomerDA.getAddress());
                lblCus_Identity.setText(aCustomerDA.getIdentify());
                lblCus_PhoneNumber.setText(aCustomerDA.getPhoneNumber());
                lblCus_CreateDate.setText(dateFormat.format(aListMemberCardDA.get(this.positionMemberCard).getCreateDate()));
                lblCus_EndDate.setText(dateFormat.format(aListMemberCardDA.get(this.positionMemberCard).getEndDate()));
                lblCus_MemberType.setText(this.aMemberTypeDA.getName());
                ImageIcon format = new ImageIcon(this.aListMemberCardDA.get(this.positionMemberCard).getImage());
                Image img = format.getImage().getScaledInstance(103, 136, Image.SCALE_SMOOTH);
                lblCus_Image.setIcon(new ImageIcon(img));
            }else{
                JOptionPane.showMessageDialog(this, "Bạn đọc này vẫn chưa trả sách lần trước, vui lòng trả sách để được tiếp tục mượn.", "Mượn sách", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn đọc này đã hết hạn dùng thẻ, vui lòng gia hạn thẻ", "Mượn sách", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean checkBorrowedCustomer(MemberCardDA Input){
        Date toDay = new Date();
        List<BorrowBookEN> aListBorrowBookEN = new ArrayList<BorrowBookEN>();
        aListBorrowBookEN = new ArrayList<BorrowBookEN>();
        for (BorrowBookDA temp : aBorrowBookBO.SelectAll()) {
            BorrowBookEN aBorrowBookEN = new BorrowBookEN(temp);
            aBorrowBookEN.setaListBorrowBookDetailDA();
            aBorrowBookEN.setAllOfExtend();
            if (aBorrowBookEN.getaListBorrowBookDetailDA().get(0).getActualReturn().after(toDay)) {
                aListBorrowBookEN.add(aBorrowBookEN);
            }
        }
        for(BorrowBookEN temp:aListBorrowBookEN){
            if(temp.getIDMemberCard() == Input.getIDMemberCard()){
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lblCus_Image = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCus_Name = new javax.swing.JLabel();
        lblCus_Birthday = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCus_Address = new javax.swing.JLabel();
        lblCus_Identity = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblCus_PhoneNumber = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jXHeader3 = new org.jdesktop.swingx.JXHeader();
        jLabel13 = new javax.swing.JLabel();
        lblCus_CreateDate = new javax.swing.JLabel();
        lblCus_EndDate = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblCus_MemberType = new javax.swing.JLabel();
        btnBorrow = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jXHeader4 = new org.jdesktop.swingx.JXHeader();
        jLabel18 = new javax.swing.JLabel();
        lblCartBook_BorrowDate = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblCartBook_ReturnDate = new javax.swing.JLabel();
        lblCartBook_Image = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCartBook = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new org.jdesktop.swingx.JXTable();
        sefSearchCustomer = new org.jdesktop.swingx.JXSearchField();
        jPanel4 = new javax.swing.JPanel();
        jXHeader2 = new org.jdesktop.swingx.JXHeader();
        sefSearchBook = new org.jdesktop.swingx.JXSearchField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBookStore = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mượn sách");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationByPlatform(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        jSplitPane1.setDividerLocation(500);
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setOneTouchExpandable(true);

        jLabel2.setText("Tên:");

        jLabel3.setText("Ngày sinh:");

        jLabel4.setText("Địa chỉ:");

        jLabel5.setText("CMND:");

        jLabel6.setText("SĐT:");

        jLabel12.setText("Ngày cấp:");

        jXHeader3.setTitle("Thông tin thẻ bạn đọc");

        jLabel13.setText("Ngày hết hạn:");

        jLabel16.setText("Loại thẻ:");

        btnBorrow.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBorrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login_Ok.png"))); // NOI18N
        btnBorrow.setText("Mượn sách");
        btnBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXHeader3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrow)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(lblCus_MemberType, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblCus_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCus_CreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCus_PhoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCus_Identity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCus_Address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCus_Birthday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCus_Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCus_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jXHeader3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblCus_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(lblCus_Birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(lblCus_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(lblCus_Identity, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(lblCus_PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblCus_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(lblCus_EndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCus_CreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblCus_MemberType, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnBorrow)
                .addContainerGap())
        );

        jXHeader4.setTitle("Giỏ sách");

        jLabel18.setText("Ngày mượn:");

        jLabel20.setText("Hạn mượn:");

        lblCartBook_Image.setMaximumSize(new java.awt.Dimension(133, 191));
        lblCartBook_Image.setMinimumSize(new java.awt.Dimension(133, 191));

        tblCartBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Tác giả", "NXB", "Năm XB", "Số trang"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCartBook.setToolTipText("Click đúp chuột để Bỏ sách ra khỏi giỏ");
        tblCartBook.setRowHeight(25);
        tblCartBook.setRowMargin(0);
        tblCartBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCartBookMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblCartBook);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCartBook_BorrowDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCartBook_ReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCartBook_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jXHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(lblCartBook_BorrowDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(lblCartBook_ReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lblCartBook_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jXHeader1.setIconPosition(null);
        jXHeader1.setScrollableHeightHint(org.jdesktop.swingx.ScrollableSizeHint.NONE);
        jXHeader1.setScrollableWidthHint(org.jdesktop.swingx.ScrollableSizeHint.NONE);
        jXHeader1.setTitle("Danh sách bạn đọc");

        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thẻ", "Tên", "Ngày sinh", "Giới tính", "Địa chỉ", "CMND", "SĐT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblCustomer.setToolTipText("Click đúp để chọn");
        tblCustomer.setRowHeight(25);
        tblCustomer.setRowMargin(0);
        tblCustomer.setSortable(false);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        sefSearchCustomer.setToolTipText("");
        sefSearchCustomer.setPrompt("Tìm bạn đọc");
        sefSearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sefSearchCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sefSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(sefSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jXHeader2.setTitle("Tủ sách");

        sefSearchBook.setToolTipText("");
        sefSearchBook.setPrompt("Tìm sách");
        sefSearchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sefSearchBookActionPerformed(evt);
            }
        });

        tblBookStore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên", "Tác giả", "NXB", "Năm XB", "Số trang", "Số quyển hiện có"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tblBookStore.setToolTipText("Click đúp chuột để Thêm sách vào giỏ");
        tblBookStore.setRowHeight(25);
        tblBookStore.setRowMargin(0);
        tblBookStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookStoreMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBookStore);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sefSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jXHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sefSearchBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        try {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                this.CustomerInfo_Load(tblCustomer.getSelectedRow());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_BorrowBook.tblCustomerMouseClicked\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void tblBookStoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookStoreMouseClicked
        try {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                this.CartBookTable_GetIn(tblBookStore.getSelectedRow());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_BorrowBook.tblBookStoreMouseClicked\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblBookStoreMouseClicked

    private void tblCartBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCartBookMouseClicked
        try {
            if (evt.getClickCount() == 2 && !evt.isConsumed()) {
                this.CartBookTable_GoOut(tblCartBook.getSelectedRow());
            } else {
                if (evt.getClickCount() == 1 && !evt.isConsumed()) {
                    ImageIcon format = new ImageIcon(this.aListCartBook.get(tblCartBook.getSelectedRow()).getImage());
                    Image img = format.getImage().getScaledInstance(133, 191, Image.SCALE_SMOOTH);
                    lblCartBook_Image.setIcon(new ImageIcon(img));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_BorrowBook.tblCartBookMouseClicked\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tblCartBookMouseClicked

    private void sefSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sefSearchCustomerActionPerformed

    }//GEN-LAST:event_sefSearchCustomerActionPerformed

    private void sefSearchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sefSearchBookActionPerformed

    }//GEN-LAST:event_sefSearchBookActionPerformed

    private void btnBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowActionPerformed
        try {
            if (!aListCartBook.isEmpty()) {
                BorrowBookDA aBorrowBookDA = new BorrowBookDA();
                aBorrowBookDA.setIDMemberCard(aListMemberCardDA.get(this.positionMemberCard).getIDMemberCard());
                aBorrowBookDA.setIDUserSystem(1);
                Date toDay = new Date();
                aBorrowBookDA.setBorrowDate(toDay);
                aBorrowBookDA.setQuantity(tblModel_CartBook.getRowCount());
                if (this.aBorrowBookBO.Insert(aBorrowBookDA)) {
                    BorrowBookDetailDA aBorrowBookDetailDA = new BorrowBookDetailDA();
                    aBorrowBookDetailDA.setIDBorrowBook(aBorrowBookBO.SelectLast_IDBorrowBook());
                    Calendar aCalendar = Calendar.getInstance();
                    aCalendar.setTime(toDay);
                    aCalendar.add(Calendar.DATE, this.aMemberTypeDA.getLimitDay());
                    aBorrowBookDetailDA.setPlanReturn(aCalendar.getTime());
                    aBorrowBookDetailDA.setActualReturn(aCalendar.getTime());
                    for (BookDA temp : aListCartBook) {
                        aBorrowBookDetailDA.setIDBook(temp.getIDBook());
                        this.aBorrowBookDetailBO.Insert(aBorrowBookDetailDA);
                        temp.setExistingNumber(temp.getExistingNumber() - 1);
                        aBookBO.Update(temp);
                    }
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Mượn sách thành công", "Mượn sách", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thành công", "Mượn sách", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Chưa chọn sách", "Mượn sách", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_BorrowBook.btnBorrowActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrowActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrow;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private org.jdesktop.swingx.JXHeader jXHeader2;
    private org.jdesktop.swingx.JXHeader jXHeader3;
    private org.jdesktop.swingx.JXHeader jXHeader4;
    private javax.swing.JLabel lblCartBook_BorrowDate;
    private javax.swing.JLabel lblCartBook_Image;
    private javax.swing.JLabel lblCartBook_ReturnDate;
    private javax.swing.JLabel lblCus_Address;
    private javax.swing.JLabel lblCus_Birthday;
    private javax.swing.JLabel lblCus_CreateDate;
    private javax.swing.JLabel lblCus_EndDate;
    private javax.swing.JLabel lblCus_Identity;
    private javax.swing.JLabel lblCus_Image;
    private javax.swing.JLabel lblCus_MemberType;
    private javax.swing.JLabel lblCus_Name;
    private javax.swing.JLabel lblCus_PhoneNumber;
    private org.jdesktop.swingx.JXSearchField sefSearchBook;
    private org.jdesktop.swingx.JXSearchField sefSearchCustomer;
    private javax.swing.JTable tblBookStore;
    private javax.swing.JTable tblCartBook;
    private org.jdesktop.swingx.JXTable tblCustomer;
    // End of variables declaration//GEN-END:variables
}
