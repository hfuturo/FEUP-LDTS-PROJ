package mainFolder.states;

import mainFolder.controller.Controller;
import mainFolder.controller.menu.InventoryController;
import mainFolder.model.menu.InventoryMenu;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.game.InventoryViewer;

public class InventoryState extends State<InventoryMenu> {
    public InventoryState(InventoryMenu model) {
        super(model);
    }

    @Override
    protected Viewer<InventoryMenu> getViewer() {
        return new InventoryViewer(getModel());
    }

    @Override
    protected Controller<InventoryMenu> getController() {
        return new InventoryController(getModel());
    }
}
