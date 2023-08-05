package mainFolder.controller.menu;

import mainFolder.Start;
import mainFolder.controller.Controller;
import mainFolder.gui.GUI;
import mainFolder.model.game.labyrinth.LoaderLabyrinthBuilder;
import mainFolder.model.menu.WinMenu;
import mainFolder.states.GameState;

import java.io.IOException;

public class WinMenuController extends Controller<WinMenu> {

    public WinMenuController(WinMenu model) {
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
                if(getModel().isSelectedPlayNewGame()) game.setState(new GameState(new LoaderLabyrinthBuilder(1).createLabyrinth()));
        }
    }
}
