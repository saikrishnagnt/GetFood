package com.getfood.user.service;

import com.getfood.user.model.User;
import com.getfood.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByPhoneNumber(phone)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUserProfile(String phone, User updatedUser) {
        User user = userRepository.findByPhoneNumber(phone)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (updatedUser.getName() != null) user.setName(updatedUser.getName());
        if (updatedUser.getAddress() != null) user.setAddress(updatedUser.getAddress());
        if (updatedUser.getProfilePicture() != null) user.setProfilePicture(updatedUser.getProfilePicture());

        return userRepository.save(user);
    }
}