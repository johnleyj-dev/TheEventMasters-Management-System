import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class framePayment extends JFrame {
	
	public static frameEventMngrMain frmEMMain;
	public static frameReceipt frmReceipt;
	private JPanel contentPane;
	private JTextField txtAmntReceived;
	private JTextField txtCardNo;
	private String[] paymentMethods = {"Cash", "Credit Card"};
	private JComboBox<String> cboPaymentMethod;
	private JLayeredPane layeredPane;
	private JPanel pnlCash;
	private JPanel pnlCard;
	private JButton btnBack;
	private JButton btnProceed;
	private JButton btnClear;
	private JLabel label;
	public static JLabel lblEventId;
	private JLabel lblPaidBy;
	private JTextField txtCustName;
	public static JLabel lblTotalCost;
	public static JLabel lblImagePreview;
	private double change;
	private double amntReceived;
	private int currentRow;

	
	public framePayment() {
		setResizable(false);
		setTitle("PAYMENT");
		setBounds(100, 100, 640, 360);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		btnBack.setBackground(new Color(105, 105, 105));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEMMain = new frameEventMngrMain();
				frmEMMain.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(508, 21, 89, 23);
		contentPane.add(btnBack);
		
		cboPaymentMethod = new JComboBox<String>();
		cboPaymentMethod.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		loadPaymentType();
		cboPaymentMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//changing panels for either cash or credit card
				if(cboPaymentMethod.getSelectedIndex() == 0)
					switchPanels(pnlCash);
				else if(cboPaymentMethod.getSelectedIndex() == 1)
					switchPanels(pnlCard);
			}
		});
		cboPaymentMethod.setBounds(124, 158, 131, 20);
		contentPane.add(cboPaymentMethod);
		
		JLabel lblNewLabel = new JLabel("Payment Method:");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 161, 115, 14);
		contentPane.add(lblNewLabel);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 186, 265, 43);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		pnlCash = new JPanel();
		pnlCash.setBackground(new Color(95, 158, 160));
		layeredPane.add(pnlCash, "name_213209063234800");
		pnlCash.setLayout(null);
		
		JLabel lblAmountReceived = new JLabel("Amount Received: ");
		lblAmountReceived.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblAmountReceived.setBounds(10, 14, 116, 14);
		pnlCash.add(lblAmountReceived);
		
		txtAmntReceived = new JTextField();
		txtAmntReceived.addKeyListener(new KeyAdapter() {
			@Override
			//to type only numbers in textfield
			public void keyTyped(KeyEvent e) {
				char temp = e.getKeyChar();
				if(!(Character.isDigit(temp) || (temp==KeyEvent.VK_BACK_SPACE) || temp==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		txtAmntReceived.setBounds(124, 11, 131, 20);
		pnlCash.add(txtAmntReceived);
		txtAmntReceived.setColumns(10);
		
		pnlCard = new JPanel();
		pnlCard.setBackground(new Color(95, 158, 160));
		layeredPane.add(pnlCard, "name_213209079554100");
		pnlCard.setLayout(null);
		
		JLabel lblCardNo = new JLabel("Card No:");
		lblCardNo.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblCardNo.setBounds(10, 14, 97, 14);
		pnlCard.add(lblCardNo);
		
		txtCardNo = new JTextField();
		txtCardNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char temp = e.getKeyChar();
				if(!(Character.isDigit(temp) || (temp==KeyEvent.VK_BACK_SPACE) || temp==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		txtCardNo.setBounds(124, 11, 131, 20);
		pnlCard.add(txtCardNo);
		txtCardNo.setColumns(10);
		
		btnProceed = new JButton("PROCEED");
		btnProceed.setForeground(Color.WHITE);
		btnProceed.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnProceed.setBackground(new Color(46, 139, 87));
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				printBill();
			}
		});
		btnProceed.setBounds(36, 271, 89, 23);
		contentPane.add(btnProceed);
		
		btnClear = new JButton("CLEAR");
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		btnClear.setBackground(new Color(205, 92, 92));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setBounds(165, 271, 89, 23);
		contentPane.add(btnClear);
		
		label = new JLabel("Event ID:");
		label.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label.setBounds(10, 85, 76, 14);
		contentPane.add(label);
		
		lblEventId = new JLabel("");
		lblEventId.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblEventId.setBounds(124, 85, 65, 14);
		contentPane.add(lblEventId);
		
		lblPaidBy = new JLabel("Customer Name: ");
		lblPaidBy.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblPaidBy.setBounds(10, 124, 115, 14);
		contentPane.add(lblPaidBy);
		
		txtCustName = new JTextField();
		txtCustName.setBounds(124, 121, 131, 20);
		contentPane.add(txtCustName);
		txtCustName.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(315, 78, 297, 151);
		contentPane.add(panel);
		
		lblImagePreview = new JLabel("");
		lblImagePreview.setForeground(Color.BLACK);
		lblImagePreview.setBackground(Color.WHITE);
		lblImagePreview.setBounds(0, 0, 297, 151);
		panel.add(lblImagePreview);
		
		JLabel label2 = new JLabel("Total Cost: ");
		label2.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label2.setBounds(387, 240, 89, 14);
		contentPane.add(label2);
		
		lblTotalCost = new JLabel("");
		lblTotalCost.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblTotalCost.setBounds(459, 240, 76, 14);
		contentPane.add(lblTotalCost);
		
		
		
	}
	
	//switching panels
	public void switchPanels(JPanel panel){
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	//if the user clicked 'PROCEED' button; proceed to print the invoice; payment
	private void printBill(){
		
		currentRow = frameEventMngrMain.modelBookHstry.getRowCount()-1;
		double totalCost = Double.parseDouble(lblTotalCost.getText());
		String validations[] = {"Customer Name is required.", "Amount Received is required.", "Card No. is required."};
		
		//if the e.m. does not proceed to the payment after booking the event.
		if(frameEventMngrMain.tblBookHistory.getSelectedRow() >= 0 && frameEventMngrMain.tblBookHistory.getSelectedRow() < frameEventMngrMain.tblBookHistory.getRowCount()){
			
			//if the customer wants to pay it cash
			if(cboPaymentMethod.getSelectedIndex() == 0){
				if(txtCustName.getText().equals("") && txtAmntReceived.getText().equals(""))
					JOptionPane.showMessageDialog(null, validations[0] + "\n" + validations[1]);
				else if(txtCustName.getText().equals(""))
					JOptionPane.showMessageDialog(null, validations[0]);
				else if(txtAmntReceived.getText().equals(""))
					JOptionPane.showMessageDialog(null, validations[1]);
				
				else{
					amntReceived = Double.parseDouble(txtAmntReceived.getText());
					
					if(amntReceived > totalCost){
						 change = amntReceived - totalCost;
						 for(int index = 0; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
							 if(frameEventMngrMain.modelBookHstry.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 1))){
								 frameEventMngrMain.modelBookHstry.setValueAt("Completed", index, 10);
								 JOptionPane.showMessageDialog(null, "Payment successful.");
							 }
						 }
						 showReceipt();
						 clear();
						 setVisible(false);
					}
					else if(amntReceived == totalCost){
						for(int index = 0; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
							if(frameEventMngrMain.modelBookHstry.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 1))){
								frameEventMngrMain.modelBookHstry.setValueAt("Completed", index, 10);
								JOptionPane.showMessageDialog(null, "Payment successful.");
							}
						}
						showReceipt();
						clear();
						setVisible(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid amount of cash.");
				}
			}
			
			//if the user wants to pay using credit card
			else{
				if(txtCustName.getText().equals("") && txtCardNo.getText().equals(""))
					JOptionPane.showMessageDialog(null, validations[0] + "\n" + validations[2]);
				else if(txtCustName.getText().equals(""))
					JOptionPane.showMessageDialog(null, validations[0]);
				else if(txtCardNo.getText().equals(""))
					JOptionPane.showMessageDialog(null, validations[2]);
				
				else{
					for(int index = 0; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
						if(frameEventMngrMain.modelBookHstry.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 1))){
							frameEventMngrMain.modelBookHstry.setValueAt("Completed", index, 10);
							JOptionPane.showMessageDialog(null, "Payment successful.");
						}
					}
					showReceipt();
					clear();
					setVisible(false);
				}
			}
			
		}
		
		//If the e.m. proceed to the payment frame
		else{
			if(frameBookEvent.dialogResultForPayment == JOptionPane.YES_OPTION){
				//if the customer wants to pay it cash
				if(cboPaymentMethod.getSelectedIndex() == 0){
					if(txtCustName.getText().equals("") && txtAmntReceived.getText().equals(""))
						JOptionPane.showMessageDialog(null, validations[0] + "\n" + validations[1]);
					else if(txtCustName.getText().equals(""))
						JOptionPane.showMessageDialog(null, validations[0]);
					else if(txtAmntReceived.getText().equals(""))
						JOptionPane.showMessageDialog(null, validations[1]);
					
					else{
						amntReceived = Double.parseDouble(txtAmntReceived.getText());
						
						if(amntReceived > totalCost){
							 change = amntReceived - totalCost;
							 for(int index = frameEventMngrMain.modelBookHstry.getRowCount()-1; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
								 if(frameEventMngrMain.modelBookHstry.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(currentRow, 1))){
									 frameEventMngrMain.modelBookHstry.setValueAt("Completed", index, 10);
									 JOptionPane.showMessageDialog(null, "Payment successful.");
								 }
							 }
							 showReceipt();
							 clear();
							 setVisible(false);
						}
						else if(amntReceived == totalCost){
							for(int index = frameEventMngrMain.modelBookHstry.getRowCount()-1; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
								if(frameEventMngrMain.modelBookHstry.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(currentRow, 1))){
									frameEventMngrMain.modelBookHstry.setValueAt("Completed", index, 10);
									JOptionPane.showMessageDialog(null, "Payment successful.");
								}
							}
							showReceipt();
							clear();
							setVisible(false);
						}
						else
							JOptionPane.showMessageDialog(null, "Invalid amount of cash.");
					}
				}
				else {
					//if the user wants to pay using credit card
					if(cboPaymentMethod.getSelectedIndex() == 1){
						if(txtCustName.getText().equals("") && txtCardNo.getText().equals(""))
							JOptionPane.showMessageDialog(null, validations[0] + "\n" + validations[2]);
						else if(txtCustName.getText().equals(""))
							JOptionPane.showMessageDialog(null, validations[0]);
						else if(txtCardNo.getText().equals(""))
							JOptionPane.showMessageDialog(null, validations[2]);
						
						else{
							for(int index = frameEventMngrMain.modelBookHstry.getRowCount()-1; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
								if(frameEventMngrMain.modelBookHstry.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(currentRow, 1))){
									frameEventMngrMain.modelBookHstry.setValueAt("Completed", index, 10);
									JOptionPane.showMessageDialog(null, "Payment successful.");
								}
							}
							showReceipt();
							clear();
							setVisible(false);
						}
					}
				}
			}
		}
	}
	
	//showing the frame of receipt
	private void showReceipt(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		
		frmReceipt = new frameReceipt();
		frmReceipt.setVisible(true);
		
		frameReceipt.lblDateBooked.setText(sdf.format(date));
		frameReceipt.lblPayMethod.setText(String.valueOf(cboPaymentMethod.getSelectedItem()));
		frameReceipt.lblCustName.setText(txtCustName.getText());
		
		frameReceipt.lblCashPaid.setText(String.valueOf(amntReceived));
		frameReceipt.lblChange.setText(String.valueOf(change));
		
		//determines if the event manager makes a payment through selecting a row on table of booked events
		if(frameEventMngrMain.tblBookHistory.getSelectedRow() >= 0 && frameEventMngrMain.tblBookHistory.getSelectedRow() < frameEventMngrMain.tblBookHistory.getRowCount()){
			for(int index = 0; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
				 if(frameEventMngrMain.modelBookHstry.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 1))){
					 frameReceipt.lblEvtMngr.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 0)));
					 frameReceipt.lblEventId.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 1)));
					 frameReceipt.lblEventName.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 2) + " (" + frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 3)+ ")"));
					 frameReceipt.lblVenue.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 4)));
					 frameReceipt.lblDate.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 5)));
					 frameReceipt.lblFoodService.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 6)));
					 frameReceipt.lblEquipments.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 7)));
					 frameReceipt.lblTotalGuests.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 8)));
					 frameReceipt.lblTotalCost.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 9)));
					 frameReceipt.lblEquipmentsCost.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 11)));
					 frameReceipt.lblFoodServiceCost.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(frameEventMngrMain.tblBookHistory.getSelectedRow(), 12)));
				 }
			 }
		}
		//or the event manager proceeds to payment
		else{
			for(int index = frameEventMngrMain.modelBookHstry.getRowCount()-1; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
				if(frameEventMngrMain.modelBookHstry.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(currentRow, 1))){
					 frameReceipt.lblEvtMngr.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 0)));
					 frameReceipt.lblEventId.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 1)));
					 frameReceipt.lblEventName.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 2) + " (" + frameEventMngrMain.modelBookHstry.getValueAt(index, 3)+ ")"));
					 frameReceipt.lblVenue.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 4)));
					 frameReceipt.lblDate.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 5)));
					 frameReceipt.lblFoodService.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 6)));
					 frameReceipt.lblEquipments.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 7)));
					 frameReceipt.lblTotalGuests.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 8)));
					 frameReceipt.lblTotalCost.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 9)));
					 frameReceipt.lblEquipmentsCost.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 11)));
					 frameReceipt.lblFoodServiceCost.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(index, 12)));
				 }
			 }
		}
		
		for(int index = 0; index < frameManageVenue.modelVenue.getRowCount(); index++){
			if(frameReceipt.lblVenue.getText().equals(frameManageVenue.modelVenue.getValueAt(index, 1))){
				frameReceipt.lblVenueCost.setText(String.valueOf(frameManageVenue.modelVenue.getValueAt(index, 3)));
			}
		}
		
	}
	
	private void clear(){
		txtCustName.setText(null);
		cboPaymentMethod.setSelectedIndex(0);
		txtAmntReceived.setText(null);
		txtCardNo.setText(null);
	}
	
	//adding the item for cbobox of payment method
	private void loadPaymentType(){
		for(String paymentMethod : paymentMethods){
			cboPaymentMethod.addItem(paymentMethod);
		}
	}
}
