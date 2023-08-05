package mainFolder.controller.menu;

import mainFolder.Start;
import mainFolder.controller.Controller;
import mainFolder.gui.GUI;
import mainFolder.model.game.labyrinth.LoaderLabyrinthBuilder;
import mainFolder.model.menu.GameOverMenu;
import mainFolder.states.GameState;

import java.io.IOException;

public class GameOverMenuController extends Controller<GameOverMenu> {

    public GameOverMenuController(GameOverMenu model) {
        super(model);
    }

    @Override
    public void step(Start game, GUI.ACTION action, long time) throws IOException {

        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if(getModel().isSelectedExit()) game.setState(null);
                if(getModel().isSelectedRetry()) game.setState(new GameState(new LoaderLabyrinthBuilder(1).createLabyrinth()));
        }
    }
}
