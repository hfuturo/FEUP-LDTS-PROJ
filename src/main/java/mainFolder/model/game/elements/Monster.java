package mainFolder.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element {

    private int health;
    public Monster(int x, int y) {
        super(x, y);
        this.health = 1;
    }

    public void decreaseHealth() {
        this.health--;
    }

    public int getHealth() {
        return health;
    }
}
