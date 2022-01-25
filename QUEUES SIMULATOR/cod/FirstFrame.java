package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.ExceptieStringGresit;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class FirstFrame extends JFrame {
	private Model model;
	private JPanel contentPane;
	private JTextField nbClients;
	private JTextField nbQueues;
	private JTextField simInt;
	private JTextField minAT;
	private JTextField maxAT;
	private JTextField minST;
	private JTextField maxST;
	private JButton btnStart;

	public FirstFrame(Model mod) {
		setTitle("Simulation");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\Tema 2\\881272-200.png"));
		setType(Type.POPUP);
		model=mod;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 431);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number of Clients:");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(19, 10, 186, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumberOfQueues = new JLabel("Number of Queues:");
		lblNumberOfQueues.setForeground(new Color(0, 128, 128));
		lblNumberOfQueues.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNumberOfQueues.setBounds(19, 48, 186, 36);
		contentPane.add(lblNumberOfQueues);
		
		JLabel lblSimulationInterval = new JLabel("Simulation Interval:");
		lblSimulationInterval.setForeground(new Color(0, 128, 128));
		lblSimulationInterval.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSimulationInterval.setBounds(19, 81, 186, 36);
		contentPane.add(lblSimulationInterval);
		
		simInt = new JTextField();
		simInt.setColumns(10);
		simInt.setBackground(new Color(175, 238, 238));
		simInt.setBounds(211, 85, 127, 32);
		contentPane.add(simInt);
		
		nbQueues = new JTextField();
		nbQueues.setColumns(10);
		nbQueues.setBackground(new Color(175, 238, 238));
		nbQueues.setBounds(211, 48, 127, 32);
		contentPane.add(nbQueues);
		
		nbClients = new JTextField();
		nbClients.setColumns(10);
		nbClients.setBackground(new Color(175, 238, 238));
		nbClients.setBounds(211, 10, 127, 32);
		contentPane.add(nbClients);
		
		JLabel lblNewLabel_1 = new JLabel("* 0< Number of Queues <=40");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(348, 58, 187, 23);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMinimumArrivalTime = new JLabel("Minimum arrival time:");
		lblMinimumArrivalTime.setForeground(new Color(0, 128, 128));
		lblMinimumArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMinimumArrivalTime.setBounds(10, 127, 233, 36);
		contentPane.add(lblMinimumArrivalTime);
		
		JLabel lblMaximumArrivalTime = new JLabel("Maximum arrival time:");
		lblMaximumArrivalTime.setForeground(new Color(0, 128, 128));
		lblMaximumArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaximumArrivalTime.setBounds(10, 161, 233, 36);
		contentPane.add(lblMaximumArrivalTime);
		
		JLabel lblMinimumServiceTime = new JLabel("Minimum service time:");
		lblMinimumServiceTime.setForeground(new Color(0, 128, 128));
		lblMinimumServiceTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMinimumServiceTime.setBounds(10, 199, 233, 36);
		contentPane.add(lblMinimumServiceTime);
		
		JLabel lblMaximumServiceTime = new JLabel("Maximum service time:");
		lblMaximumServiceTime.setForeground(new Color(0, 128, 128));
		lblMaximumServiceTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaximumServiceTime.setBounds(10, 236, 233, 36);
		contentPane.add(lblMaximumServiceTime);
		
		minAT = new JTextField();
		minAT.setColumns(10);
		minAT.setBackground(new Color(175, 238, 238));
		minAT.setBounds(221, 128, 127, 32);
		contentPane.add(minAT);
		
		maxAT = new JTextField();
		maxAT.setColumns(10);
		maxAT.setBackground(new Color(175, 238, 238));
		maxAT.setBounds(221, 165, 127, 32);
		contentPane.add(maxAT);
		
		minST = new JTextField();
		minST.setColumns(10);
		minST.setBackground(new Color(175, 238, 238));
		minST.setBounds(221, 203, 127, 32);
		contentPane.add(minST);
		
		maxST = new JTextField();
		maxST.setColumns(10);
		maxST.setBackground(new Color(175, 238, 238));
		maxST.setBounds(221, 240, 127, 32);
		contentPane.add(maxST);
		
		 btnStart = new JButton("START");
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStart.setBackground(Color.GREEN);
		btnStart.setBounds(130, 310, 135, 36);
		contentPane.add(btnStart);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Tema 2\\881272-200.png"));
		lblNewLabel_2.setBounds(300, 258, 214, 136);
		contentPane.add(lblNewLabel_2);
	}
	// Listeneri la butoane
	void addBtnStartListener(ActionListener mal) {
		btnStart.addActionListener(mal);
	}
	
	
	// Gettere de text
	int numberOfClients() throws ExceptieStringGresit {
		String s=nbClients.getText();
		String spat="[0-9]+";
		Pattern pat = Pattern.compile(spat);
		int number=-1;
	    Matcher m = pat.matcher(s);
	    if(pat.matches(spat,s)){	
			if (m.find()) {
			    number = Integer.parseInt(s);}	 }
	    else {
			   throw new ExceptieStringGresit("Numar de clienti gresit!");}
		return number;
	}
	int numberOfQueues() throws ExceptieStringGresit {
		String s=nbQueues.getText();
		String spat="[0-9]+";
		Pattern pat = Pattern.compile(spat);
		int number=-1;
	    Matcher m = pat.matcher(s);
	    if(pat.matches(spat,s)){	
			if (m.find()) {
			    number = Integer.parseInt(s);}	 }
	    else {
			   throw new ExceptieStringGresit("Numar de cozi gresit!");}
		if(number>40) {
			 throw new ExceptieStringGresit("Numar de cozi gresit!");
		}
		return number;
	}
	int simulationInterval() throws ExceptieStringGresit {
		String s=simInt.getText();
		String spat="[0-9]+";
		Pattern pat = Pattern.compile(spat);
		int number=-1;
	    Matcher m = pat.matcher(s);
	    if(pat.matches(spat,s)){	
			if (m.find()) {
			    number = Integer.parseInt(s);}	}
	    else {
			   throw new ExceptieStringGresit("Interval de simulare gresit!");}
		return number;
	}
	int minArrivalTime() throws ExceptieStringGresit {
		String s=minAT.getText();
		String spat="[0-9]+";
		Pattern pat = Pattern.compile(spat);
		int number=-1;
	    Matcher m = pat.matcher(s);
	    if(pat.matches(spat,s)){	
			if (m.find()) {
			    number = Integer.parseInt(s);
			}	
		 }
	    else {
			   throw new ExceptieStringGresit("Timp de sosire minim gresit!");
		}
		return number;
	}
	int maxArrivalTime() throws ExceptieStringGresit {
		String s=maxAT.getText();
		String spat="[0-9]+";
		Pattern pat = Pattern.compile(spat);
		int number=-1;
	    Matcher m = pat.matcher(s);
	    if(pat.matches(spat,s)){	
			if (m.find()) {
			    number = Integer.parseInt(s);}	 }
	    else {
			   throw new ExceptieStringGresit("Timp de sosire maxim gresit!");
		}
		return number;
	}
	int minServiceTime() throws ExceptieStringGresit {
		String s=minST.getText();
		String spat="[0-9]+";
		Pattern pat = Pattern.compile(spat);
		int number=-1;
	    Matcher m = pat.matcher(s);
	    if(pat.matches(spat,s)){	
			if (m.find()) {
			    number = Integer.parseInt(s);}	}
	    else {
			   throw new ExceptieStringGresit("Timp de lucru minim gresit!");}
	    return number;
	}
	int maxServiceTime() throws ExceptieStringGresit {
		String s=maxST.getText();
		String spat="[0-9]+";
		Pattern pat = Pattern.compile(spat);
		int number=-1;
	    Matcher m = pat.matcher(s);
	    if(pat.matches(spat,s)){	
			if (m.find()) {
			    number = Integer.parseInt(s);}	 }
	    else {
			   throw new ExceptieStringGresit("Timp de lucru maxim gresit!");}
		return number;
	}
	public void afisareRaport() {
		Raport con=new Raport();
		int i1, i2, i3, i4, i5, i6, i7, i10;
		i1=Integer.parseInt(nbClients.getText());
		i2=Integer.parseInt(nbQueues.getText());
		i3=Integer.parseInt(simInt.getText());
		i4=Integer.parseInt(minAT.getText());
		i5=Integer.parseInt(maxAT.getText());
		i6=Integer.parseInt(minST.getText());
		i7=Integer.parseInt(maxST.getText());
		 double i8=model.averageWaitingTime();//average waiting Time
		 int i9=model.averageServiceTime();// average service Time
		i10=model.peakHour();//peakHour
		con.adaugareDate(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10);
		con.show();
	}
}
