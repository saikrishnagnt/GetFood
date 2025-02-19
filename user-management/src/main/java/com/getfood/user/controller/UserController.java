package com.getfood.user.controller;

import com.getfood.user.model.User;
import com.getfood.user.security.JwtService;
import com.getfood.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final JwtService jwtService;
    private final UserService userService;

    public UserController(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getProfile(@RequestHeader("Authorization") String token) {
        String phone = jwtService.extractPhone(token);
        User user = userService.getUserByPhone(phone);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateProfile(@RequestHeader("Authorization") String token,
                                              @RequestBody User updatedUser) {
        String phone = jwtService.extractPhone(token);
        User user = userService.updateUserProfile(phone, updatedUser);
        return ResponseEntity.ok(user);
    }
}