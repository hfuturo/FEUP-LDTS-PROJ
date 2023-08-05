package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.game.elements.Portal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PortalViewerTest {
    private GUI gui;
    private Portal portal;
    private PortalViewer portalViewer;

    @BeforeEach
    public void setUp() {
        gui = mock(GUI.class);
        portal = mock(Portal.class);
        portalViewer = new PortalViewer();
    }

    @Test
    public void testPortalViewerImplementsElementViewer() {
        assertTrue(portalViewer instanceof ElementViewer);
    }
    @Test
    public void testPortalViewerDraw() {
        portalViewer.draw(portal, gui);
        verify(gui).drawPortal(portal.getPosition());
    }
    @Test
    public void testPortalViewerDrawException() {
        doThrow(new RuntimeException()).when(gui).drawPortal(any());
        Portal portal = new Portal(10, 20);
        try {
            portalViewer.draw(portal, gui);
            fail("Expected exception to be thrown");
        } catch (RuntimeException e) {
            // expected behavior
        }
    }

    @Test
    public void testPortalViewerDrawNullGUI() {
        GUI gui = null;
        Portal portal = new Portal(10, 20);
        try {
            portalViewer.draw(portal, gui);
            fail("Expected exception to be thrown");
        } catch (NullPointerException e) {
            // expected behavior
        }
    }

}