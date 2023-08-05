package mainFolder.model.game.elements;

import mainFolder.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    private Monster monster;

    @BeforeEach
    void setUp() {
        monster = new Monster(1, 1);
    }

    @Test
    void testGetPosition() {
        assertEquals(new Position(1, 1), monster.getPosition());
    }

    @Test
    void testGetHealth() {
        // initial health of the monster is 1
        assertEquals(1, monster.getHealth());
    }

    @Test
    void testDecreaseHealth() {
        monster.decreaseHealth();
        assertEquals(0, monster.getHealth());
    }
}