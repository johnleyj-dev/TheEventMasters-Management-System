import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class frameViewBooking extends JFrame {

	private JPanel contentPane;
	public static frameAdminMain frmAdminMain;
	private JTable tblBookHistory;
	private JButton btnBack;
	private JTextField txtSearch;
	private JComboBox<String> cboEvtMngr;
	private TableRowSorter<DefaultTableModel> sorter;
	private JLabel lblEventManagers;

	public frameViewBooking() {
		setResizable(false);
		setTitle("Booking History");
		setBounds(100, 100, 861, 405);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 184, 135));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 835, 254);
		contentPane.add(scrollPane);
		
		sorter = new TableRowSorter<DefaultTableModel>(frameEventMngrMain.modelBookHstry);
		tblBookHistory = new JTable(frameEventMngrMain.modelBookHstry);
		tblBookHistory.setDefaultEditor(Object.class, null);
		frameEventMngrMain.modelBookHstry.setColumnIdentifiers(frameEventMngrMain.columns);
		tblBookHistory.removeColumn(tblBookHistory.getColumnModel().getColumn(12));
		tblBookHistory.removeColumn(tblBookHistory.getColumnModel().getColumn(11));
		scrollPane.setViewportView(tblBookHistory);
		
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
		btnBack.setBounds(704, 21, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("BOOKING HISTORY");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(349, 48, 152, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSearchEvent = new JLabel("Search Event: ");
		lblSearchEvent.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblSearchEvent.setBounds(10, 86, 89, 14);
		contentPane.add(lblSearchEvent);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchEvents();
			}
		});
		txtSearch.setBounds(101, 83, 130, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		cboEvtMngr = new JComboBox<String>();
		cboEvtMngr.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		cboEvtMngr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filterEvtMngrs();
			}
		});
		loadEvtMngrs();
		cboEvtMngr.setBounds(715, 83, 130, 20);
		contentPane.add(cboEvtMngr);
		
		lblEventManagers = new JLabel("Event Managers");
		lblEventManagers.setFont(new Font("Lucida Fax", Font.PLAIN, 12));
		lblEventManagers.setBounds(615, 86, 112, 14);
		contentPane.add(lblEventManagers);
	}
	
	//adding all event manager ID to cbobox
	private void loadEvtMngrs(){
		cboEvtMngr.addItem("ALL");
		for(int index = 0; index < frameMain.modelUser.getRowCount(); index++) {
			cboEvtMngr.addItem(String.valueOf(frameMain.modelUser.getValueAt(index, 0)));
		}
	}
	
	//filtering the cbobox that has all event mngr ID
	private void filterEvtMngrs(){
		if(cboEvtMngr.getSelectedItem().equals("ALL")){
			tblBookHistory.setRowSorter(null);
		}else{
			RowFilter<DefaultTableModel, Object> rowFilter = null;
			rowFilter = RowFilter.regexFilter("(\\b)" + cboEvtMngr.getItemAt(cboEvtMngr.getSelectedIndex()) + "(\\b)", 0);
			sorter.setRowFilter(rowFilter);
			tblBookHistory.setRowSorter(sorter);
		}
	}
	
	//searching name of events
	private void searchEvents(){
		RowFilter<DefaultTableModel, Object> rowFilter = null;
		rowFilter = RowFilter.regexFilter(txtSearch.getText(), 2);
		sorter.setRowFilter(rowFilter);
		tblBookHistory.setRowSorter(sorter);
	}
}
