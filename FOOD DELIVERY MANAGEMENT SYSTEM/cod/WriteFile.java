package dataLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	private  FileWriter writer;
	public  WriteFile (String s){
		try {
			File file= new File(s);
			writer=new FileWriter(file, false);
		} catch (IOException e) {}
	}
	
	public void scriere(String s) {
		try {
			writer.write(s+"\n");
		} catch (IOException e) {System.out.println("Eroare la scriere in fisierul txt!");}
	}
	public void inchidere() {
		try {
			writer.close();
		} catch (IOException e) {}
	}
}
