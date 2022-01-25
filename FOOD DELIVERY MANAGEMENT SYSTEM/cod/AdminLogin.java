package presentationLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connectionToDatabase.VerifyLogin;
import mainData.MainControl;
import mainData.MainDataForDelivery;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField username;

	
	public AdminLogin(MainDataForDelivery md) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\tema 4\\5-59796_food-delivery-delivery-food-icon-png-transparent-png.png"));
		setTitle("Login\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBackground(new Color(255, 255, 102));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerifyLogin v=new VerifyLogin();
				int logrez=v.verificareAdmin(username.getText(), password.getText());
				if(logrez==1) {
					Administrator adm=new Administrator(md);
					adm.show();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"WRONG USERNAME OR PASSWORD! TRY AGAIN!");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(180, 358, 142, 38);
		contentPane.add(btnNewButton);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		password.setBounds(49, 254, 397, 55);
		contentPane.add(password);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(49, 230, 142, 26);
		contentPane.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		username.setColumns(10);
		username.setBounds(49, 150, 397, 55);
		contentPane.add(username);
		
		JLabel lblNewLabel = new JLabel("Administrator Login");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 28, 495, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(49, 127, 142, 26);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	FirstFrame ff=new FirstFrame(md);
			//	ff.show();
				MainControl.setmain(md);
				MainControl.afisareFirst();
				dispose();			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(210, 105, 30));
		btnNewButton_1.setBounds(10, 422, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}
