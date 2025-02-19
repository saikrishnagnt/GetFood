package com.getfood.user.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {
    private final Map<String, String> otpStorage = new ConcurrentHashMap<>();

    public void generateAndSendOtp(String phone) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        otpStorage.put(phone, otp);
        // Send OTP via Twilio or other provider
    }

    public boolean validateOtp(String phone, String otp) {
        return otp.equals(otpStorage.get(phone));
    }
}