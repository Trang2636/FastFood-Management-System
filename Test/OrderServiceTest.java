import com.fastfood.model.Food;
import com.fastfood.model.MenuItem;
import com.fastfood.model.Order;
import com.fastfood.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {
    private OrderService orderService;
    private Order order;

    @BeforeEach
    public void setUp() {
        orderService = new OrderService();
        order = new Order(1);

        MenuItem food = new Food(1, "Burger", 10);
        MenuItem bread = new Food(2, "Bread", 5);

        order.addItem(food,1);
        order.addItem(bread,2);
    }

    // Tong tien
    @Test
    void testCalculateTotalPrice() {
        double totalPrice = orderService.calculateTotalPrice(order);
        assertEquals(20, totalPrice);
    }
    // Tong tien voi khuyen mai
    @Test
    void testCalculateTotalPriceWithDiscount() {
        order.setDiscount(0.1);
        double totalPrice = orderService.calculateTotalPrice(order);
        assertEquals(18, totalPrice);

    }
    // Gio hang rong
    @Test
    void testCalculateEmptyOrder() {
        Order emptyOrder = new Order(2);
        double totalPrice = orderService.calculateTotalPrice(emptyOrder);
        assertEquals(0, totalPrice);
    }
}
