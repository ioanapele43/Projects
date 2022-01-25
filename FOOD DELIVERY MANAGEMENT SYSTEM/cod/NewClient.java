package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectionToDatabase.AddClient;
import mainData.MainDataForDelivery;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Toolkit;

public class NewClient extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField nume;
	private JTextField prenume;
	private JTextField adresa;
	private JTextField telefon;

	public NewClient(MainDataForDelivery md) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\tema 4\\5-59796_food-delivery-delivery-food-icon-png-transparent-png.png"));
		setBackground(new Color(178, 34, 34));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(178, 34, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setBounds(61, 51, 147, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(253, 51, 147, 26);
		contentPane.add(password);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(62, 23, 109, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPassword.setBounds(254, 23, 109, 26);
		contentPane.add(lblPassword);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setForeground(Color.WHITE);
		lblNume.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNume.setBounds(62, 91, 109, 26);
		contentPane.add(lblNume);
		
		nume = new JTextField();
		nume.setColumns(10);
		nume.setBounds(61, 119, 147, 26);
		contentPane.add(nume);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setForeground(Color.WHITE);
		lblPrenume.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPrenume.setBounds(62, 156, 109, 26);
		contentPane.add(lblPrenume);
		
		prenume = new JTextField();
		prenume.setColumns(10);
		prenume.setBounds(61, 184, 147, 26);
		contentPane.add(prenume);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setForeground(Color.WHITE);
		lblAdresa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAdresa.setBounds(62, 220, 99, 26);
		contentPane.add(lblAdresa);
		
		adresa = new JTextField();
		adresa.setColumns(10);
		adresa.setBounds(61, 248, 339, 26);
		contentPane.add(adresa);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTelefon.setBounds(62, 289, 109, 26);
		contentPane.add(lblTelefon);
		
		telefon = new JTextField();
		telefon.setColumns(10);
		telefon.setBounds(61, 317, 147, 26);
		contentPane.add(telefon);
		
		JButton btnNewButton = new JButton("Add Client");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().equals("") || password.getText().equals("") || nume.getText().equals("") || prenume.getText().equals("") || adresa.getText().equals("") || telefon.getText().equals("") )
				{
					JOptionPane.showMessageDialog(null,"DATE INCORECTE!");
				}
				else {
					AddClient adcl=new AddClient();
					adcl.adaugareContClient(username.getText(), password.getText(), nume.getText(), prenume.getText(), adresa.getText(), telefon.getText());
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setBounds(205, 390, 158, 33);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FirstFrame ff=new FirstFrame(md);
				ff.show();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setBounds(10, 422, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
