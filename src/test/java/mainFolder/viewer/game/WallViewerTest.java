package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WallViewerTest {
    private GUI gui;
    private Wall wall;
    private WallViewer wallViewer;

    @BeforeEach
    public void setup(){
        gui = mock(GUI.class);
        wall = mock(Wall.class);
        wallViewer = new WallViewer();
    }

    @Test
    public void testWallViewerImplementsElementViewer() {
        assertTrue(wallViewer instanceof ElementViewer);
    }
    @Test
    public void testWallViewerDraw() {
        wallViewer.draw(wall, gui);
        verify(gui).drawWall(wall.getPosition());
    }
    @Test
    public void testWallViewerDrawException() {
        doThrow(new RuntimeException()).when(gui).drawWall(any());;
        try {
            wallViewer.draw(wall, gui);
            fail("Expected exception to be thrown");
        } catch (RuntimeException e) {
            // expected behavior
        }
    }

}