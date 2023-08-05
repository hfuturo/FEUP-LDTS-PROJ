package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.game.elements.Coin;
import mainFolder.viewer.game.CoinViewer;
import mainFolder.viewer.game.ElementViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoinViewerTest {
    private GUI gui;
    private Coin coin;
    private CoinViewer viewer;

    @BeforeEach
    public void setUp() {
        // Create a mock GUI object
        gui = mock(GUI.class);

        // Create a Coin object
        coin = new Coin(5, 5);

        // Create a CoinViewer object
        viewer = new CoinViewer();
    }
    @Test
    public void testCoinViewerImplementsElementViewer() {
        assertTrue(viewer instanceof ElementViewer);
    }
    @Test
    public void testCoinViewerDraw() {
        viewer.draw(coin, gui);
        verify(gui).drawCoin(coin.getPosition());
    }
    @Test
    public void testCoinViewerDrawException() {
        doThrow(new RuntimeException()).when(gui).drawCoin(any());
        try {
            viewer.draw(coin, gui);
            fail("Expected exception to be thrown");
        } catch (RuntimeException e) {
            // expected behavior
        }
    }
}
