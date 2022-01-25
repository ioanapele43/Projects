package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class Raport extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;
	private JTextField t9;
	private JTextField t10;

	public Raport() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\Tema 2\\881272-200.png"));
		setType(Type.POPUP);
		setTitle("Raport ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 519);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATA ENTERED BY USERS:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 440, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblRezultateInUrma = new JLabel("RESULTS:");
		lblRezultateInUrma.setHorizontalAlignment(SwingConstants.CENTER);
		lblRezultateInUrma.setForeground(new Color(0, 0, 128));
		lblRezultateInUrma.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRezultateInUrma.setBounds(10, 301, 440, 40);
		contentPane.add(lblRezultateInUrma);
		
		JLabel lblNewLabel_1 = new JLabel("Number of Clients:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(52, 52, 158, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Number of Queues:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(52, 85, 158, 23);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Simulation Interval:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(52, 121, 158, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Minimum arrival time:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(52, 154, 158, 23);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Maximum arrival time:");
		lblNewLabel_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_1.setBounds(52, 187, 158, 23);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Minimum service time:");
		lblNewLabel_1_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_2.setBounds(52, 220, 158, 23);
		contentPane.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Maximum service time:");
		lblNewLabel_1_3_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3_3.setBounds(52, 253, 158, 23);
		contentPane.add(lblNewLabel_1_3_3);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(230, 55, 96, 19);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBounds(230, 88, 96, 19);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setColumns(10);
		t3.setBounds(230, 124, 96, 19);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setEditable(false);
		t4.setColumns(10);
		t4.setBounds(230, 157, 96, 19);
		contentPane.add(t4);
		
		t5 = new JTextField();
		t5.setEditable(false);
		t5.setColumns(10);
		t5.setBounds(230, 190, 96, 19);
		contentPane.add(t5);
		
		t6 = new JTextField();
		t6.setEditable(false);
		t6.setColumns(10);
		t6.setBounds(230, 223, 96, 19);
		contentPane.add(t6);
		
		t7 = new JTextField();
		t7.setEditable(false);
		t7.setColumns(10);
		t7.setBounds(230, 256, 96, 19);
		contentPane.add(t7);
		
		t8 = new JTextField();
		t8.setEditable(false);
		t8.setColumns(10);
		t8.setBounds(230, 354, 96, 19);
		contentPane.add(t8);
		
		JLabel lblNewLabel_1_4 = new JLabel("Average waiting time:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(10, 351, 200, 23);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Average service time:");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_1.setBounds(10, 382, 200, 23);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Peak hour:");
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4_2.setBounds(10, 415, 200, 23);
		contentPane.add(lblNewLabel_1_4_2);
		
		t9 = new JTextField();
		t9.setEditable(false);
		t9.setColumns(10);
		t9.setBounds(230, 385, 96, 19);
		contentPane.add(t9);
		
		t10 = new JTextField();
		t10.setEditable(false);
		t10.setColumns(10);
		t10.setBounds(230, 418, 96, 19);
		contentPane.add(t10);
	}
	public void adaugareDate(int i1, int i2, int i3, int i4, int i5, int i6, int i7, double i8, int i9, int i10) {
		t1.setText(i1+"");
		t2.setText(i2+"");
		t3.setText(i3+"");
		t4.setText(i4+"");
		t5.setText(i5+"");
		t6.setText(i6+"");
		t7.setText(i7+"");
		t8.setText(i8+"");
		t9.setText(i9+"");
		t10.setText(i10+"");
	}

}
