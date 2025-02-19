import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.getfood.notification.service.NotificationService;
import com.getfood.notification.gateway.FirebaseGateway;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {
    @Mock
    private FirebaseGateway firebaseGateway;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    void testSendNotification() {
        doNothing().when(firebaseGateway).sendPushNotification(anyString(), anyString());
        notificationService.sendNotification("Test Message", "user123");
        verify(firebaseGateway, times(1)).sendPushNotification(anyString(), anyString());
    }
}