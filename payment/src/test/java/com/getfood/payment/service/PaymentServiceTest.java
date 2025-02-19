import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.getfood.payment.service.PaymentService;
import com.getfood.payment.gateway.PaymentGateway;
import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    @Mock
    private PaymentGateway paymentGateway;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    void testProcessPayment() {
        when(paymentGateway.process(any())).thenReturn("SUCCESS");
        String result = paymentService.processPayment(100.0, "user123");
        assertEquals("SUCCESS", result);
    }
}