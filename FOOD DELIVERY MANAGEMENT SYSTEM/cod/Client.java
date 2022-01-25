package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import businessLayer.IDeliveryServiceProcessing;
import businessLayer.MenuItem;
import businessLayer.Observable;
import businessLayer.Order;
import connectionToDatabase.CreateBill;
import connectionToDatabase.OrderOperations;
import connectionToDatabase.SearchOperations;
import dataLayer.Serializator;
import mainData.MainControl;
import mainData.MainDataForDelivery;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Client extends JFrame implements IDeliveryServiceProcessing{

	private JPanel contentPane;
	private JTextField searcht;
	private JTextField total;
	private JTextField cluser;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private Order ord;
	private Collection<MenuItem> cos;
	private Employee em;
	private JTextField tmeniu;
	private JTable table_3;

	public Client(MainDataForDelivery md) {
		
		setTitle("Client");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\tema 4\\5-59796_food-delivery-delivery-food-icon-png-transparent-png.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1033, 736);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 345, 249);
		contentPane.add(scrollPane);

		total = new JTextField();
		total.setBounds(507, 584, 121, 19);
		contentPane.add(total);
		total.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("-Search throw base products-");
		lblNewLabel.setBounds(421, 20, 341, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		searcht = new JTextField();
		searcht.setBounds(593, 61, 169, 19);
		contentPane.add(searcht);
		searcht.setColumns(10);
		
		String[] choices= {"title","rating <=","rating >=","calories <=","calories >=", "proteins <=","proteins >=","fats <=","fats >=", "sodium <=", "sodium >=","price <=","price >=s"};
		JComboBox comboBox = new JComboBox(choices);
		comboBox.setBounds(431, 60, 121, 21);
		
		contentPane.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(791, 60, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0) {
					table=SearchOperations.searchByTitle(md,table,searcht.getText());
				}
				else if(comboBox.getSelectedIndex()==1) {
					table=SearchOperations.searchByRating(md,table,Float.parseFloat(searcht.getText()),1);
				}
				else if(comboBox.getSelectedIndex()==2) {
					table=SearchOperations.searchByRating(md,table,Float.parseFloat(searcht.getText()),2);
				}
				else if(comboBox.getSelectedIndex()==3) {
					table=SearchOperations.searchByCalories(md,table,Integer.parseInt(searcht.getText()),1);
				}
				else if(comboBox.getSelectedIndex()==4) {
					table=SearchOperations.searchByCalories(md,table,Integer.parseInt(searcht.getText()),2);
				}
				else if(comboBox.getSelectedIndex()==5) {
					table=SearchOperations.searchByProteins(md,table,Integer.parseInt(searcht.getText()),1);
				}
				else if(comboBox.getSelectedIndex()==6) {
					table=SearchOperations.searchByProteins(md,table,Integer.parseInt(searcht.getText()),2);
				}
				else if(comboBox.getSelectedIndex()==7) {
					table=SearchOperations.searchByFats(md,table,Integer.parseInt(searcht.getText()),1);
				}
				else if(comboBox.getSelectedIndex()==8) {
					table=SearchOperations.searchByFats(md,table,Integer.parseInt(searcht.getText()),2);
				}
				else if(comboBox.getSelectedIndex()==9) {
					table=SearchOperations.searchBySodium(md,table,Integer.parseInt(searcht.getText()),1);
				}
				else if(comboBox.getSelectedIndex()==10) {
					table=SearchOperations.searchBySodium(md,table,Integer.parseInt(searcht.getText()),2);
				}
				else if(comboBox.getSelectedIndex()==11) {
					table=SearchOperations.searchByPrice(md,table,Integer.parseInt(searcht.getText()),1);
				}
				else if(comboBox.getSelectedIndex()==12) {
					table=SearchOperations.searchByPrice(md,table,Integer.parseInt(searcht.getText()),2);
				}
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lbladdNew = new JLabel("-Order-");
		lbladdNew.setBounds(479, 314, 169, 30);
		lbladdNew.setHorizontalAlignment(SwingConstants.CENTER);
		lbladdNew.setForeground(Color.WHITE);
		lbladdNew.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lbladdNew);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(423, 381, 302, 187);
		contentPane.add(scrollPane_1);
		
		ord=new Order();
		cos=new ArrayList<MenuItem>();
		JButton btnNewButton_2 = new JButton("Add base product");
		btnNewButton_2.setBounds(735, 436, 199, 21);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseProduct bap=new BaseProduct(table.getModel().getValueAt(table.getSelectedRow(), 0).toString(),Float.parseFloat(table.getModel().getValueAt(table.getSelectedRow(), 1).toString()),Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 2).toString()),Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 3).toString()),Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 4).toString()),Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 5).toString()),Integer.parseInt(table.getModel().getValueAt(table.getSelectedRow(), 6).toString()));
				ord.addBaseProduct(bap);
				cos.add(bap);
				Object[] columns3={"title", "price"};
				DefaultTableModel model3=new DefaultTableModel();
				Object[] row3=new Object[2];
				model3.setColumnIdentifiers(columns3);
				cos.forEach(pro->{
					
					row3[0]=pro.getTitle();
					
					row3[1]=pro.getPrice()+"";
					
					model3.addRow(row3);
				});
				
				table_1.setModel(model3);
				total.setText(ord.getTotal()+"");
			}
		});
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Add composite product");
		btnNewButton_2_1.setBounds(735, 467, 199, 21);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				md.getCompositeProducts().forEach(pro->{
					if((pro.getTitle()).equals(table_2.getModel().getValueAt(table_2.getSelectedRow(), 0).toString())) {
						ord.addCompositeProduct(pro);
						cos.add(pro);
						//tmeniu.setText(pro.getTitle());
					}
				});
				Object[] columns3={"title", "price"};
				DefaultTableModel model3=new DefaultTableModel();
				Object[] row3=new Object[2];
				model3.setColumnIdentifiers(columns3);
				cos.forEach(pro->{
					
					row3[0]=pro.getTitle();
					row3[1]=pro.getPrice()+"";
					
					model3.addRow(row3);
				});
				
				table_1.setModel(model3);
				total.setText(ord.getTotal()+"");
			}
		});
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblProductsForOrder = new JLabel("Products for order:");
		lblProductsForOrder.setBounds(479, 352, 169, 30);
		lblProductsForOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductsForOrder.setForeground(Color.WHITE);
		lblProductsForOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblProductsForOrder);
		
		
		cluser = new JTextField();
		cluser.setBounds(722, 584, 121, 19);
		contentPane.add(cluser);
		cluser.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Add order");
		btnNewButton_3.setBounds(853, 578, 133, 30);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cluser.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"CLIENT USER NOT WRITED!");
				}
				else {
				int idcl=Integer.parseInt(cluser.getText());
				int pr=Integer.parseInt(total.getText());
				OrderOperations.addOrder(idcl,pr);
				ord.setClientID(idcl);
				ord.setOrderID(OrderOperations.idOrder());
				ord.setData(new Date());
				CreateBill crb=new CreateBill();
				crb.generareFactura(ord.getOrderID(), ord.getClientID());
				cos.forEach(prod->{
					crb.scrie(prod.getTitle());
				});
				crb.inchidere();
				md.addOrder(ord,cos);
				Serializator s=new Serializator();
				s.write(md.getOrder());
				ord=new Order();
				cos=new ArrayList<MenuItem>();
				Object[] columns3={"title", "price"};
				DefaultTableModel model3=new DefaultTableModel();
				Object[] row3=new Object[2];
				model3.setColumnIdentifiers(columns3);
				table_1.setModel(model3);
				total.setText(ord.getTotal()+"");
				notifyy();}
				
			}
		});
		contentPane.add(btnNewButton_3);
		
		table = new JTable();
		table.setBounds(365, 379, 302, 161);
		//contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(527, 379, 302, 161);
		//contentPane.add(table_1);
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tmeniu.setText(table_2.getModel().getValueAt(table_2.getSelectedRow(), 0).toString());
			}
		});
		table_2.setBounds(10, 261, 345, 112);
		
		Object[] columns={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
		DefaultTableModel model=new DefaultTableModel();
		Object[] row=new Object[7];
		model.setColumnIdentifiers(columns);
		md.getBaseProducts().forEach(pro->{
			row[0]=pro.getTitle();
			row[1]=pro.getRating()+"";
			row[2]=pro.getCalories()+"";
			row[3]=pro.getProteins()+"";
			row[4]=pro.getFats()+"";
			row[5]=pro.getSodium()+"";
			row[6]=pro.getPrice()+"";
			model.addRow(row);
		});
		
		table.setModel(model);
		
		Object[] columns2={"title", "price"};
		DefaultTableModel model2=new DefaultTableModel();
		Object[] row2=new Object[2];
		model2.setColumnIdentifiers(columns2);
		md.getCompositeProducts().forEach(pro->{
			row2[0]=pro.getTitle();
			row2[1]=pro.getPrice()+"";
			model2.addRow(row2);
		});
		
		table_2.setModel(model2);
		
		Object[] columns3={"title",  "price"};
		DefaultTableModel model3=new DefaultTableModel();
		Object[] row3=new Object[2];
		model3.setColumnIdentifiers(columns3);
		cos.forEach(pro->{
			
			row3[0]=pro.getTitle();
			row3[2]=pro.getPrice()+"";
			
			model3.addRow(row3);
		});
		
		table_1.setModel(model3);
		total.setText(ord.getTotal()+"");
		
		JButton btnNewButton_4 = new JButton("BACK");
		btnNewButton_4.setBounds(901, 630, 85, 21);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainControl.setmain(md);
				MainControl.afisareFirst();
				dispose();
			}
		});
		contentPane.add(btnNewButton_4);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 273, 345, 249);
		contentPane.add(scrollPane_2);
		
		
		//contentPane.add(table_2);
		
		scrollPane.setViewportView(table);
		scrollPane_1.setViewportView(table_1);
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_1 = new JLabel("Total price:");
		lblNewLabel_1.setBounds(403, 578, 94, 29);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Client user:");
		lblNewLabel_1_1.setBounds(618, 582, 94, 21);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(26, 571, 85, 80);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\tema 4\\rsz_download.png"));
		contentPane.add(lblNewLabel_2);
		 em=new Employee(md);
		JButton btnNewButton_5 = new JButton(" TAKE A LOOK IN THE KITCHEN");
		btnNewButton_5.setBounds(127, 598, 228, 21);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				em.setFromClient(1);
				em.show();
			}
		});
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(178, 34, 34));
		contentPane.add(btnNewButton_5);
		JLabel timp = new JLabel("New label");
		timp.setBounds(719, 2, 157, 32);
		timp.setForeground(Color.WHITE);
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
		  
		  JLabel lblcompositeProductsComponents = new JLabel("-Composite Products components-");
		  lblcompositeProductsComponents.setBounds(421, 106, 473, 30);
		  lblcompositeProductsComponents.setHorizontalAlignment(SwingConstants.CENTER);
		  lblcompositeProductsComponents.setForeground(Color.WHITE);
		  lblcompositeProductsComponents.setFont(new Font("Tahoma", Font.BOLD, 20));
		  contentPane.add(lblcompositeProductsComponents);
		  
		  tmeniu = new JTextField();
		  tmeniu.setBounds(403, 187, 149, 19);
		  contentPane.add(tmeniu);
		  tmeniu.setColumns(10);
		  
		  JScrollPane scrollPane_3 = new JScrollPane();
		  scrollPane_3.setBounds(593, 134, 366, 170);
		  contentPane.add(scrollPane_3);
		  
		  table_3 = new JTable();
		  scrollPane_3.setViewportView(table_3);
		  
		  JButton btnNewButton = new JButton("SHOW");
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		Object[] columnsn={"title", "rating", "calories",  "proteins", "fats", "sodium", "price"};
				DefaultTableModel modeln=new DefaultTableModel();
				Object[] rown=new Object[7];
				modeln.setColumnIdentifiers(columnsn);
				
		  		md.getCompositeProducts().forEach(pro->{
					if((pro.getTitle()).equals(tmeniu.getText())) {
						pro.getProduse().forEach(bp->{
							rown[0]=bp.getTitle();
							rown[1]=bp.getRating()+"";
							rown[2]=bp.getCalories()+"";
							rown[3]=bp.getProteins()+"";
							rown[4]=bp.getFats()+"";
							rown[5]=bp.getSodium()+"";
							rown[6]=bp.getPrice()+"";
							modeln.addRow(rown);
						});
					}
				});
		  		table_3.setModel(modeln);
		  			
		  }
		  });
		  btnNewButton.setBounds(425, 216, 85, 21);
		  contentPane.add(btnNewButton);
		 
	}


	
	@Override
		public void notifyy() {
		//mai incet cu observable
			Observable obs=new Observable(em);
			obs.update();
			// putin mai rapid asa, cateodata...
			//cand sunt prea multe date in file-ul serializat are intarzieri mari
			//em.update();
			//em.show();
			
		}
}
