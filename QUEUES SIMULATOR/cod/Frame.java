package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class Frame extends JFrame {
	private Model model;
	
	private JPanel contentPane;
	private PanelC panel1;
	private PanelC panel2;
	private PanelC panel3;
	private PanelC panel4;
	private PanelC panel5;
	private PanelC panel6;
	private PanelC panel7;
	private PanelC panel8;
	private PanelC panel9;
	private PanelC panel10;
	private PanelC panel11;
	private PanelC panel12;
	private PanelC panel13;
	private PanelC panel14;
	private PanelC panel15;
	private PanelC panel16;
	private PanelC panel17;
	private PanelC panel18;
	private PanelC panel19;
	private PanelC panel20;
	private PanelC panel21;
	private PanelC panel22;
	private PanelC panel23;
	private PanelC panel24;
	private PanelC panel25;
	private PanelC panel26;
	private PanelC panel27;
	private PanelC panel28;
	private PanelC panel29;
	private PanelC panel30;
	private PanelC panel31;
	private PanelC panel32;
	private PanelC panel33;
	private PanelC panel34;
	private PanelC panel35;
	private PanelC panel36;
	private PanelC panel37;
	private PanelC panel38;
	private PanelC panel39;
	private PanelC panel40;
	private JLabel timpTP;
	private ArrayList<PanelC> paneluri;
	
	public Frame(Model mod) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AN2SEM2\\TP\\Tema 2\\881272-200.png"));
		setType(Type.POPUP);
		setTitle("Simulation");
		model=mod;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(0, 0, 1525, 859);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		paneluri= new ArrayList<PanelC>();
		 panel1=new PanelC("SERVER 1");
		panel1.setBounds(10, 36, 70, 384);
		contentPane.add(panel1);
		 panel2 = new PanelC("SERVER 2");
		panel2.setLayout(null);
		panel2.setBounds(84, 36, 69, 384);
		 panel3 = new PanelC("SERVER 3");
		panel3.setLayout(null);
		panel3.setBounds(158, 36, 69, 384);
		 panel4 = new PanelC("SERVER 4");
		panel4.setLayout(null);
		panel4.setBounds(230, 36, 69, 384); panel5 = new PanelC("SERVER 5");
		panel5.setLayout(null);
		panel5.setBounds(303, 36, 69, 384);
		panel6 = new PanelC("SERVER 6");
		panel6.setLayout(null);
		panel6.setBounds(377, 36, 69, 384);
		 panel7 = new PanelC("SERVER 7");
		panel7.setLayout(null);
		panel7.setBounds(450, 36, 69, 384);
		 panel8 = new PanelC("SERVER 8");
		panel8.setLayout(null);
		panel8.setBounds(525, 36, 69, 384);
		 panel9 = new PanelC("SERVER 9");
		panel9.setLayout(null);
		panel9.setBounds(600, 36, 69, 384);
		 panel10 = new PanelC("SERVER 10");
		panel10.setLayout(null);
		panel10.setBounds(675, 36, 70, 384);
		panel20 = new PanelC("SERVER 20");
		panel20.setLayout(null);
		panel20.setBounds(1420, 36, 70, 384);
		panel11 = new PanelC("SERVER 11");
		panel11.setLayout(null);
		panel11.setBounds(755, 36, 70, 384);
		panel12 = new PanelC("SERVER 12");
		panel12.setLayout(null);
		panel12.setBounds(829, 36, 69, 384);
		panel13 = new PanelC("SERVER 13");
		panel13.setLayout(null);
		panel13.setBounds(903, 36, 69, 384);
		panel14 = new PanelC("SERVER 14");
		panel14.setLayout(null);
		panel14.setBounds(975, 36, 69, 384);
		panel15 = new PanelC("SERVER 15");
		panel15.setLayout(null);
		panel15.setBounds(1048, 36, 69, 384);
		panel16 = new PanelC("SERVER 16");
		panel16.setLayout(null);
		panel16.setBounds(1122, 36, 69, 384);
		panel17 = new PanelC("SERVER 17");
		panel17.setLayout(null);
		panel17.setBounds(1195, 36, 69, 384);
		panel18 = new PanelC("SERVER 18");
		panel18.setLayout(null);
		panel18.setBounds(1270, 36, 69, 384);
		panel19 = new PanelC("SERVER 19");
		panel19.setLayout(null);
		panel19.setBounds(1345, 36, 69, 384);
		JLabel lblNewLabel_2 = new JLabel("Time in principal Thread:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(401, 0, 233, 26);
		contentPane.add(lblNewLabel_2);
		 timpTP = new JLabel("0");
		timpTP.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timpTP.setBounds(644, 0, 40, 24);
		contentPane.add(timpTP);
		 panel21 = new PanelC("SERVER 21");
		panel21.setLayout(null);
		panel21.setBounds(10, 433, 70, 384);
		 panel22 = new PanelC("SERVER 22");
		panel22.setLayout(null);
		panel22.setBounds(84, 433, 69, 384);
		 panel23 = new PanelC("SERVER 23");
		panel23.setLayout(null);
		panel23.setBounds(158, 433, 69, 384);
		 panel24 = new PanelC("SERVER 24");
		panel24.setLayout(null);
		panel24.setBounds(230, 433, 69, 384);
		 panel25 = new PanelC("SERVER 25");
		panel25.setLayout(null);
		panel25.setBounds(303, 433, 69, 384);
		 panel26 = new PanelC("SERVER 26");
		panel26.setLayout(null);
		panel26.setBounds(377, 433, 69, 384);
		 panel27 = new PanelC("SERVER 27");
		panel27.setLayout(null);
		panel27.setBounds(450, 433, 69, 384);
		 panel28 = new PanelC("SERVER 28");
		panel28.setLayout(null);
		panel28.setBounds(525, 433, 69, 384);
		 panel29 = new PanelC("SERVER 29");
		panel29.setLayout(null);
		panel29.setBounds(600, 433, 69, 384);
		 panel30 = new PanelC("SERVER 30");
		panel30.setLayout(null);
		panel30.setBounds(675, 433, 70, 384);
		 panel31 = new PanelC("SERVER 31");
		panel31.setLayout(null);
		panel31.setBounds(755, 433, 70, 384);
		 panel32 = new PanelC("SERVER 32");
		panel32.setLayout(null);
		panel32.setBounds(829, 433, 69, 384);
		 panel33 = new PanelC("SERVER 33");
		panel33.setLayout(null);
		panel33.setBounds(903, 433, 69, 384);
		 panel34 = new PanelC("SERVER 34");
		panel34.setLayout(null);
		panel34.setBounds(975, 433, 69, 384);
		 panel35 = new PanelC("SERVER 35");
		panel35.setLayout(null);
		panel35.setBounds(1048, 433, 69, 384);
		 panel36 = new PanelC("SERVER 36");
		panel36.setLayout(null);
		panel36.setBounds(1122, 433, 69, 384);
		 panel37 = new PanelC("SERVER 37");
		panel37.setLayout(null);
		panel37.setBounds(1195, 433, 69, 384);
		 panel38 = new PanelC("SERVER 38");
		panel38.setLayout(null);
		panel38.setBounds(1270, 433, 69, 384);
		 panel39 = new PanelC("SERVER 39");
		panel39.setLayout(null);
		panel39.setBounds(1345, 433, 69, 384);
		 panel40 = new PanelC("SERVER 40");
		panel40.setLayout(null);
		panel40.setBounds(1420, 433, 70, 384);
		paneluri.add(panel1);
		paneluri.add(panel2);
		paneluri.add(panel3);
		paneluri.add(panel4);
		paneluri.add(panel5);
		paneluri.add(panel6);
		paneluri.add(panel7);
		paneluri.add(panel8);
		paneluri.add(panel9);
		paneluri.add(panel10);
		paneluri.add(panel11);
		paneluri.add(panel12);
		paneluri.add(panel13);
		paneluri.add(panel14);
		paneluri.add(panel15);
		paneluri.add(panel16);
		paneluri.add(panel17);
		paneluri.add(panel18);
		paneluri.add(panel19);
		paneluri.add(panel20);
		paneluri.add(panel21);
		paneluri.add(panel22);
		paneluri.add(panel23);
		paneluri.add(panel24);
		paneluri.add(panel25);
		paneluri.add(panel26);
		paneluri.add(panel27);
		paneluri.add(panel28);
		paneluri.add(panel29);
		paneluri.add(panel30);
		paneluri.add(panel31);
		paneluri.add(panel32);
		paneluri.add(panel33);
		paneluri.add(panel34);
		paneluri.add(panel35);
		paneluri.add(panel36);
		paneluri.add(panel37);
		paneluri.add(panel38);
		paneluri.add(panel39);
		paneluri.add(panel40);
		for(int i=0;i<40;i++) {
			contentPane.add(paneluri.get(i));}
	}
	public void removePanel(int i) {
		contentPane.remove(paneluri.get(i));
	}
	public void resize(int i) {
		if(i<=10) {
			setBounds(0, 0, 800, 450);
		}
		if(i>10 && i<=20) {
			setBounds(0, 0, 1525, 450);
		}
		if(i>20 && i<=40) {
			setBounds(0, 0, 1525, 859);
		}
	}

	public ArrayList<PanelC> getPaneluri() {
		return paneluri;
	}
	public void setTimpTP(String s) {
		this.timpTP.setText(s);;
	}
	
}
