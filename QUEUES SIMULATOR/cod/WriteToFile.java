package business;
import java.io.FileWriter;
import java.io.IOException;

import data.Server;
import gui.Model;

public class WriteToFile {
	private  FileWriter writer;
	private Model model;
	public WriteToFile(FileWriter w, Model m){
		writer=w;
		model=m;
	}
	public void scriereTimp(int timp) {
		try {
			writer.write("Time:"+timp+"\n");
		} catch (IOException e) {System.out.println("Eroare la scriere in fisierul txt!");}
	}
	public void scriereClienti(int timp)  {
			try {
				writer.write("Waiting Clients:");
			} catch (IOException e1) {}
		model.getClienti().forEach(c->{
			if(timp<c.getSosire()) {
					try {
						writer.write("("+c.getId()+","+c.getSosire()+","+c.getTimpAsteptare()+")");
					} catch (IOException e) {System.out.println("Eroare la scriere in fisierul txt!");}
			}
		});
	}
	private boolean scris;
	public void scriereCoada(int i, Server coada,int timp)  {
		try {
			writer.write("\nQueue "+i+": ");
		} catch (IOException e1) {}
		scris=false;
		coada.getClienti().forEach(c->{
			if(c.getSosire()<=timp && timp<c.getPlecare()) {
				try {
					writer.write("("+c.getId()+","+c.getSosire()+","+(c.getPlecare()-timp)+")");
					scris=true;
				} catch (IOException e) {System.out.println("Eroare la scriere in fisierul txt!");}
			}
		});
		if(scris==false) {
			try {
				writer.write("closed");
			} catch (IOException e) {System.out.println("Eroare la scriere in fisierul txt!");}
		}
	}
	public void scriereCozi(int timp,int nr) {
		for(int i=0;i<nr;i++) {
					scriereCoada(i+1, model.getCozi2().get(i),timp);}
		try {
			writer.write("\n");
		} catch (IOException e) {System.out.println("Eroare la scriere in fisierul txt!");}
	}
}
