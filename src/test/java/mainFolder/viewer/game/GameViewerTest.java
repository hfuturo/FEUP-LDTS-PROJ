package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Coin;
import mainFolder.model.game.elements.Door;
import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Key;
import mainFolder.model.game.labyrinth.Labyrinth;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.text.View;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameViewerTest {

    private GUI gui;
    private Labyrinth labyrinth;
    private GameViewer gameViewer;

    @BeforeEach
    public void setUp() {
        gui = mock(GUI.class);
        labyrinth = mock(Labyrinth.class);
        gameViewer = new GameViewer(labyrinth);
    }
    @Test
    public void testGameViewerExtendsViewer() {
        assertTrue(gameViewer instanceof GameViewer);
    }
    @Test
    public void testGameViewerConstructor() {
        assertSame(labyrinth, gameViewer.getModel());
    }
    @Test
    public void testGameViewerDrawElements() {
        GUI gui = mock(GUI.class);
        Labyrinth labyrinth = mock(Labyrinth.class);
        GameViewer viewer = new GameViewer(labyrinth);

        List<Coin> coins = Arrays.asList(new Coin(0, 0), new Coin(1, 1));
        when(labyrinth.getCoins()).thenReturn(coins);
        viewer.drawElements(gui, coins, new CoinViewer());
        Mockito.verify(gui, times(2)).drawCoin(any());

        List<Door> doors = Arrays.asList(new Door(2, 2), new Door(3, 3));
        when(labyrinth.getDoors()).thenReturn(doors);
        viewer.drawElements(gui, doors, new DoorViewer());
        Mockito.verify(gui, times(2)).drawDoor(any());
    }
    @Test
    public void testGameViewerDrawElement() {
        GUI gui = mock(GUI.class);
        Labyrinth labyrinth = mock(Labyrinth.class);
        GameViewer viewer = new GameViewer(labyrinth);

        Hero hero = new Hero(0, 0);
        when(labyrinth.getHero()).thenReturn(hero);
        viewer.drawElement(gui, hero, new HeroViewer());
        verify(gui).drawHero(any());

        Key key = new Key(1, 1);
        when(labyrinth.getKey()).thenReturn(key);
        viewer.drawElement(gui, key, new KeyViewer());
        verify(gui).drawKey(any());
    }
}