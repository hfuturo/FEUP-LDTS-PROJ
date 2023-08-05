package mainFolder.model.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {
    private Coin coin;

    @BeforeEach
    public void setUp() {
        coin = new Coin(5, 10);
    }

    @Test
    public void testGetXPosition() {
        assertEquals(5, coin.getPosition().getX());
    }

    @Test
    public void testGetYPosition() {
        assertEquals(10, coin.getPosition().getY());
    }

}
