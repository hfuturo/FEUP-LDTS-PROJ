package mainFolder.controller.game;

import mainFolder.Start;
import mainFolder.model.Position;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;
import mainFolder.gui.GUI;

import java.io.IOException;

public class MonsterController extends GameController {
    private long lastMovement;

    public MonsterController(Labyrinth labyrinth) {
        super(labyrinth);

        this.lastMovement = 0;
    }
    public long getLastMovement() {
        return lastMovement;
    }

    @Override
    public void step(Start game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            for (Monster monster : getModel().getMonsters()) {
                moveMonster(monster, monster.getPosition().getRandomNeighbour());
            }
            this.lastMovement = time;
        }
    }

    private void initBattle(Monster monster) {
        getModel().getHero().initBattle(true);
        getModel().createBattle(getModel().getHero(), monster);
    }

    private void moveMonster(Monster monster, Position position) {
        if (getModel().canHeroMove(position)) {
            monster.setPosition(position);
            if (getModel().getHero().getPosition().equals(position))
                initBattle(monster);
        }
    }
}
