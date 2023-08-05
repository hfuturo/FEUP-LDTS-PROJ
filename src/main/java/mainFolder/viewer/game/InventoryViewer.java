package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.InventoryMenu;
import mainFolder.viewer.Viewer;

public class InventoryViewer extends Viewer<InventoryMenu> {

    public InventoryViewer(InventoryMenu inventoryMenu) {
        super(inventoryMenu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 2), "Inventory", "#FFFFFF", "#000000");
        gui.drawText(new Position(5, 4), getModel().stringHeroHealth(), "#FFFFFF", "#000000");
        gui.drawText(new Position(5, 6), getModel().stringInventorySpace(), "#FFFFFF", "#000000");

        for(int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 8+i),
                    getModel().addString(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#000000"
            );
    }
}
