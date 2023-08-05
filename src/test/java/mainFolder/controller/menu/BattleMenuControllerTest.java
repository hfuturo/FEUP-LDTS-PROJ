package mainFolder.controller.game.menu;

import mainFolder.Start;
import mainFolder.controller.menu.BattleMenuController;
import mainFolder.gui.GUI;
import mainFolder.model.game.battle.BattleMenu;
import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BattleMenuControllerTest {
    private BattleMenuController controller;
    private BattleMenu model;
    private Start game;

    @BeforeEach
    public void setUp() {
        // Create a mock BattleMenu object
        model = mock(BattleMenu.class);

        // Create a BattleMenuController object with the mock BattleMenu object
        controller = new BattleMenuController(model);

        // Create a mock Start object
        game = mock(Start.class);
    }

    @Test
    public void testHeroWin() {
        // Set up the mock BattleMenu object to return a mock Hero and Monster
        Hero hero = mock(Hero.class);
        Monster monster = mock(Monster.class);
        when(model.getHero()).thenReturn(hero);
        when(model.getMonster()).thenReturn(monster);

        // Set up the mock Hero object to return a score of 100
        when(hero.getScore()).thenReturn(100);

        // Set up the mock Labyrinth object to return the mock Monster object
        Labyrinth labyrinth = mock(Labyrinth.class);
        when(model.getLabyrinth()).thenReturn(labyrinth);

        // Call the heroWin method on the controller
        controller.heroWin(game);

        // Verify that the heroWin method called the removeMonster and killedMonster methods on the mock Labyrinth and Hero objects, respectively
        verify(labyrinth).removeMonster(monster.getPosition());
        verify(hero).killedMonster();
    }
    /*
    @Test
    public void testStepHandlesSelectAction() throws IOException {
        // Set up the mock BattleMenu object to return true when the isSelectedRock, isSelectedPaper, and isSelectedScissors methods are called
        when(model.isSelectedRock()).thenReturn(true);
        when(model.isSelectedPaper()).thenReturn(true);
        when(model.isSelectedScissors()).thenReturn(true);

        // Call the step method on the controller with the SELECT action
        controller.step(game, GUI.ACTION.SELECT, 0);

        // Verify that the step method called the useRock, usePaper, and useScissors methods on the mock BattleMenu object
        verify(model).useRock();
        verify(model).usePaper();
        verify(model).useScissors();
    }

     */
}