package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Door;
import mainFolder.model.game.elements.Key;
import mainFolder.viewer.game.DoorViewer;
import mainFolder.viewer.game.ElementViewer;
import mainFolder.viewer.game.KeyViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class KeyViewerTest {
    private GUI gui;
    private Key key;
    private KeyViewer viewer;

    @BeforeEach
    public void setUp() {
        // Create a mock GUI object
        gui = mock(GUI.class);

        // Create a Door object
        key = new Key(5, 5);

        // Create a DoorViewer object
        viewer = new KeyViewer();
    }
    @Test
    public void testKeyViewerImplementsElementViewer() {
        assertTrue(viewer instanceof ElementViewer);
    }
    @Test
    public void testKeyViewerDraw() {
        viewer.draw(key, gui);
        verify(gui).drawKey(key.getPosition());
    }
    @Test
    public void testKeyViewerDrawException() {
        doThrow(new RuntimeException()).when(gui).drawKey(any());  // configure mock GUI to throw exception
        try {
            viewer.draw(key, gui);  // call draw() method
            fail("Expected exception to be thrown");  // if no exception is thrown, fail the test
        } catch (RuntimeException e) {
            // expected behavior: exception is caught and test passes
        }
    }
}
