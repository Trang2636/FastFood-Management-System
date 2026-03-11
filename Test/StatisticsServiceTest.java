import com.fastfood.model.Food;
import com.fastfood.model.MenuItem;
import com.fastfood.model.Order;
import com.fastfood.service.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticsServiceTest {
    private StatisticsService statisticsService;

    @BeforeEach
    public void setUp() {
        statisticsService = new StatisticsService();
    }
    @Test
    void testCalculateTotalRevenue() {
        MenuItem burger = new Food(1, "Burger", 10);
        Order order = new Order(1);
        order.addItem(burger, 2);
        Order order2 = new Order(2);
        order2.addItem(burger, 1);

        List<Order> orders = List.of(order, order2);
        double totalRevenue = statisticsService.calculateTotalRevenue(orders);
        assertEquals(30, totalRevenue);
    }
    @Test
    void testRevenueEmptyOrder() {
        List<Order> emptyOrders = List.of();
        double totalRevenue = statisticsService.calculateTotalRevenue(emptyOrders);
        assertEquals(0, totalRevenue);
    }
}
