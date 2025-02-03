package com.example.spring_boot_mongodb_crud.controller;

import com.example.spring_boot_mongodb_crud.controller.dto.request.UserRequest;
import com.example.spring_boot_mongodb_crud.model.User;
import com.example.spring_boot_mongodb_crud.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    public void createUser(@RequestBody UserRequest userRequest) {
        userService.save(userRequest);
    }

    @GetMapping("/api/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/api/user/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/api/user/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.updateUser(userRequest ,id);
    }

}
