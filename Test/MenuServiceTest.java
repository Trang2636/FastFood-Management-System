import com.fastfood.model.Drink;
import com.fastfood.model.Food;
import com.fastfood.model.MenuItem;
import com.fastfood.service.MenuService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuServiceTest {
    private MenuService menuService;

    @BeforeEach
    public void setUp() {
        menuService = new MenuService();
        menuService.addMenuItem(new Food(1, "Burger", 10));
        menuService.addMenuItem(new Food(2, "Bread", 5));
        menuService.addMenuItem(new Food(3, "Coke", 3));
    }
    // Tim theo ten
    @Test
    void testSearchByName() {
        List<MenuItem> result = menuService.searchByName("Burger");
        assertEquals(1, result.size());
        assertEquals("Burger", result.get(0).getName());
    }
    // Tim theo khoang gia
    @Test
    void testSearchByPriceRange() {
        List<MenuItem> result = menuService.searchByPriceRange(5, 10);
        assertEquals(2, result.size());
    }
    // Khong tim thay
    @Test
    void testSearchEmptyResult() {
        List<MenuItem> result = menuService.searchByName("Pizza");
        assertTrue(result.isEmpty());
    }

}
