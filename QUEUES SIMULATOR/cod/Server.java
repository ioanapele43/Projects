package data;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Server {
	private ArrayList<Task> clienti;
	private int nrClienti;
	private  FileWriter writer;
	private boolean gol;
	public Server(String s) {
		clienti=new ArrayList<Task>();
		nrClienti=0;
		try {
			writer = new FileWriter(s, false);
		} catch (IOException e) {System.out.println("Eroare la scriere in fisierul txt!");}
		gol=true;
	}
	public void adaugareClienti(Task c) {
		gol=false;
		clienti.add(c);
		nrClienti++;
	}
	public boolean isGol() {
		return gol;
	}
	public ArrayList<Task> getClienti() {
		return clienti;
	}
	public int getNrClienti() {
		return nrClienti;
	}
	public void setNrClienti(int nrClienti) {
		this.nrClienti = nrClienti;
	}
	public void scriere(String s) throws IOException{
		 writer.write(s);
	}
	public void closeTextFile() throws IOException {
		 writer.close();
	}
	double nr;
	public double timpLucru() {
		nr=0;
		clienti.forEach(c->{
			nr+=c.getTimpAsteptare();
		});
		return nr;
	}
}
