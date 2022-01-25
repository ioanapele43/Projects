package connectionToDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class OrderOperations {
		public static void addOrder(int i,int s) {
			try {
				Connection con=ConnectionFactory.getConnection();
				String sql=" insert into orders(idClient,dataComandare,dataFinalizare,suma) values("+i+", now(),now()+INTERVAL 30 SECOND ,"+s+"); ";
				Statement pst=con.prepareStatement(sql);
				boolean rs=pst.execute(sql);
				//ConnectionFactory.close(rs);
				ConnectionFactory.closes(pst);
				ConnectionFactory.close(con);
				JOptionPane.showMessageDialog(null,"SUCCESFULLY!");
				}catch(Exception e2) {System.out.print(e2);}
		}
		public static int idOrder() {
			int idm = 0;
			try {
				
				Connection con=ConnectionFactory.getConnection();
				String sql="SELECT MAX(idOrders) as maxim FROM orders;";
				Statement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery(sql);
				if(rs.next())
					idm=Integer.parseInt(rs.getString("maxim"));
				ConnectionFactory.close(rs);
				ConnectionFactory.closes(pst);
				ConnectionFactory.close(con);
			}catch(Exception e2) {System.out.print(e2);}
			return idm;
		}
		public static int verificareLivrareProdus(int i) {
			int l=0;
			try {
				
				Connection con=ConnectionFactory.getConnection();
				String sql="SELECT * FROM fooddelivery.orders where idorders="+i+" and dataFinalizare>now() and day(dataFinalizare)=day(now());";
				Statement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery(sql);
				if(rs.next())
					l=0;
				else
					l=1;
				ConnectionFactory.close(rs);
				ConnectionFactory.closes(pst);
				ConnectionFactory.close(con);
			}catch(Exception e2) {System.out.print(e2);}
			
			return l;
		}
		public static int verifPlecareComanda(int i) {
			int l=0;
			try {
				
				Connection con=ConnectionFactory.getConnection();
				String sql="SELECT * FROM fooddelivery.orders where idorders="+i+" and dataFinalizare=now() ;";
				Statement pst=con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery(sql);
				if(rs.next())
					l=1;
				else
					l=0;
				ConnectionFactory.close(rs);
				ConnectionFactory.closes(pst);
				ConnectionFactory.close(con);
			}catch(Exception e2) {System.out.print(e2);}
			
			return l;
		}
}
