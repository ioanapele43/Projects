package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mainData.MainDataForDelivery;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class FirstFrame extends JFrame {

	private JPanel contentPane;

	
	public FirstFrame(MainDataForDelivery md) {
		setTitle("Food Delivery");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\tema 4\\5-59796_food-delivery-delivery-food-icon-png-transparent-png.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 608);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Administrator");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin al=new AdminLogin(md);
				al.show();
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(153, 0, 0));
		btnNewButton.setBounds(411, 10, 233, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Employee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeLogin el=new EmployeeLogin(md);
				el.show();
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(153, 0, 0));
		btnNewButton_1.setBounds(411, 64, 233, 44);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Client");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientLogin cl= new ClientLogin(md);
				cl.show();
				dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBackground(new Color(153, 0, 0));
		btnNewButton_2.setBounds(411, 118, 233, 44);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\tema 4\\food-delivery-service-with-motorcycle-icon-vector-ilustration_24911-24690.jpg"));
		lblNewLabel.setBounds(0, 36, 626, 535);
		contentPane.add(lblNewLabel);
	}
}
