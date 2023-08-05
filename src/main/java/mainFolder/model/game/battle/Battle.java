package mainFolder.model.game.battle;

import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;


public class Battle {

    public Hero hero;
    public Monster monster;
    public Labyrinth labyrinth;

    public Battle(Hero hero, Monster monster, Labyrinth labyrinth) {
        this.hero = hero;
        this.monster = monster;
        this.labyrinth = labyrinth;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Monster getMonster() {
        return monster;
    }

    public Labyrinth getLabyrinth() { return labyrinth;}

    public void setLabyrinth(Labyrinth labyrinth) { this.labyrinth = labyrinth;}

}
