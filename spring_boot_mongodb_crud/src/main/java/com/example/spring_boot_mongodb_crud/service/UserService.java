package com.example.spring_boot_mongodb_crud.service;

import com.example.spring_boot_mongodb_crud.controller.dto.request.UserRequest;
import com.example.spring_boot_mongodb_crud.model.User;
import com.example.spring_boot_mongodb_crud.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public void save(UserRequest userRequest) {
        User user = new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        userRepo.save(user);
    }

    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users;
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user.orElse(null);
    }

    public void deleteUserById(Long id) {
        userRepo.deleteById(id);
    }

    public User updateUser(UserRequest userRequest , Long id) {
        Optional<User> user = userRepo.findById(id);
        user.ifPresent(user1 -> {
            user1.setName(userRequest.getName());
            user1.setPassword(userRequest.getPassword());
            user1.setEmail(userRequest.getEmail());
            userRepo.save(user1);
        });
      return user.get();
    }
}
