package business;

import java.io.IOException;

import javax.swing.JOptionPane;

import data.Server;
import data.Task;
import gui.PanelC;

public class ThreadCoada implements Runnable {
   private Thread t;
   private long limitaTimp;
   private PanelC frame;
   private Server coada;
   private int timpCurent;
  
   public ThreadCoada( Server c, long l,PanelC fr) {
      coada=c;
      limitaTimp=l;
       frame=fr;
   }
   
   public void run() {
	   frame.setVisible(true);
         timpCurent=0;
         while(timpCurent<limitaTimp) {
        	 timpCurent++;
        	 frame.secunde(timpCurent);
        	 frame.afisareCoadaAsteptare(coada.getNrClienti());
        	 coada.getClienti().forEach(m-> {
        		 if(m.getSosire()==timpCurent) {
        		 int nr=coada.getNrClienti()-1;
        		 coada.setNrClienti(nr);
        		 frame.afisareCoadaAsteptare(nr);
        		 try {
					coada.scriere(m.getNume()+ " a ajuns la ora "+ m.getSosire()+" si a asteptat "+m.getTimpAsteptare()+" secunde si a plecat la "+m.getPlecare()+"\n");
				} catch (IOException e) {JOptionPane.showMessageDialog(null,"NU S-A PUTUT SCRIE IN FISIER!");}
        		 frame.adaugare(); }
        		 if(m.getPlecare()==timpCurent) {
	        		 frame.scoatere();}
        	 });
        	 if(coada.getNrClienti()==0 && frame.verfInchidere()==true) { frame.inchidere();}
        	 try {t.sleep(1000);} catch (InterruptedException e) {}
        	}
    try {
		coada.closeTextFile();
	} catch (IOException e) {JOptionPane.showMessageDialog(null,"NU S-A PUTUT SCRIE IN FISIER!");}
      t.stop(); 
      }
   
   public void start () {
      if (t == null) {
         t = new Thread (this);
         t.start ();
      }
   }
   public void stopt() {
	   t.stop();
   }
}
