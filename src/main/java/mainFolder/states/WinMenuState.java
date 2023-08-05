package mainFolder.states;

import mainFolder.controller.Controller;
import mainFolder.controller.menu.WinMenuController;
import mainFolder.model.menu.Menu;
import mainFolder.model.menu.WinMenu;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.menu.WinMenuViewer;

import java.util.Arrays;

public class WinMenuState extends State<WinMenu> {

    public WinMenuState(WinMenu model) {
        super(model);
    }

    @Override
    protected Viewer<WinMenu> getViewer() {
        return new WinMenuViewer(getModel());
    }

    @Override
    protected Controller<WinMenu> getController() {
        return new WinMenuController(getModel());
    }
}
