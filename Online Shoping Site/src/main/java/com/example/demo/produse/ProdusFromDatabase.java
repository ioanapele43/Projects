package com.example.demo.produse;

import com.example.demo.user.User;

import javax.persistence.Table;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusFromDatabase {
    private static final String url="jdbc:mysql://localhost:3306/onlineshop?serverTimezone=UTC&user=root&password=btsbts43";
    public List<Produs> vizualizareProduse() throws SQLException {
        List<Produs> listap=new ArrayList<Produs>();

        Connection con= DriverManager.getConnection(url);
        String sql="select * from products";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            Produs p=new Produs();
            p.setId( rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setQuantity(rs.getInt("quantity"));
            p.setProvider(rs.getString("provider"));
            p.setPrice(rs.getInt("price"));
            p.setImage1(rs.getString("image1"));
            p.setImage2(rs.getString("image2"));
            p.setImage3(rs.getString("image3"));
            p.setCategory(rs.getString("category"));
            p.setDescription(rs.getString("description"));
            p.setCountry(rs.getString("country"));
            p.setCategory(rs.getString("category"));
            p.setSubcategory(rs.getString("subcategory"));
            listap.add(p);
            
        }
        //System.out.println(listap);
        rs.close();
        st.close();
        con.close();
        return listap;
    }
    public Produs vizualizareProdus(Long id) throws SQLException {

        Produs p=new Produs();
        Connection con= DriverManager.getConnection(url);
        String sql="select * from products where id="+id+";";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){

            p.setId( rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setQuantity(rs.getInt("quantity"));
            p.setProvider(rs.getString("provider"));
            p.setPrice(rs.getInt("price"));
            p.setImage1(rs.getString("image1"));
            p.setImage2(rs.getString("image2"));
            p.setImage3(rs.getString("image3"));
            p.setCategory(rs.getString("category"));
            p.setDescription(rs.getString("description"));
            p.setCountry(rs.getString("country"));
            p.setCategory(rs.getString("category"));
            p.setSubcategory(rs.getString("subcategory"));


        }
        //System.out.println(listap);
        rs.close();
        st.close();
        con.close();
        return p;
    }
    public Produs vizualizareProdusDupaNume(String nume) throws SQLException {

        Produs p=new Produs();
        Connection con= DriverManager.getConnection(url);
        String sql="select * from products where name=\""+nume+"\";";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){

            p.setId( rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setQuantity(rs.getInt("quantity"));
            p.setProvider(rs.getString("provider"));
            p.setPrice(rs.getInt("price"));
            p.setImage1(rs.getString("image1"));
            p.setImage2(rs.getString("image2"));
            p.setImage3(rs.getString("image3"));
            p.setCategory(rs.getString("category"));
            p.setDescription(rs.getString("description"));
            p.setCountry(rs.getString("country"));
            p.setCategory(rs.getString("category"));
            p.setSubcategory(rs.getString("subcategory"));


        }
        //System.out.println(listap);
        rs.close();
        st.close();
        con.close();
        return p;
    }
    public List<Produs> vizualizareProdusCat(String cat) throws SQLException {

        List<Produs> listap=new ArrayList<Produs>();

        Connection con= DriverManager.getConnection(url);
        String sql="select * from products where category like \"%"+cat+"%\";";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            Produs p=new Produs();
            p.setId( rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setQuantity(rs.getInt("quantity"));
            p.setProvider(rs.getString("provider"));
            p.setPrice(rs.getInt("price"));
            p.setImage1(rs.getString("image1"));
            p.setImage2(rs.getString("image2"));
            p.setImage3(rs.getString("image3"));
            p.setCategory(rs.getString("category"));
            p.setDescription(rs.getString("description"));
            p.setCountry(rs.getString("country"));
            p.setCategory(rs.getString("category"));
            p.setSubcategory(rs.getString("subcategory"));
            listap.add(p);

        }
        //System.out.println(listap);
        rs.close();
        st.close();
        con.close();
        return listap;
    }
    public List<Produs> vizualizareProdusNume(String nume) throws SQLException {
        List<Produs> listap=new ArrayList<Produs>();

        Connection con= DriverManager.getConnection(url);
        String sql="select * from products where name like \"%"+nume+"%\";";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            Produs p=new Produs();
            p.setId( rs.getLong("id"));
            p.setName(rs.getString("name"));
            p.setQuantity(rs.getInt("quantity"));
            p.setProvider(rs.getString("provider"));
            p.setPrice(rs.getInt("price"));
            p.setImage1(rs.getString("image1"));
            p.setImage2(rs.getString("image2"));
            p.setImage3(rs.getString("image3"));
            p.setCategory(rs.getString("category"));
            p.setDescription(rs.getString("description"));
            p.setCountry(rs.getString("country"));
            p.setCategory(rs.getString("category"));
            p.setSubcategory(rs.getString("subcategory"));
            listap.add(p);

        }
        //System.out.println(listap);
        rs.close();
        st.close();
        con.close();
        return listap;
    }
    public boolean verificareExistentaProdus(Produs produs) throws SQLException{
        Connection con= DriverManager.getConnection(url);
        boolean exista=false;
        String sql="select * from products where name=\""+produs.getName()+"\" and provider=\""+produs.getProvider()+"\" ;";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){
            exista=true;
        }
        //System.out.println(listap);
        rs.close();
        st.close();
        con.close();
        return exista;
    }
    public int cantitateProdus(Produs produs) throws SQLException{
        Connection con= DriverManager.getConnection(url);

        int c=0;
        String sql="select * from products where name=\""+produs.getName()+"\" and provider=\""+produs.getProvider()+"\" ;";
        Statement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery(sql);
        while(rs.next()){

            c=rs.getInt("quantity");
        }
        rs.close();
        st.close();
        con.close();
        return c;
    }
    public void updateProdus(Produs produs) throws SQLException {
        Connection con= DriverManager.getConnection(url);
        String sql="UPDATE products SET category=\""+produs.getCategory()+"\", subcategory=\""+produs.getSubcategory()+"\", country=\""+produs.getCountry()+"\", description=\""+produs.getDescription()+"\", image1=\""+produs.getImage1()+"\", image2=\""+produs.getImage2()+"\", image3=\""+produs.getImage3()+"\", price="+produs.getPrice()+", quantity="+produs.getQuantity()+" WHERE name=\""+produs.getName()+ "\" and provider=\""+produs.getProvider()+"\" ";
        Statement pst=con.prepareStatement(sql);
        boolean rs=pst.execute(sql);
        pst.close();
        con.close();
    }
    public void updateProdusQ(Produs produs) throws SQLException {
        Connection con= DriverManager.getConnection(url);
        String sql="UPDATE products SET category=\""+produs.getCategory()+"\", subcategory=\""+produs.getSubcategory()+"\", country=\""+produs.getCountry()+"\", description=\""+produs.getDescription()+"\", image1=\""+produs.getImage1()+"\", image2=\""+produs.getImage2()+"\", image3=\""+produs.getImage3()+"\", price="+produs.getPrice()+", quantity="+produs.getQuantity()+" WHERE name=\""+produs.getName()+ "\" and provider=\""+produs.getProvider()+"\" ";
        Statement pst=con.prepareStatement(sql);
        boolean rs=pst.execute(sql);
        pst.close();
        con.close();
    }
    public void insertProdus(Produs produs) throws SQLException{
        Connection con= DriverManager.getConnection(url);
        String sql="INSERT INTO products(category,country,description,image1,image2,image3,name,price,provider,quantity,subcategory) VALUES(\""+produs.getCategory()+"\",\""+produs.getCountry()+"\",\""+produs.getDescription()+"\",\""+produs.getImage1()+"\",\""+produs.getImage2()+"\",\""+produs.getImage3()+"\",\""+produs.getName()+"\","+produs.getPrice()+",\""+produs.getProvider()+"\","+produs.getQuantity()+",\""+produs.getSubcategory()+"\") ";
        Statement pst=con.prepareStatement(sql);
        boolean rs=pst.execute(sql);
        pst.close();
        con.close();

    }
    public static void main(String[] args) throws SQLException {
        ProdusFromDatabase p= new ProdusFromDatabase();
        List<Produs> lp = new ArrayList<Produs>();
        lp=p.vizualizareProduse();
        lp.forEach(l-> System.out.println(l.getName()));
        Produs prod=new Produs();
        prod.setName("a1");
        prod.setProvider("a");
        p.updateProdus(prod);
        System.out.println(p.verificareExistentaProdus(prod));
        System.out.println(p.cantitateProdus(prod));
        p.insertProdus(prod);

    }
}
