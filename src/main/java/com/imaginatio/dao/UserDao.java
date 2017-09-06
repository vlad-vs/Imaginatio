package com.imaginatio.dao;

import com.imaginatio.entity.User;

public interface UserDao {

    User findByEmail(String email);

    User findByID(int id);

    void saveUser(User user);
}





