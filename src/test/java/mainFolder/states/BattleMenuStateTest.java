package mainFolder.states;

import mainFolder.controller.menu.BattleMenuController;
import mainFolder.gui.GUI;
import mainFolder.model.game.battle.BattleMenu;
import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;
import mainFolder.viewer.menu.BattleMenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BattleMenuStateTest {
    private BattleMenuState state;
    private BattleMenu model;
    private Hero hero;
    private Monster monster;

    @BeforeEach
    public void setup() {
        hero = new Hero( 10, 0);
        monster = new Monster( 10, 0);
        model = new BattleMenu(hero, monster, new Labyrinth(5,10,1,3));
        state = new BattleMenuState(model);
    }

    @Test
    public void testGetViewerReturnsCorrectViewer() {
        assertTrue(state.getViewer() instanceof BattleMenuViewer);
    }

    @Test
    public void testGetControllerReturnsCorrectController() {
        assertTrue(state.getController() instanceof BattleMenuController);
    }

    /*

    @Test
    public void testStepCallsCorrectMethodOnController() {
        BattleMenuController controller = mock(BattleMenuController.class);
        state.getController();

        state.step(null, GUI.ACTION.UP, 0);
        verify(controller).step(null, GUI.ACTION.UP, 0);
    }

     */
}
