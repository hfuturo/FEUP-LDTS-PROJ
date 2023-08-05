package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.GameOverMenu;
import mainFolder.model.menu.WinMenu;
import mainFolder.viewer.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class WinMenuViewerTest {

    @Test
    public void testInventoryViewerExtendsViewer() {
        WinMenu winMenu = mock(WinMenu.class);
        WinMenuViewer viewer = new WinMenuViewer(winMenu);
        assertTrue(viewer instanceof Viewer);
    }

    @Test
    public void testInventoryViewerConstructor() {
        WinMenu winMenu = mock(WinMenu.class);
        WinMenuViewer viewer = new WinMenuViewer(winMenu);
        assertSame(winMenu, viewer.getModel());
    }

    @Test
    public void testGameOverMenuViewerDrawElements() {
        GUI gui = mock(GUI.class);
        WinMenu winMenu = mock(WinMenu.class);
        when(winMenu.stringScore()).thenReturn("Your score was: 100");
        when(winMenu.getNumberEntries()).thenReturn(2);
        when(winMenu.getEntry(0)).thenReturn("Option 1");
        when(winMenu.getEntry(1)).thenReturn("Option 2");
        when(winMenu.isSelected(0)).thenReturn(true);
        when(winMenu.isSelected(1)).thenReturn(false);
        WinMenuViewer viewer = new WinMenuViewer(winMenu);
        viewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 3), "YOU WIN!", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 5), "Your score was: 100", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 7), "Option 1", "#FFD700", "#000000");
        verify(gui).drawText(new Position(5, 8), "Option 2", "#FFFFFF", "#000000");
    }
}
