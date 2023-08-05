package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.game.elements.Door;
import mainFolder.model.game.elements.Element;
import mainFolder.model.game.labyrinth.Labyrinth;
import mainFolder.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Labyrinth> {
    public GameViewer(Labyrinth labyrinth) {
        super(labyrinth);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());
        drawElements(gui, getModel().getCoins(),new CoinViewer());
        drawElement(gui, getModel().getShop(), new ShopViewer());
        drawElement(gui, getModel().getPortal(), new PortalViewer());
        drawElements(gui, getModel().getDoors(), new DoorViewer());
        if(getModel().getKey() != null)
            drawElement(gui, getModel().getKey(), new KeyViewer());

        gui.drawText(new Position(0, 0), "Lives:" + getModel().getHero().getHealth() + "/" + getModel().getHero().getMaxHealth(), "#FFFFFF", "#323232");
        gui.drawText(new Position(13,0),"Score:" + getModel().getHero().getScore(),"#FFFFFF", "#323232");
        gui.drawText(new Position(22, 0), "Level:" + getModel().getLevel() + "/" + getModel().getMaxLevel(), "#FFFFFF", "#323232");
    }

    public <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    public <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
