package com.example.userstories.service;

import com.example.userstories.entity.User;
import com.example.userstories.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Integer id, User userDetail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        user.setEmail(userDetail.getEmail());
        user.setPassword(userDetail.getPassword());
        user.setFirstName(userDetail.getFirstName());
        user.setLastName(userDetail.getLastName());

        return userRepository.save(user);
    }

    @Override
    public User updateEmail(Integer id, String newEmail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        user.setEmail(newEmail);

        return userRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateProfilePicture(Integer id, MultipartFile file) throws IOException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        user.setProfilePicture(file.getBytes());
        user.setProfilePictureType(file.getContentType());

        userRepository.save(user);
    }

    @Override
    public byte[] getProfilePicture(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        if (user.getProfilePicture() == null) {
            throw new EntityNotFoundException("Profile picture not found for user with id: " + id);
        }

        return user.getProfilePicture();
    }

    @Override
    public String getProfilePictureType(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        if (user.getProfilePictureType() == null) {
            throw new EntityNotFoundException("Profile picture type not found for user with id: " + id);
        }

        return user.getProfilePictureType();
    }
}
