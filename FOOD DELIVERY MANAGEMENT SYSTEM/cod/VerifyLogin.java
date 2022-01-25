package connectionToDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VerifyLogin {
	
	public int verificareAdmin(String s1, String s2) {
		int rez=0;
		try {
		Connection con=ConnectionFactory.getConnection();
		String sql="Select * from utilizatori where username=\""+s1+"\" and parola=\""+s2+"\" and tip=\"administrator\"";
		//String sql="SHOW COLUMNS FROM "+tabel+";";
		Statement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		if(rs.next()) {
			rez=1;
		}
		ConnectionFactory.close(rs);
		ConnectionFactory.closes(pst);
		ConnectionFactory.close(con);
		}catch(Exception e2) {System.out.print(e2);}
		return rez;
	}
	public int verificareAngajat(String s1, String s2) {
		int rez=0;
		try {
		Connection con=ConnectionFactory.getConnection();
		String sql="Select * from utilizatori where username=\""+s1+"\" and parola=\""+s2+"\" and tip=\"angajat\"";
		//String sql="SHOW COLUMNS FROM "+tabel+";";
		Statement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		if(rs.next()) {
			rez=1;
		}
		ConnectionFactory.close(rs);
		ConnectionFactory.closes(pst);
		ConnectionFactory.close(con);
		}catch(Exception e2) {System.out.print(e2);}
		return rez;
	}
	public int verificareClient(String s1, String s2) {
		int rez=0;
		try {
		Connection con=ConnectionFactory.getConnection();
		String sql="Select * from utilizatori where username=\""+s1+"\" and parola=\""+s2+"\" and tip=\"client\"";
		//String sql="SHOW COLUMNS FROM "+tabel+";";
		Statement pst=con.prepareStatement(sql);
		ResultSet rs=pst.executeQuery(sql);
		if(rs.next()) {
			rez=1;
		}
		ConnectionFactory.close(rs);
		ConnectionFactory.closes(pst);
		ConnectionFactory.close(con);
		}catch(Exception e2) {System.out.print(e2);}
		return rez;
	}
}
