package mainFolder.model.menu;

import com.sun.tools.javac.Main;
import mainFolder.model.Position;

import java.util.List;

public abstract class MenuBuilder {

    public MainMenu createMenu(){
        MainMenu mainMenu = new MainMenu();
        fillMenu(mainMenu);
        return mainMenu;
    }

    private void fillMenu(MainMenu mainMenu) {
        mainMenu.setWhite(createWhite());
        mainMenu.setBlue(createBlue());
        mainMenu.setBrown(createBrown());
        mainMenu.setGreen(createGreen());
        mainMenu.setBorder(createBorder());
        mainMenu.setYellow(createYellow());
    }

    protected abstract List<Position> createWhite();
    protected abstract List<Position> createBlue();
    protected abstract List<Position> createBrown();
    protected abstract List<Position> createGreen();
    protected abstract List<Position> createBorder();
    protected abstract List<Position> createYellow();

}
