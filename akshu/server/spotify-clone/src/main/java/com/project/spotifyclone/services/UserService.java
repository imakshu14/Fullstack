package com.project.spotifyclone.services;

import com.project.spotifyclone.model.User;
import com.project.spotifyclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public Optional<User> getUserInfo(String email) {
        return userRepository.findById(email);
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public User editUser(String email, User updatedUser) {
        userRepository.save(updatedUser);
        return updatedUser;
    }
    public Optional<User> deleteUser(String email) {
        Optional<User> user = userRepository.findById(email);
        userRepository.deleteById(email);
        return user;
    }
}

