package com.example.crud.service;

import com.example.crud.dao.ConnectionDb;
import com.example.crud.dao.UserDao;
import com.example.crud.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    static UserDao userDao = new UserDao();

    public static void getUser(){
        List<User> users = userDao.getAllUser();
        for (User user: users) {
            System.out.println("Usuario:"+ user);
        }
    }

    public static void   insertUser(){
        User user = new User("Fidel", "1233", "fidel@gmail.com");
        boolean inserto = userDao.createUser(user);
        if (inserto){
            System.out.println("Inserto correctamente");
        }else{
            System.out.println("Error al insertar");
        }
    }

    public static void  updatetUser(){
        User user = new User("Fidelito", "1233", "fidel@gmail.com");
        user.setId(1);
        boolean inserto = userDao.updateUser(user);
        if (inserto){
            System.out.println("Actualizo correctamente");
        }else{
            System.out.println("Error al actualizar");
        }
    }

    public static void  deleteUser(){
        User user = new User("Fidelito", "1233", "fidel@gmail.com");
        user.setId(1);
        boolean inserto = userDao.deleteUser(user);
        if (inserto){
            System.out.println("Elimino correctamente");
        }else{
            System.out.println("Error al eliminar");
        }
    }


    public static void main(String[] args) {

        getUser();

    }

}
