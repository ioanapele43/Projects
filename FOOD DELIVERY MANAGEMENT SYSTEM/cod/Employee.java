package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLayer.DeliveryService;
import connectionToDatabase.OrderOperations;
import mainData.MainControl;
import mainData.MainDataForDelivery;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Employee extends JFrame implements Observer {

	private JPanel contentPane;
	private String stare;
	private JTable table;
	private MainDataForDelivery mdc;
	private int fromClient;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private int plecare=0;
	public Employee(MainDataForDelivery md) {
		mdc=md;
		setTitle("Employee");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\tema 4\\5-59796_food-delivery-delivery-food-icon-png-transparent-png.png"));
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		stare="gatire";
		 lblNewLabel = new JLabel("");
		
		
		lblNewLabel.setBounds(10, 79, 395, 428);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\tema 4\\giphy (3).gif"));
		lblNewLabel_2.setBounds(470, 394, 406, 140);
		
		lblNewLabel_2.setVisible(false);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MainControl.setmain(md);
				MainControl.afisareFirst();
				dispose();
			}
		});
		btnNewButton.setBounds(48, 513, 85, 21);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 23, 334, 308);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBounds(466, 10, 323, 96);
		//contentPane.add(table);
		
		/*Object[] columns3={"order", "client"};
		DefaultTableModel model3=new DefaultTableModel();
		Object[] row3=new Object[2];
		model3.setColumnIdentifiers(columns3);
		md.getOrder().forEach(pro->{
			row3[0]=pro.getOrd().getOrderID();
			row3[1]=pro.getOrd().getClientID();
			
			model3.addRow(row3);
		});
		
		table.setModel(model3);*/
		
		
			 lblNewLabel_1 = new JLabel("I'm waiting.....");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_1.setBounds(62, 132, 212, 29);
			contentPane.add(lblNewLabel_1);
			lblNewLabel_1.setVisible(false);
				
				//lblNewLabel.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\tema 4\\giphy (5).gif"));
			
				lblNewLabel_3 = new JLabel("I'm working.....");
				lblNewLabel_3.setForeground(Color.WHITE);
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNewLabel_3.setBounds(62, 132, 212, 29);
				contentPane.add(lblNewLabel_3);
				//lblNewLabel_3.setVisible(false);
				lblNewLabel.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\tema 4\\giphy (6).gif"));
			
		
		
		JLabel timp = new JLabel("New label");
		timp.setForeground(Color.WHITE);
		timp.setBounds(31, 10, 154, 32);
		Thread clock=new Thread() {
			public void run() {
				
		    try {
		    	for(;;) {
		    		
		    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    	Date date = new Date();  
		    	timp.setText(formatter.format(date));
		    	update();
		    	sleep(1000);}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
		clock.start();
		  contentPane.add(timp);
	
	

		
	
	
	scrollPane.setViewportView(table);
	
	JButton btnNewButton_1 = new JButton("CLOSE");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if( fromClient==1){
				dispose();
				fromClient=0;
			}
			else {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
		}
	});
	
	btnNewButton_1.setBounds(154, 513, 85, 21);
	contentPane.add(btnNewButton_1);
	}
	
	public void setFromClient(int fromClient) {
		this.fromClient = fromClient;
	}
int ad=0;

	@Override
	public void update() {
		ad=0;
		
		mdc.getOrder().forEach(ord->{
			int li=OrderOperations.verificareLivrareProdus(ord.getOrd().getOrderID());
				ord.getOrd().setLivrat(li);
		});
		plecare=0;
		mdc.getOrder().forEach(ord->{
			int li2=OrderOperations.verifPlecareComanda(ord.getOrd().getOrderID());
			if(li2==1) {
				plecare++;
			}
		});
		if(plecare==1) {
			lblNewLabel_2.setVisible(true);
		}
		else {
			lblNewLabel_2.setVisible(false);
		}
		Object[] columns3={"order", "client"};
		DefaultTableModel model3=new DefaultTableModel();
		Object[] row3=new Object[2];
		model3.setColumnIdentifiers(columns3);
		mdc.getOrder().forEach(pro->{
			if(pro.getOrd().getLivrat()==0) {
			row3[0]=pro.getOrd().getOrderID();
			row3[1]=pro.getOrd().getClientID();
			
			model3.addRow(row3);
			ad++;
			}
		});
		if(ad==0) {
			setStare("asteptare");
		}
		else {
			setStare("gatire");
		}
		table.setModel(model3);
		if(stare.equals("asteptare")) {
			lblNewLabel_1.setVisible(true);
			lblNewLabel_3.setVisible(false);
			lblNewLabel.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\tema 4\\giphy (5).gif"));
		}
		else {
			lblNewLabel_3.setVisible(true);
			lblNewLabel_1.setVisible(false);
			lblNewLabel.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\tema 4\\giphy (6).gif"));
		}
	}

	public void setStare(String stare) {
		this.stare = stare;
	}
	
}

