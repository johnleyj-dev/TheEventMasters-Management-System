import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;

public class frameManageVenue extends JFrame {

	private JPanel contentPane;
	public static JTable tblVenue;
	public static frameAdminMain frmAdminMain;
	private String[] columns = {"Venue ID", "NAME", "PLACE", "COST", "CONTACT NO.", "IMAGE URL"};
	private Object[] rowData;
	public static DefaultTableModel modelVenue = new DefaultTableModel();
	public static int venueId = 1;
	private boolean add = false, update = false;
	private JLabel lblVenueNo;
	public static JLabel lblVenueID;
	private JLabel lblVenueName;
	public static JTextField txtVenueName;
	private JLabel lblPlaceOfVenue;
	public static JTextField txtVenuePlace;
	private JLabel lblCost;
	public static JTextField txtVenueCost;
	private JLabel lblContactNo;
	public static JTextField txtVenueContact;
	private JButton btnAddVenue;
	private JButton btnSave;
	private JButton btnBack;
	private JButton btnDelete;
	private JButton btnCancel;
	private JLabel lblRecords;
	public static JLabel lblRecordCount;
	public static int venueCount = 1;
	private JPanel panel;
	private JLabel lblImgPreview;
	private JButton btnChooseImage;
	private JLabel lblImgUrl;
	public static String path;
	private JButton btnUpdate;
	
	
	
	public frameManageVenue() {
		setResizable(false);
		setTitle("VENUE MANAGEMENT");
		setBounds(100, 100, 750, 410);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 55, 459, 234);
		contentPane.add(scrollPane);
		
