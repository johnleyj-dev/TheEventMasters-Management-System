import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.awt.Font;

public class frameUpdateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtMobileNo;
	private JButton btnBack;
	public static frameEventMngrMain frmEMMain;
	private JPasswordField txtPassword;
	private JButton btnCancel;
	private JButton btnUpdate;
	private JButton btnEdit;
	private JTextArea txtAreaAddress;
	private JCheckBox chkShowPass;
	private JLabel lblIdNo;
	private JRadioButton rdoMale;
	private JRadioButton rdoFemale;
	private boolean edit = false;
	private JLabel lblValidation;

	
	public frameUpdateAccount() {
		setTitle("UPDATE ACCOUNT");
		setResizable(false);
		setBounds(100, 100, 690, 425);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME: ");
		lblName.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblName.setBounds(34, 80, 68, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(112, 77, 132, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		btnBack.setBackground(new Color(105, 105, 105));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEMMain = new frameEventMngrMain();
				frmEMMain.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(545, 15, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblEmail = new JLabel("E-MAIL: ");
		lblEmail.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblEmail.setBounds(34, 120, 74, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(112, 117, 132, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO.:");
		lblMobileNo.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblMobileNo.setBounds(34, 154, 89, 14);
		contentPane.add(lblMobileNo);
		
		txtMobileNo = new JTextField();
		txtMobileNo.addKeyListener(new KeyAdapter() {
			@Override
			//validate if the user doesn't enter numbers
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
		txtMobileNo.setBounds(112, 151, 132, 20);
		contentPane.add(txtMobileNo);
		txtMobileNo.setColumns(10);
		
		JPanel panelSex = new JPanel();
		panelSex.setBackground(new Color(95, 158, 160));
		panelSex.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "SEX:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSex.setBounds(34, 195, 110, 72);
		contentPane.add(panelSex);
		panelSex.setLayout(null);
		
		rdoMale = new JRadioButton("MALE");
		rdoMale.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		rdoMale.setBackground(new Color(95, 158, 160));
		rdoMale.setBounds(6, 16, 98, 23);
		panelSex.add(rdoMale);
		
		rdoFemale = new JRadioButton("FEMALE");
		rdoFemale.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		rdoFemale.setBackground(new Color(95, 158, 160));
		rdoFemale.setBounds(6, 42, 98, 23);
		panelSex.add(rdoFemale);
		
		JLabel label = new JLabel("ID NO.:");
		label.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label.setBounds(349, 80, 61, 14);
		contentPane.add(label);
		
		lblIdNo = new JLabel("");
		lblIdNo.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblIdNo.setBounds(429, 80, 61, 14);
		contentPane.add(lblIdNo);
		
		JLabel lblPassword = new JLabel("PASSWORD:");
		lblPassword.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblPassword.setBounds(349, 120, 81, 14);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(429, 117, 132, 20);
		contentPane.add(txtPassword);
		
		chkShowPass = new JCheckBox("Show Password");
		chkShowPass.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		chkShowPass.setBackground(new Color(95, 158, 160));
		chkShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPass();
			}
		});
		chkShowPass.setBounds(429, 141, 132, 23);
		contentPane.add(chkShowPass);
		
		JLabel lblAddress = new JLabel("ADDRESS:");
		lblAddress.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblAddress.setBounds(349, 176, 68, 14);
		contentPane.add(lblAddress);
		
		txtAreaAddress = new JTextArea();
		txtAreaAddress.setBounds(429, 176, 218, 96);
		contentPane.add(txtAreaAddress);
		
		btnEdit = new JButton("EDIT");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnEdit.setBackground(new Color(205, 133, 63));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editAcc();
			}
		});
		btnEdit.setBounds(196, 309, 89, 29);
		contentPane.add(btnEdit);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(46, 139, 87));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAcc();
			}
		});
		btnUpdate.setBounds(295, 309, 89, 29);
		contentPane.add(btnUpdate);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnCancel.setBackground(new Color(205, 92, 92));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDefaults();
			}
		});
		btnCancel.setBounds(394, 309, 89, 29);
		contentPane.add(btnCancel);
		
		lblValidation = new JLabel("");
		lblValidation.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblValidation.setForeground(Color.RED);
		lblValidation.setBounds(112, 170, 132, 14);
		contentPane.add(lblValidation);
		
		loadDefaults();
	}
	
	private void showPass(){
		if(chkShowPass.isSelected()==true)
			txtPassword.setEchoChar((char)0);
		else
			txtPassword.setEchoChar('•');
	}
	
	private void handleTextFields(boolean status){
		txtName.setEnabled(status);
		txtEmail.setEnabled(status);
		txtMobileNo.setEnabled(status);
		txtPassword.setEnabled(status);
		txtAreaAddress.setEnabled(status);
		
	}
	
	private void loadDefaults() {
		handleTextFields(false);
		rdoMale.setEnabled(false);
		rdoFemale.setEnabled(false);
		chkShowPass.setEnabled(false);
		chkShowPass.setSelected(false);
		edit = false;
		
		if(frameMain.modelUser.getRowCount() > 0){
			for(int i=0; i < frameMain.modelUser.getRowCount(); i++){
				if(frameMain.userId.equals(frameMain.modelUser.getValueAt(i, 0))){
					lblIdNo.setText(String.valueOf(frameMain.modelUser.getValueAt(i, 0)));
					txtName.setText(String.valueOf(frameMain.modelUser.getValueAt(i, 1)));
					txtEmail.setText(String.valueOf(frameMain.modelUser.getValueAt(i, 2)));
					txtMobileNo.setText(String.valueOf(frameMain.modelUser.getValueAt(i, 3)));
					txtPassword.setText(String.valueOf(frameMain.modelUser.getValueAt(i, 4)));
					if(frameMain.modelUser.getValueAt(i, 5).equals("MALE"))
						rdoMale.setSelected(true);
					else
						rdoFemale.setSelected(true);
					txtAreaAddress.setText(String.valueOf(frameMain.modelUser.getValueAt(i, 6)));
				}
			}
		}
	}
	
	//if the event manager clicks the 'EDIT' button
	private void editAcc(){
		edit = true;
		handleTextFields(true);
		chkShowPass.setEnabled(true);
	}

	//if the event manager clicks the 'UPDATE' button
	private void updateAcc(){
		if(edit == true){
			
			if(txtName.getText().equals("") || txtEmail.getText().equals("") || txtMobileNo.getText().equals("") || txtAreaAddress.getText().equals("")|| txtPassword.getText().equals(""))
				JOptionPane.showMessageDialog(null, "Must fill up all information needed.");
			else{
				if(!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", txtEmail.getText())))
					JOptionPane.showMessageDialog(null, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
				else{
					edit = false;
					for(int i=0; i < frameMain.modelUser.getRowCount(); i++){
						if(frameMain.userId.equals(frameMain.modelUser.getValueAt(i, 0))){
							frameMain.modelUser.setValueAt(txtName.getText(), i, 1);
							frameMain.modelUser.setValueAt(txtEmail.getText(), i, 2);
							frameMain.modelUser.setValueAt(txtMobileNo.getText(), i, 3);
							frameMain.modelUser.setValueAt(new String(txtPassword.getPassword()), i, 4);
							frameMain.modelUser.setValueAt(txtAreaAddress.getText(), i, 6);
							loadDefaults();
							JOptionPane.showMessageDialog(null, "Your personal info has been updated.");
						}
					}
				}
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Click EDIT button if you want to update your account.");

	}
}
