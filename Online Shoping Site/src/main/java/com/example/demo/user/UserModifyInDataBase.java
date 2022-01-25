package com.example.demo.user;

import com.example.demo.comenzi.Comanda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserModifyInDataBase {
    private static final String url="jdbc:mysql://localhost:3306/onlineshop?serverTimezone=UTC&user=root&password=btsbts43";
    public void updateUser(User user) throws SQLException {
            Connection con= DriverManager.getConnection(url);
            String sql="UPDATE users SET last_name = \""+user.getLastName()+"\" WHERE (email = \""+user.getEmail()+"\"); ";
            System.out.println(user.getLastName()+ "cu idul"+user.getId());
        Statement pst=con.prepareStatement(sql);
        boolean rs=pst.execute(sql);
        pst.close();
            con.close();


    }
    public static void main(String[] args) throws SQLException {
        User user=new User();
        user.setId(1L);
        user.setLastName("IOANAA");
        UserModifyInDataBase um=new UserModifyInDataBase();
        um.updateUser(user);
    }
}
