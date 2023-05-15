import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class frameAdminMain extends JFrame {

	private JPanel contentPane;
	public static frameMain frmMain;
	public static frameManageVenue frmManageVenue;
	public static frameViewBooking frmViewBooking;
	public static frameManageFoodService frmMngFoodservice;
	
	private JMenu mnManage;
	private JMenuItem mntmVenue;
	private JMenuItem mntmFoods;
	private JMenuItem mntmViewBookings;
	private JMenuItem mntmLogOut;

	private JTable tblUser;
	private JLabel lblRegisteredEventManagers;
	private JComboBox<String> cboSexFilter;
	private String[] filters = {"ALL", "MALE", "FEMALE"};
	private TableRowSorter<DefaultTableModel> sorter;
	private JTextField txtSearch;
	private JLabel lblSex;
	
	
	

	public frameAdminMain() {
		setResizable(false);
		setTitle("Admin | Home");
		setBounds(100, 100, 765, 454);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(222, 184, 135));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("MENU");
		mnNewMenu.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		menuBar.add(mnNewMenu);
		
		mnManage = new JMenu("MANAGE");
		mnManage.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mnManage.setBackground(new Color(220, 20, 60));
		mnNewMenu.add(mnManage);
		
		mntmVenue = new JMenuItem("VENUES");
		mntmVenue.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmVenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmManageVenue = new frameManageVenue();
				frmManageVenue.setVisible(true);
				setVisible(false);
			}
		});
		mnManage.add(mntmVenue);
		
		mntmFoods = new JMenuItem("FOOD SERVICES");
		mntmFoods.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmFoods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMngFoodservice = new frameManageFoodService();
				frmMngFoodservice.setVisible(true);
				setVisible(false);
			}
		});
		mnManage.add(mntmFoods);
		
		mntmViewBookings = new JMenuItem("VIEW BOOKINGS");
		mntmViewBookings.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmViewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewBooking = new frameViewBooking();
				frmViewBooking.setVisible(true);
				setVisible(false);
			}
		});
		mnNewMenu.add(mntmViewBookings);
		
		mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					frmMain = new frameMain();
					frmMain.setVisible(true);
					setVisible(false);
				}
			}
		});
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mnNewMenu.add(mntmLogOut);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("WELCOME ADMIN!");
		lblWelcomeAdmin.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		lblWelcomeAdmin.setBounds(10, 29, 131, 14);
		contentPane.add(lblWelcomeAdmin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 739, 265);
		contentPane.add(scrollPane);
		
		sorter = new TableRowSorter<DefaultTableModel>(frameMain.modelUser);
		tblUser = new JTable(frameMain.modelUser);
		frameMain.modelUser.setColumnIdentifiers(frameMain.columns);
		tblUser.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(tblUser);
		
		lblRegisteredEventManagers = new JLabel("REGISTERED EVENT MANAGERS");
		lblRegisteredEventManagers.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisteredEventManagers.setFont(new Font("Lucida Fax", Font.BOLD, 12));
		lblRegisteredEventManagers.setBounds(280, 73, 198, 14);
		contentPane.add(lblRegisteredEventManagers);
		
		cboSexFilter = new JComboBox<String>();
		cboSexFilter.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		cboSexFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filterUsers();
			}
		});
		loadSexFilter();
		cboSexFilter.setBounds(626, 98, 123, 20);
		contentPane.add(cboSexFilter);
		
		txtSearch = new JTextField();
		txtSearch.setBackground(new Color(255, 255, 255));
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchUsers();
			}
		});
		txtSearch.setBounds(65, 98, 131, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblSearch.setBounds(10, 101, 65, 14);
		contentPane.add(lblSearch);
		
		lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblSex.setBounds(586, 101, 46, 14);
		contentPane.add(lblSex);
		
		
		
	}
	
	private void loadSexFilter(){
		for(String filter : filters){
			cboSexFilter.addItem(filter);
		}
	}
	
	//comboBox filter for sex
	private void filterUsers(){
		if(cboSexFilter.getItemAt(cboSexFilter.getSelectedIndex()).equals("ALL")){
			tblUser.setRowSorter(null);
		}else{
			RowFilter<DefaultTableModel, Object> rowFilter = null;
			rowFilter = RowFilter.regexFilter("(\\b)" + cboSexFilter.getItemAt(cboSexFilter.getSelectedIndex()) + "(\\b)", 5);
			sorter.setRowFilter(rowFilter);
			tblUser.setRowSorter(sorter);
		}
	}

	//search filter for names
	private void searchUsers(){
		RowFilter<DefaultTableModel, Object> rowFilter = null;
		rowFilter = RowFilter.regexFilter(txtSearch.getText(), 1);
		sorter.setRowFilter(rowFilter);
		tblUser.setRowSorter(sorter);
	}
}
