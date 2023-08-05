package mainFolder.states;

import mainFolder.controller.Controller;
import mainFolder.controller.menu.GameOverMenuController;
import mainFolder.model.menu.GameOverMenu;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.menu.GameOverMenuViewer;

public class GameOverMenuState extends State<GameOverMenu> {

    public GameOverMenuState(GameOverMenu model) {
        super(model);
    }

    @Override
    protected Viewer<GameOverMenu> getViewer() {
        return new GameOverMenuViewer(getModel());
    }

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverMenuController(getModel());
    }
}
