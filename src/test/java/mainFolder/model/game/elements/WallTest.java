package mainFolder.model.game.elements;

import mainFolder.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {
    private Wall wall;

    @BeforeEach
    void setUp() {
        wall = new Wall(10, 20);
    }

    @Test
    void testGetPosition() {
        assertEquals(10, wall.getPosition().getX());
        assertEquals(20, wall.getPosition().getY());
    }

    @Test
    void testSetPosition() {
        wall.setPosition(new Position(30, 40));
        assertEquals(30, wall.getPosition().getX());
        assertEquals(40, wall.getPosition().getY());
    }
}