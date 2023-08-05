package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Door;
import mainFolder.model.game.elements.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MonsterViewerTest {

    private GUI gui;
    private Monster monster;
    private MonsterViewer viewer;

    @BeforeEach
    public void setUp() {
        // Create a mock GUI object
        gui = mock(GUI.class);

        // Create a Door object
        monster = new Monster(5, 5);

        // Create a DoorViewer object
        viewer = new MonsterViewer();
    }

    @Test
    public void testMonsterViewerImplementsElementViewer() {
        assertTrue(viewer instanceof ElementViewer);
    }
    @Test
    public void testMonsterViewerDraw() {
        viewer.draw(monster, gui);
        verify(gui).drawMonster(monster.getPosition());
    }
    @Test
    public void testMonsterViewerDrawException() {
        doThrow(new RuntimeException()).when(gui).drawMonster(any());
        try {
            viewer.draw(monster, gui);
            fail("Expected exception to be thrown");
        } catch (RuntimeException e) {
            // expected behavior
        }
    }
}