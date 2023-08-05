package mainFolder.controller.game;

import mainFolder.Start;
import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.game.Inventory;
import mainFolder.model.game.labyrinth.Labyrinth;

public class HeroController extends GameController{
    public HeroController(Labyrinth labyrinth) {
        super(labyrinth);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().canHeroMove(position)) {
            getModel().getHero().setPosition(position);

            if (getModel().isMonster(position)) {
                getModel().getHero().initBattle(true);
                getModel().createBattle(getModel().getHero(), getModel().getMonster(position));
            }

            if(getModel().isCoins(position)) {
                getModel().getHero().addScore();
                getModel().collectCoins(position);
            }

            if(getModel().isKey(position)) {
                getModel().getHero().setKey(true);
                getModel().openDoors();
                getModel().setKey(null);

            }
        }
    }

    @Override
    public void step(Start game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
    }

}
