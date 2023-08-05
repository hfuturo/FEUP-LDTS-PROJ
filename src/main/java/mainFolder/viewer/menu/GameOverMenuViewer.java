package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.menu.GameOverMenu;
import mainFolder.viewer.Viewer;

public class GameOverMenuViewer extends Viewer<GameOverMenu> {

    public GameOverMenuViewer(GameOverMenu gameOverMenu) {
        super(gameOverMenu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(5, 2), "Game Over", "#FFFFFF", "#000000");
        gui.drawText(new Position(5, 4), getModel().stringScore(), "#FFFFFF", "#000000");
        for(int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(
                    new Position(5, 7+i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF", "#000000");
        }
    }
}
