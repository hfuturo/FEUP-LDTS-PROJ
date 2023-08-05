package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Door;
import mainFolder.model.game.elements.Wall;

public class DoorViewer implements ElementViewer<Door> {

    @Override
    public void draw(Door door, GUI gui) {
        gui.drawDoor(door.getPosition());
    }
}
