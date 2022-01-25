package gui;

import java.awt.Color;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class PanelC extends JPanel {
	private JTextField txtCoada;
	private JLabel timp;
	private JLabel textField_1;
	private JLabel a1;
	private JLabel a2;
	private JLabel a3;
	private JLabel a4;
	private JLabel a5;
	private JLabel a6;
	private JLabel a7;
	private JLabel a8;
	private JLabel a9;
	private JLabel a10;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField txtInchis;
	/**
	 * Create the panel.
	 */
	public PanelC(String s) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		
		timp = new JLabel("0");
		timp.setBounds(37, 10, 45, 13);
		add(timp);
		
		JLabel lblNewLabel = new JLabel("Time:");
		lblNewLabel.setBounds(0, 10, 45, 13);
		add(lblNewLabel);
		
		txtCoada = new JTextField();
		txtCoada.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtCoada.setBounds(10, 33, 56, 19);
		add(txtCoada);
		txtCoada.setHorizontalAlignment(SwingConstants.CENTER);
		txtCoada.setForeground(Color.WHITE);
		txtCoada.setText(s);
		txtCoada.setBackground(new Color(0, 0, 128));
		txtCoada.setEditable(false);
		txtCoada.setColumns(10);
		
		
		
		textField_1 = new JLabel("");
		textField_1.setBounds(24, 66, 30, 19);
		add(textField_1);
		textField_1.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (2).jpg"));
		textField_2 = new JTextField();
		textField_2.setBounds(10, 62, 56, 27);
		add(textField_2);
		textField_2.setBackground(new Color(255, 222, 173));
		textField_2.setColumns(10);
		a1 = new JLabel("");
		a1.setBounds(10, 95, 45, 19);
		add(a1);
		a1.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a2 = new JLabel("");
		a2.setBounds(10, 127, 45, 19);
		add(a2);
		a2.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a3 = new JLabel("");
		a3.setBounds(10, 155, 45, 19);
		add(a3);
		a3.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a4 = new JLabel("");
		a4.setBounds(10, 182, 45, 19);
		add(a4);
		a4.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a6 = new JLabel("");
		a6.setBounds(10, 241, 45, 19);
		add(a6);
		a6.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a5 = new JLabel("");
		a5.setBounds(10, 211, 45, 19);
		add(a5);
		a5.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a7 = new JLabel("");
		a7.setBounds(10, 271, 45, 19);
		add(a7);
		a7.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a8 = new JLabel("");
		a8.setBounds(10, 300, 45, 19);
		add(a8);
		a8.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a9 = new JLabel("");
		a9.setBounds(10, 329, 45, 19);
		add(a9);
		a9.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		a10 = new JLabel("");
		a10.setBounds(10, 355, 45, 19);
		add(a10);
		a10.setIcon(new ImageIcon("D:\\AN2SEM2\\TP\\Webp.net-resizeimage (3).jpg"));
		
		txtInchis = new JTextField();
		txtInchis.setHorizontalAlignment(SwingConstants.CENTER);
		txtInchis.setForeground(new Color(240, 255, 255));
		txtInchis.setBackground(new Color(255, 0, 0));
		txtInchis.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtInchis.setText("INCHIS");
		txtInchis.setBounds(10, 95, 56, 33);
		add(txtInchis);
		txtInchis.setColumns(10);
		
		a10.setVisible(false);
		a9.setVisible(false);
		a8.setVisible(false);
		a7.setVisible(false);
		a5.setVisible(false);
		a6.setVisible(false);
		a4.setVisible(false);
		a3.setVisible(false);
		a2.setVisible(false);
		a1.setVisible(false);
		txtInchis.setVisible(false);
		textField_1.setVisible(false);
	}
	
	public void secunde(int i) {
		timp.setText(i+" ");
	}
	public void adaugare() {
		
		textField_1.setVisible(true);
	}
	public void scoatere() {
		textField_1.setVisible(false);
			}
	public void inchidere() {
		txtInchis.setVisible(true);
	}
	public boolean verfInchidere() {
		if(textField_1.isVisible()) {
			return false;
		}
		else
		{
			return true;
		}
	}
	public void setareVizibilitate(boolean v1,boolean v2,boolean v3,boolean v4,boolean v5,boolean v6,boolean v7,boolean v8,boolean v9,boolean v10) {
		a1.setVisible(v1);
		a2.setVisible(v2);
		a3.setVisible(v3);
		a4.setVisible(v4);
		a5.setVisible(v5);
		a6.setVisible(v6);
		a7.setVisible(v7);
		a8.setVisible(v8);
		a9.setVisible(v9);
		a10.setVisible(v10);
	}
	public void afisareCoadaAsteptare(int nr) {
		if(nr==1) {
			setareVizibilitate(true,false,false,false,false,false,false,false,false,false);}
		if(nr==2) {
			setareVizibilitate(true,true,false,false,false,false,false,false,false,false);}
		if(nr==3) {
			setareVizibilitate(true,true,true,false,false,false,false,false,false,false);}
		if(nr==4) {
			setareVizibilitate(true,true,true,true,false,false,false,false,false,false);}
		if(nr==5) {
			setareVizibilitate(true,true,true,true,true,false,false,false,false,false);}
		if(nr==6) {
			setareVizibilitate(true,true,true,true,true,true,false,false,false,false);}
		if(nr==7) {
			setareVizibilitate(true,true,true,true,true,true,true,false,false,false);}
		if(nr==8) {
			setareVizibilitate(true,true,true,true,true,true,true,true,false,false);}
		if(nr==9) {
			setareVizibilitate(true,true,true,true,true,true,true,true,true,false);}
		if(nr>=10) {
			setareVizibilitate(true,true,true,true,true,true,true,true,true,true);}
		if(nr<1) {setareVizibilitate(false,false,false,false,false,false,false,false,false,false);}
	}

}
