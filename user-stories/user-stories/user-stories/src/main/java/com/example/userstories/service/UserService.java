package com.example.userstories.service;

import com.example.userstories.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User getById(Integer id);
    List<User> getAll();
    User update(Integer id, User userDetail);
    void delete(Integer id);
}
