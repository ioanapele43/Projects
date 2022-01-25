package business;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import gui.FirstFrame;
import gui.Frame;
import gui.Model;

public class ThreadPrincipal implements Runnable {
   private Thread t;
 // private String threadName;
   private long limitaTimp;
   private FirstFrame view;
   private Frame view2;
  private int timpCurent;
  	private Model model;
  	private  FileWriter writer;
  	private WriteToFile w;
  	private int nr;
   
   private ArrayList<ThreadCoada> tc ;
   public ThreadPrincipal(){
	   limitaTimp=0;
	   model=new Model();
	   timpCurent=0;
	   view= new FirstFrame(model);
	   view2=new Frame(model);
	   tc=new ArrayList<ThreadCoada>();
	   try {
			writer = new FileWriter("Simulation.txt", false);
		} catch (IOException e) {}
	   w=new WriteToFile(writer,model);
   }
   public ThreadPrincipal(  int l,FirstFrame v, Frame v2,ArrayList<ThreadCoada> t, Model m,int i) {
      limitaTimp=l;
      view=v;
      view2=v2;
      model=m;
      tc=t;
       try {
			writer = new FileWriter("Simulation.txt", false);
		} catch (IOException e) {}
       w=new WriteToFile(writer,model);
       nr=i;
   }
   
   public void run() {
    try {
         timpCurent=0;
         for(int i=0;i<nr;i++) {
				tc.get(i).start();
			}
        w.scriereTimp(timpCurent);
        w.scriereClienti(timpCurent);
        w.scriereCozi(timpCurent,nr);
         while(timpCurent<(limitaTimp +2)) {
        	 timpCurent++;
        	 view2.setTimpTP(timpCurent+"");
        	if(timpCurent<=limitaTimp) {
        	 w.scriereTimp(timpCurent);
             w.scriereClienti(timpCurent);
             w.scriereCozi(timpCurent,nr);
        	}
        	 t.sleep(1000);}	
	} catch (InterruptedException e) { }
	    try {
			writer.close();
		} catch (IOException e) {}
	      stop2();
   }
   
   public void start () {
      if (t == null) {
         t = new Thread (this);
         t.start ();
      }
   }

public int getTimpCurent() {
	return timpCurent;
}
public void stop1() {
	for(int i=0;i<nr;i++) {
		tc.get(i).stopt();
	}
	t.stop();
}
   public void stop2() {
	   for(int i=0;i<nr;i++) {
			tc.get(i).stopt();
		}
	   view2.setVisible(false);
	   view.afisareRaport();
	      t.stop();
   }
   
}

