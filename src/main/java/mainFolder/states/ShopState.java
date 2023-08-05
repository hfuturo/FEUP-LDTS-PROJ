package mainFolder.states;

import mainFolder.controller.Controller;
import mainFolder.controller.menu.ShopMenuController;
import mainFolder.model.menu.ShopMenu;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.menu.ShopMenuViewer;

public class ShopState extends State<ShopMenu> {

    public ShopState(ShopMenu shop) {
        super(shop);
    }
    @Override
    protected Viewer<ShopMenu> getViewer() {
        return new ShopMenuViewer(getModel());
    }

    @Override
    protected Controller<ShopMenu> getController() {
        return new ShopMenuController(getModel());
    }
}
