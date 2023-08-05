package mainFolder.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainMenuTest {

    private MainMenu mainMenu;

    @BeforeEach
    public void helper() {
        mainMenu = new MainMenu();
    }

    @Test
    public void isSelectedExitTest() {
        mainMenu.nextEntry();
        Assertions.assertTrue(mainMenu.isSelected(1));
        Assertions.assertTrue(mainMenu.isSelectedExit());
    }

    @Test
    public void isSelectedStartTest() {
        Assertions.assertTrue(mainMenu.isSelected(0));
        Assertions.assertTrue(mainMenu.isSelectedStart());
    }
}
