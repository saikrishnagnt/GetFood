package com.getfood.user.controller;

import com.getfood.user.service.OtpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final OtpService otpService;

    public AuthController(OtpService otpService) {
        this.otpService = otpService;
    }

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String phone) {
        otpService.generateAndSendOtp(phone);
        return ResponseEntity.ok("OTP sent successfully.");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestParam String phone, @RequestParam String otp) {
        if (otpService.validateOtp(phone, otp)) {
            return ResponseEntity.ok("OTP verification successful.");
        }
        return ResponseEntity.status(401).body("Invalid OTP.");
    }
}