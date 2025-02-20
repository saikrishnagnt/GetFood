package com.getfood.user.security;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JwtServiceTest {
    private final JwtService jwtService = new JwtService();

    @Test
    void testGenerateToken() {
        String token = jwtService.generateToken("1234567890");
        assertNotNull(token);
    }

    @Test
    void testValidateToken() {
        String token = jwtService.generateToken("1234567890");
        assertTrue(jwtService.validateToken(token));
    }

    @Test
    void testExtractPhone() {
        String token = jwtService.generateToken("1234567890");
        assertEquals("1234567890", jwtService.extractPhone(token));
    }
}