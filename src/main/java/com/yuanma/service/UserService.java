package com.yuanma.service;

import com.yuanma.model.User;

import java.util.List;

public interface UserService {
    List<User> selectAll();

    int updateUser(User user);

    int deleteUserById(int id);

    int addUser(User user);

    User selectUserById(int parseInt);

    User selectUserByName(String name);
}
