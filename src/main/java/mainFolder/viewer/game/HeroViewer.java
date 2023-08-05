package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero>{
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
