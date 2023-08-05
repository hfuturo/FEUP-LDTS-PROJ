package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.game.battle.BattleMenu;
import mainFolder.viewer.Viewer;


public class BattleMenuViewer extends Viewer<BattleMenu> {

    public BattleMenuViewer(BattleMenu battleMenu) {
        super(battleMenu);
    }
    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5,2), "Battle Scene", "#fc0303", "#000000");
        for(int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(5, 4 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#000000");
        }
        gui.drawText(new Position(3,12), "Hero lives: " + getModel().getHero().getHealth(), "#a36a6a", "#000000");
        gui.drawText(new Position(3,13), "Monster lives: " + getModel().getMonster().getHealth(), "#746aa3", "#000000");

        if(getModel().getHeroMove() != null)
            gui.drawText(new Position(1,16), "Hero used " + getModel().getHeroMove(), "#a36a6a", "#000000");
        if(getModel().getMonsterMove() != null)
            gui.drawText(new Position(1,17), "Monster used " + getModel().getMonsterMove(), "#746aa3", "#000000");
        gui.drawText(new Position(20,20), "Round "+ getModel().getRounds(), "#0bfc03", "#000000");
    }
}