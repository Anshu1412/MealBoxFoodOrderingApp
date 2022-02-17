package com.Project.MealBoxOnlineOrderingApp.Service;

import com.Project.MealBoxOnlineOrderingApp.Entity.User;
import com.Project.MealBoxOnlineOrderingApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Boolean existsById(String username) {
        return userRepository.existsById(username);
    }

    public User findUserByUsername(String username) {
        return userRepository.getById(username);
    }

    public User findById(String username) {
        return userRepository.getById(username);
    }

    public User updateUser(User existingUser) {
        return userRepository.save(existingUser);
    }


}

