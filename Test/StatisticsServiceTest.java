import com.fastfood.model.Food;
import com.fastfood.model.Order;
import com.fastfood.model.OrderStatus;
import com.fastfood.service.StatisticsService;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class StatisticsServiceTest {
    @Test
    void testDailyRevenue() {
        Order order1 = new Order("1","A");
        order1.addItem(new Food(1,"Burger",10),2);
        order1.setStatus(OrderStatus.PAID);

        Order order2 = new Order("2","B");
        order2.addItem(new Food(1,"Burger",10),1);
        order2.setStatus(OrderStatus.PAID);

        List<Order> orders = List.of(order1,order2);
        StatisticsService statisticsService = new StatisticsService(orders);
        double revenue = statisticsService.getDailyRevenue(order1.getOrderDate().toLocalDate());
        assertTrue(revenue > 0);
    }

    @Test
    void testRevenueEmptyOrder() {
        StatisticsService statisticsService = new StatisticsService(List.of());
        double revenue = statisticsService.getDailyRevenue(java.time.LocalDate.now());
        assertEquals(0,revenue);
    }
}