package com.example.userstories.service;

import com.example.userstories.entity.User;
import java.util.List;

public interface UserService {
    User create(User user);
    User getById(Integer id);
    User getByEmail(String email); // New method to get user by email
    List<User> getAll();
    User update(Integer id, User userDetail);
    User updateEmail(Integer id, String newEmail); // New method to update user email
    void delete(Integer id);
}

