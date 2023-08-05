package mainFolder.model.game.labyrinth;

import mainFolder.model.Position;
import mainFolder.model.game.elements.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LabyrinthTest {
    Labyrinth labyrinth;

    @BeforeEach
    public void helper() {
        labyrinth = new Labyrinth(20, 10, 1, 3);
    }

    @Test
    public void getLevelTest() {
        Assertions.assertEquals(1, labyrinth.getLevel());
    }

    @Test
    public void getMaxLevel() {
        Assertions.assertEquals(3, labyrinth.getMaxLevel());
    }

    @Test
    public void getPortalTest() {
        Portal portal = new Portal(5, 5);
        labyrinth.setPortal(portal);
        Assertions.assertEquals(portal, labyrinth.getPortal());
    }

    @Test
    public void setPortalTest() {
        Portal portal = new Portal(1, 1);
        labyrinth.setPortal(portal);
        Assertions.assertEquals(portal, labyrinth.getPortal());
        Portal p = new Portal(2, 2);
        labyrinth.setPortal(p);
        Assertions.assertEquals(p, labyrinth.getPortal());
    }

    @Test
    public void getShopTest() {
        Shop shop = new Shop(5, 5);
        labyrinth.setShop(shop);
        Assertions.assertEquals(shop, labyrinth.getShop());
    }

    @Test
    public void setShopTest() {
        Shop shop = new Shop(1, 1);
        labyrinth.setShop(shop);
        Assertions.assertEquals(shop, labyrinth.getShop());
        Shop s = new Shop(2, 2);
        labyrinth.setShop(s);
        Assertions.assertEquals(s, labyrinth.getShop());
    }

    @Test
    public void canHeroMoveTest() {
        List<Door> doors = new ArrayList<>();
        List<Wall> walls = new ArrayList<>();
        Position position = Mockito.mock(Position.class);
        Position doorPosition = Mockito.mock(Position.class);
        Position wallPosition = Mockito.mock(Position.class);
        Position shopPosition = Mockito.mock(Position.class);
        Shop shop = Mockito.mock(Shop.class);
        Door door = Mockito.mock(Door.class);
        Wall wall = Mockito.mock(Wall.class);
        doors.add(door);
        walls.add(wall);

        labyrinth.setShop(shop);
        labyrinth.setDoors(doors);
        labyrinth.setWalls(walls);
        Mockito.when(door.getPosition()).thenReturn(doorPosition);
        Mockito.when(wall.getPosition()).thenReturn(wallPosition);
        Mockito.when(shop.getPosition()).thenReturn(shopPosition);

        Assertions.assertTrue(labyrinth.canHeroMove(position));
        Assertions.assertFalse(labyrinth.canHeroMove(wallPosition));
        Assertions.assertFalse(labyrinth.canHeroMove(doorPosition));
        Assertions.assertFalse(labyrinth.canHeroMove(shopPosition));
    }

    @Test
    public void getHeroTest() {
        Hero hero = new Hero(5, 5);
        labyrinth.setHero(hero);
        Assertions.assertEquals(hero, labyrinth.getHero());
    }

    @Test
    public void setHeroTest() {
        Hero hero = new Hero(1, 1);
        labyrinth.setHero(hero);
        Assertions.assertEquals(hero, labyrinth.getHero());
        Hero h = new Hero(2, 2);
        labyrinth.setHero(h);
        Assertions.assertEquals(h, labyrinth.getHero());
    }

    @Test
    public void inRangeShopTest() {
        Shop shop = Mockito.mock(Shop.class);
        Hero hero = Mockito.mock(Hero.class);
        Position heroPosition = Mockito.mock(Position.class);
        Position shopPosition = Mockito.mock(Position.class);
        Mockito.when(shop.getPosition()).thenReturn(shopPosition);
        Mockito.when(shopPosition.getX()).thenReturn(0);
        Mockito.when(shopPosition.getY()).thenReturn(0);
        labyrinth.setShop(shop);

        Mockito.when(hero.getPosition()).thenReturn(heroPosition);
        Mockito.when(heroPosition.getX()).thenReturn(1);
        Mockito.when(heroPosition.getY()).thenReturn(1);
        labyrinth.setHero(hero);
        Assertions.assertTrue(labyrinth.inRangeShop());

        Mockito.when(heroPosition.getX()).thenReturn(2);
        Mockito.when(heroPosition.getY()).thenReturn(2);
        labyrinth.setHero(hero);
        Assertions.assertFalse(labyrinth.inRangeShop());
    }

    @Test
    public void getMonstersTest() {
        Assertions.assertNull(labyrinth.getMonsters());
    }

    @Test
    public void getWallsTest() {
        Assertions.assertNotNull(labyrinth.getWalls());
    }

    @Test
    public void isMonsterTest() {
        List<Monster> monsters = new ArrayList<>();
        Monster monster = Mockito.mock(Monster.class);
        Position monsterPosition = Mockito.mock(Position.class);
        Position position = Mockito.mock(Position.class);
        monsters.add(monster);

        labyrinth.setMonsters(monsters);
        Mockito.when(monster.getPosition()).thenReturn(monsterPosition);

        Assertions.assertFalse(labyrinth.isMonster(position));
        Assertions.assertTrue(labyrinth.isMonster(monsterPosition));
    }

    @Test
    public void getMonsterTest() {
        List<Monster> monsters = new ArrayList<>();
        Monster monster = Mockito.mock(Monster.class);
        Position monsterPosition = Mockito.mock(Position.class);
        Position position = Mockito.mock(Position.class);
        monsters.add(monster);

        labyrinth.setMonsters(monsters);
        Mockito.when(monster.getPosition()).thenReturn(monsterPosition);

        Assertions.assertNull(labyrinth.getMonster(position));
        Assertions.assertEquals(monster, labyrinth.getMonster(monsterPosition));
    }


    @Test
    public void removeMonsterTest() {
        List<Monster> monsters = new ArrayList<>();
        Monster monster = Mockito.mock(Monster.class);
        Position monsterPosition = Mockito.mock(Position.class);
        Position position = Mockito.mock(Position.class);
        monsters.add(monster);

        labyrinth.setMonsters(monsters);
        Mockito.when(monster.getPosition()).thenReturn(monsterPosition);

        labyrinth.removeMonster(position);
        Assertions.assertEquals(1, labyrinth.getMonsters().size());
        labyrinth.removeMonster(monsterPosition);
        Assertions.assertEquals(0, labyrinth.getMonsters().size());
    }

    @Test
    public void openDoorsTest() {
        List<Door> doors = new ArrayList<>();
        Door door = Mockito.mock(Door.class);
        doors.add(door);
        labyrinth.setDoors(doors);

        Assertions.assertEquals(1, labyrinth.getDoors().size());
        labyrinth.openDoors();
        Assertions.assertEquals(0, labyrinth.getDoors().size());
    }

    @Test
    public void getDoorsTest() {
        List<Door> doors = new ArrayList<>();
        Door door = Mockito.mock(Door.class);
        doors.add(door);
        labyrinth.setDoors(doors);
        Assertions.assertEquals(1, labyrinth.getDoors().size());
    }

    @Test
    public void setDoorsTest() {
        List<Door> doors = new ArrayList<>();
        Door door = Mockito.mock(Door.class);
        doors.add(door);
        labyrinth.setDoors(doors);
        Assertions.assertEquals(1, labyrinth.getDoors().size());
    }

    @Test
    public void getCoinsTest() {
        List<Coin> coins = new ArrayList<>();
        Coin coin = Mockito.mock(Coin.class);
        coins.add(coin);
        labyrinth.setCoins(coins);
        Assertions.assertEquals(1, labyrinth.getCoins().size());
    }

    @Test
    public void setCoinsTest() {
        List<Coin> coins = new ArrayList<>();
        Coin coin = Mockito.mock(Coin.class);
        coins.add(coin);
        labyrinth.setCoins(coins);
        Assertions.assertEquals(1, labyrinth.getCoins().size());
    }

    @Test
    public void isCoinsTest() {
        List<Coin> coins = new ArrayList<>();
        Coin coin = Mockito.mock(Coin.class);
        Position position = Mockito.mock(Position.class);
        Position coinPosition = Mockito.mock(Position.class);
        coins.add(coin);
        labyrinth.setCoins(coins);

        Mockito.when(coin.getPosition()).thenReturn(coinPosition);

        Assertions.assertTrue(labyrinth.isCoins(coinPosition));
        Assertions.assertFalse(labyrinth.isCoins(position));
    }

    @Test
    public void collectCoinsTest() {
        List<Coin> coins = new ArrayList<>();
        Coin coin = Mockito.mock(Coin.class);
        Position coinPosition = Mockito.mock(Position.class);
        Position position = Mockito.mock(Position.class);
        coins.add(coin);

        labyrinth.setCoins(coins);
        Mockito.when(coin.getPosition()).thenReturn(coinPosition);
        Assertions.assertEquals(1, labyrinth.collectCoins(position).size());
        Assertions.assertTrue(labyrinth.collectCoins(coinPosition).isEmpty());
    }

    @Test
    public void getKeyTest() {
        Key key = Mockito.mock(Key.class);
        labyrinth.setKey(key);
        Assertions.assertEquals(key, labyrinth.getKey());
    }

    @Test
    public void setKeyTest() {
        Key key = Mockito.mock(Key.class);
        labyrinth.setKey(key);
        Assertions.assertEquals(key, labyrinth.getKey());
    }

    @Test
    public void isKeyTest() {
        Key key = Mockito.mock(Key.class);
        Position keyPosition = Mockito.mock(Position.class);
        Position position = Mockito.mock(Position.class);
        Mockito.when(key.getPosition()).thenReturn(keyPosition);

        labyrinth.setKey(null);
        Assertions.assertFalse(labyrinth.isKey(position));
        labyrinth.setKey(key);
        Assertions.assertFalse(labyrinth.isKey(position));
        Assertions.assertTrue(labyrinth.isKey(keyPosition));
    }

    @Test
    public void createBattleTest() {
        Hero hero = Mockito.mock(Hero.class);
        Monster monster = Mockito.mock(Monster.class);

        labyrinth.createBattle(hero, monster);
    }
}
