import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class frameEventMngrMain extends JFrame {

	private JPanel contentPane;
	public static frameMain frmMain;
	public static frameViewVenue frmViewVenue;
	public static frameViewFoodService frmViewFService;
	public static frameBookEvent frmBookEvent;
	public static frameUpdateAccount frmUpdateAcct;
	public static framePayment frmPayment;
	public static JTable tblBookHistory;
	public static DefaultTableModel modelBookHstry = new DefaultTableModel();
	public static String[] columns = {"Evt Mngr ID", "Event ID", "Event Name", "Event Type", "Venue", "Event Date", "Food Service", "Equipments", "No. of Guests", "Total Cost", "Payment Status", "TotalEquipmentsCost", "TotalFoodCost"};
	private JMenuItem mntmVenues;
	private JMenuItem mntmFoods;
	private JMenuItem mntmLogout;
	private JMenuItem mntmBookEvent;
	private JLabel lblWelcome;
	private JMenuItem mntmUpdate;
	private JButton btnPayForEvent;
	private JButton btnCancelBook;
	private JLabel lblRecordCount;

	public frameEventMngrMain() {
		setTitle("Event Manager | Home");
		setResizable(false);
		setBounds(100, 100, 850, 454);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(222, 184, 135));
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("MENU");
		mnMenu.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		menuBar.add(mnMenu);
		
		mntmBookEvent = new JMenuItem("BOOK AN EVENT");
		mntmBookEvent.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmBookEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBooking();
			};
		});
		mnMenu.add(mntmBookEvent);
		
		JMenu mnView = new JMenu("VIEW");
		mnView.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mnMenu.add(mnView);
		
		mntmVenues = new JMenuItem("VENUES");
		mntmVenues.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmVenues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewVenue = new frameViewVenue();
				frmViewVenue.setVisible(true);
				setVisible(false);
			}
		});
		mnView.add(mntmVenues);
		
		mntmFoods = new JMenuItem("FOOD SERVICES");
		mntmFoods.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmFoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewFService = new frameViewFoodService();
				frmViewFService.setVisible(true);
				setVisible(false);
			}
		});
		mnView.add(mntmFoods);
		
		JMenu mnAccount = new JMenu("MY ACCOUNT");
		mnAccount.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mnMenu.add(mnAccount);
		
		mntmUpdate = new JMenuItem("UPDATE");
		mntmUpdate.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmUpdateAcct = new frameUpdateAccount();
				frmUpdateAcct.setVisible(true);
				setVisible(false);
			}
		});
		mnAccount.add(mntmUpdate);
		
		JSeparator separator = new JSeparator();
		mnMenu.add(separator);
		
		mntmLogout = new JMenuItem("Log Out");
		mntmLogout.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					frmMain = new frameMain();
					frmMain.setVisible(true);
					setVisible(false);
				}
			}
		});
		mnMenu.add(mntmLogout);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 824, 261);
		contentPane.add(scrollPane);
		
		tblBookHistory = new JTable(modelBookHstry);
		tblBookHistory.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				handleCancelBtn();
			}
		});
		tblBookHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				handleCancelBtn();
			}
		});
		tblBookHistory.setDefaultEditor(Object.class, null);
		modelBookHstry.setColumnIdentifiers(columns);
		tblBookHistory.removeColumn(tblBookHistory.getColumnModel().getColumn(12));
		tblBookHistory.removeColumn(tblBookHistory.getColumnModel().getColumn(11));
		scrollPane.setViewportView(tblBookHistory);
		
		lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		lblWelcome.setBounds(26, 28, 188, 19);
		contentPane.add(lblWelcome);
		
		JLabel lblBookingHistory = new JLabel("-BOOKING HISTORY-");
		lblBookingHistory.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		lblBookingHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingHistory.setBounds(333, 64, 179, 14);
		contentPane.add(lblBookingHistory);
		
		btnPayForEvent = new JButton("PAY FOR EVENT");
		btnPayForEvent.setForeground(Color.WHITE);
		btnPayForEvent.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnPayForEvent.setBackground(new Color(46, 139, 87));
		btnPayForEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment();
				
			}
		});
		btnPayForEvent.setBounds(357, 363, 131, 28);
		contentPane.add(btnPayForEvent);
		
		btnCancelBook = new JButton("CANCEL BOOK");
		btnCancelBook.setForeground(Color.WHITE);
		btnCancelBook.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		btnCancelBook.setBackground(new Color(205, 92, 92));
		btnCancelBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelBook();
			}
		});
		btnCancelBook.setBounds(10, 363, 132, 28);
		contentPane.add(btnCancelBook);
		
		lblRecordCount = new JLabel("");
		lblRecordCount.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblRecordCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecordCount.setBounds(671, 370, 46, 14);
		contentPane.add(lblRecordCount);
		
		JLabel lblNewLabel_1 = new JLabel("BOOKED RECORDS");
		lblNewLabel_1.setFont(new Font("Lucida Fax", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(724, 370, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		loadDefaults();
	}
	
	private void loadDefaults(){
		for(int i = 0; i < frameMain.modelUser.getRowCount(); i++){
			if(frameMain.userId.equals(frameMain.modelUser.getValueAt(i, 0)))
				lblWelcome.setText("Welcome " + frameMain.modelUser.getValueAt(i, 1));
		}
		lblRecordCount.setText(String.valueOf(modelBookHstry.getRowCount()));
		tblBookHistory.clearSelection();
	}
	
	//validation if there is no venue or food service yet, the event manager is not allowed to book an event
	private void checkBooking(){
		if(frameManageVenue.modelVenue.getRowCount() == 0 || frameManageFoodService.modelFService.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "Booking an event has not yet managed by the admin. Please consult to the admin.");
		else {
			frmBookEvent = new frameBookEvent();
			frmBookEvent.setVisible(true);
			setVisible(false);
		}
	}
	
	//if the customer wants to pay for their event from the event manager
	private void payment(){
		if(tblBookHistory.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "There are no recorded books.");
		else{
			if(tblBookHistory.getSelectedRow() >=0 && tblBookHistory.getSelectedRow() < tblBookHistory.getRowCount()){
				if(tblBookHistory.getValueAt(tblBookHistory.getSelectedRow(), 10).equals("Completed")) {
					JOptionPane.showMessageDialog(null, "This event is already paid. \nAsk the admin if you want the saved invoice of this event.");
					tblBookHistory.clearSelection();
				}
				else{
					frmPayment = new framePayment();
					frmPayment.setVisible(true);
					
					framePayment.lblEventId.setText(String.valueOf(tblBookHistory.getValueAt(tblBookHistory.getSelectedRow(), 1)));
					framePayment.lblTotalCost.setText(String.valueOf(tblBookHistory.getValueAt(tblBookHistory.getSelectedRow(), 9)));
					
					for(int index = 0; index < frameManageVenue.modelVenue.getRowCount(); index++){
						if(frameManageVenue.modelVenue.getValueAt(index, 1).equals(modelBookHstry.getValueAt(tblBookHistory.getSelectedRow(), 4))){
							framePayment.lblImagePreview.setIcon(ResizeImage(String.valueOf(frameManageVenue.modelVenue.getValueAt(index, 5))));
						}
					}
					setVisible(false);
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Select a record first.");
			}
		}
	}
	
	//if the customer wants to cancel their 'not paid' book
	private void cancelBook() {
		if(tblBookHistory.getRowCount() == 0)
			JOptionPane.showMessageDialog(null, "There are no recorded books.");
		else{
			if(tblBookHistory.getSelectedRow() >=0 && tblBookHistory.getSelectedRow() < tblBookHistory.getRowCount()){
				if(tblBookHistory.getValueAt(tblBookHistory.getSelectedRow(), 10).equals("Completed")) {
					JOptionPane.showMessageDialog(null, "You can't cancel book that's already completed.");
					tblBookHistory.clearSelection();
				}
				else {
					int dialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel the selected booked event?", "Confirmation", JOptionPane.YES_NO_OPTION);
					if(dialog == JOptionPane.YES_OPTION) {
						modelBookHstry.removeRow(tblBookHistory.getSelectedRow());
						JOptionPane.showMessageDialog(null, "Your selected booked event has been cancelled.");
					}
					lblRecordCount.setText(String.valueOf(modelBookHstry.getRowCount()));
				}
			}else
				JOptionPane.showMessageDialog(null, "Select a record first.");
		}
	}
	
	//validate to enable or disable the 'cancel event' button
	private void handleCancelBtn() {
		if(frameMain.userId.equals(modelBookHstry.getValueAt(tblBookHistory.getSelectedRow(), 0))) {
			if(modelBookHstry.getValueAt(tblBookHistory.getSelectedRow(), 10).equals("Pending"))
				btnCancelBook.setEnabled(true);
		}
		else
			btnCancelBook.setEnabled(false);
	}
	
	
	public ImageIcon ResizeImage(String ImagePath){
		 
		 ImageIcon myImage = new ImageIcon(ImagePath);
	     Image img = myImage.getImage();
	     Image resizeImg = img.getScaledInstance(framePayment.lblImagePreview.getWidth(), framePayment.lblImagePreview.getHeight(), Image.SCALE_SMOOTH);
	     ImageIcon image = new ImageIcon(resizeImg);
	     return image;
	     
	 }
}
