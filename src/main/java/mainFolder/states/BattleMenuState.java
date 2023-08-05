package mainFolder.states;


import mainFolder.controller.Controller;
import mainFolder.controller.menu.BattleMenuController;
import mainFolder.model.game.battle.BattleMenu;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.menu.BattleMenuViewer;

public class BattleMenuState extends State<BattleMenu>{

    public BattleMenuState(BattleMenu model) {
        super(model);
    }

    @Override
    protected Viewer<BattleMenu> getViewer() {
        return new BattleMenuViewer(getModel());
    }

    @Override
    protected Controller<BattleMenu> getController() {
        return new BattleMenuController(getModel());
    }
}