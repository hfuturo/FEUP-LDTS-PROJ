package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.GameOverMenu;
import mainFolder.model.menu.InventoryMenu;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.game.InventoryViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameOverMenuViewerTest {
    @Test
    public void testInventoryViewerExtendsViewer() {
        GameOverMenu gameOverMenu = mock(GameOverMenu.class);
        GameOverMenuViewer viewer = new GameOverMenuViewer(gameOverMenu);
        assertTrue(viewer instanceof Viewer);
    }

    @Test
    public void testInventoryViewerConstructor() {
        GameOverMenu gameOverMenu = mock(GameOverMenu.class);
        GameOverMenuViewer viewer = new GameOverMenuViewer(gameOverMenu);
        assertSame(gameOverMenu, viewer.getModel());
    }
    @Test
    public void testGameOverMenuViewerDrawElements() {
        GUI gui = mock(GUI.class);
        GameOverMenu gameOverMenu = mock(GameOverMenu.class);
        when(gameOverMenu.stringScore()).thenReturn("Your score was: 100");
        when(gameOverMenu.getNumberEntries()).thenReturn(2);
        when(gameOverMenu.getEntry(0)).thenReturn("Option 1");
        when(gameOverMenu.getEntry(1)).thenReturn("Option 2");
        when(gameOverMenu.isSelected(0)).thenReturn(true);
        when(gameOverMenu.isSelected(1)).thenReturn(false);
        GameOverMenuViewer viewer = new GameOverMenuViewer(gameOverMenu);
        viewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 2), "Game Over", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 4), "Your score was: 100", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 7), "Option 1", "#FFD700", "#000000");
        verify(gui).drawText(new Position(5, 8), "Option 2", "#FFFFFF", "#000000");
    }
}