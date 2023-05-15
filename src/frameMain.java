import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;


public class frameMain extends JFrame {

	private JPanel contentPane;
	public static frameAdminMain frmAdminMain;
	public static frameEventMngrMain frmEventMngrMain;
	private JLayeredPane layeredPane;
	
	//buttons for panels
	private JButton btnHome;
	private JButton btnUserLogin;
	private JButton btnRegister;
	private JButton btnAdminLogin;
	
	
	//admin login panel
	private JTextField txtAdminID;
	private JPasswordField txtPasswordAdmin;
	private JButton btnOkA;
	private JButton btnCancelA;
	private String adminId = "admin";
	private String adminPass = "admin";

	//register e.m. panel
	private JTextField txtNameUser;
	private JTextField txtEmailUser;
	private JLabel lblPassword_1;
	private JPasswordField txtPassword;
	private JRadioButton rdoMale;
	private JRadioButton rdoFemale;
	private ButtonGroup rdoBtnGroup = new ButtonGroup();
	private JLabel lblMobileNo;
	private JTextField txtMobileNo;
	private JLabel lblAddress;
	private JTextArea txtAddress;
	private JButton btnSubmit;
	private JButton btnCancel;
	private JLabel lblValidation;
	private Object[] rowData;
	private JLabel lblIdNo;
	
	//e.m. login panel
	private JTextField txtUserID;
	private JPasswordField txtPasswordUser;
	private JLabel lblPassword;
	private JButton btnOkU;
	private JButton btnCancelU;
	public static String userId;
	private String pass;
	private boolean registeredUser = false;
	private JPanel pnlEMLogin;
	private JCheckBox showPasswordU;
	private JCheckBox chkShowPass;
	private JCheckBox showPasswordA;
	
