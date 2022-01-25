package gui;
import java.util.ArrayList;

import business.ExceptieStringGresit;
import data.Server;
import data.Task;
import strategy.Strategies;

public class Model {
	private Strategies o;
	private int totalTimpAsteptare;
	private ArrayList<Double> cozi;
	private int nr;
	private int nr2;
	private int total;
	private int maxClienti;
	private int ora;
	private int i;
	private ArrayList<Server> cozi2;
	private ArrayList<Task> clienti;
   //variabile necesare
   private int timpLimita;
   private int nrCozi;
   private int nrClienti;
   private int minArTime;
   private int maxArTime;
   private int minSerTime;
   private int maxSerTime;
   public Model(){
	   cozi=new ArrayList();
	   cozi2=new ArrayList<Server>();
	   o=new Strategies();
	   totalTimpAsteptare=0;
	   nr=0;
	   total=0;
	   maxClienti=0;
	   ora=0;
	   clienti=new ArrayList<Task>();
   }
   public void populareCozi() throws ExceptieStringGresit {
	   Task c;
	   for(int i=1;i<=40;i++) {
		   Server co=new Server("logCoada"+i+".txt");
		   cozi2.add(co);}
	   if(maxArTime+maxSerTime>timpLimita) {
		   throw new ExceptieStringGresit("Datele introduse fac ca simularea sa dureze mai mult decat timpul limita introdus!");}
	   int nr2=(maxArTime-minArTime)*40/minSerTime;
	   if(nr2<nrClienti) {
		   throw new ExceptieStringGresit("Timp de servire minim prea mare!"); }
	   int nr=(maxArTime-minArTime)*40/maxSerTime;
	  while(nr<nrClienti && maxSerTime>minSerTime) {
		   maxSerTime--;
		   nr=nr=(maxArTime-minArTime)*40/maxSerTime;}
	   for(int i=1;i<=nrClienti;i++) {
		   boolean verfClient=false;
		   c=new Task();
		   while(verfClient==false) {
			    c=o.generareClient(minArTime, maxArTime, minSerTime, maxSerTime, i);
			    verfClient=o.verificareDacaPoateFiAdaugat(c,cozi2);}
		  clienti.add(c);
		   totalTimpAsteptare+=c.getTimpAsteptare();
		   cozi2=o.adaugareInCoadaPotrivita(nrCozi, c,cozi2);}
	   cozi2.forEach(co->{ cozi.add(co.timpLucru());});
   }
public double averageWaitingTime() {
	double medie=0;
	medie=totalTimpAsteptare*1.0/nrClienti;
	return medie;
}
private int medie;
public int averageServiceTime() {
	medie=0;
	nr2=0;
	cozi.forEach(c->{
		if(c!=0) {
			medie+=c;
			nr++;
		}
	});
	medie=medie/nr;
	return medie;
}
public int peakHour() {
	ora=0;
	
	for(i=0;i<=timpLimita;i++) {
		nr=0;
		cozi2.forEach(coz->{
			coz.getClienti().forEach(c->{
				if(c.getSosire()<=i && i<=c.getPlecare()) {
					nr++;
				}
			});
		});
		if(maxClienti<nr) {
			ora=i;
			maxClienti=nr;	
		}
	}
	return ora;
}
public ArrayList<Server> getCozi2() {
	return cozi2;
}
public int getTotalTimpAsteptare() {
	return totalTimpAsteptare;
}
public void setTotalTimpAsteptare(int totalTimpAsteptare) {
	this.totalTimpAsteptare = totalTimpAsteptare;
}
public ArrayList<Double> getCozi() {
	return cozi;
}
public void setCozi(ArrayList<Double> cozi) {
	this.cozi = cozi;
}

public int getOra() {
	return ora;
}
public void setOra(int ora) {
	this.ora = ora;
}
public int getTimpLimita() {
	return timpLimita;
}

public void setTimpLimita(int timpLimita) {
	this.timpLimita = timpLimita;
}
public int getNrCozi() {
	return nrCozi;
}
public void setNrCozi(int nrCozi) {
	this.nrCozi = nrCozi;
}

public int getNrClienti() {
	return nrClienti;
}

public void setNrClienti(int nrClienti) {
	this.nrClienti = nrClienti;
}

public int getMinArTime() {
	return minArTime;
}

public void setMinArTime(int minArTime) {
	this.minArTime = minArTime;
}

public int getMaxArTime() {
	return maxArTime;
}

public void setMaxArTime(int maxArTime) {
	this.maxArTime = maxArTime;
}

public int getMinSerTime() {
	return minSerTime;
}

public void setMinSerTime(int minSerTime) {
	this.minSerTime = minSerTime;
}

public int getMaxSerTime() {
	return maxSerTime;
}

public void setMaxSerTime(int maxSerTime) {
	this.maxSerTime = maxSerTime;
}

public ArrayList<Task> getClienti() {
	return clienti;
}
}
