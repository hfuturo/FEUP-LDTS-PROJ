package mainFolder.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinMenuTest {

    private WinMenu winMenu;

    @BeforeEach
    public void helper() {
        winMenu = new WinMenu(100);
    }

    @Test
    public void isSelectedPlayNewGameTest() {
        Assertions.assertTrue(winMenu.isSelected(0));
        Assertions.assertTrue(winMenu.isSelectedPlayNewGame());
    }

    @Test
    public void isSelectedExit() {
        winMenu.nextEntry();
        Assertions.assertTrue(winMenu.isSelected(1));
        Assertions.assertTrue(winMenu.isSelectedExit());
    }

    @Test
    public void stringScoreTest() {
        Assertions.assertEquals("Score:100", winMenu.stringScore());
    }

    @Test
    public void nextEntryTest() {
        winMenu.nextEntry();
        Assertions.assertTrue(winMenu.isSelected(1));
        winMenu.nextEntry();
        Assertions.assertTrue(winMenu.isSelected(0));
    }

    @Test
    public void previousEntryTest() {
        winMenu.previousEntry();
        Assertions.assertTrue(winMenu.isSelected(1));
        winMenu.previousEntry();
        Assertions.assertTrue(winMenu.isSelected(0));
    }

    @Test
    public void getEntryTest() {
        Assertions.assertTrue(winMenu.isSelected(0));
        Assertions.assertEquals("Play New Game", winMenu.getEntry(0));
    }

    @Test
    public void isSelectedTest() {
        Assertions.assertTrue(winMenu.isSelected(0));
        Assertions.assertFalse(winMenu.isSelected(1));
    }

    @Test
    public void getNumberEntriesTest() {
        Assertions.assertEquals(2, winMenu.getNumberEntries());
    }
}
