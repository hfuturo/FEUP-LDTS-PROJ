package mainFolder.states;

import mainFolder.controller.Controller;
import mainFolder.controller.menu.MenuController;
import mainFolder.model.menu.MainMenu;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.menu.MenuViewer;

public class MenuState extends State<MainMenu>{
    public MenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MenuController(getModel());
    }
}
