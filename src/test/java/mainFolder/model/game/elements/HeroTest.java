package mainFolder.model.game.elements;

import mainFolder.model.game.items.ExtraHealthPotion;
import mainFolder.model.game.items.HealthPotion;
import mainFolder.model.game.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

class HeroTest {

    private Hero hero;

    @BeforeEach
    public void helper() {
        hero = new Hero(5, 5);
    }

    @Test
    public void killedMonsterTest() {
        Assertions.assertEquals(0, hero.getScore());
        hero.killedMonster();
        Assertions.assertEquals(5, hero.getScore());
    }

    @Test
    public void getHealthTest() {
        Assertions.assertEquals(10, hero.getHealth());
    }

    @Test
    public void getMaxHealthTest() {
        Assertions.assertEquals(10, hero.getMaxHealth());
    }

    @Test
    public void increaseMaxHealthTest() {
        hero.increaseMaxHealth();
        Assertions.assertEquals(11, hero.getMaxHealth());
    }

    @Test
    public void decreaseHealthTest() {
        hero.decreaseHealth();
        Assertions.assertEquals(9, hero.getHealth());
    }

    @Test
    public void increaseHealthTest() {
        hero.increaseHealth();
        Assertions.assertEquals(11, hero.getHealth());
    }

    @Test
    public void addItemTest() {
        Assertions.assertEquals(0, hero.getInventorySize());

        Item potion = Mockito.mock(HealthPotion.class);
        hero.addItem(potion);

        Assertions.assertEquals(1, hero.getInventorySize());
    }

    @Test
    public void useItemTest() {
        Item potion = Mockito.mock(ExtraHealthPotion.class);
        Mockito.when(potion.getName()).thenReturn("Extra Health Potion");

        hero.addItem(potion);
        Assertions.assertEquals(1, hero.getInventorySize());

        hero.useItem(potion.getName());
        Assertions.assertEquals(0, hero.getInventorySize());
    }

    @Test
    public void getInventorySizeTest() {
        Assertions.assertEquals(0, hero.getInventorySize());
    }

    @Test
    public void getInventoryMaxSizeTest() {
        Assertions.assertEquals(10, hero.getInventoryMaxSize());
    }

    @Test
    public void getItemsTest() {
        List<Item> items = hero.getItems();
        Assertions.assertTrue(items.isEmpty());
        Item potion = Mockito.mock(HealthPotion.class);
        hero.addItem(potion);
        items = hero.getItems();
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals(items.get(0), potion);
    }

    @Test
    public void initBattleTest() {
        Assertions.assertFalse(hero.getBattle());
        hero.initBattle(true);
        Assertions.assertTrue(hero.getBattle());
        hero.initBattle(false);
        Assertions.assertFalse(hero.getBattle());
    }

    @Test
    public void getBattleTest() {
        Assertions.assertFalse(hero.getBattle());
    }

    @Test
    public void addScoreTest() {
        Assertions.assertEquals(0, hero.getScore());
        hero.addScore();
        Assertions.assertEquals(10, hero.getScore());
    }

    @Test
    public void getScoreTest() {
        Assertions.assertEquals(0, hero.getScore());
    }

    @Test
    public void setScoreTest() {
        Assertions.assertEquals(0, hero.getScore());
        hero.setScore(70);
        Assertions.assertEquals(70, hero.getScore());
    }

    @Test
    public void inventoryHasSpaceTest() {
        Assertions.assertTrue(hero.inventoryHasSpace());

        for(int i = 0; i < 10; i++) {
            Item potion = Mockito.mock(HealthPotion.class);
            hero.addItem(potion);
        }

        Assertions.assertFalse(hero.inventoryHasSpace());
    }

    @Test
    public void setKeyTest() {
        hero.setKey(true);
    }
}