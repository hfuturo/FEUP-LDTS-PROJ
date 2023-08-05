package mainFolder.viewer.menu;

import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.game.battle.BattleMenu;
import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;
import mainFolder.viewer.Viewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BattleMenuViewerTest {
    @Test
    public void testBattleMenuViewerExtendsViewer() {
        BattleMenu battleMenu = mock(BattleMenu.class);
        BattleMenuViewer viewer = new BattleMenuViewer(battleMenu);
        assertTrue(viewer instanceof Viewer);
    }
}