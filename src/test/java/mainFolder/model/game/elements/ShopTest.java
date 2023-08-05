package mainFolder.model.game.elements;

import mainFolder.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {
    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop(5, 5);
    }

    @Test
    void testGetPosition() {
        assertEquals(new Position(5, 5), shop.getPosition());
    }

    @Test
    void testSetPosition() {
        shop.setPosition(new Position(10, 10));
        assertEquals(new Position(10, 10), shop.getPosition());
    }

    @Test
    void testGetShop() {
        HashMap<String, Integer> expectedShop = new HashMap<>();
        expectedShop.put("Health Potion", 5);
        expectedShop.put("Extra Health Potion", 10);
        assertEquals(expectedShop, shop.getShop());
    }
    @Test
    public void testFillShop() {

        // Check that the shop has the correct number of items
        assertEquals(2, shop.getShop().size());

        // Check that the shop has the correct items and prices
        assertEquals(5, (int) shop.getShop().get("Health Potion"));
        assertEquals(10, (int) shop.getShop().get("Extra Health Potion"));
    }
}