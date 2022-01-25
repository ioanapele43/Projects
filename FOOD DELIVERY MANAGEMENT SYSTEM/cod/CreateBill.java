package connectionToDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dataLayer.WriteFile;

public class CreateBill {
	WriteFile wf;
	private void scriereDateClient(int i) {
		try {
			
			Connection con=ConnectionFactory.getConnection();
			String sql="SELECT * FROM clienti where idClienti="+i+";";
			Statement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			if(rs.next()) {
				wf.scriere("Client id "+rs.getString("idclienti"));
				wf.scriere("Client username "+rs.getString("username"));
				wf.scriere("Client name  "+rs.getString("nume")+" "+rs.getString("prenume"));
				wf.scriere("Client address "+rs.getString("adresa"));
				wf.scriere("Client phone "+rs.getString("telefon"));
			}
			ConnectionFactory.close(rs);
			ConnectionFactory.closes(pst);
			ConnectionFactory.close(con);
		}catch(Exception e2) {System.out.print(e2);}
		
	}
	private void scriereDateComanda(int i) {
		try {
			
			Connection con=ConnectionFactory.getConnection();
			String sql="SELECT *  FROM orders where idorders="+i+";";
			Statement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery(sql);
			if(rs.next()) {
				wf.scriere("Order id "+rs.getString("idorders"));
				wf.scriere("Order date "+rs.getString("dataComandare"));
				wf.scriere("Order price "+rs.getString("suma"));
				wf.scriere("Components: ");
			}
				
			ConnectionFactory.close(rs);
			ConnectionFactory.closes(pst);
			ConnectionFactory.close(con);
		}catch(Exception e2) {System.out.print(e2);}
		
	}
	public void generareFactura(int o, int c) {
		wf=new WriteFile("bon"+o+".txt");
		scriereDateClient(c);
		scriereDateComanda(o);
	}
	public void scrie(String s) {
		wf.scriere(s);
	}
	public void inchidere() {
		wf.inchidere();
	}
}