		tblVenue = new JTable(modelVenue);
		tblVenue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				showDetails();
				//validation to disable buttons if a row is selected
				if(tblVenue.getSelectedRowCount() > 0) {
					btnAddVenue.setEnabled(false);
					btnCancel.setEnabled(true);
				}
			}
		});
		tblVenue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showDetails();
				if(tblVenue.getSelectedRowCount() > 0) {
					btnAddVenue.setEnabled(false);
					btnCancel.setEnabled(true);
				}
			}
		});
		
		modelVenue.setColumnIdentifiers(columns);
		tblVenue.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tblVenue);
		
		lblVenueNo = new JLabel("VENUE NO.:");
		lblVenueNo.setForeground(Color.BLACK);
		lblVenueNo.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblVenueNo.setBounds(10, 55, 83, 14);
		contentPane.add(lblVenueNo);
		
		lblVenueID = new JLabel("");
		lblVenueID.setForeground(Color.BLACK);
		lblVenueID.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblVenueID.setBounds(111, 55, 54, 14);
		contentPane.add(lblVenueID);
		
		lblVenueName = new JLabel("VENUE NAME: ");
		lblVenueName.setForeground(Color.BLACK);
		lblVenueName.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblVenueName.setBounds(10, 86, 108, 14);
		contentPane.add(lblVenueName);
		
		txtVenueName = new JTextField();
		txtVenueName.setBounds(111, 83, 140, 20);
		contentPane.add(txtVenueName);
		txtVenueName.setColumns(10);
		
		lblPlaceOfVenue = new JLabel("PLACE:");
		lblPlaceOfVenue.setForeground(Color.BLACK);
		lblPlaceOfVenue.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblPlaceOfVenue.setBounds(10, 119, 83, 14);
		contentPane.add(lblPlaceOfVenue);
		
		txtVenuePlace = new JTextField();
		txtVenuePlace.setColumns(10);
		txtVenuePlace.setBounds(111, 116, 140, 20);
		contentPane.add(txtVenuePlace);
		
		lblCost = new JLabel("COST:");
		lblCost.setForeground(Color.BLACK);
		lblCost.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblCost.setBounds(10, 154, 67, 14);
		contentPane.add(lblCost);
		
		txtVenueCost = new JTextField();
		txtVenueCost.addKeyListener(new KeyAdapter() {
			@Override
			//to type numbers only to the txtfield
			public void keyTyped(KeyEvent e) {
				char temp = e.getKeyChar();
				if(!(Character.isDigit(temp) || (temp ==KeyEvent.VK_BACK_SPACE) || temp==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		txtVenueCost.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtVenueCost.setColumns(10);
		txtVenueCost.setBounds(111, 151, 140, 20);
		contentPane.add(txtVenueCost);
		
		lblContactNo = new JLabel("CONTACT NO.:");
		lblContactNo.setForeground(Color.BLACK);
		lblContactNo.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblContactNo.setBounds(10, 185, 108, 14);
		contentPane.add(lblContactNo);
		
		txtVenueContact = new JTextField();
		txtVenueContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char temp = e.getKeyChar();
				if(!(Character.isDigit(temp) || (temp ==KeyEvent.VK_BACK_SPACE) || temp==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		txtVenueContact.setColumns(10);
		txtVenueContact.setBounds(111, 182, 140, 20);
		contentPane.add(txtVenueContact);
		
		btnAddVenue = new JButton("ADD VENUE");
		btnAddVenue.setForeground(Color.WHITE);
		btnAddVenue.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnAddVenue.setBackground(new Color(0, 100, 0));
		btnAddVenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addVenue();
			}
		});
		btnAddVenue.setBounds(280, 300, 108, 23);
		contentPane.add(btnAddVenue);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(205, 133, 63));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateVenue();
			}
		});
		btnUpdate.setBounds(398, 300, 90, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteVenue();
			}
		});
		btnDelete.setBounds(500, 300, 90, 23);
		contentPane.add(btnDelete);
		
		btnSave = new JButton("SAVE");
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnSave.setBackground(new Color(46, 139, 87));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveVenue();
			}
		});
		btnSave.setBounds(344, 334, 90, 23);
		contentPane.add(btnSave);
		
		btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		btnBack.setBackground(new Color(105, 105, 105));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAdminMain = new frameAdminMain();
				frmAdminMain.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(600, 14, 89, 23);
		contentPane.add(btnBack);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnCancel.setBackground(new Color(205, 92, 92));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDefaults();
			}
		});
		btnCancel.setBounds(453, 334, 90, 23);
		contentPane.add(btnCancel);
		
		lblRecords = new JLabel("Records: ");
		lblRecords.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblRecords.setBounds(655, 300, 61, 14);
		contentPane.add(lblRecords);
		
		lblRecordCount = new JLabel("");
		lblRecordCount.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblRecordCount.setBounds(711, 300, 46, 14);
		contentPane.add(lblRecordCount);
		
		JLabel lblImage = new JLabel("IMAGE:");
		lblImage.setForeground(Color.BLACK);
		lblImage.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblImage.setBounds(10, 220, 46, 14);
		contentPane.add(lblImage);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(76, 220, 175, 107);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblImgPreview = new JLabel("");
		lblImgPreview.setBounds(0, 0, 175, 107);
		panel.add(lblImgPreview);
		lblImgPreview.setForeground(Color.BLACK);
		lblImgPreview.setBackground(Color.WHITE);
		
		btnChooseImage = new JButton("Choose Image");
		btnChooseImage.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addingImage();
			}
		});
		btnChooseImage.setBounds(106, 330, 115, 23);
		contentPane.add(btnChooseImage);
		
		lblImgUrl = new JLabel("");
		lblImgUrl.setBounds(228, 338, 149, 14);
		lblImgUrl.setVisible(false);
		contentPane.add(lblImgUrl);
		
		
		loadDefaults();
	}
	
	//method for choosing the image of a venue; when 'Choose Image' clicked
	private void addingImage(){
		
		JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        //filter the files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
         //if the user click on save in JFileChooser
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            lblImgPreview.setIcon(ResizeImage(path));
            lblImgUrl.setText(path);
        }
        else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No File Select");
        }
	}
	
	 // Method to resize imageIcon with the same size of Jlabel
	 public ImageIcon ResizeImage(String ImagePath){
		 
		 ImageIcon MyImage = new ImageIcon(ImagePath);
	     Image img = MyImage.getImage();
	     Image newImg = img.getScaledInstance(lblImgPreview.getWidth(), lblImgPreview.getHeight(), Image.SCALE_SMOOTH);
	     ImageIcon image = new ImageIcon(newImg);
	     return image;
	     
	 }
	
	
	private void loadDefaults(){
		lblVenueID.setText(null);
		txtVenueName.setText(null);
		txtVenuePlace.setText(null);
		txtVenueCost.setText(null);
		txtVenueContact.setText(null);
		lblImgPreview.setIcon(null);
		lblRecordCount.setText(String.valueOf(modelVenue.getRowCount()));
		
		lblImgUrl.setText(null);
		
		handleTxtFields(false);
		tblVenue.clearSelection();
		add = false;
		update = false;
		handleButtons();
		
	}
	
	//validations for enabling and disabling the buttons
	private void handleButtons() {
		
		handleAddBtn();
		handleUpdBtn();
		
		if(tblVenue.getRowCount() > 0) {
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
		}else {
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
		}
	}
	
	private void handleAddBtn() {
		if(add) {
			btnAddVenue.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
		}else {
			btnAddVenue.setEnabled(true);
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
		}
	}
	
	private void handleUpdBtn() {
		if(update) {
			btnUpdate.setEnabled(false);
			btnAddVenue.setEnabled(false);
			btnDelete.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
		}else {
			btnUpdate.setEnabled(true);
			btnAddVenue.setEnabled(true);
			btnDelete.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
		}
	}
	
	private void handleTxtFields(boolean status) {
		
		txtVenueName.setEnabled(status);
		txtVenuePlace.setEnabled(status);
		txtVenueCost.setEnabled(status);
		txtVenueContact.setEnabled(status);
		btnChooseImage.setEnabled(status);
	}
	
	//if the user wants to add a venue
	private void addVenue(){
		add = true;
		handleTxtFields(true);
		handleAddBtn();
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		lblVenueID.setText(String.valueOf(venueId));
	}
	
	//if the user wants to update the venue
	private void updateVenue(){  
		if(tblVenue.getSelectedRow() >= 0 && tblVenue.getSelectedRow() < tblVenue.getRowCount()){
			update = true;
			handleTxtFields(true);
			handleUpdBtn();
			lblImgUrl.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 5)));
		}
		else
			JOptionPane.showMessageDialog(null, "Select a venue first.");
	}
	
	//when the button 'SAVE' clicked
	private void saveVenue(){
		String validations[] = {"Name of Venue is empty.", "Venue Place is empty.", "Venue Cost is empty.", "Contact No. is empty.", "Put an image of the venue."};
		
		if(txtVenueName.getText().equals("") && txtVenuePlace.getText().equals("") && txtVenueCost.getText().equals("") && txtVenueContact.getText().equals("") && lblImgUrl.getText().equals(""))
			JOptionPane.showMessageDialog(null, validations);
		
		else if(txtVenueName.getText().equals("")){
			JOptionPane.showMessageDialog(null, validations[0]);
			txtVenueName.requestFocus();
		}
		else if(txtVenuePlace.getText().equals("")){
			JOptionPane.showMessageDialog(null, validations[1]);
			txtVenuePlace.requestFocus();
		}
		else if(txtVenueCost.getText().equals("")){
			JOptionPane.showMessageDialog(null, validations[2]);
			txtVenueCost.requestFocus();
		}
		else if(txtVenueContact.getText().equals("")){
			JOptionPane.showMessageDialog(null, validations[3]);
			txtVenueContact.requestFocus();
		}
		else if(lblImgUrl.getText().equals(""))
			JOptionPane.showMessageDialog(null, validations[4]);
		
		else{
			if(update == true) {
				update = false;
			
				modelVenue.setValueAt(txtVenueName.getText(), tblVenue.getSelectedRow(), 1);
				modelVenue.setValueAt(txtVenuePlace.getText(), tblVenue.getSelectedRow(), 2);
				modelVenue.setValueAt(Double.parseDouble(txtVenueCost.getText()), tblVenue.getSelectedRow(), 3);
				modelVenue.setValueAt(txtVenueContact.getText(), tblVenue.getSelectedRow(), 4);
				modelVenue.setValueAt(lblImgUrl.getText(), tblVenue.getSelectedRow(), 5);
				loadDefaults();
				JOptionPane.showMessageDialog(null, "The selected venue has been updated.");
			}
			
			if(add == true){
				if(isExist()==true)
					JOptionPane.showMessageDialog(null, "Venue already exists.");
				else { 
					if(isImageExist()==true) 
						JOptionPane.showMessageDialog(null, "Image already exists.");
					else{
					
						add = false;
				
						rowData = new Object[tblVenue.getColumnCount()];
						rowData[0] = lblVenueID.getText();
						rowData[1] = txtVenueName.getText();
						rowData[2] = txtVenuePlace.getText();
						rowData[3] = Double.parseDouble(txtVenueCost.getText());
						rowData[4] = txtVenueContact.getText();
						rowData[5] = lblImgUrl.getText();
						modelVenue.addRow(rowData);
						venueId++;
						lblRecordCount.setText(String.valueOf(modelVenue.getRowCount()));
						loadDefaults();
						venueCount++;
						JOptionPane.showMessageDialog(null, "Venue added successfully.");
					}
				}
			}
		}
	}
	
	//if the user wants to delete a venue
	private void deleteVenue(){
		if(tblVenue.getSelectedRow() >= 0 && tblVenue.getSelectedRow() < tblVenue.getRowCount()){
			int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete the selected venue?", "Warning", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION){
				modelVenue.removeRow(tblVenue.getSelectedRow());
				lblRecordCount.setText(String.valueOf(tblVenue.getRowCount()));
				loadDefaults();
				JOptionPane.showMessageDialog(null, "Selected venue has been deleted.");
			}
			else
				loadDefaults();
		}
		else
			JOptionPane.showMessageDialog(null, "Select a venue first.");
	}
	
	//if the user wants to show the values of selected row to the textfield. only if the add and update button are not clicked
	private void showDetails(){
		if(add == false && update == false) {
			lblVenueID.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 0)));
			txtVenueName.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 1)));
			txtVenuePlace.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 2)));
			txtVenueCost.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 3)));
			txtVenueContact.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 4)));
			lblImgPreview.setIcon(ResizeImage(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 5))));
		}
	}
	
	//validation if the venue name already exists
	private boolean isExist(){
		boolean found = false;
		
		for(int index=0; index < modelVenue.getRowCount(); index++){
			if(txtVenueName.getText().equals(tblVenue.getValueAt(index, 1))){
				found = true;
				break;
			}
		}
		return found;
	}
	
	//validation if the image already exists
	private boolean isImageExist(){
		boolean found = false;
		
		for(int index=0; index < modelVenue.getRowCount(); index++){
			if(lblImgUrl.getText().equals(tblVenue.getValueAt(index, 5))){
				found = true;
				break;
			}
		}
		return found;
	}
}
