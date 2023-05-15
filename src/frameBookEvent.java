import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class frameBookEvent extends JFrame {

	private JPanel contentPane;
	public static frameEventMngrMain frmEMMain;
	public static framePayment frmPayment;
	public static JComboBox<String> cboEventType;
	public static JComboBox<String> cboVenue;
	public static JComboBox<String> cboFoodService;
	private String[] eventTypes = {"Anniversary", "Birthday Party", "Corporate", "Debut", "Family Event", "Holiday Event", "Product Launch", "Seminar", "Wedding"};
	private ArrayList<String> venues = new ArrayList<String>();
	private ArrayList<String> foodServices = new ArrayList<String>();
	public static ArrayList<String> equipsName = new ArrayList<String>();
	private Object[] rowData;
	public static JTextField txtEventName;
	private JLabel lblImgPreview;
	public static int eventId = 1101;
	public static JTextField txtNoOfGuests;
	public static JButton btnBook;
	public static JDateChooser dateVenue;
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	private Date currentDate = new Date();
	private JCheckBox chkPresentation;
	private JCheckBox chkSoundMusic;
	private JCheckBox chkDecor;
	private JCheckBox chkLighting;
	public static JCheckBox[] chkEquipments;
	private double[] equipsPrice = {599, 499, 399, 449};
	public static double tempEquipPrice;
	public static JLabel lblVenueCost;
	public static JLabel lblFoodServCost;
	public static JLabel lblEquipsCost;
	public static String selectedEquips = "";
	public static JButton btnBack;
	private int currentRow;
	public static int dialogResultForPayment;
	
	
	public frameBookEvent() {
		
		setResizable(false);
		setTitle("BOOK AN EVENT");
		setBounds(100, 100, 770, 519);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEventType = new JLabel("Event Type");
		lblEventType.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblEventType.setBounds(40, 121, 113, 14);
		contentPane.add(lblEventType);
		
		cboEventType = new JComboBox<String>();
		loadEventType();
		cboEventType.setBounds(127, 118, 160, 20);
		contentPane.add(cboEventType);
		
		JLabel lblVenue = new JLabel("Venue");
		lblVenue.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblVenue.setBounds(40, 160, 68, 14);
		contentPane.add(lblVenue);
		
		cboVenue = new JComboBox<String>();
		addVenue();
		loadVenue();
		cboVenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewImage();
				viewVenuePrice();
			}
		});
		
		cboVenue.setBounds(127, 156, 160, 23);
		contentPane.add(cboVenue);
		
		
		JLabel lblBook = new JLabel("BOOK AN EVENT");
		lblBook.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		lblBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblBook.setBounds(327, 31, 113, 14);
		contentPane.add(lblBook);
		
		JLabel lblEventDate = new JLabel("Event Date");
		lblEventDate.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblEventDate.setBounds(40, 199, 80, 14);
		contentPane.add(lblEventDate);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(105, 105, 105));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEMMain = new frameEventMngrMain();
				frmEMMain.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(633, 11, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblFood = new JLabel("Food Service");
		lblFood.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblFood.setBounds(40, 237, 99, 14);
		contentPane.add(lblFood);
		
		dateVenue = new JDateChooser();
		dateVenue.setBounds(127, 199, 160, 20);
		contentPane.add(dateVenue);
		
		JLabel lblEquipments = new JLabel("Equipments");
		lblEquipments.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		
		lblEquipments.setBounds(40, 277, 99, 14);
		contentPane.add(lblEquipments);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblEventName.setBounds(40, 82, 80, 14);
		contentPane.add(lblEventName);
		
		txtEventName = new JTextField();
		txtEventName.setBounds(127, 79, 160, 20);
		contentPane.add(txtEventName);
		txtEventName.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(386, 82, 352, 223);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblImgPreview = new JLabel("");
		lblImgPreview.setBounds(0, 0, 352, 223);
		panel.add(lblImgPreview);
		
		JLabel lblNoOfGuests = new JLabel("No. of Guests");
		lblNoOfGuests.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblNoOfGuests.setBounds(40, 401, 113, 14);
		contentPane.add(lblNoOfGuests);
		
		txtNoOfGuests = new JTextField();
		txtNoOfGuests.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				//to type only numbers in txtfield
				char temp = e.getKeyChar();
				if(!(Character.isDigit(temp) || (temp==KeyEvent.VK_BACK_SPACE) || temp==KeyEvent.VK_DELETE)){
					e.consume();
				}
			}
		});
		txtNoOfGuests.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNoOfGuests.setBounds(127, 398, 89, 20);
		contentPane.add(txtNoOfGuests);
		txtNoOfGuests.setColumns(10);
		
		btnBook = new JButton("BOOK");
		btnBook.setForeground(Color.WHITE);
		btnBook.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		btnBook.setBackground(new Color(46, 139, 87));
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bookEvent();
			}
		});
		btnBook.setBounds(342, 445, 89, 23);
		contentPane.add(btnBook);
		
		JLabel lblVenuePrice = new JLabel("Venue Cost: ");
		lblVenuePrice.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblVenuePrice.setBounds(452, 326, 107, 14);
		contentPane.add(lblVenuePrice);
		
		JLabel lblFoodCost = new JLabel("Food Cost Per Guest: ");
		lblFoodCost.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblFoodCost.setBounds(452, 364, 143, 14);
		contentPane.add(lblFoodCost);
		
		JLabel lblEquipmentCost = new JLabel("Equipments Cost: ");
		lblEquipmentCost.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblEquipmentCost.setBounds(452, 401, 121, 14);
		contentPane.add(lblEquipmentCost);
		
		cboFoodService = new JComboBox<String>();
		addFoodService();
		loadFoodService();
		cboFoodService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewFoodservicePrice();
			}
		});
		
		cboFoodService.setBounds(127, 237, 160, 20);
		contentPane.add(cboFoodService);
		
		chkPresentation = new JCheckBox("Presentation");
		chkPresentation.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		chkPresentation.setBackground(new Color(95, 158, 160));
		chkPresentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//for changing the cost of equipment's cost
				if(chkPresentation.isSelected()){
					tempEquipPrice += equipsPrice[0];
					lblEquipsCost.setText(String.valueOf(tempEquipPrice));
				}
				else{
					tempEquipPrice -= equipsPrice[0];
					lblEquipsCost.setText(String.valueOf(tempEquipPrice));
				}
			}
		});
		chkPresentation.setBounds(127, 273, 121, 23);
		contentPane.add(chkPresentation);
		
		chkSoundMusic = new JCheckBox("Sound & Music");
		chkSoundMusic.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		chkSoundMusic.setBackground(new Color(95, 158, 160));
		chkSoundMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkSoundMusic.isSelected()){
					tempEquipPrice += equipsPrice[1];
					lblEquipsCost.setText(String.valueOf(tempEquipPrice));
				}
				else{
					tempEquipPrice -= equipsPrice[1];
					lblEquipsCost.setText(String.valueOf(tempEquipPrice));
				}
			}
		});
		chkSoundMusic.setBounds(127, 299, 121, 23);
		contentPane.add(chkSoundMusic);
		
		chkDecor = new JCheckBox("Decor");
		chkDecor.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		chkDecor.setBackground(new Color(95, 158, 160));
		chkDecor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkDecor.isSelected()){
					tempEquipPrice += equipsPrice[2];
					lblEquipsCost.setText(String.valueOf(tempEquipPrice));
				}
				else{
					tempEquipPrice -= equipsPrice[2];
					lblEquipsCost.setText(String.valueOf(tempEquipPrice));
				}
			}
		});
		chkDecor.setBounds(127, 322, 121, 23);
		contentPane.add(chkDecor);
		
		chkLighting = new JCheckBox("Lighting");
		chkLighting.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		chkLighting.setBackground(new Color(95, 158, 160));
		chkLighting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkLighting.isSelected()){
					tempEquipPrice += equipsPrice[3];
					lblEquipsCost.setText(String.valueOf(tempEquipPrice));
				}
				else{
					tempEquipPrice -= equipsPrice[3];
					lblEquipsCost.setText(String.valueOf(tempEquipPrice));
				}
			}
		});
		chkLighting.setBounds(127, 348, 121, 23);
		contentPane.add(chkLighting);
		
		lblVenueCost = new JLabel("");
		lblVenueCost.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		lblVenueCost.setBounds(595, 326, 99, 14);
		contentPane.add(lblVenueCost);
		
		lblFoodServCost = new JLabel("");
		lblFoodServCost.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		lblFoodServCost.setBounds(595, 364, 99, 14);
		contentPane.add(lblFoodServCost);
		
		lblEquipsCost = new JLabel("");
		lblEquipsCost.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		lblEquipsCost.setBounds(595, 401, 99, 14);
		contentPane.add(lblEquipsCost);
		
		
		chkEquipments = new JCheckBox[]{chkPresentation, chkSoundMusic, chkDecor, chkLighting};
		loadDefaults();
	}
	
	private void loadDefaults(){
		
		//to display the image of first venue to default displayed image
		if(venues.get(0).equals(cboVenue.getItemAt(0))){
			lblImgPreview.setIcon(ResizeImage(String.valueOf(frameManageVenue.tblVenue.getValueAt(0, 5))));
		}
		lblVenueCost.setText(String.valueOf(frameManageVenue.tblVenue.getValueAt(cboVenue.getSelectedIndex(), 3)));
		lblFoodServCost.setText(String.valueOf(frameManageFoodService.tblFoodService.getValueAt(cboFoodService.getSelectedIndex(), 2)));
		tempEquipPrice = 0;
		lblEquipsCost.setText(String.valueOf(tempEquipPrice));
		
		//setting JDateChooser to current date
		try {
			Date date =  new SimpleDateFormat("MM/dd/yyyy").parse((String) dateFormat.format(currentDate));
			dateVenue.setDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtEventName.setText(null);
		txtNoOfGuests.setText(null);
		cboVenue.setSelectedIndex(0);
		cboEventType.setSelectedIndex(0);
		cboFoodService.setSelectedIndex(0);
		dateVenue.setDateFormatString(null);
		for(int index = 0; index < chkEquipments.length; index++){
			chkEquipments[index].setSelected(false);
		}

	}
	
	private void handleControls(boolean status){
		txtEventName.setEnabled(status);
		cboVenue.setEnabled(status);
		cboEventType.setEnabled(status);
		cboFoodService.setEnabled(status);
		dateVenue.setEnabled(status);
		txtNoOfGuests.setEnabled(status);
		for(int index = 0; index < chkEquipments.length; index++){
			chkEquipments[index].setEnabled(status);
		}
		btnBook.setEnabled(status);
		btnBack.setEnabled(status);
	}
	
	//adding to array list all of the list venues
	private void addVenue(){
		for(int i= 0; i < frameManageVenue.tblVenue.getRowCount(); i++){
			venues.add(String.valueOf(frameManageVenue.tblVenue.getValueAt(i, 1)));
		}
	}
	
	private void loadVenue(){
		for(String venue : venues){
			cboVenue.addItem(venue);
		}
	}
	
	//adding to array list all of the list service
	private void addFoodService(){
		for(int i= 0; i < frameManageFoodService.tblFoodService.getRowCount(); i++){
			foodServices.add(String.valueOf(frameManageFoodService.tblFoodService.getValueAt(i, 1)));
		}
	}
	
	private void loadFoodService(){
		for(String foodService : foodServices){
			cboFoodService.addItem(foodService);
		}
	}
	
	private void loadEventType(){
		for(String eventType : eventTypes){
			cboEventType.addItem(eventType);
		}
	}
	
	//to show the image of selected venue
	private void viewImage(){
		for(int i = 0; i < frameManageVenue.modelVenue.getRowCount(); i++){
			if(frameManageVenue.tblVenue.getValueAt(i, 1).equals(cboVenue.getSelectedItem())){
				lblImgPreview.setIcon(ResizeImage(String.valueOf(frameManageVenue.tblVenue.getValueAt(i, 5))));
			}
		}
	}
	
	//to show cost of the venue
	private void viewVenuePrice(){
		for(int index = 0; index < frameManageVenue.modelVenue.getRowCount(); index++){
			if(frameManageVenue.tblVenue.getValueAt(index, 1).equals(cboVenue.getSelectedItem())){
				lblVenueCost.setText(String.valueOf(frameManageVenue.tblVenue.getValueAt(index, 3)));
			}
		}
	}
	
	//to show cost of food service
	private void viewFoodservicePrice(){
		for(int index = 0; index < frameManageFoodService.modelFService.getRowCount(); index++){
			if(frameManageFoodService.tblFoodService.getValueAt(index, 1).equals(cboFoodService.getSelectedItem())){
				lblFoodServCost.setText(String.valueOf(frameManageFoodService.tblFoodService.getValueAt(index, 3)));
			}
		}
	}
	
	//to compute total cost of event
	private double computeTotal(){
		double venueCost = Double.parseDouble(lblVenueCost.getText());
		double chargePerGuest = Double.parseDouble(lblFoodServCost.getText());
		double equipsCost = Double.parseDouble(lblEquipsCost.getText());
		int totalGuest = Integer.parseInt(txtNoOfGuests.getText());
		double totalCost = 0;
		double totalPriceGuest = chargePerGuest * totalGuest;
		totalCost = venueCost + totalPriceGuest + equipsCost;
		
		return totalCost;
	}
	
	
	private double computeCostPerGuest(){
		double chargePerGuest = Double.parseDouble(lblFoodServCost.getText());
		int totalGuest = Integer.parseInt(txtNoOfGuests.getText());
		double totalPriceGuest = chargePerGuest * totalGuest;
		
		return totalPriceGuest;
	}
	
	//method when the button 'BOOK' clicked
	private void bookEvent(){
		String validations[] = {"Event Name is required.", "Date of Event is required.", "No. of Guests is required."};
		if(txtEventName.getText().equals("") && dateVenue.getDateFormatString().equals(null) && txtNoOfGuests.getText().equals(""))
			JOptionPane.showMessageDialog(null, validations);
		
		else if(txtEventName.getText().equals("")){
			JOptionPane.showMessageDialog(null, validations[0]);
			txtEventName.requestFocus();
		}
		else if(dateVenue.getDateFormatString().equals(null)){
			JOptionPane.showMessageDialog(null, validations[1]);
			dateVenue.requestFocus();
		}
		else if(txtNoOfGuests.getText().equals("")){
			JOptionPane.showMessageDialog(null, validations[2]);
			txtNoOfGuests.requestFocus();
		}
		else{
			if(isEventNameExist()==true){
				JOptionPane.showMessageDialog(null, "Your desired event name is already exist.");
			}
			else{
				if(isVenueDateExist()==true){
					JOptionPane.showMessageDialog(null, "There is an event scheduled on your desired venue and date.");
				}
				else{
					handleControls(false);
	
					int dialogResult = JOptionPane.showConfirmDialog(null, "CONFIRM TO BOOK THIS EVENT? \n"
								+ "\n\tEvent ID: " + eventId + "\n\n\t" + 
			                   	"Event Name: " + txtEventName.getText() + "\n\n\t" + 
			                   	"Event Type: " + cboEventType.getSelectedItem() + "\n\n\t" + 
							  	"Venue: " + cboVenue.getSelectedItem() + "\n\n\t" +
			                   	"Date: " + dateFormat.format(dateVenue.getDate()) + "\n\n\t" +
							  	"Food Service: " + cboFoodService.getSelectedItem() + "\n\n\t" +
			                   	"Equipments: " + getEquips() + "\n\n\t" +
							  	"Number of Guests: " + txtNoOfGuests.getText() + "\n\n\t" + 
			                   	"Venue Cost: " + lblVenueCost.getText() + "\n\t" +
							  	"Total Food Service Cost: " + computeCostPerGuest() + "\n\t" +
			                   	"Equipments Cost: " + lblEquipsCost.getText() + "\n\n\t" +
							  	"TOTAL COST: " + computeTotal(),
								"EVENT DETAILS", JOptionPane.OK_CANCEL_OPTION);
					
					if(dialogResult == JOptionPane.OK_OPTION){
						rowData = new Object[frameEventMngrMain.modelBookHstry.getColumnCount()];
						
						rowData[0] = frameMain.userId;
						rowData[1] = eventId;
						rowData[2] = txtEventName.getText();
						rowData[3] = cboEventType.getSelectedItem();
						rowData[4] = cboVenue.getSelectedItem();
						rowData[5] = dateFormat.format(dateVenue.getDate());
						rowData[6] = cboFoodService.getSelectedItem();
						rowData[7] = selectedEquips;
						rowData[8] = txtNoOfGuests.getText();
						rowData[9] = computeTotal();
						rowData[10] = "Pending";
						rowData[11] = lblEquipsCost.getText();
						rowData[12] = computeCostPerGuest();
						frameEventMngrMain.modelBookHstry.addRow(rowData);
						selectedEquips = "";
						JOptionPane.showMessageDialog(null, "Event successfully booked.");
						currentRow = frameEventMngrMain.modelBookHstry.getRowCount()-1;
						
						dialogResultForPayment = JOptionPane.showConfirmDialog(null, "Proceed to payment?", "Confirmation", JOptionPane.YES_NO_OPTION);
						if(dialogResultForPayment == JOptionPane.YES_OPTION){
							frmPayment = new framePayment();
							frmPayment.setVisible(true);
							
							framePayment.lblEventId.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(currentRow, 1)));
							framePayment.lblTotalCost.setText(String.valueOf(frameEventMngrMain.modelBookHstry.getValueAt(currentRow, 9)));
							
							for(int index = 0; index < frameManageVenue.modelVenue.getRowCount(); index++){
								if(frameManageVenue.modelVenue.getValueAt(index, 1).equals(frameEventMngrMain.modelBookHstry.getValueAt(currentRow, 4))){
									framePayment.lblImagePreview.setIcon(ResizeImage(String.valueOf(frameManageVenue.modelVenue.getValueAt(index, 5))));
								}
							}
							setVisible(false);
						}
						eventId++;
						loadDefaults();
						handleControls(true);
						
					}
					else{
						selectedEquips = "";
						handleControls(true);
					}
				}
			}
		}
	}
	
	
	//to resize the image to the size of jlabel
	public ImageIcon ResizeImage(String ImagePath){
		 
		 ImageIcon myImage = new ImageIcon(ImagePath);
	     Image img = myImage.getImage();
	     Image resizeImg = img.getScaledInstance(lblImgPreview.getWidth(), lblImgPreview.getHeight(), Image.SCALE_SMOOTH);
	     ImageIcon image = new ImageIcon(resizeImg);
	     return image;
	     
	 }
	
	//to identify the selected equips
	private String getEquips(){
		
		String tempEquips = "";
		for(int index = 0; index < chkEquipments.length; index++){
			if(chkEquipments[index].isSelected() == true){
				tempEquips += "\n" + chkEquipments[index].getText();
				selectedEquips += chkEquipments[index].getText() + ", ";

			}
		}
		if(tempEquips == ""){
			tempEquips = "N/A";
			selectedEquips = "N/A";
		}
		
		return tempEquips;
	}
	
	//if the event name is already exist
	private boolean isEventNameExist(){
		boolean found = false;
		
		for(int index=0; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
			if(txtEventName.getText().equals(frameEventMngrMain.modelBookHstry.getValueAt(index, 2))){
				found = true;
				break;
			}
		}
		return found;
	}
	
	//if the date of the venue is already exist
	private boolean isVenueDateExist(){
		boolean found = false;
		
		for(int index=0; index < frameEventMngrMain.modelBookHstry.getRowCount(); index++){
			if(cboVenue.getSelectedItem().equals(frameEventMngrMain.modelBookHstry.getValueAt(index, 4)) && dateFormat.format(dateVenue.getDate()).equals(frameEventMngrMain.modelBookHstry.getValueAt(index, 5))){
				found = true;
				break;
			}
		}
		return found;
	}
}
