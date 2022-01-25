package com.example.demo.cos;

import com.example.demo.produse.Produs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CosFromDatabase {
    private static final String url="jdbc:mysql://localhost:3306/onlineshop?serverTimezone=UTC&user=root&password=btsbts43";
    List<ProdusCos> listaC=new ArrayList<>();

    public List<ProdusCos> vizualizareCos(String email) throws SQLException {

        Connection con= DriverManager.getConnection(url);
        String sql="select * from cart where quantity_cart>0 and email=\""+email+"\";";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            ProdusCos p=new ProdusCos();

            p.setId(rs.getLong("id"));
            p.setCategory(rs.getString("category"));
            p.setImage(rs.getString("image"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getInt("price"));
            p.setQuantityCart(rs.getInt("quantity_cart"));
            p.setQuantityStock(rs.getInt("quantity_stock"));
            listaC.add(p);
        }
        System.out.println(listaC);
        rs.close();
        st.close();
        con.close();
        return listaC;
    }
    public ProdusCos vizualizareProdus(String name) throws SQLException {

        Connection con= DriverManager.getConnection(url);
        String sql="select * from cart where quantity_cart>0 and name=\""+name+"\" ; ";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        ProdusCos p=new ProdusCos();
        while(rs.next()){


            p.setId(rs.getLong("id"));
            p.setCategory(rs.getString("category"));
            p.setImage(rs.getString("image"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getInt("price"));
            p.setQuantityCart(rs.getInt("quantity_cart"));
            p.setQuantityStock(rs.getInt("quantity_stock"));

        }
        System.out.println(listaC);
        rs.close();
        st.close();
        con.close();
        return p;
    }
    public int TotalV(String email) throws SQLException {

        Connection con= DriverManager.getConnection(url);
        String sql="Select sum(quantity_cart*price) as \"s\" from onlineshop.cart where email=\""+email+"\";";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        int t=0;
        while(rs.next()){

            t=rs.getInt("s");
        }
        System.out.println(listaC);
        rs.close();
        st.close();
        con.close();
        return t;
    }
    public boolean verificareExistentaProdus(ProdusCos produs) throws SQLException{
        Connection con= DriverManager.getConnection(url);
        boolean exista=false;
        String sql="select * from cart where name=\""+produs.getName()+"\" and email=\""+produs.getEmail()+"\" ;";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            exista=true;
        }
        rs.close();
        st.close();
        con.close();
        return exista;
    }
    public void stergereProduse(String email) throws SQLException {
        Connection con= DriverManager.getConnection(url);
        String sql = "Delete from cart where email=\""+email+"\" ;";
        Statement pst=con.prepareStatement(sql);
        boolean rs=pst.execute(sql);
        pst.close();
        con.close();
    }
    public void insertProdusCos(ProdusCos produs) throws SQLException{
        Connection con= DriverManager.getConnection(url);

        if (verificareExistentaProdus(produs)==false) {
            produs.setQuantityCart(1);
            String sql = "INSERT INTO cart(category,image,name,price,quantity_cart,quantity_stock,email) VALUES(\"" + produs.getCategory() + "\",\"" + produs.getImage() + "\",\"" + produs.getName() + "\"," + produs.getPrice() + "," + produs.getQuantityCart() + "," + produs.getQuantityStock() + ",\"" + produs.getEmail()+ "\") ;";
            Statement pst = con.prepareStatement(sql);
            boolean rs = pst.execute(sql);
        }
        else
        {
            int quantity=0;
            String sql1 = "select quantity_cart from cart where name=\""+produs.getName()+"\" and email=\""+produs.getEmail()+"\" ;";
            Statement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery(sql1);
            if (rs1.next())
                quantity = rs1.getInt("quantity_cart");

            con= DriverManager.getConnection(url);
            produs.setQuantityCart(quantity+1);
            String sql="UPDATE cart SET  quantity_cart=\""+produs.getQuantityCart()+"\" WHERE name=\""+produs.getName()+"\" and email=\""+produs.getEmail()+"\" ;";
            Statement pst = con.prepareStatement(sql);
            boolean rs = pst.execute(sql);

        }
        con.close();

    }

    public void deleteProdusCos(ProdusCos produs) throws SQLException{
        Connection con= DriverManager.getConnection(url);

        if (verificareExistentaProdus(produs)==false)
        {

        }
        else
        {
            int quantity=0;
            String sql1 = "select quantity_cart from cart where name=\""+produs.getName()+"\" and email=\""+produs.getEmail()+"\" ;";
            Statement pst1 = con.prepareStatement(sql1);
            ResultSet rs1 = pst1.executeQuery(sql1);
            if (rs1.next())
                quantity = rs1.getInt("quantity_cart");

            if (quantity>=1) {
                con = DriverManager.getConnection(url);
                produs.setQuantityCart(quantity - 1);
                String sql = "UPDATE cart SET  quantity_cart=\"" + produs.getQuantityCart() + "\" WHERE name=\"" + produs.getName() +"\" and email=\""+produs.getEmail()+"\" ;";
                Statement pst = con.prepareStatement(sql);
                boolean rs = pst.execute(sql);
            }
            else
            {
                con = DriverManager.getConnection(url);
                produs.setQuantityCart(0);
                String sql = "UPDATE cart SET  quantity_cart=\"" + produs.getQuantityCart() + "\" WHERE name=\"" + produs.getName() +"\" and email=\""+produs.getEmail()+"\" ;";
                Statement pst = con.prepareStatement(sql);
                boolean rs = pst.execute(sql);
            }

        }
        con.close();

    }



}
