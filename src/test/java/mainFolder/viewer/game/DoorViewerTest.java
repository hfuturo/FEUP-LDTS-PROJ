package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Door;
import mainFolder.viewer.game.DoorViewer;
import mainFolder.viewer.game.ElementViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DoorViewerTest {
    private GUI gui;
    private Door door;
    private DoorViewer viewer;

    @BeforeEach
    public void setUp() {
        // Create a mock GUI object
        gui = mock(GUI.class);

        // Create a Door object
        door = new Door(5, 5);

        // Create a DoorViewer object
        viewer = new DoorViewer();
    }
    @Test
    public void testDoorViewerImplementsElementViewer() {
        DoorViewer viewer = new DoorViewer();
        assertTrue(viewer instanceof ElementViewer);
    }
    @Test
    public void testDoorViewerDraw() {
        viewer.draw(door, gui);
        verify(gui).drawDoor(door.getPosition());
    }
    @Test
    public void testDoorViewerDrawException() {
        doThrow(new RuntimeException()).when(gui).drawDoor(any());
        try {
            viewer.draw(door, gui);
            fail("Expected exception to be thrown"); //if no execption is thrown, the test is set to fail
        } catch (RuntimeException e) {
            // expected behavior : execption is caught and test passes
        }
    }
}
