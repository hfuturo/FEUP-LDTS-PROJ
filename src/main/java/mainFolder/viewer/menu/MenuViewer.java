package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.MainMenu;
import mainFolder.viewer.Viewer;

public class MenuViewer extends Viewer<MainMenu> {
    public MenuViewer(MainMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawBackground();
        gui.drawXeldaMenu(getModel().getWhite(),getModel().getGreen(),getModel().getBlue(),getModel().getBrown(),getModel().getYellow());
        gui.drawBorder(getModel().getBorder());
        gui.drawText(new Position(5,6),"Xelda","#FFFFFF","#0C1E40");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 8 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#0C1E40");
    }
}
