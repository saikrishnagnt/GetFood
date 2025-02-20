package com.getfood.user.service;

import com.getfood.user.model.User;
import com.getfood.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserByPhone_Success() {
        User mockUser = new User(1L, "John Doe", "john@example.com", "1234567890", "Some Address", "profile.jpg");
        when(userRepository.findByPhoneNumber("1234567890")).thenReturn(Optional.of(mockUser));
        
        User user = userService.getUserByPhone("1234567890");
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    void testGetUserByPhone_UserNotFound() {
        when(userRepository.findByPhoneNumber("0000000000")).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> userService.getUserByPhone("0000000000"));
    }
}