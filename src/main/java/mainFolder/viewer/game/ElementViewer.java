package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Element;

public interface ElementViewer<T extends Element> {

    void draw(T element, GUI gui);
}
