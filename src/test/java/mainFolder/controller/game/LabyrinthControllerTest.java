package mainFolder.controller.game;

import mainFolder.Start;
import mainFolder.gui.GUI;
import mainFolder.model.game.labyrinth.Labyrinth;
import mainFolder.states.GameOverMenuState;
import mainFolder.states.InventoryState;
import mainFolder.states.ShopState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LabyrinthControllerTest {

    private LabyrinthController controller;
    private Labyrinth labyrinth;
    private GUI.ACTION action;
    private Start game;

    @BeforeEach
    public void setUp() {
        // Create a Labyrinth object
        labyrinth = mock(Labyrinth.class);

        // Create a LabyrinthController object
        controller = new LabyrinthController(labyrinth);

        // Create a mock Start object
        game = mock(Start.class);
    }

    @Test
    public void testQuitGame() throws IOException {
        // Set the action to QUIT
        action = GUI.ACTION.QUIT;

        // Call the step method on the controller
        controller.step(game, action, 0);

        // Verify that the game's setState method was called with a null argument
        verify(game).setState(null);
    }
    /*
    @Test
    public void testIsHeroDead() throws IOException {
        // Set the hero's health to 0
        when(labyrinth.getHero().getHealth()).thenReturn(0);

        // Set the action to GO_UP
        action = GUI.ACTION.GO_UP;

        // Call the step method on the controller
        controller.step(game, action, 0);

        // Verify that the game's setState method was called with the correct argument
        verify(game).setState(any(GameOverMenuState.class));
    }

    @Test
    public void testGoToInventory() throws IOException {
        // Set the action to INVENTORY
        action = GUI.ACTION.INVENTORY;

        // Call the step method on the controller
        controller.step(game, action, 0);

        // Verify that the game's setState method was called with the correct argument
        verify(game).setState(any(InventoryState.class));
    }

    @Test
    public void testGoToShopInRange() throws IOException {
        // Set the action to SHOP
        action = GUI.ACTION.SHOP;

        // Set the inRangeShop method to return true
        when(labyrinth.inRangeShop()).thenReturn(true);

        // Call the step method on the controller
        controller.step(game, action, 0);

        // Verify that the game's setState method was called with the correct argument
        verify(game).setState(any(ShopState.class));
    }

     */
}