package com.example.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {

    public  Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "root");
            System.out.println("exitos");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }catch (Exception e){
            System.out.println("Error in Connection::"+ e.getMessage());
        }

        return  connection;
    }
}
