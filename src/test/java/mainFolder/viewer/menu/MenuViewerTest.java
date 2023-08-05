package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MenuViewerTest {
    private GUI gui;
    private MainMenu mainMenu;
    private MenuViewer viewer;

    @BeforeEach
    public void setUp() {
        // Create a mock GUI object
        gui = mock(GUI.class);

        // Create a MainMenu object and a MenuViewer object
        mainMenu = new MainMenu();
        viewer = new MenuViewer(mainMenu);
    }

    @Test
    public void testDrawElementsCallsDrawBackground() {
        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a MainMenu object and a MenuViewer object
        MainMenu mainMenu = new MainMenu();
        MenuViewer viewer = new MenuViewer(mainMenu);

        // Call the drawElements method on the viewer
        viewer.drawElements(gui);

        // Verify that the GUI's drawBackground method was called
        verify(gui).drawBackground();
    }

    @Test
    public void testDrawElementsDisplaysXeldaLabel() {
        // Create a mock GUI object
        GUI gui = mock(GUI.class);

        // Create a MainMenu object and a MenuViewer object
        MainMenu mainMenu = new MainMenu();
        MenuViewer viewer = new MenuViewer(mainMenu);

        // Call the drawElements method on the viewer
        viewer.drawElements(gui);

        // Verify that the GUI's drawText method was called with the correct parameters
        verify(gui).drawText(new Position(5, 6), "Xelda", "#FFFFFF", "#0C1E40");
    }
}