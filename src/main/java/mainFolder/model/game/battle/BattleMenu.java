package mainFolder.model.game.battle;

import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BattleMenu extends Battle{

    private int currentEntry = 0;

    private int rounds;

    private String heroMove;
    private String monsterMove;

    private final List<String> entries = Arrays.asList("Rock", "Paper", "Scissors");

    public BattleMenu(Hero hero, Monster monster, Labyrinth labyrinth) {
        super(hero, monster, labyrinth);
    }

    public boolean isSelectedRock() {
        return isSelected(0);
    }

    public void useRock() {
        incrementRound();
        int monsterMove = randomMove();
        this.heroMove = "Rock";

        if(entries.get(monsterMove).equals("Paper")) {
            hero.decreaseHealth();
            setMonsterMove("Paper");
        }
        if(entries.get(monsterMove).equals("Scissors")) {
            monster.decreaseHealth();
            setMonsterMove("Scissors");
        }
        if(entries.get(monsterMove).equals("Rock"))
            setMonsterMove("Rock");
    }

    public void usePaper() {
        incrementRound();
        int monsterMove = randomMove();
        setHeroMove("Paper");

        if(entries.get(monsterMove).equals("Rock")) {
            monster.decreaseHealth();
            setMonsterMove("Rock");
        }
        if(entries.get(monsterMove).equals("Scissors")) {
            hero.decreaseHealth();
            setMonsterMove("Scissors");
        }
        if(entries.get(monsterMove).equals("Paper"))
            setMonsterMove("Paper");
    }

    public void useScissors() {
        incrementRound();
        int monsterMove = randomMove();
        setHeroMove("Scissors");

        if(entries.get(monsterMove).equals("Paper")) {
            monster.decreaseHealth();
            setMonsterMove("Paper");
        }
        if(entries.get(monsterMove).equals("Rock")) {
            hero.decreaseHealth();
            setMonsterMove("Rock");
        }
        if(entries.get(monsterMove).equals("Scissors"))
            setMonsterMove("Scissors");
    }

    public boolean isSelectedPaper() {
        return isSelected(1);
    }

    public boolean isSelectedScissors() {
        return isSelected(2);
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = entries.size() - 1;
    }

    public void resetBattle() {
        heroMove = null;
        monsterMove = null;
        rounds = 0;
        hero.initBattle(false);
    }

    public int getNumberEntries() {
        return entries.size();
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int randomMove() {
        return new Random().nextInt(entries.size());
    }

    public String getHeroMove() {
        return heroMove;
    }

    public String getMonsterMove() {
        return monsterMove;
    }

    public void setHeroMove(String string) {
        this.heroMove = string;
    }

    public void setMonsterMove(String string) {
        this.monsterMove = string;
    }

    public int getRounds() {return rounds;}

    public void incrementRound() {
        rounds+=1;
    }
}