package mainFolder.model.game.elements;

import mainFolder.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortalTest {
    private Portal portal;

    @BeforeEach
    public void setup() {
        portal = new Portal(10, 15);
    }

    @Test
    public void testGetPosition() {
        assertEquals(10, portal.getPosition().getX());
        assertEquals(15, portal.getPosition().getY());
    }

    @Test
    public void testSetPosition() {
        portal.setPosition(new Position(20, 25));
        assertEquals(20, portal.getPosition().getX());
        assertEquals(25, portal.getPosition().getY());
    }
}