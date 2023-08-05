package mainFolder.model.game.battle;

import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BattleMenuTest {

    private Hero hero;

    private Labyrinth labyrinth;

    private Monster monster;

    BattleMenu battleMenu;

    @BeforeEach
    public void helper() {
        hero = Mockito.mock(Hero.class);
        labyrinth = Mockito.mock(Labyrinth.class);
        monster = Mockito.mock(Monster.class);

        battleMenu = new BattleMenu(hero, monster, labyrinth);
    }

    @Test
    public void isSelectedRockTest() {
        Assertions.assertTrue(battleMenu.isSelected(0));
        Assertions.assertTrue(battleMenu.isSelectedRock());
    }

    @Test
    public void useRockTest() {
        int rock = 0;
        int paper = 0;
        int scissors = 0;
        Assertions.assertEquals(0, battleMenu.getRounds());
        Assertions.assertNull(battleMenu.getHeroMove());
        Assertions.assertNull(battleMenu.getMonsterMove());

        for(int i = 0; i < 20; i++) {
            battleMenu.useRock();
            if(battleMenu.getMonsterMove().equals("Paper"))
                paper++;
            if(battleMenu.getMonsterMove().equals("Rock"))
                rock++;
            if(battleMenu.getMonsterMove().equals("Scissors"))
                scissors++;
        }

        Assertions.assertNotNull(battleMenu.getMonsterMove());
        Assertions.assertEquals("Rock", battleMenu.getHeroMove());
        Assertions.assertEquals(20, battleMenu.getRounds());
        Assertions.assertNotEquals(0, paper);
        Assertions.assertNotEquals(0, rock);
        Assertions.assertNotEquals(0, scissors);
    }

    @Test
    public void usePaperTest() {
        int rock = 0;
        int paper = 0;
        int scissors = 0;
        Assertions.assertEquals(0, battleMenu.getRounds());
        Assertions.assertNull(battleMenu.getHeroMove());
        Assertions.assertNull(battleMenu.getMonsterMove());

        for(int i = 0; i < 20; i++) {
            battleMenu.usePaper();
            if(battleMenu.getMonsterMove().equals("Paper"))
                paper++;
            if(battleMenu.getMonsterMove().equals("Rock"))
                rock++;
            if(battleMenu.getMonsterMove().equals("Scissors"))
                scissors++;
        }

        Assertions.assertEquals("Paper", battleMenu.getHeroMove());
        Assertions.assertEquals(20, battleMenu.getRounds());
        Assertions.assertNotEquals(0, paper);
        Assertions.assertNotEquals(0, rock);
        Assertions.assertNotEquals(0, scissors);
    }

    @Test
    public void useScissorsTest() {
        int rock = 0;
        int paper = 0;
        int scissors = 0;
        Assertions.assertEquals(0, battleMenu.getRounds());
        Assertions.assertNull(battleMenu.getHeroMove());
        Assertions.assertNull(battleMenu.getMonsterMove());

        for(int i = 0; i < 20; i++) {
            battleMenu.useScissors();
            if(battleMenu.getMonsterMove().equals("Paper"))
                paper++;
            if(battleMenu.getMonsterMove().equals("Rock"))
                rock++;
            if(battleMenu.getMonsterMove().equals("Scissors"))
                scissors++;
        }

        Assertions.assertEquals("Scissors", battleMenu.getHeroMove());
        Assertions.assertEquals(20, battleMenu.getRounds());
        Assertions.assertNotEquals(0, paper);
        Assertions.assertNotEquals(0, rock);
        Assertions.assertNotEquals(0, scissors);
    }

    @Test
    public void isSelectedPaperTest() {
        battleMenu.nextEntry();
        Assertions.assertTrue(battleMenu.isSelected(1));
        Assertions.assertTrue(battleMenu.isSelectedPaper());
    }

    @Test
    public void isSelectedScissorsTest() {
        battleMenu.previousEntry();
        Assertions.assertTrue(battleMenu.isSelected(2));
        Assertions.assertTrue(battleMenu.isSelectedScissors());
    }

    @Test
    public void nextEntryTest() {
        battleMenu.nextEntry();
        Assertions.assertTrue(battleMenu.isSelected(1));
        battleMenu.nextEntry();
        Assertions.assertTrue(battleMenu.isSelected(2));
        battleMenu.nextEntry();
        Assertions.assertTrue(battleMenu.isSelected(0));
    }

    @Test
    public void previousEntryTest() {
        battleMenu.previousEntry();
        Assertions.assertTrue(battleMenu.isSelected(2));
        battleMenu.previousEntry();
        Assertions.assertTrue(battleMenu.isSelected(1));
        battleMenu.previousEntry();
        Assertions.assertTrue(battleMenu.isSelected(0));
    }

    @Test
    public void resetBattleTest() {
        Mockito.when(hero.getBattle()).thenReturn(true);
        battleMenu.setHeroMove("Rock");
        battleMenu.setMonsterMove("Paper");
        battleMenu.incrementRound();

        Assertions.assertNotNull(battleMenu.getHeroMove());
        Assertions.assertNotNull(battleMenu.getMonsterMove());
        Assertions.assertNotEquals(0, battleMenu.getRounds());

        battleMenu.resetBattle();
        Mockito.when(hero.getBattle()).thenReturn(false);

        Assertions.assertNull(battleMenu.getHeroMove());
        Assertions.assertNull(battleMenu.getMonsterMove());
        Assertions.assertEquals(0, battleMenu.getRounds());
        Assertions.assertFalse(battleMenu.hero.getBattle());
    }

    @Test
    public void getNumberEntriesTest() {
        Assertions.assertEquals(3, battleMenu.getNumberEntries());
    }

    @Test
    public void getEntryTest() {
        Assertions.assertEquals("Rock", battleMenu.getEntry(0));
    }

    @Test
    public void isSelectedTest() {
        Assertions.assertTrue(battleMenu.isSelected(0));
        Assertions.assertFalse(battleMenu.isSelected(1));
    }

    @Test
    public void randomMoveTest() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 1000; i++) {
            int random = battleMenu.randomMove();
            if (random < min)
                min = random;
            if (random > max)
                max = random;
        }
        Assertions.assertEquals(2, max);
        Assertions.assertEquals(0, min);
    }

    @Test
    public void getHeroMoveTest() {
        Assertions.assertNull(battleMenu.getHeroMove());
        battleMenu.setHeroMove("Scissors");
        Assertions.assertEquals("Scissors", battleMenu.getHeroMove());
    }

    @Test
    public void getMonsterMoveTest() {
        Assertions.assertNull(battleMenu.getMonsterMove());
        battleMenu.setMonsterMove("Paper");
        Assertions.assertEquals("Paper", battleMenu.getMonsterMove());
    }

    @Test
    public void setHeroMoveTest() {
        Assertions.assertNull(battleMenu.getHeroMove());
        battleMenu.setHeroMove("Scissors");
        Assertions.assertEquals("Scissors", battleMenu.getHeroMove());
    }

    @Test
    public void setMonsterMoveTest() {
        Assertions.assertNull(battleMenu.getMonsterMove());
        battleMenu.setMonsterMove("Paper");
        Assertions.assertEquals("Paper", battleMenu.getMonsterMove());
    }

    @Test
    public void getRoundsTest() {
        Assertions.assertEquals(0, battleMenu.getRounds());
    }

    @Test
    public void incrementRoundTest() {
        Assertions.assertEquals(0, battleMenu.getRounds());
        battleMenu.incrementRound();
        Assertions.assertEquals(1, battleMenu.getRounds());
    }
}