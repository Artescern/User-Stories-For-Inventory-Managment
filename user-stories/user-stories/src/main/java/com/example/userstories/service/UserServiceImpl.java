package com.example.userstories.service;

import com.example.userstories.repository.UserRepository;
import com.example.userstories.entity.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        Optional<User> optional = userRepository.findByEmail(user.getEmail());
        if(optional.isPresent()){
            return null;
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
        return user;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Integer id, User userDetail) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(userDetail.getEmail());
            user.setPassword(userDetail.getPassword());
            user.setFirstName(userDetail.getFirstName());
            user.setLastName(userDetail.getLastName());
            return userRepository.save(user);
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }


    @Override
    public void delete(Integer id) {
        User user = getById(id);
        userRepository.delete(user);
    }
}
