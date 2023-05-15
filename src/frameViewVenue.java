import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class frameViewVenue extends JFrame {

	private JPanel contentPane;
	public static frameEventMngrMain frmEventMngrMain;
	private String[] columns = {"Venue ID", "NAME", "PLACE", "COST", "CONTACT NO.", "IMAGE URL"};
	private JLabel lblVenueId;
	private JTextField txtVenueName;
	private JTextField txtVenuePlace;
	private JTextField txtVenueCost;
	private JTextField txtVenueContact;
	private JTable tblVenue;
	
	private JButton btnBack;
	private JTextField txtSearch;
	private JLabel lblSearch;
	private TableRowSorter<DefaultTableModel> sorter;
	private JLabel lblImage;
	private JLabel lblImgPreview;
	private JPanel panel;

	public frameViewVenue() {
		setResizable(false);
		setTitle("VENUES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 422);
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
				frmEventMngrMain = new frameEventMngrMain();
				frmEventMngrMain.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(600, 14, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 101, 470, 214);
		contentPane.add(scrollPane);
		
		sorter = new TableRowSorter<DefaultTableModel>(frameManageVenue.modelVenue);
		tblVenue = new JTable(frameManageVenue.modelVenue);
		tblVenue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				showDetails();
			}
		});
		tblVenue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showDetails();
			}
		});
		frameManageVenue.modelVenue.setColumnIdentifiers(columns);
		tblVenue.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tblVenue);
		
		JLabel label = new JLabel("VENUE NO.:");
		label.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label.setBounds(10, 102, 83, 14);
		contentPane.add(label);
		
		lblVenueId = new JLabel("");
		lblVenueId.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblVenueId.setBounds(121, 101, 54, 14);
		contentPane.add(lblVenueId);
		
		JLabel label_2 = new JLabel("NAME OF VENUE: ");
		label_2.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label_2.setBounds(10, 132, 120, 14);
		contentPane.add(label_2);
		
		txtVenueName = new JTextField();
		txtVenueName.setText((String) null);
		txtVenueName.setEnabled(false);
		txtVenueName.setColumns(10);
		txtVenueName.setBounds(121, 129, 128, 20);
		contentPane.add(txtVenueName);
		
		JLabel label_3 = new JLabel("PLACE:");
		label_3.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label_3.setBounds(10, 165, 83, 14);
		contentPane.add(label_3);
		
		txtVenuePlace = new JTextField();
		txtVenuePlace.setText((String) null);
		txtVenuePlace.setEnabled(false);
		txtVenuePlace.setColumns(10);
		txtVenuePlace.setBounds(121, 162, 128, 20);
		contentPane.add(txtVenuePlace);
		
		JLabel label_4 = new JLabel("COST:");
		label_4.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label_4.setBounds(10, 200, 67, 14);
		contentPane.add(label_4);
		
		txtVenueCost = new JTextField();
		txtVenueCost.setText((String) null);
		txtVenueCost.setEnabled(false);
		txtVenueCost.setColumns(10);
		txtVenueCost.setAlignmentX(1.0f);
		txtVenueCost.setBounds(121, 197, 128, 20);
		contentPane.add(txtVenueCost);
		
		JLabel label_5 = new JLabel("CONTACT NO.:");
		label_5.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label_5.setBounds(10, 231, 108, 14);
		contentPane.add(label_5);
		
		txtVenueContact = new JTextField();
		txtVenueContact.setText((String) null);
		txtVenueContact.setEnabled(false);
		txtVenueContact.setColumns(10);
		txtVenueContact.setBounds(121, 228, 128, 20);
		contentPane.add(txtVenueContact);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchVenue();
			}
		});
		txtSearch.setBounds(600, 73, 135, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		lblSearch = new JLabel("Search Venue:");
		lblSearch.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblSearch.setBounds(508, 76, 97, 14);
		contentPane.add(lblSearch);
		
		lblImage = new JLabel("IMAGE: ");
		lblImage.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblImage.setBounds(10, 269, 67, 14);
		contentPane.add(lblImage);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(68, 269, 181, 111);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblImgPreview = new JLabel("");
		lblImgPreview.setBounds(0, 0, 181, 111);
		panel.add(lblImgPreview);
		
		loadDefaults();
	}
	
	private void loadDefaults(){
		txtVenueName.setEnabled(false);
		txtVenuePlace.setEnabled(false);
		txtVenueCost.setEnabled(false);
		txtVenueContact.setEnabled(false);
	}
	
	private void showDetails(){
		lblVenueId.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 0)));
		txtVenueName.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 1)));
		txtVenuePlace.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 2)));
		txtVenueCost.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 3)));
		txtVenueContact.setText(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 4)));
		lblImgPreview.setIcon(ResizeImage(String.valueOf(tblVenue.getValueAt(tblVenue.getSelectedRow(), 5))));
	}
	
	public ImageIcon ResizeImage(String ImagePath){
		 
		 ImageIcon MyImage = new ImageIcon(ImagePath);
	     Image img = MyImage.getImage();
	     Image newImg = img.getScaledInstance(lblImgPreview.getWidth(), lblImgPreview.getHeight(), Image.SCALE_SMOOTH);
	     ImageIcon image = new ImageIcon(newImg);
	     return image;
	     
	 }
	
	//rowFilter to search the venue name
	private void searchVenue(){
		RowFilter<DefaultTableModel, Object> rowFilter = null;
		rowFilter = RowFilter.regexFilter(txtSearch.getText(), 1);
		sorter.setRowFilter(rowFilter);
		tblVenue.setRowSorter(sorter);
		//lblRecordCount.setText("Records : " + tblPerson.getRowCount());
	}
}
