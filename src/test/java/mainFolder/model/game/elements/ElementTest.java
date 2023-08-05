package mainFolder.model.game.elements;

import mainFolder.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {
    private Element element;

    @BeforeEach
    public void setUp() {
        element = new Element(5, 10);
    }

    @Test
    public void testGetPosition() {
        assertEquals(5, element.getPosition().getX());
        assertEquals(10, element.getPosition().getY());
    }

    @Test
    public void testSetPosition() {
        element.setPosition(new Position(7, 3));
        assertEquals(7, element.getPosition().getX());
        assertEquals(3, element.getPosition().getY());
    }
}