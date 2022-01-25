package com.example.demo.comenzi;

import com.example.demo.produse.Produs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComandaFromDatabase {
    private static final String url="jdbc:mysql://localhost:3306/onlineshop?serverTimezone=UTC&user=root&password=btsbts43";
    public List<Comanda> vizualizareComenzi() throws SQLException {
        List<Comanda> listac =new ArrayList<Comanda>();
        Connection con= DriverManager.getConnection(url);
        String sql="select * from comenzi";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            Comanda c=new Comanda();
            c.setId(rs.getLong("id"));
            c.setAddress(rs.getString("address"));
            c.setEmail(rs.getString("email"));
            c.setLastName(rs.getString("last_name"));
            c.setFirstName(rs.getString("first_name"));
            c.setTelefon(rs.getString("telefon"));
            c.setTotalValue(rs.getInt("total_value"));
            c.setDatac(rs.getDate("datacomanda"));
            listac.add(c);
        }
        rs.close();
        st.close();
        con.close();
        return listac;
    }
    public List<Comanda> vizualizareComenziClient(String email) throws SQLException {
        List<Comanda> listac =new ArrayList<Comanda>();
        Connection con= DriverManager.getConnection(url);
        String sql="select * from comenzi where email=\""+email+"\";";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            Comanda c=new Comanda();
            c.setId(rs.getLong("id"));
            c.setAddress(rs.getString("address"));
            c.setEmail(rs.getString("email"));
            c.setLastName(rs.getString("last_name"));
            c.setFirstName(rs.getString("first_name"));
            c.setTelefon(rs.getString("telefon"));
            c.setTotalValue(rs.getInt("total_value"));
            c.setDatac(rs.getDate("datacomanda"));
            listac.add(c);
        }
        rs.close();
        st.close();
        con.close();
        return listac;
    }
    public void insertcomanda(Comanda comanda ) throws SQLException{
        Connection con= DriverManager.getConnection(url);
        String sql="INSERT INTO comenzi(address, email, first_name, last_name,telefon, total_value,datacomanda) Values (\""+comanda.getAddress()+"\",\""+comanda.getEmail()+"\",\""+comanda.getFirstName()+"\",\""+comanda.getLastName()+"\",\""+comanda.getTelefon()+"\","+comanda.getTotalValue()+",now())";
        Statement pst=con.prepareStatement(sql);
        boolean rs=pst.execute(sql);
        System.out.println("s-a inserat");
        pst.close();
        con.close();

    }
}
