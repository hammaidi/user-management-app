package com.oreo.dao;

import java.util.List;
import com.oreo.entity.User;

public interface UserDao {
    void displayUsers();
    List<User> returnUsersByNameAsc();
    List<User> returnUsersByNameDesc();
    void addUser(User u);
    void deleteUser(int id); // Doit utiliser int comme paramètre
    void updateUser(User u);
    boolean findUser(User u);
    User findUserById(int id);
}