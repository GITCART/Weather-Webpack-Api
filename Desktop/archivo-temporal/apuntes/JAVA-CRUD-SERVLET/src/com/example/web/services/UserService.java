package com.example.web.services;

import com.example.web.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> users = new ArrayList<User>();

    public List<User> getAll(){
        User user = new User(1, "admin", "1233", "admin@gmail.com");
        users.add(user);
        return  users;
    }

    public boolean crearteUser(User user){
        users.add(user);
        return true;
    }

    public boolean updateUser(User user){
        int idx = 0;
        for (User userSeacrh: users) {
            if(user == userSeacrh){
                users.set(idx, user);
                break;
            }
            idx++;
        }
        return true;
    }

    public boolean deleteUser(User user){
        int idx = 0;
        for (User userSeacrh: users) {
            if(user == userSeacrh){
                users.remove(user);
                break;
            }
            idx++;
        }
        return true;
    }

    public User getUserById(int id){
        int idx = 0;
        for (User userSeacrh: users) {
            if(id == userSeacrh.getId()){
                return userSeacrh;
            }
            idx++;
        }
        return null;
    }


}
