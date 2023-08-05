package mainFolder.model.game.labyrinth;

import mainFolder.model.Position;
import mainFolder.model.game.elements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

public class LoaderLabyrinthBuilderTest {

    LoaderLabyrinthBuilder loaderLabyrinthBuilder;

    @BeforeEach
    public void helper() throws IOException {
        loaderLabyrinthBuilder = new LoaderLabyrinthBuilder(1);
    }

    @Test
    public void getWidthTest() {
        //each map has a width of 31
        Assertions.assertEquals(31, loaderLabyrinthBuilder.getWidth());
    }

    @Test
    public void getHeightTest() {
        //each map has a height of 20
        Assertions.assertEquals(20, loaderLabyrinthBuilder.getHeight());
    }

    @Test
    public void getLevelTest() {
        Assertions.assertEquals(1, loaderLabyrinthBuilder.getLevel());
    }

    @Test
    public void getMaxLevelTest() {
        Assertions.assertEquals(3, loaderLabyrinthBuilder.getMaxLevel());
    }

    @Test
    public void getMapPositionTest() {
        Position position = loaderLabyrinthBuilder.getMapPosition('H');
        Assertions.assertNotNull(position);
        position = loaderLabyrinthBuilder.getMapPosition('´');
        Assertions.assertNull(position);
    }

    @Test
    public void getMapPositionsTest() {
        List<Position> positions = loaderLabyrinthBuilder.getMapPositions('#');
        Assertions.assertFalse(positions.isEmpty());
        positions = loaderLabyrinthBuilder.getMapPositions('´');
        Assertions.assertTrue(positions.isEmpty());
    }

    @Test
    public void createWallsTest() {
        List<Wall> walls = loaderLabyrinthBuilder.createWalls();
        Assertions.assertFalse(walls.isEmpty());
    }

    @Test
    public void createMonstersTest() {
        List<Monster> monsters = loaderLabyrinthBuilder.createMonsters();
        Assertions.assertFalse(monsters.isEmpty());
    }

    @Test
    public void createHeroTest() {
        Hero hero = loaderLabyrinthBuilder.createHero();
        Assertions.assertNotNull(hero);
    }

    @Test
    public void loadHeroPositionTest() {
        Position position = loaderLabyrinthBuilder.loadHeroPosition();
        Assertions.assertNotNull(position);
    }

    @Test
    public void createCoinsTest() {
        List<Coin> coins = loaderLabyrinthBuilder.createCoins();
        Assertions.assertFalse(coins.isEmpty());
    }

    @Test
    public void createDoorsTest() {
        List<Door> doors = loaderLabyrinthBuilder.createDoors();
        Assertions.assertFalse(doors.isEmpty());
    }

    @Test
    public void createShopTest() {
        Shop shop = loaderLabyrinthBuilder.createShop();
        Assertions.assertNotNull(shop);
    }

    @Test
    public void creatPortalTest() {
        Portal portal = loaderLabyrinthBuilder.createPortal();
        Assertions.assertNotNull(portal);
    }

    @Test
    public void createKeyTest() {
        Key key = loaderLabyrinthBuilder.createKey();
        Assertions.assertNotNull(key);
    }

    @Test
    public void createLabyrinthTest() {
        Labyrinth labyrinth = loaderLabyrinthBuilder.createLabyrinth();
        Assertions.assertNotNull(labyrinth);
    }

    @Test
    public void createLabyrinthSaveHeroTest() {
        Hero hero = Mockito.mock(Hero.class);
        Labyrinth labyrinth = loaderLabyrinthBuilder.createLabyrinth(hero);
        Assertions.assertNotNull(labyrinth);
    }

    @Test
    public void getLabyrinthTest() {
        Labyrinth labyrinth = Mockito.mock(Labyrinth.class);
        loaderLabyrinthBuilder.setLabyrinth(labyrinth);
        Assertions.assertSame(labyrinth, loaderLabyrinthBuilder.getLabyrinth());
    }

    @Test
    public void setLabyrinthTest() {
        Labyrinth labyrinth = Mockito.mock(Labyrinth.class);
        loaderLabyrinthBuilder.setLabyrinth(labyrinth);
        Assertions.assertSame(labyrinth, loaderLabyrinthBuilder.getLabyrinth());
    }
}
