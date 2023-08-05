package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.InventoryMenu;
import mainFolder.viewer.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InventoryViewerTest {

    @Test
    public void testInventoryViewerExtendsViewer() {
        InventoryMenu inventoryMenu = mock(InventoryMenu.class);
        InventoryViewer viewer = new InventoryViewer(inventoryMenu);
        assertTrue(viewer instanceof Viewer);
    }

    @Test
    public void testInventoryViewerConstructor() {
        InventoryMenu inventoryMenu = mock(InventoryMenu.class);
        InventoryViewer viewer = new InventoryViewer(inventoryMenu);
        assertSame(inventoryMenu, viewer.getModel());
    }

    @Test
    public void testInventoryViewerDrawElements() {
        GUI gui = mock(GUI.class);
        InventoryMenu inventoryMenu = mock(InventoryMenu.class);
        InventoryViewer viewer = new InventoryViewer(inventoryMenu);

        when(inventoryMenu.stringHeroHealth()).thenReturn("Health: 10/10");
        when(inventoryMenu.stringInventorySpace()).thenReturn("Inventory space: 5/5");
        when(inventoryMenu.getNumberEntries()).thenReturn(3);
        when(inventoryMenu.addString(0)).thenReturn("Item 1");
        when(inventoryMenu.addString(1)).thenReturn("Item 2");
        when(inventoryMenu.addString(2)).thenReturn("Item 3");
        when(inventoryMenu.isSelected(0)).thenReturn(true);
        when(inventoryMenu.isSelected(1)).thenReturn(false);
        when(inventoryMenu.isSelected(2)).thenReturn(true);
        when(inventoryMenu.addString(0)).thenReturn("Potion (1)");
        when(inventoryMenu.isSelected(0)).thenReturn(true);
        when(inventoryMenu.addString(1)).thenReturn("Key (1)");
        when(inventoryMenu.isSelected(1)).thenReturn(false);
        when(inventoryMenu.addString(2)).thenReturn("Shield (1)");
        when(inventoryMenu.isSelected(2)).thenReturn(false);

        viewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 2), "Inventory", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 4), "Health: 10/10", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 6), "Inventory space: 5/5", "#FFFFFF", "#000000");
    }
}