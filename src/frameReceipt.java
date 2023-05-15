import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.*;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.print.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frameReceipt extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JButton btnPrint;
	private JButton btnBackToHome;
	public static frameEventMngrMain frmEMMain;
	public static JLabel lblDateBooked;
	public static JLabel lblEvtMngr;
	public static JLabel lblEventId;
	public static JLabel lblEventName;
	public static JLabel lblVenue;
	public static JLabel lblDate;
	public static JLabel lblFoodService;
	public static JLabel lblEquipments;
	public static JLabel lblTotalGuests;
	public static JLabel lblPayMethod;
	public static JLabel lblCustName;
	public static JLabel lblVenueCost;
	public static JLabel lblFoodServiceCost;
	public static JLabel lblEquipmentsCost;
	public static JLabel lblChange;
	public static JLabel lblCashPaid;
	public static JLabel lblTotalCost;
	

	
	public frameReceipt() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 730, 571);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.BLACK);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEventBookingInvoice = new JLabel("EVENT BOOKING INVOICE");
		lblEventBookingInvoice.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblEventBookingInvoice.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventBookingInvoice.setBounds(263, 46, 211, 14);
		contentPanel.add(lblEventBookingInvoice);
		
		JLabel label_1 = new JLabel("******************************************************************************************");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(37, 57, 651, 14);
		contentPanel.add(label_1);
		
		JLabel label = new JLabel("******************************************************************************************");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Monospaced", Font.BOLD, 11));
		label.setBackground(Color.WHITE);
		label.setBounds(37, 11, 651, 14);
		contentPanel.add(label);
		
		JLabel lblNewLabel = new JLabel("PAYMENT DATE:");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 75, 113, 14);
		contentPanel.add(lblNewLabel);
		
		lblDateBooked = new JLabel("");
		lblDateBooked.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblDateBooked.setBounds(122, 75, 147, 14);
		contentPanel.add(lblDateBooked);
		
		JLabel label_3 = new JLabel("--------------------------------------------------------------------------------------------------");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_3.setBounds(0, 111, 696, 16);
		contentPanel.add(label_3);
		
		JLabel lblEventManager = new JLabel("EVENT MANAGER: ");
		lblEventManager.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblEventManager.setBounds(10, 100, 122, 14);
		contentPanel.add(lblEventManager);
		
		lblEvtMngr = new JLabel("");
		lblEvtMngr.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblEvtMngr.setBounds(122, 100, 134, 14);
		contentPanel.add(lblEvtMngr);
		
		JLabel label1 = new JLabel("EVENT ID:");
		label1.setFont(new Font("Monospaced", Font.BOLD, 12));
		label1.setBounds(10, 173, 89, 14);
		contentPanel.add(label1);
		
		JLabel label2 = new JLabel("EVENT NAME: ");
		label2.setFont(new Font("Monospaced", Font.BOLD, 12));
		label2.setBounds(10, 215, 113, 14);
		contentPanel.add(label2);
		
		JLabel label3 = new JLabel("VENUE: ");
		label3.setFont(new Font("Monospaced", Font.BOLD, 12));
		label3.setBounds(10, 254, 89, 14);
		contentPanel.add(label3);
		
		JLabel label4 = new JLabel("DATE: ");
		label4.setFont(new Font("Monospaced", Font.BOLD, 12));
		label4.setBounds(10, 288, 65, 14);
		contentPanel.add(label4);
		
		JLabel label5 = new JLabel("FOOD SERVICE: ");
		label5.setFont(new Font("Monospaced", Font.BOLD, 12));
		label5.setBounds(10, 323, 122, 14);
		contentPanel.add(label5);
		
		JLabel label6 = new JLabel("EQUIPMENTS: ");
		label6.setFont(new Font("Monospaced", Font.BOLD, 12));
		label6.setBounds(10, 356, 113, 14);
		contentPanel.add(label6);
		
		JLabel label7 = new JLabel("NO. OF GUESTS: ");
		label7.setFont(new Font("Monospaced", Font.BOLD, 12));
		label7.setBounds(10, 442, 140, 14);
		contentPanel.add(label7);
		
		lblEventId = new JLabel("");
		lblEventId.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblEventId.setBounds(160, 173, 140, 14);
		contentPanel.add(lblEventId);
		
		lblEventName = new JLabel("");
		lblEventName.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblEventName.setBounds(160, 215, 197, 14);
		contentPanel.add(lblEventName);
		
		lblVenue = new JLabel("");
		lblVenue.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblVenue.setBounds(160, 254, 197, 14);
		contentPanel.add(lblVenue);
		
		lblDate = new JLabel("");
		lblDate.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblDate.setBounds(160, 288, 152, 14);
		contentPanel.add(lblDate);
		
		lblFoodService = new JLabel("");
		lblFoodService.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblFoodService.setBounds(160, 323, 197, 14);
		contentPanel.add(lblFoodService);
		
		lblEquipments = new JLabel("");
		lblEquipments.setVerticalAlignment(SwingConstants.TOP);
		lblEquipments.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblEquipments.setBounds(10, 377, 347, 46);
		contentPanel.add(lblEquipments);
		
		lblTotalGuests = new JLabel("");
		lblTotalGuests.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblTotalGuests.setBounds(160, 442, 109, 14);
		contentPanel.add(lblTotalGuests);
		
		JLabel label_7 = new JLabel("----------------------------------------------");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_7.setBounds(20, 188, 330, 16);
		contentPanel.add(label_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 0)));
		panel.setBounds(367, 122, 347, 387);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblAmount = new JLabel("AMOUNT");
		lblAmount.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblAmount.setBounds(230, 140, 70, 14);
		panel.add(lblAmount);
		
		JLabel label_13 = new JLabel("----------------------------------------------");
		label_13.setHorizontalAlignment(SwingConstants.LEFT);
		label_13.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_13.setBounds(10, 258, 330, 16);
		panel.add(label_13);
		
		JLabel labelVenue = new JLabel("VENUE COST: ");
		labelVenue.setBounds(10, 179, 165, 14);
		panel.add(labelVenue);
		labelVenue.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		JLabel label_5 = new JLabel("----------------------------------------------");
		label_5.setBounds(10, 194, 330, 16);
		panel.add(label_5);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Monospaced", Font.BOLD, 11));
		
		JLabel lblFoodserviceCost = new JLabel("FOOD SERVICE COST: ");
		lblFoodserviceCost.setBounds(10, 211, 165, 14);
		panel.add(lblFoodserviceCost);
		lblFoodserviceCost.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		JLabel label_6 = new JLabel("----------------------------------------------");
		label_6.setBounds(10, 225, 330, 16);
		panel.add(label_6);
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("Monospaced", Font.BOLD, 11));
		
		JLabel lblTotalEquipmentsCost = new JLabel("TOTAL EQUIPMENTS COST: ");
		lblTotalEquipmentsCost.setBounds(10, 242, 176, 14);
		panel.add(lblTotalEquipmentsCost);
		lblTotalEquipmentsCost.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		JLabel lblPaymentMethod = new JLabel("PAYMENT METHOD: ");
		lblPaymentMethod.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblPaymentMethod.setBounds(10, 64, 133, 14);
		panel.add(lblPaymentMethod);
		
		JLabel lblCustomerName = new JLabel("CUSTOMER NAME:");
		lblCustomerName.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblCustomerName.setBounds(10, 102, 133, 14);
		panel.add(lblCustomerName);
		
		JLabel label_2 = new JLabel("----------------------------------------------");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_2.setBounds(10, 79, 330, 16);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("----------------------------------------------");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_4.setBounds(10, 113, 330, 16);
		panel.add(label_4);
		
		lblPayMethod = new JLabel("");
		JLabel lblPayMethod2 = lblPayMethod;
		lblPayMethod2.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblPayMethod2.setBounds(230, 64, 107, 14);
		panel.add(lblPayMethod2);
		
		lblCustName = new JLabel("");
		JLabel lblCustName2 = lblCustName;
		lblCustName2.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblCustName2.setBounds(230, 102, 110, 14);
		panel.add(lblCustName2);
		
		lblVenueCost = new JLabel("");
		lblVenueCost.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblVenueCost.setBounds(230, 180, 110, 14);
		panel.add(lblVenueCost);
		
		lblFoodServiceCost = new JLabel("");
		lblFoodServiceCost.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblFoodServiceCost.setBounds(230, 212, 107, 14);
		panel.add(lblFoodServiceCost);
		
		lblEquipmentsCost = new JLabel("");
		lblEquipmentsCost.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblEquipmentsCost.setBounds(230, 243, 107, 14);
		panel.add(lblEquipmentsCost);
		
		JLabel lblGrandTotal = new JLabel("GRAND TOTAL: ");
		lblGrandTotal.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblGrandTotal.setBounds(10, 277, 150, 14);
		panel.add(lblGrandTotal);
		
		JLabel lblNewLabel_2 = new JLabel("CASH PAID: ");
		lblNewLabel_2.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 315, 111, 14);
		panel.add(lblNewLabel_2);
		
		JLabel labelchange = new JLabel("CHANGE: ");
		labelchange.setFont(new Font("Monospaced", Font.BOLD, 12));
		labelchange.setBounds(10, 350, 84, 14);
		panel.add(labelchange);
		
		JLabel label_14 = new JLabel("----------------------------------------------");
		label_14.setHorizontalAlignment(SwingConstants.LEFT);
		label_14.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_14.setBounds(10, 298, 330, 16);
		panel.add(label_14);
		
		JLabel label_15 = new JLabel("----------------------------------------------");
		label_15.setHorizontalAlignment(SwingConstants.LEFT);
		label_15.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_15.setBounds(10, 334, 330, 16);
		panel.add(label_15);
		
		lblTotalCost = new JLabel("");
		lblTotalCost.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblTotalCost.setBounds(230, 277, 110, 14);
		panel.add(lblTotalCost);
		
		lblCashPaid = new JLabel("");
		lblCashPaid.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblCashPaid.setBounds(230, 315, 107, 14);
		panel.add(lblCashPaid);
		
		lblChange = new JLabel("");
		lblChange.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblChange.setBounds(230, 351, 107, 14);
		panel.add(lblChange);
		
		JLabel lblDescription = new JLabel("DESCRIPTION");
		lblDescription.setBounds(10, 6, 111, 14);
		panel.add(lblDescription);
		lblDescription.setFont(new Font("Monospaced", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("EVENT DETAILS");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 128, 140, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel label_8 = new JLabel("----------------------------------------------");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_8.setBounds(20, 230, 330, 16);
		contentPanel.add(label_8);
		
		JLabel label_9 = new JLabel("----------------------------------------------");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_9.setBounds(20, 267, 330, 16);
		contentPanel.add(label_9);
		
		JLabel label_10 = new JLabel("----------------------------------------------");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_10.setBounds(20, 304, 330, 16);
		contentPanel.add(label_10);
		
		JLabel label_11 = new JLabel("----------------------------------------------");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_11.setBounds(20, 339, 330, 16);
		contentPanel.add(label_11);
		
		JLabel label_12 = new JLabel("----------------------------------------------");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setFont(new Font("Monospaced", Font.BOLD, 11));
		label_12.setBounds(20, 424, 330, 16);
		contentPanel.add(label_12);
		
		JLabel lblEventMasters = new JLabel("EVENT MASTERS");
		lblEventMasters.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventMasters.setFont(new Font("Monospaced", Font.BOLD, 13));
		lblEventMasters.setBounds(263, 21, 211, 16);
		contentPanel.add(lblEventMasters);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnPrint = new JButton("PRINT INVOICE");
				btnPrint.setForeground(Color.WHITE);
				btnPrint.setFont(new Font("Lucida Fax", Font.BOLD, 11));
				btnPrint.setBackground(new Color(46, 139, 87));
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						printInvoice(contentPanel);
					}
				});
				btnPrint.setActionCommand("OK");
				buttonPane.add(btnPrint);
				getRootPane().setDefaultButton(btnPrint);
			}
			{
				btnBackToHome = new JButton("BACK TO HOME");
				btnBackToHome.setForeground(Color.WHITE);
				btnBackToHome.setFont(new Font("Lucida Fax", Font.BOLD, 11));
				btnBackToHome.setBackground(new Color(205, 92, 92));
				btnBackToHome.addActionListener(new ActionListener() {
					//This will save the invoice of the event if the event manager doesn't want to print the invoice or forgot to print it
					//This file is located at the main folder
					public void actionPerformed(ActionEvent arg0) {
						String invoiceName = "BOOKING_INVOICE_EvtID-" + lblEventId.getText() + ".txt";
						try {
							PrintWriter file = new PrintWriter(invoiceName);
							file.println("******************************************************");
							file.println("*******************EVENT MASTERS**********************");
							file.println("                                                      ");
							file.println("****************EVENT BOOKING INVOICE*****************");
							file.println("******************************************************");
							file.println("PAYMENT DATE:       		   " + lblDateBooked.getText());
							file.println("Evt Mngr ID:       			          " + lblEvtMngr.getText());
							file.println("                                                      ");
							file.println("*******************EVENT DETAILS**********************");
							file.println("EVENT ID:       	" + lblEventId.getText());
							file.println("EVENT NAME:       	" + lblEventName.getText());
							file.println("VENUE:       		" + lblVenue.getText());
							file.println("DATE:       		" + lblDate.getText());
							file.println("FOOD SERVICE:       	" + lblFoodService.getText());
							file.println("EQUIPMENTS:       	" + lblEquipments.getText());
							file.println("NO. OF GUESTS:       	" + lblTotalGuests.getText());
							file.println("                                                      ");
							file.println("********************DESCRIPTION***********************");
							file.println("PAYMENT METHOD:       		" + lblPayMethod.getText());
							file.println("CUSTOMER NAME:       		" + lblCustName.getText());
							file.println("VENUE COST:       		" + lblVenueCost.getText());
							file.println("FOOD SERVICE COST:              " + lblFoodServiceCost.getText());
							file.println("TOTAL EQUIPMENTS COST:          " + lblEquipmentsCost.getText());
							file.println("GRAND TOTAL:       		" + lblTotalCost.getText());
							file.println("CASH PAID:       		" + lblCashPaid.getText());
							file.println("CHANGE:       			" + lblChange.getText());
							file.close();
							JOptionPane.showMessageDialog(null, "An auto-generated invoice is saved in the main folder.");
						}catch(FileNotFoundException e) {
							e.printStackTrace();
						}
						
						frmEMMain = new frameEventMngrMain();
						frmEMMain.setVisible(true);
						setVisible(false);
					}
				});
				btnBackToHome.setActionCommand("Cancel");
				buttonPane.add(btnBackToHome);
			}
		}
	}
	
	//if the event manager wants to print the invoice immediately
	private void printInvoice(JPanel panel){
        
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Invoice");
        
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D graphics2D = (Graphics2D)graphics;
                // set graphics translations
                graphics2D.translate(pageFormat.getImageableX()+20, pageFormat.getImageableY()+25);
                // This is a page scale
                graphics2D.scale(0.8, 1.0);
               
                panel.paint(graphics2D);
                
                return Printable.PAGE_EXISTS;
            }
        });

        boolean returningResult = printerJob.printDialog();
        if(returningResult){
            try{
                printerJob.print();
            }catch (PrinterException printerException){
                JOptionPane.showMessageDialog(this, "Print Error: " + printerException.getMessage());
            }
        }
    }
	
	
}
