package mainFolder.controller.menu;

import mainFolder.Start;
import mainFolder.gui.GUI;
import mainFolder.model.game.labyrinth.LoaderLabyrinthBuilder;
import mainFolder.model.menu.GameOverMenu;
import mainFolder.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class GameOverMenuControllerTest {
    private GameOverMenu model;
    private Start game;
    private GameOverMenuController controller;

    @BeforeEach
    public void setUp() {
        // Create mock objects for the model, game, and controller
        model = Mockito.mock(GameOverMenu.class);
        game = Mockito.mock(Start.class);
        controller = new GameOverMenuController(model);
    }

    @Test
    public void testStepHandlesUpAction() throws IOException {
        // Call the step method on the controller with the UP action
        controller.step(game, GUI.ACTION.UP, 0);

        // Verify that the step method called the previousEntry method on the mock GameOverMenu object
        verify(model).previousEntry();
    }

    @Test
    public void testStepHandlesDownAction() throws IOException {
        // Call the step method on the controller with the DOWN action
        controller.step(game, GUI.ACTION.DOWN, 0);

        // Verify that the step method called the nextEntry method on the mock GameOverMenu object
        verify(model).nextEntry();
    }
}