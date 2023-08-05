package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.game.elements.Shop;
import mainFolder.model.menu.GameOverMenu;
import mainFolder.model.menu.ShopMenu;
import mainFolder.viewer.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class ShopMenuViewerTest {

    @Test
    public void testInventoryViewerExtendsViewer() {
        ShopMenu shopMenu = mock(ShopMenu.class);
        ShopMenuViewer viewer = new ShopMenuViewer(shopMenu);
        assertTrue(viewer instanceof Viewer);
    }

    @Test
    public void testInventoryViewerConstructor() {
        ShopMenu shopMenu = mock(ShopMenu.class);
        ShopMenuViewer viewer = new ShopMenuViewer(shopMenu);
        assertSame(shopMenu, viewer.getModel());
    }

    @Test
    public void testGameOverMenuViewerDrawElements() {
        GUI gui = mock(GUI.class);
        ShopMenu shopMenu = mock(ShopMenu.class);
        when(shopMenu.stringCoins()).thenReturn("Coins:100");
        when(shopMenu.stringHeroHealth()).thenReturn("Lives:7/10");
        when(shopMenu.stringInventorySpace()).thenReturn("Space:8/10");
        when(shopMenu.getNumberEntries()).thenReturn(3);
        when(shopMenu.addString(0)).thenReturn("Option 1");
        when(shopMenu.addString(1)).thenReturn("Option 2");
        when(shopMenu.addString(2)).thenReturn("Option 3");
        when(shopMenu.isSelected(0)).thenReturn(true);
        when(shopMenu.isSelected(1)).thenReturn(false);
        when(shopMenu.isSelected(2)).thenReturn(false);
        ShopMenuViewer viewer = new ShopMenuViewer(shopMenu);
        viewer.drawElements(gui);
        verify(gui).drawText(new Position(5, 2), "Shop", "#74FF00", "#000000");
        verify(gui).drawText(new Position(5, 4), "Lives:7/10", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 6), "Coins:100", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 7), "Space:8/10", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 9), "Option 1", "#FFD700", "#000000");
        verify(gui).drawText(new Position(5, 10), "Option 2", "#FFFFFF", "#000000");
        verify(gui).drawText(new Position(5, 11), "Option 3", "#FFFFFF", "#000000");
    }
}
