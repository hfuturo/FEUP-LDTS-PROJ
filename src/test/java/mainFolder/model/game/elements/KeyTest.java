package mainFolder.model.game.elements;

import mainFolder.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyTest {
    private Key key;

    @BeforeEach
    public void setUp() {
        key = new Key(5, 10);
    }

    @Test
    public void testGetPosition() {
        assertEquals(5, key.getPosition().getX());
        assertEquals(10, key.getPosition().getY());
    }

    @Test
    public void testSetPosition() {
        key.setPosition(new Position(7, 3));
        assertEquals(7, key.getPosition().getX());
        assertEquals(3, key.getPosition().getY());
    }
}