package strategy;
import java.util.ArrayList;
import java.util.Random;

import data.Server;
import data.Task;

public class Strategies {
	private boolean nepotrivire;
	int numarRandom(int min, int max) {
		int nr;
		Random r= new Random();
		nr= r.nextInt(max-min)+min;
		return nr;
	}
	public Task generareClient(int mins, int maxs, int minast, int maxast, int id) {
		Task c;
		int sosire=numarRandom(mins,maxs);
		int asteptare;
		if(minast==maxast) {
			 asteptare=minast;
		}
		else
		{
			 asteptare=numarRandom(minast, maxast);
		}
		c=new Task(id,sosire,asteptare);
		return c;
	}
	public boolean verificareAdaugare(Server co,Task c) {
		 nepotrivire =false;
		co.getClienti().forEach(m->{
			if((c.getSosire()>=m.getSosire() && c.getSosire()<m.getPlecare())|| (c.getPlecare()>m.getSosire() && c.getPlecare()<=m.getPlecare()) || (c.getSosire()<m.getSosire() && c.getPlecare()>m.getPlecare()) ) {
				nepotrivire=true;
			}
		});
		if(nepotrivire==true) {
			return false;
		}
		else {
			return true;
		}
	}
	public ArrayList<Server> adaugareInCoadaPotrivita(int nrCozi,Task c, ArrayList<Server> coada){
		boolean adaugat=false;
		for(int i=0;i<nrCozi;i++) {
			boolean verf=verificareAdaugare(coada.get(i),c);
			if(verf==true && adaugat==false) {
				coada.get(i).adaugareClienti(c);
				adaugat=true;
			}
		}
		if(adaugat==false) {
			for(int i=nrCozi;i<coada.size();i++) {
				boolean verf=verificareAdaugare(coada.get(i),c);
				if(verf==true && adaugat==false) {
					coada.get(i).adaugareClienti(c);
					adaugat=true;
				}
			}
		}
		return coada;
	}
	public boolean verificareDacaPoateFiAdaugat(Task c, ArrayList<Server> coada) {
		boolean adaugat=false;
		for(int i=0;i<coada.size();i++) {
				boolean verf=verificareAdaugare(coada.get(i),c);
				if(verf==true && adaugat==false) {
					adaugat=true;
				}
			}
		return adaugat;
		}
}
	