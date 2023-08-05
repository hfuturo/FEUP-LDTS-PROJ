package mainFolder.controller.menu;

import mainFolder.Start;
import mainFolder.controller.Controller;
import mainFolder.gui.GUI;
import mainFolder.model.menu.ShopMenu;
import mainFolder.states.GameState;

import java.io.IOException;

public class ShopMenuController extends Controller<ShopMenu> {

    public ShopMenuController(ShopMenu model) {
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
                if(getModel().isSelectedHealthPotion()) getModel().buyHealthPotion();
                if(getModel().isSelectedExtraHealthPotion()) getModel().buyExtraHealthPotion();
                if(getModel().isSelectedExit()) game.setState(new GameState(getModel().getLabyrinth()));
        }

    }
}
