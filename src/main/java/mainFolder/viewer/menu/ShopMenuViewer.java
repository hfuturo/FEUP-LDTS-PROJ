package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.ShopMenu;
import mainFolder.viewer.Viewer;

public class ShopMenuViewer extends Viewer<ShopMenu> {
    public ShopMenuViewer(ShopMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5,2), "Shop", "#74FF00", "#000000");
        gui.drawText(new Position(5, 4), getModel().stringHeroHealth(), "#FFFFFF", "#000000");
        gui.drawText(new Position(5,6), getModel().stringCoins(), "#FFFFFF", "#000000");
        gui.drawText(new Position(5,7), getModel().stringInventorySpace(), "#FFFFFF", "#000000");

        for(int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(5,9+i),
                    getModel().addString(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#000000");
        }
    }
}
