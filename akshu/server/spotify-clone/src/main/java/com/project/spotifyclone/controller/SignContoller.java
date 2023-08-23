package com.project.spotifyclone.controller;
import com.project.spotifyclone.model.User;
import com.project.spotifyclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class SignContoller {

    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{email}")
    public Optional<User> getUserInfo(@PathVariable String rno) {
        return userService.getUserInfo(rno);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{email}")
    public User editUser(@PathVariable String email, @RequestBody User user) {
        return userService.editUser(email, user);
        // return user;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{email}")
    public Optional<User> deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }
}

