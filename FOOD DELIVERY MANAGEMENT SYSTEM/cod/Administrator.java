package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import connectionToDatabase.GenerareRaport;
import importing.ProductImport;
import mainData.MainControl;
import mainData.MainDataForDelivery;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.IntConsumer;

public class Administrator extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private MainDataForDelivery md;
	private JTable table_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTable table;
	private JTable table_2;
	private JTextField title;
	private JTextField rating;
	private JTextField calories;
	private JTextField protein;
	private JTextField fat;
	private JTextField sodium;
	private JTextField price;
	private JTextField tc;
	private JTable table_3;
	private JTextField timpmin;
	private JTextField vr2;
	private JTextField vr4;
	private JTextField vr3;
	private JTextField dday;
	private CompositeProduct cp;
	private List<BaseProduct> cos;
	private JTextField timpmax;
	private int vf;		
	public Administrator(MainDataForDelivery md2) {
		md=md2;
		setTitle("Administrator");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\tema 4\\5-59796_food-delivery-delivery-food-icon-png-transparent-png.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//md=new MainDataForDelivery();
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 10, 842, 543);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		tabbedPane.addTab("Import", null, panel, null);
		panel.setLayout(null);
		
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(46, 10, 750, 376);
				panel.add(scrollPane);
				
				table_1 = new JTable();
				table_1.setModel(model);
				scrollPane.setViewportView(table_1);
				table_1.setBounds(38, 348, 486, 164);
				
				
				btnNewButton = new JButton("import products");
				btnNewButton.setBounds(596, 431, 164, 27);
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ProductImport pi=new ProductImport();
						md=pi.importpr(md);
						md.getBaseProducts().forEach(pro->{
						row[0]=pro.getTitle();
						row[1]=pro.getRating()+"";
						row[2]=pro.getCalories()+"";
						row[3]=pro.getProteins()+"";
						row[4]=pro.getFats()+"";
						row[5]=pro.getSodium()+"";
						row[6]=pro.getPrice()+"";
						model.addRow(row);
						//System.out.println("s-a adaugat");
					});
					}
				});
				
				//scrollPane.setLayout(null);
	
				btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
				btnNewButton.setForeground(new Color(178, 34, 34));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(178, 34, 34));
		tabbedPane.addTab("Products", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(268, 10, 559, 237);
		panel_1.add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(375, 261, 452, 225);
		panel_1.add(scrollPane_2);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				title.setText(table.getModel().getValueAt(table.getSelectedRow(), 0)+"");
				rating.setText(table.getModel().getValueAt(table.getSelectedRow(), 1)+"");
				calories.setText(table.getModel().getValueAt(table.getSelectedRow(), 2)+"");
				protein.setText(table.getModel().getValueAt(table.getSelectedRow(), 3)+"");
				fat.setText(table.getModel().getValueAt(table.getSelectedRow(), 4)+"");
				sodium.setText(table.getModel().getValueAt(table.getSelectedRow(), 5)+"");
				price.setText(table.getModel().getValueAt(table.getSelectedRow(), 6)+"");
			}
		});
		table.setBounds(20, 43, 225, 153);
		//panel_1.add(table);
		table.setModel(model);
		scrollPane_1.setViewportView(table);
		
		table_2 = new JTable();
		table_2.setBounds(10, 233, 235, 146);
		//panel_1.add(table_2);
		
		scrollPane_2.setViewportView(table_2);
		
		title = new JTextField();
		title.setBounds(28, 43, 96, 19);
		panel_1.add(title);
		title.setColumns(10);
		
		rating = new JTextField();
		rating.setColumns(10);
		rating.setBounds(143, 43, 96, 19);
		panel_1.add(rating);
		
		calories = new JTextField();
		calories.setColumns(10);
		calories.setBounds(28, 79, 96, 19);
		panel_1.add(calories);
		
		protein = new JTextField();
		protein.setColumns(10);
		protein.setBounds(143, 79, 96, 19);
		panel_1.add(protein);
		
		fat = new JTextField();
		fat.setColumns(10);
		fat.setBounds(28, 116, 96, 19);
		panel_1.add(fat);
		
		sodium = new JTextField();
		sodium.setColumns(10);
		sodium.setBounds(143, 116, 96, 19);
		panel_1.add(sodium);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(28, 150, 96, 19);
		panel_1.add(price);
		
		JButton btnNewButton_1 = new JButton("add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseProduct bpn=new BaseProduct(title.getText(),Float.parseFloat(rating.getText()),Integer.parseInt(calories.getText()),Integer.parseInt(protein.getText()),Integer.parseInt(fat.getText()),Integer.parseInt(sodium.getText()),Integer.parseInt(price.getText()));
				md.addBasePr(bpn);
				DefaultTableModel model2=new DefaultTableModel();
				model2.setColumnIdentifiers(columns);
				md.getBaseProducts().forEach(pro->{
					row[0]=pro.getTitle();
					row[1]=pro.getRating()+"";
					row[2]=pro.getCalories()+"";
					row[3]=pro.getProteins()+"";
					row[4]=pro.getFats()+"";
					row[5]=pro.getSodium()+"";
					row[6]=pro.getPrice()+"";
					model2.addRow(row);
				});
				table.setModel(model2);
				scrollPane_1.setViewportView(table);
			}
		});
		btnNewButton_1.setBounds(28, 179, 85, 21);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("modify");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseProduct bpn=new BaseProduct(title.getText(),Float.parseFloat(rating.getText()),Integer.parseInt(calories.getText()),Integer.parseInt(protein.getText()),Integer.parseInt(fat.getText()),Integer.parseInt(sodium.getText()),Integer.parseInt(price.getText()));
				md.setBaseProducts(md.modifyBasePr(bpn));
				DefaultTableModel model2=new DefaultTableModel();
				model2.setColumnIdentifiers(columns);
				md.getBaseProducts().forEach(pro->{
					row[0]=pro.getTitle();
					row[1]=pro.getRating()+"";
					row[2]=pro.getCalories()+"";
					row[3]=pro.getProteins()+"";
					row[4]=pro.getFats()+"";
					row[5]=pro.getSodium()+"";
					row[6]=pro.getPrice()+"";
					model2.addRow(row);
				});
				table.setModel(model2);
				scrollPane_1.setViewportView(table);
			}
		});
		btnNewButton_2.setBounds(143, 179, 85, 21);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseProduct bpn=new BaseProduct(title.getText(),Float.parseFloat(rating.getText()),Integer.parseInt(calories.getText()),Integer.parseInt(protein.getText()),Integer.parseInt(fat.getText()),Integer.parseInt(sodium.getText()),Integer.parseInt(price.getText()));
				md.setBaseProducts(md.removeBasePr(bpn));
				DefaultTableModel model2=new DefaultTableModel();
				model2.setColumnIdentifiers(columns);
				md.getBaseProducts().forEach(pro->{
					row[0]=pro.getTitle();
					row[1]=pro.getRating()+"";
					row[2]=pro.getCalories()+"";
					row[3]=pro.getProteins()+"";
					row[4]=pro.getFats()+"";
					row[5]=pro.getSodium()+"";
					row[6]=pro.getPrice()+"";
					model2.addRow(row);
				});
				table.setModel(model2);
				scrollPane_1.setViewportView(table);
			}
		});
		btnNewButton_3.setBounds(72, 210, 85, 21);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(28, 31, 96, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setForeground(Color.WHITE);
		lblRating.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblRating.setBounds(146, 31, 93, 15);
		panel_1.add(lblRating);
		
		JLabel lblCalories = new JLabel("Calories");
		lblCalories.setForeground(Color.WHITE);
		lblCalories.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCalories.setBounds(29, 64, 95, 15);
		panel_1.add(lblCalories);
		
		JLabel lblProtein = new JLabel("Protein");
		lblProtein.setForeground(Color.WHITE);
		lblProtein.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblProtein.setBounds(142, 66, 97, 15);
		panel_1.add(lblProtein);
		
		JLabel lblFat = new JLabel("Fat");
		lblFat.setForeground(Color.WHITE);
		lblFat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFat.setBounds(29, 101, 95, 15);
		panel_1.add(lblFat);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPrice.setBounds(29, 136, 95, 15);
		panel_1.add(lblPrice);
		
		JLabel lblSodium = new JLabel("Sodium");
		lblSodium.setForeground(Color.WHITE);
		lblSodium.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSodium.setBounds(142, 103, 97, 15);
		panel_1.add(lblSodium);
		
		JLabel lblbaseProducts = new JLabel("-BASE PRODUCTS-");
		lblbaseProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblbaseProducts.setForeground(Color.WHITE);
		lblbaseProducts.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblbaseProducts.setBounds(10, 10, 229, 15);
		panel_1.add(lblbaseProducts);
		
		JLabel lblcompositeProducts = new JLabel("-COMPOSITE PRODUCTS-");
		lblcompositeProducts.setHorizontalAlignment(SwingConstants.CENTER);
		lblcompositeProducts.setForeground(Color.WHITE);
		lblcompositeProducts.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblcompositeProducts.setBounds(10, 249, 229, 15);
		panel_1.add(lblcompositeProducts);
		
		JLabel lblDenumire = new JLabel("Title");
		lblDenumire.setForeground(Color.WHITE);
		lblDenumire.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDenumire.setBounds(28, 283, 96, 15);
		panel_1.add(lblDenumire);
		
		tc = new JTextField();
		tc.setColumns(10);
		tc.setBounds(28, 297, 279, 19);
		panel_1.add(tc);
		
		JLabel lblComponents = new JLabel("Components:");
		lblComponents.setForeground(Color.WHITE);
		lblComponents.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblComponents.setBounds(28, 326, 96, 15);
		panel_1.add(lblComponents);
		 cp=new CompositeProduct();
		 cos=new ArrayList<BaseProduct>();
		table_3 = new JTable();
		table_3.setBounds(10, 348, 355, 104);
		//panel_1.add(table_3);
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 348, 355, 104);
		scrollPane_3.setViewportView(table_3);
		JButton btnNewButton_4 = new JButton("Add New Composite Product");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		Object[] columns2={"title", "price"};
				DefaultTableModel model2=new DefaultTableModel();
				Object[] row2=new Object[2];
				model2.setColumnIdentifiers(columns2);
	
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vf=0;
				md.getCompositeProducts().forEach(x->{
					if(x.getTitle().equals(tc.getText())) {
						vf++;
					}
				});
				if(vf!=0) {
					JOptionPane.showMessageDialog(null,"exista deja!");
				}
				else {
				cos.forEach(pr->{
					cp.addProduse(pr);
				});
				cp.setTitle(tc.getText());
					row[0]=cp.getTitle();
					row[1]=cp.getPrice()+"";
					model2.addRow(row);
				md.addCompositePr(cp);
				
				 cp=new CompositeProduct();
				cos=new ArrayList<BaseProduct>();
				
				table_3.setModel(new DefaultTableModel());}
			}
		});
		table_2.setModel(model2);
				scrollPane_2.setViewportView(table_2);
		btnNewButton_4.setBounds(184, 465, 181, 21);
		panel_1.add(btnNewButton_4);
		
		
		JButton btnNewButton_5 = new JButton("Add the product selected");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseProduct bpn=new BaseProduct(title.getText(),Float.parseFloat(rating.getText()),Integer.parseInt(calories.getText()),Integer.parseInt(protein.getText()),Integer.parseInt(fat.getText()),Integer.parseInt(sodium.getText()),Integer.parseInt(price.getText()));
				cos.add(bpn);
				DefaultTableModel model2=new DefaultTableModel();
				model2.setColumnIdentifiers(columns);
				cos.forEach(pro->{
					row[0]=pro.getTitle();
					row[1]=pro.getRating()+"";
					row[2]=pro.getCalories()+"";
					row[3]=pro.getProteins()+"";
					row[4]=pro.getFats()+"";
					row[5]=pro.getSodium()+"";
					row[6]=pro.getPrice()+"";
					model2.addRow(row);
				});
				table_3.setModel(model2);
				scrollPane_3.setViewportView(table_3);
			}
		});
		btnNewButton_5.setBounds(10, 465, 164, 21);
		panel_1.add(btnNewButton_5);
		
		
		panel_1.add(scrollPane_3);
		
		JButton btnNewButton_8 = new JButton("SHOW");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model2=new DefaultTableModel();
				model2.setColumnIdentifiers(columns);
				md.getBaseProducts().forEach(pro->{
					row[0]=pro.getTitle();
					row[1]=pro.getRating()+"";
					row[2]=pro.getCalories()+"";
					row[3]=pro.getProteins()+"";
					row[4]=pro.getFats()+"";
					row[5]=pro.getSodium()+"";
					row[6]=pro.getPrice()+"";
					model2.addRow(row);
				});
				table.setModel(model2);
				scrollPane_1.setViewportView(table);
			}
		});
		btnNewButton_8.setBounds(278, 249, 85, 19);
		panel_1.add(btnNewButton_8);
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(178, 34, 34));
		tabbedPane.addTab("Reports", null, panel_2, null);
		panel_2.setLayout(null);
		
		timpmin = new JTextField();
		timpmin.setBounds(102, 60, 101, 25);
		panel_2.add(timpmin);
		timpmin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("time interval of the orders");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(21, 25, 306, 25);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("the products ordered more than a specified number of times so far");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(21, 95, 806, 25);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("the clients that have ordered more than a specified number of times");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 169, 806, 25);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("and the value of the order was higher than a specified amount");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 192, 806, 25);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("the products ordered within a specified day with the number of times they have \r\nbeen ordered");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(21, 326, 806, 42);
		panel_2.add(lblNewLabel_1_1_1_1_1);
		GenerareRaport gr=new GenerareRaport(md);
		JButton btnNewButton_6 = new JButton("Generare");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
				try {
					Date d1=formatter6.parse(timpmin.getText());
					Date d2=formatter6.parse(timpmax.getText());
					gr.timeIntervalOrders(d1, d2);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			}
		});
		btnNewButton_6.setForeground(new Color(255, 215, 0));
		btnNewButton_6.setBackground(new Color(178, 34, 34));
		btnNewButton_6.setBounds(552, 62, 121, 21);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_6_1 = new JButton("Generare");
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nrmin=Integer.parseInt(vr2.getText());
				gr.productsOrder(nrmin);
			}
		});
		btnNewButton_6_1.setForeground(new Color(255, 215, 0));
		btnNewButton_6_1.setBackground(new Color(178, 34, 34));
		btnNewButton_6_1.setBounds(307, 130, 121, 21);
		panel_2.add(btnNewButton_6_1);
		
		vr2 = new JTextField();
		vr2.setColumns(10);
		vr2.setBounds(137, 130, 139, 25);
		panel_2.add(vr2);
		
		JButton btnNewButton_6_2 = new JButton("Generare");
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int v1=Integer.parseInt(vr3.getText());
				int v2=Integer.parseInt(vr4.getText());
				gr.clientsRap(v1, v2);
			}
		});
		btnNewButton_6_2.setForeground(new Color(255, 215, 0));
		btnNewButton_6_2.setBackground(new Color(178, 34, 34));
		btnNewButton_6_2.setBounds(307, 262, 121, 21);
		panel_2.add(btnNewButton_6_2);
		
		vr4 = new JTextField();
		vr4.setColumns(10);
		vr4.setBounds(137, 274, 121, 25);
		panel_2.add(vr4);
		
		JButton btnNewButton_6_4 = new JButton("Generare");
		btnNewButton_6_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");  
					try {
						Date d1=formatter6.parse(dday.getText());
						gr.productsDay(d1);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}  
			}
		});
		btnNewButton_6_4.setForeground(new Color(255, 215, 0));
		btnNewButton_6_4.setBackground(new Color(178, 34, 34));
		btnNewButton_6_4.setBounds(436, 378, 121, 21);
		panel_2.add(btnNewButton_6_4);
		
		vr3 = new JTextField();
		vr3.setColumns(10);
		vr3.setBounds(137, 239, 121, 25);
		panel_2.add(vr3);
		
		dday = new JTextField();
		dday.setColumns(10);
		dday.setBounds(178, 378, 209, 25);
		panel_2.add(dday);
		
		timpmax = new JTextField();
		timpmax.setColumns(10);
		timpmax.setBounds(276, 60, 101, 25);
		panel_2.add(timpmax);
		
		JLabel txt = new JLabel("first order:");
		txt.setForeground(Color.WHITE);
		txt.setBounds(31, 66, 63, 13);
		panel_2.add(txt);
		
		JLabel lblFinishHour = new JLabel("last order:");
		lblFinishHour.setForeground(Color.WHITE);
		lblFinishHour.setBounds(213, 66, 63, 13);
		panel_2.add(lblFinishHour);
		
		JLabel lblR = new JLabel("value:");
		lblR.setHorizontalAlignment(SwingConstants.RIGHT);
		lblR.setForeground(Color.WHITE);
		lblR.setBounds(64, 130, 63, 29);
		panel_2.add(lblR);
		
		JLabel lblValueForOrders = new JLabel("value for orders:");
		lblValueForOrders.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValueForOrders.setForeground(Color.WHITE);
		lblValueForOrders.setBounds(21, 235, 106, 29);
		panel_2.add(lblValueForOrders);
		
		JLabel lblValueForPrice = new JLabel("value for price:");
		lblValueForPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValueForPrice.setForeground(Color.WHITE);
		lblValueForPrice.setBounds(21, 272, 106, 29);
		panel_2.add(lblValueForPrice);
		
		JLabel lblDate = new JLabel("date :");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(62, 378, 106, 29);
		panel_2.add(lblDate);
		
		JButton btnNewButton_7 = new JButton("BACK");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.setmain(md);
				MainControl.afisareFirst();
				dispose();
			}
		});
		btnNewButton_7.setBounds(751, 564, 72, 15);
		contentPane.add(btnNewButton_7);
		JLabel timp = new JLabel("New label");
		timp.setForeground(Color.WHITE);
		timp.setBounds(719, 2, 157, 32);
		Thread clock=new Thread() {
			public void run() {
				
		    try {
		    	for(;;) {
		    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		    	Date date = new Date();  
		    	timp.setText(formatter.format(date));
		    	
		    	sleep(1000);}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
		clock.start();
		  contentPane.add(timp);
	}
}
