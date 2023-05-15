import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class frameManageFoodService extends JFrame {

	private JPanel contentPane;
	public static JTable tblFoodService;
	public static frameAdminMain frmAdmin;
	public static String[] columns = {"FoodService ID", "SERVICE NAME", "COST", "PRICE PER GUEST"};
	private Object[] rowData;
	public static DefaultTableModel modelFService = new DefaultTableModel();
	private boolean add = false, update = false;
	public static int fServiceId = 1;
	private JTextField txtFServiceName;
	private JTextField txtFServiceCost;
	private JButton btnBack;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnAddService;
	private JButton btnUpdate;
	private JButton btnDelete;
	public static JLabel lblRecordCount;
	public static JLabel lblFServiceId;
	
	private JTextField txtPricePerGuest;

	public frameManageFoodService() {
		setResizable(false);
		setTitle("FOOD SERVICE MANAGEMENT");
		setBounds(100, 100, 760, 378);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(291, 76, 452, 210);
		contentPane.add(scrollPane);
		
		tblFoodService = new JTable(modelFService);
		tblFoodService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showDetails();
				//validation to disable buttons if a row is selected
				if(tblFoodService.getSelectedRowCount() > 0) {
					btnAddService.setEnabled(false);
					btnCancel.setEnabled(true);
				}
			}
		});
		tblFoodService.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				showDetails();
				if(tblFoodService.getSelectedRowCount() > 0) {
					btnAddService.setEnabled(false);
					btnCancel.setEnabled(true);
				}
			}
		});
		modelFService.setColumnIdentifiers(columns);
		tblFoodService.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tblFoodService);
		
		JLabel lblFoodserviceId = new JLabel("FOOD SERVICE ID: ");
		lblFoodserviceId.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblFoodserviceId.setBounds(10, 87, 127, 14);
		contentPane.add(lblFoodserviceId);
		
		lblFServiceId = new JLabel("");
		lblFServiceId.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblFServiceId.setBounds(132, 87, 59, 14);
		contentPane.add(lblFServiceId);
		
		JLabel lblFoodserviceName = new JLabel("SERVICE NAME: ");
		lblFoodserviceName.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblFoodserviceName.setBounds(10, 133, 127, 14);
		contentPane.add(lblFoodserviceName);
		
		JLabel lblCost = new JLabel("COST: ");
		lblCost.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblCost.setBounds(10, 174, 68, 14);
		contentPane.add(lblCost);
		
		txtFServiceName = new JTextField();
		txtFServiceName.setBounds(132, 130, 141, 20);
		contentPane.add(txtFServiceName);
		txtFServiceName.setColumns(10);
		
		txtFServiceCost = new JTextField();
		txtFServiceCost.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char temp = e.getKeyChar();
				if(!(Character.isDigit(temp) || (temp ==KeyEvent.VK_BACK_SPACE) || temp==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		txtFServiceCost.setBounds(132, 171, 141, 20);
		contentPane.add(txtFServiceCost);
		txtFServiceCost.setColumns(10);
		
		txtPricePerGuest = new JTextField();
		txtPricePerGuest.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char temp = e.getKeyChar();
				if(!(Character.isDigit(temp) || (temp ==KeyEvent.VK_BACK_SPACE) || temp==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		txtPricePerGuest.setBounds(132, 213, 141, 20);
		contentPane.add(txtPricePerGuest);
		txtPricePerGuest.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		btnBack.setBackground(new Color(105, 105, 105));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAdmin = new frameAdminMain();
				frmAdmin.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(610, 22, 89, 23);
		contentPane.add(btnBack);
		
		btnSave = new JButton("SAVE");
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnSave.setBackground(new Color(46, 139, 87));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveFoodService();
			}
		});
		btnSave.setBounds(31, 263, 89, 23);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnCancel.setBackground(new Color(205, 92, 92));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadDefaults();
			}
		});
		btnCancel.setBounds(158, 263, 89, 23);
		contentPane.add(btnCancel);
		
		btnAddService = new JButton("ADD SERVICE");
		btnAddService.setForeground(Color.WHITE);
		btnAddService.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnAddService.setBackground(new Color(0, 100, 0));
		btnAddService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFoodService();
			}
		});
		btnAddService.setBounds(301, 297, 124, 23);
		contentPane.add(btnAddService);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(205, 133, 63));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateFoodService();
			}
		});
		btnUpdate.setBounds(435, 297, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnDelete.setBackground(new Color(220, 20, 60));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteFoodService();
			}
		});
		btnDelete.setBounds(534, 297, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblRecords = new JLabel("Records:");
		lblRecords.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblRecords.setBounds(668, 297, 75, 14);
		contentPane.add(lblRecords);
		
		lblRecordCount = new JLabel("");
		lblRecordCount.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblRecordCount.setBounds(726, 297, 40, 14);
		contentPane.add(lblRecordCount);
		
		JLabel lblPricePerGuest = new JLabel("PRICE PER GUEST: ");
		lblPricePerGuest.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblPricePerGuest.setBounds(10, 216, 127, 14);
		contentPane.add(lblPricePerGuest);
		
		loadDefaults();
	}
	
	private void loadDefaults(){
		lblFServiceId.setText(null);
		txtFServiceName.setText(null);
		txtFServiceCost.setText(null);
		txtPricePerGuest.setText(null);
		lblRecordCount.setText(String.valueOf(modelFService.getRowCount()));
		handleTxtFields(false);
		tblFoodService.clearSelection();
		add = false;
		update = false;
		handleButtons();
	}
	
	//validations for enabling and disabling the buttons
	private void handleButtons() {
		
		handleAddBtn();
		handleUpdBtn();
		
		if(tblFoodService.getRowCount() > 0) {
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
		}else {
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
		}
	}
	
	private void handleAddBtn() {
		if(add) {
			btnAddService.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
		}else {
			btnAddService.setEnabled(true);
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
		}
	}
	
	private void handleUpdBtn() {
		if(update) {
			btnUpdate.setEnabled(false);
			btnAddService.setEnabled(false);
			btnDelete.setEnabled(false);
			btnSave.setEnabled(true);
			btnCancel.setEnabled(true);
		}else {
			btnUpdate.setEnabled(true);
			btnAddService.setEnabled(true);
			btnDelete.setEnabled(true);
			btnSave.setEnabled(false);
			btnCancel.setEnabled(false);
		}
	}
	
	private void handleTxtFields(boolean status) {
		
		txtFServiceName.setEnabled(status);
		txtFServiceCost.setEnabled(status);
		txtPricePerGuest.setEnabled(status);
	}
	
	//if the user wants to add a service
	private void addFoodService(){
		add = true;
		handleTxtFields(true);
		handleAddBtn();
		lblFServiceId.setText(String.valueOf(fServiceId));
	}
	
	//if the user wants to update a service
	private void updateFoodService(){
		if(tblFoodService.getSelectedRow() >= 0 && tblFoodService.getSelectedRow() < tblFoodService.getRowCount()){
			update = true;
			handleTxtFields(true);
			handleUpdBtn();
		}
		else
			JOptionPane.showMessageDialog(null, "Select a food service first.");
	}
	
	//if the user wants to delete a service
	private void deleteFoodService(){
		if(tblFoodService.getSelectedRow() >= 0 && tblFoodService.getSelectedRow() < tblFoodService.getRowCount()){
			int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete the selected service?", "Warning", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION){
				modelFService.removeRow(tblFoodService.getSelectedRow());
				lblRecordCount.setText(String.valueOf(tblFoodService.getRowCount()));
				loadDefaults();
				JOptionPane.showMessageDialog(null, "Selected food service has been deleted.");
			}
			else
				loadDefaults();
		}
		else
			JOptionPane.showMessageDialog(null, "Select a food service first.");
	}
	
	//method when the button 'SAVE' clicked
	private void saveFoodService(){
		String validations[] = {"Service Name is empty.", "Cost is empty.", "Price Per Guest is empty."};
		if(txtFServiceName.getText().equals("") && txtFServiceCost.getText().equals("") && txtPricePerGuest.getText().equals(""))
			JOptionPane.showMessageDialog(null, validations);
		
		else if(txtFServiceName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, validations[0]);
			txtFServiceName.requestFocus();
		}
		else if(txtFServiceCost.getText().equals("")) {
			JOptionPane.showMessageDialog(null, validations[1]);
			txtFServiceCost.requestFocus();
		}
		else if(txtPricePerGuest.getText().equals("")) {
			JOptionPane.showMessageDialog(null, validations[2]);
			txtPricePerGuest.requestFocus();
		}
		else{
			if(update == true) {
				update = false;
	
				modelFService.setValueAt(txtFServiceName.getText(), tblFoodService.getSelectedRow(), 1);
				modelFService.setValueAt(Double.parseDouble(txtFServiceCost.getText()), tblFoodService.getSelectedRow(), 2);
				modelFService.setValueAt(Double.parseDouble(txtPricePerGuest.getText()), tblFoodService.getSelectedRow(), 3);
				loadDefaults();
				JOptionPane.showMessageDialog(null, "The selected food service has been updated.");
			}
			
			if(isExist()==true)
				JOptionPane.showMessageDialog(null, "Food Service already exists.");
			else {
				if(add == true){
					add = false;
				
					rowData = new Object[tblFoodService.getColumnCount()];
					rowData[0] = lblFServiceId.getText();
					rowData[1] = txtFServiceName.getText();
					rowData[2] = Double.parseDouble(txtFServiceCost.getText());
					rowData[3] = Double.parseDouble(txtPricePerGuest.getText());
					modelFService.addRow(rowData);
					fServiceId++;
					lblRecordCount.setText(String.valueOf(modelFService.getRowCount()));
					loadDefaults();
					JOptionPane.showMessageDialog(null, "FoodService added successfully.");
				}
			}
		}
	}
	
	//if the user wants to show the values of selected row to the textfield. only if the add and update button are not clicked
	private void showDetails(){
		if(add == false && update == false) {
			lblFServiceId.setText(String.valueOf(tblFoodService.getValueAt(tblFoodService.getSelectedRow(), 0)));
			txtFServiceName.setText(String.valueOf(tblFoodService.getValueAt(tblFoodService.getSelectedRow(), 1)));
			txtFServiceCost.setText(String.valueOf(tblFoodService.getValueAt(tblFoodService.getSelectedRow(), 2)));
			txtPricePerGuest.setText(String.valueOf(tblFoodService.getValueAt(tblFoodService.getSelectedRow(), 3)));
		}
	}
	
	//validate if there's an existing service name
	private boolean isExist(){
		boolean found = false;
		for(int index=0; index < modelFService.getRowCount(); index++){
			if(txtFServiceName.getText().equals(tblFoodService.getValueAt(index, 1))){
				found = true;
				break;
			}
		}
		return found;
	}
	
	
}
