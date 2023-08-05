package mainFolder.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOverMenuTest {

    private GameOverMenu gameOverMenu;

    @BeforeEach
    void setUp() {
        gameOverMenu = new GameOverMenu(100);
    }

    @Test
    void testStringScore() {
        assertEquals("Score:100", gameOverMenu.stringScore());
    }

    @Test
    void testIsSelectedRetry() {
        Assertions.assertTrue(gameOverMenu.isSelected(0));
        Assertions.assertTrue(gameOverMenu.isSelectedRetry());
    }

    @Test
    void testIsSelectedExit() {
        gameOverMenu.nextEntry();
        Assertions.assertTrue(gameOverMenu.isSelected(1));
        Assertions.assertTrue(gameOverMenu.isSelectedExit());
    }
}