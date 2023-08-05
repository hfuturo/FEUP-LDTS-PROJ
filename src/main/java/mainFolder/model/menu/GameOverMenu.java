package mainFolder.model.menu;

import java.util.Arrays;

public class GameOverMenu extends Menu {

    private int score;
    public GameOverMenu(int score) {
        super(Arrays.asList("Retry", "Exit"));
        this.score = score;
    }

    public boolean isSelectedRetry() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public String stringScore() {
        return "Score:" + score;
    }
}
