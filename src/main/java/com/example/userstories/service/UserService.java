package com.example.userstories.service;

import com.example.userstories.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User create(User user);
    User getById(Integer id);
    User getByEmail(String email);
    List<User> getAll();
    User update(Integer id, User userDetail);
    User updateEmail(Integer id, String newEmail);
    void delete(Integer id);
    void updateProfilePicture(Integer id, MultipartFile file) throws IOException; // New method for updating profile picture
    byte[] getProfilePicture(Integer id); // New method for retrieving profile picture
    String getProfilePictureType(Integer id); // New method for retrieving profile picture type
}
