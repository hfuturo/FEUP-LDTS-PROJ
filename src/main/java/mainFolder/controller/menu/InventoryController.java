package mainFolder.controller.menu;

import mainFolder.Start;
import mainFolder.controller.Controller;
import mainFolder.gui.GUI;
import mainFolder.model.menu.InventoryMenu;
import mainFolder.states.GameState;

import java.io.IOException;

public class InventoryController extends Controller<InventoryMenu> {
    public InventoryController(InventoryMenu model) {
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
                if(getModel().isSelectedExtraHealthPotion()) getModel().useExtraHealthPotion();
                if(getModel().isSelectedHealthPotion()) getModel().useHealthPotion();
                if(getModel().isSelectedExit()) game.setState(new GameState(getModel().getLabyrinth()));
        }
    }
}
