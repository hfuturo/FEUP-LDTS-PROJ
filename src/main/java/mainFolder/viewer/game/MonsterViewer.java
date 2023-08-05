package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Monster;

public class MonsterViewer implements ElementViewer<Monster>{
    public void draw(Monster monster, GUI gui) {
        gui.drawMonster(monster.getPosition());
    }
}
