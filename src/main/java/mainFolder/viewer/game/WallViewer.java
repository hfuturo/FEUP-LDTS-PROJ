package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall>{
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
