package com.example.crud.dao;

import com.example.crud.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUser{

    ConnectionDb connectionDb = null;

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT usu_id, usu_username, usu_password, usu_email FROM crud";

        connectionDb = new ConnectionDb();
        Connection conn = connectionDb.getConnection();

        if(conn != null){

            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("usu_id"));
                    user.setUsername(rs.getString("usu_username"));
                    user.setPassword(rs.getString("usu_password"));
                    user.setEmail(rs.getString("usu_email"));
                    users.add(user);
                }
            } catch (SQLException e) {
                System.out.println("Error en SQL");
                return null;
            }
            return  users;
        }


        return null;
    }

    @Override
    public User getOneUser(int id) {
        return null;
    }

    @Override
    public boolean createUser(User user) {
        String sql = "INSERT INTO crud (usu_username, usu_password, usu_email) values(?,?,?)";
        connectionDb = new ConnectionDb();
        Connection conn = connectionDb.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());

            if(ps.executeUpdate() > 0){
                return  true;
            }

        } catch (SQLException e) {
            System.out.println("Error en SQL - INSERT");
            return false;
        }
        return  false;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "UPDATE crud SET usu_username=?, usu_password=?, usu_email=? WHERE usu_id=?";
        connectionDb = new ConnectionDb();
        Connection conn = connectionDb.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getId());
            if(ps.executeUpdate() > 0){
                return  true;
            }

        } catch (SQLException e) {
            System.out.println("Error en SQL - UPDATE");
            return false;
        }
        return  false;
    }

    @Override
    public boolean deleteUser(User user) {
        String sql = "DELETE FROM crud WHERE usu_id=?";
        connectionDb = new ConnectionDb();
        Connection conn = connectionDb.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            if(ps.executeUpdate() > 0){
                return  true;
            }

        } catch (SQLException e) {
            System.out.println("Error en SQL - DELETE");
            return false;
        }
        return  false;
    }
}
