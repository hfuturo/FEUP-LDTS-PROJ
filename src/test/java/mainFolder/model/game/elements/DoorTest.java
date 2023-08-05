package mainFolder.model.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoorTest {
    private Door door;

    @BeforeEach
    public void setUp() {
        door = new Door(5, 10);
    }

    @Test
    public void testGetXPosition() {
        assertEquals(5, door.getPosition().getX());
    }

    @Test
    public void testGetYPosition() {
        assertEquals(10, door.getPosition().getY());
    }

}