package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.WinMenu;
import mainFolder.viewer.Viewer;

public class WinMenuViewer extends Viewer<WinMenu> {

    public WinMenuViewer(WinMenu winMenu) {
        super(winMenu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 3), "YOU WIN!", "#FFFFFF", "#000000");
        gui.drawText(new Position(5, 5), getModel().stringScore(), "#FFFFFF", "#000000");

        for(int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(5, 7+i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#000000");
        }
    }
}
