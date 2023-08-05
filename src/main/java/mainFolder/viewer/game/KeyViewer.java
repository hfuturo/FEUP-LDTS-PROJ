package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Key;

public class KeyViewer implements ElementViewer<Key>{
    @Override
    public void draw(Key key, GUI gui) {
        gui.drawKey(key.getPosition());
    }
}
