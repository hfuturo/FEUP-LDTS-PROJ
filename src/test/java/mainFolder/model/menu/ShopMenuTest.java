package mainFolder.model.menu;

import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.items.ExtraHealthPotion;
import mainFolder.model.game.items.HealthPotion;
import mainFolder.model.game.items.Item;
import mainFolder.model.game.labyrinth.Labyrinth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;

public class ShopMenuTest {

    private ShopMenu shopMenu;

    private Hero hero;

    private Labyrinth labyrinth;

    private HashMap<String, Integer> shop;

    @BeforeEach
    public void helper() {
        shop = new HashMap<>();
        shop.put("Health Potion", 5);
        shop.put("Extra Health Potion", 10);

        hero = Mockito.mock(Hero.class);
        labyrinth = Mockito.mock(Labyrinth.class);

        shopMenu = new ShopMenu(shop, labyrinth, hero);
    }

    @Test
    public void getLabyrinthTest() {
        Assertions.assertEquals(labyrinth, shopMenu.getLabyrinth());
    }

    @Test
    public void isSelectedHealthPotionTest() {
        Assertions.assertTrue(shopMenu.isSelected(0));
        Assertions.assertTrue(shopMenu.isSelectedHealthPotion());
    }

    @Test
    public void buyHealthPotionTest() {
        shopMenu.buyHealthPotion();
        ShopMenu sm = Mockito.mock(ShopMenu.class);
        sm.buyHealthPotion();
        Mockito.verify(sm, Mockito.times(1)).buyHealthPotion();
    }

    @Test
    public void buyExtraHealthPotionTest() {
        shopMenu.buyExtraHealthPotion();
        ShopMenu sm = Mockito.mock(ShopMenu.class);
        sm.buyExtraHealthPotion();
        Mockito.verify(sm, Mockito.times(1)).buyExtraHealthPotion();
    }

    @Test
    public void buyPotionTest() {
        //pass
        Item potion = Mockito.mock(HealthPotion.class);
        Mockito.when(potion.getName()).thenReturn("Health Potion");
        Mockito.when(hero.getScore()).thenReturn(20);
        Mockito.when(hero.inventoryHasSpace()).thenReturn(true);
        shopMenu.buyPotion(potion);
        Mockito.verify(hero, Mockito.times(1)).addItem(potion);

        // ----------  fail -> not enough score

        Mockito.when(hero.getScore()).thenReturn(2);
        shopMenu.buyPotion(potion);
        Mockito.verify(hero, Mockito.times(1)).addItem(potion);

        // ----------  fail -> not enough space

        Mockito.when(hero.inventoryHasSpace()).thenReturn(false);
        Mockito.when(hero.getScore()).thenReturn(20);
        shopMenu.buyPotion(potion);
        Mockito.verify(hero, Mockito.times(1)).addItem(potion);
    }

    @Test
    public void isSelectedExtraHealthPotionTest() {
        shopMenu.nextEntry();
        Assertions.assertTrue(shopMenu.isSelected(1));
        Assertions.assertTrue(shopMenu.isSelectedExtraHealthPotion());
    }

    @Test
    public void isSelectedExitTest() {
        shopMenu.nextEntry();
        shopMenu.nextEntry();
        Assertions.assertTrue(shopMenu.isSelected(2));
        Assertions.assertTrue(shopMenu.isSelectedExit());
    }

    @Test
    public void addStringTest() {
        Assertions.assertEquals("Health Potion(5c)", shopMenu.addString(0));
        Assertions.assertEquals("Extra Health Potion(10c)", shopMenu.addString(1));
        Assertions.assertEquals("Exit", shopMenu.addString(2));
    }

    @Test
    public void stringCoinsTest() {
        Mockito.when(hero.getScore()).thenReturn(20);
        Assertions.assertEquals("Coins:20c", shopMenu.stringCoins());
    }

    @Test
    public void stringInventorySpaceTest() {
        Mockito.when(hero.getInventorySize()).thenReturn(3);
        Mockito.when(hero.getInventoryMaxSize()).thenReturn(10);

        Assertions.assertEquals("Inventory:3/10", shopMenu.stringInventorySpace());
    }

    @Test
    public void stringHeroHealthTest() {
        Mockito.when(hero.getHealth()).thenReturn(7);
        Mockito.when(hero.getMaxHealth()).thenReturn(10);

        Assertions.assertEquals("Lives:7/10", shopMenu.stringHeroHealth());
    }
}
