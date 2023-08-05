package mainFolder.model.menu;

import java.util.Arrays;

public class WinMenu extends Menu {

    private int score;

    public WinMenu(int score) {
        super(Arrays.asList("Play New Game", "Exit"));
        this.score = score;
    }

    public boolean isSelectedPlayNewGame() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public String stringScore() {
        return "Score:" + score;
    }
}
