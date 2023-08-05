package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Portal;

public class PortalViewer implements ElementViewer<Portal> {

    @Override
    public void draw(Portal portal, GUI gui) {
        gui.drawPortal(portal.getPosition());
    }
}
