/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarian.FormTask;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 *
 * @author Brucelee Thanh
 */
public class fraTsk_Customer_Insert_Backup extends javax.swing.JFrame {

    private File file;
    
    public fraTsk_Customer_Insert_Backup() {
        initComponents();
        this.SetLookAndFeel();
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
            java.util.logging.Logger.getLogger(fraTsk_Customer_Insert_Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Customer_Insert_Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Customer_Insert_Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fraTsk_Customer_Insert_Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        txtCard_NameCustomer = new javax.swing.JLabel();
        txtCard_BirthdayCustomer = new javax.swing.JLabel();
        txtCard_IdentifyCustomer = new javax.swing.JLabel();
        txtCard_AddressCustomer = new javax.swing.JLabel();
        txtCard_EndDate = new javax.swing.JLabel();
        txtCard_NameLib = new javax.swing.JLabel();
        txtCard_Type = new javax.swing.JLabel();
        txtCard_ID = new javax.swing.JLabel();
        txtImage = new javax.swing.JLabel();
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
        btnInsertCus = new javax.swing.JButton();

        fchBrowseImage.setCurrentDirectory(new java.io.File("C:\\"));
            fchBrowseImage.setDialogTitle("Chọn ảnh thẻ");

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            panMemberCard.setLayout(null);
            panMemberCard.add(txtCard_NameCustomer);
            txtCard_NameCustomer.setBounds(60, 80, 180, 20);
            panMemberCard.add(txtCard_BirthdayCustomer);
            txtCard_BirthdayCustomer.setBounds(100, 110, 150, 20);
            panMemberCard.add(txtCard_IdentifyCustomer);
            txtCard_IdentifyCustomer.setBounds(80, 140, 160, 20);
            panMemberCard.add(txtCard_AddressCustomer);
            txtCard_AddressCustomer.setBounds(80, 170, 160, 60);
            panMemberCard.add(txtCard_EndDate);
            txtCard_EndDate.setBounds(250, 200, 110, 20);

            txtCard_NameLib.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            txtCard_NameLib.setForeground(new java.awt.Color(51, 0, 0));
            panMemberCard.add(txtCard_NameLib);
            txtCard_NameLib.setBounds(110, 10, 140, 30);

            txtCard_Type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            panMemberCard.add(txtCard_Type);
            txtCard_Type.setBounds(300, 20, 70, 20);
            panMemberCard.add(txtCard_ID);
            txtCard_ID.setBounds(370, 64, 20, 60);
            panMemberCard.add(txtImage);
            txtImage.setBounds(260, 50, 93, 123);

            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/MemberCard_small.png"))); // NOI18N
            jLabel1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Librarian/FormTask/MemberCard.jpg"))); // NOI18N
            jLabel1.setOpaque(true);
            panMemberCard.add(jLabel1);
            jLabel1.setBounds(4, 4, 390, 245);

            jLabel9.setText("Tên");

            jLabel10.setText("Ngày sinh");

            jLabel11.setText("Giới tính");

            jLabel12.setText("Địa chỉ");

            jLabel13.setText("CMND");

            jLabel14.setText("Số điện thoại");

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

            btnInsertCus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            btnInsertCus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Login_Ok.png"))); // NOI18N
            btnInsertCus.setText("Thêm bạn đọc");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panMemberCard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInsertCus, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGap(34, 34, 34))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(panMemberCard, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertCus)
                    .addGap(32, 32, 32))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseImageActionPerformed
        try {
            fchBrowseImage = new JFileChooser();
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
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Librarian.FormTask.fraTsk_InsertMemberCard.btnBrowseImageActionPerformed\n" + ex.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBrowseImageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgGender;
    private javax.swing.JButton btnBrowseImage;
    private javax.swing.JButton btnInsertCus;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblMem_Image;
    private javax.swing.JPanel panMemberCard;
    private javax.swing.JRadioButton rdbGender_Man;
    private javax.swing.JRadioButton rdbGender_Woman;
    private javax.swing.JLabel txtCard_AddressCustomer;
    private javax.swing.JLabel txtCard_BirthdayCustomer;
    private javax.swing.JLabel txtCard_EndDate;
    private javax.swing.JLabel txtCard_ID;
    private javax.swing.JLabel txtCard_IdentifyCustomer;
    private javax.swing.JLabel txtCard_NameCustomer;
    private javax.swing.JLabel txtCard_NameLib;
    private javax.swing.JLabel txtCard_Type;
    private javax.swing.JTextField txtCus_Address;
    private javax.swing.JTextField txtCus_Identify;
    private javax.swing.JTextField txtCus_Name;
    private javax.swing.JTextField txtCus_PhoneNumber;
    private javax.swing.JLabel txtImage;
    // End of variables declaration//GEN-END:variables
}

class BackgroundPanel extends JPanel
{
	public static final int SCALED = 0;
	public static final int TILED = 1;
	public static final int ACTUAL = 2;

	private Paint painter;
	private Image image;
	private int style = SCALED;
	private float alignmentX = 0.5f;
	private float alignmentY = 0.5f;
	private boolean isTransparentAdd = true;

