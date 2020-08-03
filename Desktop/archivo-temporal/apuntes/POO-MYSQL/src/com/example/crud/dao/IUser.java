package com.example.crud.dao;

import com.example.crud.model.User;

import java.util.List;

public interface IUser {
    public List<User> getAllUser();

    public User getOneUser(int id);

    public boolean createUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(User user);

}
