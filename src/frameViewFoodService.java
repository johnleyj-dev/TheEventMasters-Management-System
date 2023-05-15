import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class frameViewFoodService extends JFrame {

	private JPanel contentPane;
	public static frameEventMngrMain frmEMMain;
	private JTextField txtFServiceName;
	private JTextField txtFServiceCost;
	private JTable tblFoodService;
	private JButton btnBack;
	private JLabel lblFServiceId;
	private JTextField txtSearch;
	private TableRowSorter<DefaultTableModel> sorter;
	private JLabel lblNewLabel;
	private JTextField txtPricePerGuest;

	
	public frameViewFoodService() {
		setResizable(false);
		setTitle("FOOD SERVICES");
		setBounds(100, 100, 736, 345);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFoodserviceId = new JLabel("FOODSERVICE ID:");
		lblFoodserviceId.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblFoodserviceId.setBounds(10, 108, 108, 14);
		contentPane.add(lblFoodserviceId);
		
		lblFServiceId = new JLabel("");
		lblFServiceId.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblFServiceId.setBounds(119, 108, 54, 14);
		contentPane.add(lblFServiceId);
		
		JLabel lblServiceName = new JLabel("SERVICE NAME:");
		lblServiceName.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblServiceName.setBounds(10, 155, 108, 14);
		contentPane.add(lblServiceName);
		
		txtFServiceName = new JTextField();
		txtFServiceName.setText((String) null);
		txtFServiceName.setEnabled(false);
		txtFServiceName.setColumns(10);
		txtFServiceName.setBounds(119, 152, 142, 20);
		contentPane.add(txtFServiceName);
		
		JLabel label_3 = new JLabel("COST:");
		label_3.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		label_3.setBounds(10, 195, 67, 14);
		contentPane.add(label_3);
		
		txtFServiceCost = new JTextField();
		txtFServiceCost.setText((String) null);
		txtFServiceCost.setEnabled(false);
		txtFServiceCost.setColumns(10);
		txtFServiceCost.setAlignmentX(1.0f);
		txtFServiceCost.setBounds(119, 192, 142, 20);
		contentPane.add(txtFServiceCost);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(283, 108, 437, 188);
		contentPane.add(scrollPane);
		
		sorter = new TableRowSorter<DefaultTableModel>(frameManageFoodService.modelFService);
		tblFoodService = new JTable(frameManageFoodService.modelFService);
		tblFoodService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showDetails();
			}
		});
		tblFoodService.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				showDetails();
			}
		});
		tblFoodService.setDefaultEditor(Object.class, null);
		frameManageFoodService.modelFService.setColumnIdentifiers(frameManageFoodService.columns);
		scrollPane.setViewportView(tblFoodService);
		
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
		btnBack.setBounds(595, 17, 89, 23);
		contentPane.add(btnBack);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				searchFoodService();
			}
		});
		txtSearch.setBounds(585, 75, 135, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblSearchService = new JLabel("Search Service: ");
		lblSearchService.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblSearchService.setBounds(487, 78, 101, 14);
		contentPane.add(lblSearchService);
		
		lblNewLabel = new JLabel("PRICE PER GUEST: ");
		lblNewLabel.setFont(new Font("Lucida Fax", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 236, 118, 14);
		contentPane.add(lblNewLabel);
		
		txtPricePerGuest = new JTextField();
		txtPricePerGuest.setText((String) null);
		txtPricePerGuest.setEnabled(false);
		txtPricePerGuest.setColumns(10);
		txtPricePerGuest.setAlignmentX(1.0f);
		txtPricePerGuest.setBounds(119, 233, 142, 20);
		contentPane.add(txtPricePerGuest);
		
		
		loadDefaults();
	}
	
	private void loadDefaults(){
		txtFServiceName.setEnabled(false);
		txtFServiceCost.setEnabled(false);
		txtPricePerGuest.setEnabled(false);
	}
	
	private void showDetails(){
		lblFServiceId.setText(String.valueOf(tblFoodService.getValueAt(tblFoodService.getSelectedRow(), 0)));
		txtFServiceName.setText(String.valueOf(tblFoodService.getValueAt(tblFoodService.getSelectedRow(), 1)));
		txtFServiceCost.setText(String.valueOf(tblFoodService.getValueAt(tblFoodService.getSelectedRow(), 2)));
		txtPricePerGuest.setText(String.valueOf(tblFoodService.getValueAt(tblFoodService.getSelectedRow(), 3)));
	}
	
	//rowFilter to search a food service
	private void searchFoodService(){
		RowFilter<DefaultTableModel, Object> rowFilter = null;
		rowFilter = RowFilter.regexFilter(txtSearch.getText(), 1);
		sorter.setRowFilter(rowFilter);
		tblFoodService.setRowSorter(sorter);
		//lblRecordCount.setText("Records : " + tblPerson.getRowCount());
	}
}
