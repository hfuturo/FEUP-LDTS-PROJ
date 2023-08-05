package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Portal;
import mainFolder.model.game.elements.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ShopViewerTest {
    private GUI gui;
    private Shop shop;
    private ShopViewer shopViewer;

    @BeforeEach
    public void setUp() {
        gui = mock(GUI.class);
        shop = mock(Shop.class);
        shopViewer = new ShopViewer();
    }
    @Test
    public void testShopViewerImplementsElementViewer() {
        assertTrue(shopViewer instanceof ElementViewer);
    }
    @Test
    public void testShopViewerDraw() {
        shopViewer.draw(shop, gui);
        verify(gui).drawShop(shop.getPosition());
    }
    @Test
    public void testShopViewerDrawException() {
        doThrow(new RuntimeException()).when(gui).drawShop(any());
        try {
            shopViewer.draw(shop, gui);
            fail("Expected exception to be thrown");
        } catch (RuntimeException e) {
            // expected behavior
        }
    }

}