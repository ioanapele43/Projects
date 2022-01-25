package connectionToDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AddClient {
	public void adaugareContClient(String user, String pass, String nume, String prenume, String adresa, String telefon) {
		try {
			Connection con=ConnectionFactory.getConnection();
			String sqlv="select * from clienti where username=\""+user+"\";";
			String sql=" insert into utilizatori(username, parola,tip) values (\""+user+"\",\""+pass+"\",\"client\");";
			String sql2=" insert into clienti(username,nume,prenume,adresa,telefon) values (\""+user+"\",\""+nume+"\",\" "+prenume+"\",\""+adresa+"\",\""+telefon+"\");";
			Statement pst=con.prepareStatement(sqlv);
			ResultSet rsv=pst.executeQuery(sqlv);
			if(rsv.next()) {
				JOptionPane.showMessageDialog(null,"exista deja id-ul!");
			}
			else {
				boolean rs;
				 pst=con.prepareStatement(sql);
				 rs=pst.execute(sql);
				 pst=con.prepareStatement(sql2);
				 rs=pst.execute(sql2);
			}
			
		//	ConnectionFactory.close(rs);
			ConnectionFactory.closes(pst);
			ConnectionFactory.close(con);
			JOptionPane.showMessageDialog(null,"SUCCESFULLY!");
			}catch(Exception e2) {System.out.print(e2);}
		
	}
}
