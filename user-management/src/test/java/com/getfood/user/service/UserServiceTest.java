import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.getfood.user.service.UserService;
import com.getfood.user.repository.UserRepository;
import com.getfood.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User(1L, "John Doe", "1234567890", "CUSTOMER");
    }

    @Test
    void testFindUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        User user = userService.getUserById(1L);
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    void testUserNotFound() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> userService.getUserById(2L));
    }
}