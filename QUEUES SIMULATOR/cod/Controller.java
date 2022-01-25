package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import business.ExceptieStringGresit;
import business.ThreadCoada;
import business.ThreadPrincipal;

public class Controller {
	  private Model model;
	  private Frame frame;
	  private FirstFrame frame2;
	  private ArrayList<ThreadCoada> tc ;
	  private ThreadPrincipal tP;
	  
	   public Controller( Model m, Frame f,FirstFrame f2){
		   model=m;
		   frame=f;
		   frame2=f2;
		   tP=new ThreadPrincipal();
		   tc=new ArrayList<ThreadCoada>();
		   frame2.addBtnStartListener(new BtnStartListener());
	   }
	   class BtnStartListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				try {model.setNrClienti(frame2.numberOfClients());
					try {model.setNrCozi(frame2.numberOfQueues());
						try {model.setTimpLimita(frame2.simulationInterval());
							try {model.setMinArTime(frame2.minArrivalTime());
								try {model.setMaxArTime(frame2.maxArrivalTime());
									try {model.setMinSerTime(frame2.minServiceTime());
										try {model.setMaxSerTime(frame2.maxServiceTime());
											model.populareCozi();//initializare cozi
											frame.setVisible(true);
											frame2.setVisible(false);
											int nr=0;
												for(int i=0;i<40;i++) {
													ThreadCoada t=new ThreadCoada( model.getCozi2().get(i),model.getTimpLimita(),frame.getPaneluri().get(i));
													tc.add(t);
													if(model.getCozi2().get(i).getNrClienti()==0) {
														frame.removePanel(i);}
													else {nr++;}}
												frame.resize(nr);
										       tP=new ThreadPrincipal(model.getTimpLimita(),frame2,frame,tc,model,nr);
											   tP.start();
										} catch (ExceptieStringGresit e1) {System.out.println(e1);}
									} catch (ExceptieStringGresit e1) {System.out.println(e1);}
								} catch (ExceptieStringGresit e1) {	System.out.println(e1);}	
							} catch (ExceptieStringGresit e1) {System.out.println(e1);}
						} catch (ExceptieStringGresit e1) {System.out.println(e1);}
						} catch (ExceptieStringGresit e1) {System.out.println(e1);}
					} catch (ExceptieStringGresit e1) {System.out.println(e1);}}
	}
	   }

