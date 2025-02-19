import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.getfood.order.controller.OrderController;
import com.getfood.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OrderIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPlaceOrder() throws Exception {
        mockMvc.perform(post("/api/orders")
                .contentType("application/json")
                .content("{\"customerId\":1, \"restaurantId\":2, \"items\":[{\"id\":101,\"quantity\":2}]}")
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.orderStatus").value("PENDING"));
    }
}