	/*
	 *  Set image as the background with the SCALED style
	 */
	public BackgroundPanel(Image image)
	{
		this(image, SCALED);
	}

	/*
	 *  Set image as the background with the specified style
	 */
	public BackgroundPanel(Image image, int style)
	{
		setImage( image );
		setStyle( style );
		setLayout( new BorderLayout() );
	}

	/*
	 *  Set image as the backround with the specified style and alignment
	 */
	public BackgroundPanel(Image image, int style, float alignmentX, float alignmentY)
	{
		setImage( image );
		setStyle( style );
		setImageAlignmentX( alignmentX );
		setImageAlignmentY( alignmentY );
		setLayout( new BorderLayout() );
	}

	/*
	 *  Use the Paint interface to paint a background
	 */
	public BackgroundPanel(Paint painter)
	{
		setPaint( painter );
		setLayout( new BorderLayout() );
	}

	/*
	 *	Set the image used as the background
	 */
	public void setImage(Image image)
	{
		this.image = image;
		repaint();
	}

	/*
	 *	Set the style used to paint the background image
	 */
	public void setStyle(int style)
	{
		this.style = style;
		repaint();
	}

	/*
	 *	Set the Paint object used to paint the background
	 */
	public void setPaint(Paint painter)
	{
		this.painter = painter;
		repaint();
	}

	/*
	 *  Specify the horizontal alignment of the image when using ACTUAL style
	 */
	public void setImageAlignmentX(float alignmentX)
	{
		this.alignmentX = alignmentX > 1.0f ? 1.0f : alignmentX < 0.0f ? 0.0f : alignmentX;
		repaint();
	}

	/*
	 *  Specify the horizontal alignment of the image when using ACTUAL style
	 */
	public void setImageAlignmentY(float alignmentY)
	{
		this.alignmentY = alignmentY > 1.0f ? 1.0f : alignmentY < 0.0f ? 0.0f : alignmentY;
		repaint();
	}

	/*
	 *  Override method so we can make the component transparent
	 */
	public void add(JComponent component)
	{
		add(component, null);
	}

	/*
	 *  Override to provide a preferred size equal to the image size
	 */
	@Override
	public Dimension getPreferredSize()
	{
		if (image == null)
			return super.getPreferredSize();
		else
			return new Dimension(image.getWidth(null), image.getHeight(null));
	}

	/*
	 *  Override method so we can make the component transparent
	 */
	public void add(JComponent component, Object constraints)
	{
		if (isTransparentAdd)
		{
			makeComponentTransparent(component);
		}

		super.add(component, constraints);
	}

	/*
	 *  Controls whether components added to this panel should automatically
	 *  be made transparent. That is, setOpaque(false) will be invoked.
	 *  The default is set to true.
	 */
	public void setTransparentAdd(boolean isTransparentAdd)
	{
		this.isTransparentAdd = isTransparentAdd;
	}

	/*
	 *	Try to make the component transparent.
	 *  For components that use renderers, like JTable, you will also need to
	 *  change the renderer to be transparent. An easy way to do this it to
	 *  set the background of the table to a Color using an alpha value of 0.
	 */
	private void makeComponentTransparent(JComponent component)
	{
		component.setOpaque( false );

		if (component instanceof JScrollPane)
		{
			JScrollPane scrollPane = (JScrollPane)component;
			JViewport viewport = scrollPane.getViewport();
			viewport.setOpaque( false );
			Component c = viewport.getView();

			if (c instanceof JComponent)
			{
				((JComponent)c).setOpaque( false );
			}
		}
	}

	/*
	 *  Add custom painting
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		//  Invoke the painter for the background

		if (painter != null)
		{
			Dimension d = getSize();
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(painter);
			g2.fill( new Rectangle(0, 0, d.width, d.height) );
		}

		//  Draw the image

		if (image == null ) return;

		switch (style)
		{
			case SCALED :
				drawScaled(g);
				break;

			case TILED  :
				drawTiled(g);
				break;

			case ACTUAL :
				drawActual(g);
				break;

			default:
            	drawScaled(g);
		}
	}

	/*
	 *  Custom painting code for drawing a SCALED image as the background
	 */
	private void drawScaled(Graphics g)
	{
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}

	/*
	 *  Custom painting code for drawing TILED images as the background
	 */
	private void drawTiled(Graphics g)
	{
		   Dimension d = getSize();
		   int width = image.getWidth( null );
		   int height = image.getHeight( null );

		   for (int x = 0; x < d.width; x += width)
		   {
			   for (int y = 0; y < d.height; y += height)
			   {
				   g.drawImage( image, x, y, null, null );
			   }
		   }
	}

	/*
	 *  Custom painting code for drawing the ACTUAL image as the background.
	 *  The image is positioned in the panel based on the horizontal and
	 *  vertical alignments specified.
	 */
	private void drawActual(Graphics g)
	{
		Dimension d = getSize();
		Insets insets = getInsets();
		int width = d.width - insets.left - insets.right;
		int height = d.height - insets.top - insets.left;
		float x = (width - image.getWidth(null)) * alignmentX;
		float y = (height - image.getHeight(null)) * alignmentY;
		g.drawImage(image, (int)x + insets.left, (int)y + insets.top, this);
	}
}