	public static JTable tblUser;
	public static String[] columns = {"ID NO.", "NAME", "EMAIL", "MOBILE NO.", "PASSWORD", "SEX", "ADDRESS"};
	public static DefaultTableModel modelUser = new DefaultTableModel();
	public static int idNo = 1001;
	private JLabel lblNewLabel_3;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	
	

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameMain frame = new frameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frameMain() {
		setResizable(false);
		setTitle("THE EVENT MASTERS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 470);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new MatteBorder(0, 3, 0, 0, (Color) new Color(0, 0, 0)));
		layeredPane.setBounds(197, 0, 532, 440);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel pnlHome = new JPanel();
		pnlHome.setForeground(new Color(255, 255, 255));
		pnlHome.setBackground(new Color(47, 79, 79));
		layeredPane.add(pnlHome, "name_1498439099939839");
		pnlHome.setLayout(null);
		
		
		JLabel lblTheEventMasters = new JLabel("-THE EVENT MASTERS-");
		lblTheEventMasters.setForeground(new Color(255, 255, 255));
		lblTheEventMasters.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		lblTheEventMasters.setBounds(22, 37, 234, 14);
		pnlHome.add(lblTheEventMasters);
		
		
		JLabel lblNewLabel = new JLabel("<html>        THE EVENT MASTERS is considered to be one of the best event management companies because of our qualified and well trained staff, which is the reason we are growing each day in just a short time of span.\r\nWe are not only about planning an event. We make sure our clients will have a unique experience working with us.</html>");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 89, 475, 105);
		pnlHome.add(lblNewLabel);
		
		
		JLabel lblWorkingWithThe = new JLabel("<html> Working with THE EVENT MASTERS, we guarantee to satisfy our customers whether it's a wedding or a commercial event. </html>");
		lblWorkingWithThe.setForeground(new Color(255, 255, 255));
		lblWorkingWithThe.setVerticalAlignment(SwingConstants.TOP);
		lblWorkingWithThe.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		lblWorkingWithThe.setBounds(22, 301, 432, 72);
		pnlHome.add(lblWorkingWithThe);
		
		
		JLabel lblVisitWwwtheeventmasterscomph = new JLabel("Visit theeventmasters.com.ph for more... ");
		lblVisitWwwtheeventmasterscomph.setForeground(new Color(255, 255, 255));
		lblVisitWwwtheeventmasterscomph.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 11));
		lblVisitWwwtheeventmasterscomph.setHorizontalAlignment(SwingConstants.LEFT);
		lblVisitWwwtheeventmasterscomph.setBounds(22, 384, 291, 14);
		pnlHome.add(lblVisitWwwtheeventmasterscomph);
		
		
		JLabel lblourProfessionallyTrained = new JLabel("<html>Our professionally trained staff is well experienced in all of the requirements of an event. Each staff knows how to satisfy the needs of our clients from different caters to decorate with unique ideas.</html>");
		lblourProfessionallyTrained.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		lblourProfessionallyTrained.setForeground(new Color(255, 255, 255));
		lblourProfessionallyTrained.setVerticalAlignment(SwingConstants.TOP);
		lblourProfessionallyTrained.setBounds(22, 205, 475, 79);
		pnlHome.add(lblourProfessionallyTrained);
		
		tblUser = new JTable(modelUser);
		tblUser.setDefaultEditor(Object.class, null);
		tblUser.setVisible(false);
		modelUser.setColumnIdentifiers(columns);
		
		tblUser.setBounds(497, 386, 22, 14);
		pnlHome.add(tblUser);
		
		pnlEMLogin = new JPanel();
		pnlEMLogin.setBackground(new Color(47, 79, 79));
		layeredPane.add(pnlEMLogin, "name_1498443812475737");
		pnlEMLogin.setLayout(null);
		
		
		JLabel lblEventManagerLogin = new JLabel("-EVENT MANAGER LOGIN-");
		lblEventManagerLogin.setForeground(new Color(255, 255, 255));
		lblEventManagerLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventManagerLogin.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		lblEventManagerLogin.setBounds(156, 59, 229, 14);
		pnlEMLogin.add(lblEventManagerLogin);
		
		
		JLabel lblNewLabel_1 = new JLabel("EVENT MANAGER ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(129, 147, 117, 14);
		pnlEMLogin.add(lblNewLabel_1);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(259, 144, 138, 20);
		pnlEMLogin.add(txtUserID);
		txtUserID.setColumns(10);
		
		txtPasswordUser = new JPasswordField();
		txtPasswordUser.setBounds(259, 194, 138, 20);
		pnlEMLogin.add(txtPasswordUser);
		
		lblPassword = new JLabel("PASSWORD:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblPassword.setBounds(129, 197, 86, 14);
		pnlEMLogin.add(lblPassword);
		
		btnOkU = new JButton("OK");
		btnOkU.setForeground(Color.WHITE);
		btnOkU.setBackground(new Color(46, 139, 87));
		btnOkU.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnOkU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginEventManager();
			}
		});
		btnOkU.setBounds(169, 272, 89, 23);
		pnlEMLogin.add(btnOkU);
		
		btnCancelU = new JButton("CANCEL");
		btnCancelU.setForeground(Color.WHITE);
		btnCancelU.setBackground(new Color(205, 92, 92));
		btnCancelU.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnCancelU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUserID.setText(null);
				txtPasswordUser.setText(null);
				showPasswordU.setSelected(false);
				switchPanels(pnlHome);
			}
		});
		btnCancelU.setBounds(296, 272, 89, 23);
		pnlEMLogin.add(btnCancelU);
		
		showPasswordU = new JCheckBox("Show Password");
		showPasswordU.setForeground(new Color(255, 255, 255));
		showPasswordU.setBackground(new Color(47, 79, 79));
		showPasswordU.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		showPasswordU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPasswordforUser();
			}
		});
		showPasswordU.setBounds(259, 221, 126, 23);
		pnlEMLogin.add(showPasswordU);
		
		JPanel pnlEMRegister = new JPanel();
		pnlEMRegister.setBackground(new Color(47, 79, 79));
		layeredPane.add(pnlEMRegister, "name_1498481343772596");
		pnlEMRegister.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("-REGISTER AN EVENT MANAGER-");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(160, 40, 281, 14);
		pnlEMRegister.add(lblNewLabel_2);
		
		JLabel lblName= new JLabel("NAME:");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblName.setBounds(10, 147, 53, 14);
		pnlEMRegister.add(lblName);
		
		txtNameUser = new JTextField();
		txtNameUser.setBounds(92, 145, 152, 20);
		pnlEMRegister.add(txtNameUser);
		txtNameUser.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblEmail.setBounds(10, 182, 53, 14);
		pnlEMRegister.add(lblEmail);
		
		txtEmailUser = new JTextField();
		txtEmailUser.setBounds(92, 180, 152, 20);
		pnlEMRegister.add(txtEmailUser);
		txtEmailUser.setColumns(10);
		
		lblPassword_1 = new JLabel("PASSWORD:");
		lblPassword_1.setForeground(new Color(255, 255, 255));
		lblPassword_1.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblPassword_1.setBounds(259, 182, 76, 14);
		pnlEMRegister.add(lblPassword_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(376, 180, 131, 20);
		pnlEMRegister.add(txtPassword);
		
		JPanel panelSex = new JPanel();
		panelSex.setForeground(new Color(255, 255, 255));
		panelSex.setBackground(new Color(47, 79, 79));
		panelSex.setBorder(new TitledBorder(null, "SEX", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelSex.setBounds(10, 260, 105, 73);
		pnlEMRegister.add(panelSex);
		panelSex.setLayout(null);
		
		rdoMale = new JRadioButton("MALE");
		rdoMale.setForeground(new Color(255, 255, 255));
		rdoMale.setBackground(new Color(47, 79, 79));
		rdoMale.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		rdoMale.setBounds(6, 16, 93, 23);
		panelSex.add(rdoMale);
		
		rdoFemale = new JRadioButton("FEMALE");
		rdoFemale.setForeground(new Color(255, 255, 255));
		rdoFemale.setBackground(new Color(47, 79, 79));
		rdoFemale.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		rdoFemale.setBounds(6, 43, 93, 23);
		panelSex.add(rdoFemale);
		
		rdoBtnGroup.add(rdoMale);
		rdoBtnGroup.add(rdoFemale);
		
		lblMobileNo = new JLabel("MOBILE NO.");
		lblMobileNo.setForeground(new Color(255, 255, 255));
		lblMobileNo.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblMobileNo.setBounds(10, 216, 76, 14);
		pnlEMRegister.add(lblMobileNo);
		
		txtMobileNo = new JTextField();
		txtMobileNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				char input = e.getKeyChar();
			    
			    if ((input < '0' || input > '9') && input != '\b'){
			     e.consume();
			     lblValidation.setText("Invalid mobile number!");
			    }
			    else
			     lblValidation.setText("");
			    
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char temp = e.getKeyChar();
				if(!(Character.isDigit(temp) || (temp ==KeyEvent.VK_BACK_SPACE) || temp==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		
		txtMobileNo.setBounds(92, 214, 152, 20);
		pnlEMRegister.add(txtMobileNo);
		txtMobileNo.setColumns(10);
		
		lblValidation = new JLabel("");
		lblValidation.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblValidation.setForeground(Color.RED);
		lblValidation.setBounds(92, 235, 131, 14);
		pnlEMRegister.add(lblValidation);
		
		lblAddress = new JLabel("ADDRESS:");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblAddress.setBounds(259, 235, 76, 14);
		pnlEMRegister.add(lblAddress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 254, 248, 90);
		pnlEMRegister.add(scrollPane);
		
		txtAddress = new JTextArea();
		scrollPane.setViewportView(txtAddress);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(46, 139, 87));
		btnSubmit.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerEventManager();
			}
		});
		btnSubmit.setBounds(155, 369, 89, 23);
		pnlEMRegister.add(btnSubmit);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(205, 92, 92));
		btnCancel.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDefaultForPnlReg();
				switchPanels(pnlHome);
			}
		});
		btnCancel.setBounds(285, 369, 89, 23);
		pnlEMRegister.add(btnCancel);
		
		JLabel labelIdNo = new JLabel("ID No: ");
		labelIdNo.setForeground(new Color(255, 255, 255));
		labelIdNo.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		labelIdNo.setBounds(259, 148, 59, 14);
		pnlEMRegister.add(labelIdNo);
		
		lblIdNo = new JLabel("");
		lblIdNo.setForeground(new Color(255, 255, 255));
		lblIdNo.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblIdNo.setBounds(376, 148, 65, 14);
		pnlEMRegister.add(lblIdNo);
		
		chkShowPass = new JCheckBox("Show Password");
		chkShowPass.setForeground(Color.WHITE);
		chkShowPass.setBackground(new Color(47, 79, 79));
		chkShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPassword();
			}
		});
		chkShowPass.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		chkShowPass.setBounds(376, 207, 123, 23);
		pnlEMRegister.add(chkShowPass);
		
		JPanel pnlAdminLogin = new JPanel();
		pnlAdminLogin.setBackground(new Color(47, 79, 79));
		layeredPane.add(pnlAdminLogin, "name_1498506871371612");
		pnlAdminLogin.setLayout(null);
		
		
		JLabel lblAdminId = new JLabel("ADMIN ID: ");
		lblAdminId.setForeground(Color.WHITE);
		lblAdminId.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblAdminId.setBounds(142, 147, 92, 14);
		pnlAdminLogin.add(lblAdminId);
		
		txtAdminID = new JTextField();
		txtAdminID.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtAdminID.setColumns(10);
		txtAdminID.setBounds(259, 144, 138, 20);
		pnlAdminLogin.add(txtAdminID);
		
		txtPasswordAdmin = new JPasswordField();
		txtPasswordAdmin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPasswordAdmin.setBounds(259, 194, 138, 20);
		pnlAdminLogin.add(txtPasswordAdmin);
		
		JLabel lblPassword_2 = new JLabel("PASSWORD:");
		lblPassword_2.setForeground(Color.WHITE);
		lblPassword_2.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblPassword_2.setBounds(142, 197, 92, 14);
		pnlAdminLogin.add(lblPassword_2);
		
		btnOkA = new JButton("OK");
		btnOkA.setForeground(Color.WHITE);
		btnOkA.setBackground(new Color(46, 139, 87));
		btnOkA.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnOkA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAdmin();
			}
		});
		btnOkA.setBounds(156, 273, 89, 23);
		pnlAdminLogin.add(btnOkA);
		
		btnCancelA = new JButton("CANCEL");
		btnCancelA.setForeground(Color.WHITE);
		btnCancelA.setBackground(new Color(205, 92, 92));
		btnCancelA.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnCancelA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAdminID.setText(null);
				txtPasswordAdmin.setText(null);
				showPasswordA.setSelected(false);
				switchPanels(pnlHome);
			}
		});
		btnCancelA.setBounds(283, 273, 89, 23);
		pnlAdminLogin.add(btnCancelA);
		
		JLabel lblLoginAsAdmin = new JLabel("-ADMIN LOGIN-");
		lblLoginAsAdmin.setForeground(Color.WHITE);
		lblLoginAsAdmin.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		lblLoginAsAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginAsAdmin.setBounds(198, 59, 138, 14);
		pnlAdminLogin.add(lblLoginAsAdmin);
		
		showPasswordA = new JCheckBox("Show Password");
		showPasswordA.setForeground(Color.WHITE);
		showPasswordA.setBackground(new Color(47, 79, 79));
		showPasswordA.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		showPasswordA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPasswordforAdmin();
			}
		});
		showPasswordA.setBounds(259, 221, 125, 23);
		pnlAdminLogin.add(showPasswordA);
		
		btnUserLogin = new JButton("LOG IN");
		btnUserLogin.setForeground(new Color(255, 255, 255));
		btnUserLogin.setBackground(new Color(47, 79, 79));
		btnUserLogin.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(pnlEMLogin);
			}
		});
		btnUserLogin.setBounds(43, 159, 99, 23);
		contentPane.add(btnUserLogin);
		
		btnRegister = new JButton("REGISTER");
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(47, 79, 79));
		btnRegister.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(pnlEMRegister);
			}
		});
		btnRegister.setBounds(43, 247, 99, 23);
		contentPane.add(btnRegister);
		
		btnAdminLogin = new JButton("ADMIN");
		btnAdminLogin.setForeground(new Color(255, 255, 255));
		btnAdminLogin.setBackground(new Color(47, 79, 79));
		btnAdminLogin.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(pnlAdminLogin);
			}
		});
		btnAdminLogin.setBounds(43, 339, 99, 23);
		contentPane.add(btnAdminLogin);
		
		btnHome = new JButton("H O M E");
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(47, 79, 79));
		btnHome.setBounds(43, 66, 100, 21);
		contentPane.add(btnHome);
		btnHome.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-75, 33, 282, 83);
		contentPane.add(lblNewLabel_3);
		
		label = new JLabel("");
		label.setBounds(-74, 127, 282, 83);
		contentPane.add(label);
		
		label_1 = new JLabel("");
		label_1.setBounds(-74, 215, 282, 83);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setBounds(-74, 307, 282, 83);
		contentPane.add(label_2);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(pnlHome);
			}
		});
		
		loadDefaultForPnlReg();
		
	}
	
	//method for switching the panels when clicking the main buttons
	public void switchPanels(JPanel panel){
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private void showPassword(){
		if(chkShowPass.isSelected()==true)
			txtPassword.setEchoChar((char)0);
		else
			txtPassword.setEchoChar('•');
	}
	
	private void showPasswordforAdmin(){
		if(showPasswordA.isSelected()==true)
			txtPasswordAdmin.setEchoChar((char)0);
		else
			txtPasswordAdmin.setEchoChar('•');
	}
	
	private void showPasswordforUser(){
		if(showPasswordU.isSelected()==true)
			txtPasswordUser.setEchoChar((char)0);
		else
			txtPasswordUser.setEchoChar('•');
	}
	
	private void loadDefaultForPnlReg(){
		lblIdNo.setText(String.valueOf(idNo));
		txtNameUser.setText(null);
		txtEmailUser.setText(null);
		txtMobileNo.setText(null);
		txtPassword.setText(null);
		txtAddress.setText(null);
		rdoMale.setSelected(true);
		chkShowPass.setSelected(false);
	}
	
	
	//method and some validation if the admin wants to login
	private void loginAdmin(){
		String passAdmin = new String(txtPasswordAdmin.getPassword());
		if(txtAdminID.getText().equals("") && txtPasswordAdmin.equals("")){
			JOptionPane.showMessageDialog(null, "Type your ID and password.");
			txtAdminID.requestFocus();
		}
		else if(txtAdminID.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please enter your ID.");
			txtAdminID.requestFocus();
		}
		else if(passAdmin.equals("")){
			JOptionPane.showMessageDialog(null, "Please enter your password.");
			txtPasswordAdmin.requestFocus();
		}
			
		else{
			if(txtAdminID.getText().equals(adminId) && passAdmin.equals(adminPass)){
					JOptionPane.showMessageDialog(null, "Successfully login. \nWelcome Admin!");
					
					
					frmAdminMain = new frameAdminMain();
					frmAdminMain.setVisible(true);
					setVisible(false);
			}
			else{
				JOptionPane.showMessageDialog(null, "Incorrect ID or password!");
				txtAdminID.setText(null);
				txtPasswordAdmin.setText(null);
				txtAdminID.requestFocus();
			}
		}
	}
	
	//to register an event manager
	private void registerEventManager(){
		if(txtNameUser.getText().equals("") || txtEmailUser.getText().equals("") || txtMobileNo.getText().equals("") || txtAddress.getText().equals("")|| txtPassword.getText().equals(""))
			JOptionPane.showMessageDialog(null, "Fill up all information needed.");
		
		else{
			if(!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txtEmailUser.getText())))
				JOptionPane.showMessageDialog(null, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
			
			else{
				if(isUserExist() == true)
					JOptionPane.showMessageDialog(null, "Event Manager already registered.");
				else{
					rowData = new Object[modelUser.getColumnCount()];
					rowData[0] = lblIdNo.getText();
					rowData[1] = txtNameUser.getText();
					rowData[2] = txtEmailUser.getText();
					rowData[3] = txtMobileNo.getText();
					rowData[4] = new String(txtPassword.getPassword());
					if(rdoMale.isSelected()==true)
						rowData[5] = rdoMale.getText();
					else
						rowData[5] = rdoFemale.getText();
					
					rowData[6] = txtAddress.getText();
					
					JOptionPane.showMessageDialog(null, "An Event Manager has successfully registered. \nYour ID is " + lblIdNo.getText() + ". Use it to login.");
					modelUser.addRow(rowData);
					idNo++;
					loadDefaultForPnlReg();
					switchPanels(pnlEMLogin);
				}
			}
		}
	}
	
	//if the event manager is already exist
	private boolean isUserExist(){
		boolean found = false;
		
		for(int i=0; i < modelUser.getRowCount(); i++){
			if(txtNameUser.getText().equals(tblUser.getValueAt(i, 1))){
				found = true;
				break;
			}
		}
		
		return found;
	}
	
	private void loadDefaultForEMLogin(){
		txtUserID.setText(null);
		txtPasswordUser.setText(null);
		txtUserID.requestFocus();
	}
	
	//method and some validations if an event manager wants to login to their account
	private void loginEventManager(){
		userId = txtUserID.getText();
		pass = new String(txtPasswordUser.getPassword());
			if(modelUser.getRowCount() <= 0){
				JOptionPane.showMessageDialog(contentPane, "There is no registered event manager.");
				txtUserID.setText(null);
				txtPasswordUser.setText(null);
				loadDefaultForEMLogin();
				
			}else{
				for(int i = 0; i < tblUser.getRowCount(); i++){
					if(modelUser.getValueAt(i, 0).equals(userId)){
						if(modelUser.getValueAt(i, 4).equals(pass)){
							
							JOptionPane.showMessageDialog(null, "Successfully login. Welcome!");
							
							frmEventMngrMain = new frameEventMngrMain();
							frmEventMngrMain.setVisible(true);
							registeredUser = true;
							setVisible(false);
							
						}
					}
				}
				if(registeredUser == false){
				JOptionPane.showMessageDialog(contentPane, "The ID No. and/or password you've entered is either incorrect or unregistered.");
				loadDefaultForEMLogin();
				}
			}
	}
}
