package mainFolder.controller.game;

import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterControllerTest {
    private Labyrinth labyrinth;
    private MonsterController controller;
    private Monster monster;

    @BeforeEach
    public void setUp() {
        labyrinth = new Labyrinth(30,30,1,3);
        monster = labyrinth.getMonsters().get(0);
        controller = new MonsterController(labyrinth);
    }

    /*
    @Test
    public void testStepMovesMonstersAfter500Milliseconds() {
        // Set the last movement time to 1000 milliseconds in the past
        controller.lastMovement = 1000;

        // Call the step method with a current time of 1500 milliseconds
        controller.step(null, null, 1500);

        // Verify that the monster was moved
        assertEquals(monster.getPosition(), labyrinth.getHero().getPosition().getRandomNeighbour());
        assertEquals(1500, controller.getLastMovement());
    }
    */

}