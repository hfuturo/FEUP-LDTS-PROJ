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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryMenuTest {

    private InventoryMenu inventoryMenu;

    Labyrinth labyrinth;

    Hero hero;

    List<Item> items;
    @BeforeEach
    public void helper() {
        hero = Mockito.mock(Hero.class);
        labyrinth = Mockito.mock(Labyrinth.class);
        items = new ArrayList<>();

        Item health = Mockito.mock(HealthPotion.class);
        Item extra = Mockito.mock(ExtraHealthPotion.class);
        Mockito.when(health.getName()).thenReturn("Health Potion");
        Mockito.when(health.getQuantity()).thenReturn(1);
        Mockito.when(extra.getName()).thenReturn("Extra Health Potion");
        Mockito.when(extra.getQuantity()).thenReturn(1);

        items.add(health);
        items.add(extra);

        inventoryMenu = new InventoryMenu(items, labyrinth);
    }

    @Test
    public void getLabyrinthTest() {
        Assertions.assertEquals(labyrinth, inventoryMenu.getLabyrinth());
    }

    @Test
    public void setLabyrinthTest() {
        Labyrinth lab = Mockito.mock(Labyrinth.class);
        Assertions.assertNotSame(lab, labyrinth);
        inventoryMenu.setLabyrinth(lab);
        Assertions.assertSame(lab, inventoryMenu.getLabyrinth());
    }

    @Test
    public void nextEntryTest() {
        inventoryMenu.nextEntry();
        Assertions.assertTrue(inventoryMenu.isSelected(1));
        inventoryMenu.nextEntry();
        Assertions.assertTrue(inventoryMenu.isSelected(2));
        inventoryMenu.nextEntry();
        Assertions.assertTrue(inventoryMenu.isSelected(0));
    }

    @Test
    public void previousEntryTest() {
        inventoryMenu.previousEntry();
        Assertions.assertTrue(inventoryMenu.isSelected(2));
        inventoryMenu.previousEntry();
        Assertions.assertTrue(inventoryMenu.isSelected(1));
        inventoryMenu.previousEntry();
        Assertions.assertTrue(inventoryMenu.isSelected(0));
    }

    @Test
    public void getEntryTest() {
        Assertions.assertEquals("Health Potion", inventoryMenu.getEntry(0));
        Assertions.assertEquals("Extra Health Potion", inventoryMenu.getEntry(1));
        Assertions.assertEquals("Exit", inventoryMenu.getEntry(2));
    }

    @Test
    public void isSelectedTest() {
        Assertions.assertTrue(inventoryMenu.isSelected(0));
        Assertions.assertFalse(inventoryMenu.isSelected(1));
    }

    @Test
    public void getNumberEntriesTest() {
        Assertions.assertEquals(3, inventoryMenu.getNumberEntries());
    }

    @Test
    public void isSelectedHealthPotionTest() {
        Assertions.assertTrue(inventoryMenu.isSelected(0));
        Assertions.assertTrue(inventoryMenu.isSelectedHealthPotion());
    }

    @Test
    public void isSelectedExtraHealthPotionTest() {
        inventoryMenu.nextEntry();
        Assertions.assertTrue(inventoryMenu.isSelected(1));
        Assertions.assertTrue(inventoryMenu.isSelectedExtraHealthPotion());
    }

    @Test
    public void isSelectedExitTest() {
        inventoryMenu.previousEntry();
        Assertions.assertTrue(inventoryMenu.isSelected(2));
        Assertions.assertTrue(inventoryMenu.isSelectedExit());
    }

    @Test
    public void useHealthPotionTest() {
        Mockito.when(labyrinth.getHero()).thenReturn(hero);
        inventoryMenu.useHealthPotion();
        Mockito.verify(labyrinth, Mockito.times(1)).getHero();
    }

    @Test
    public void useExtraHealthPotionTest() {
        Mockito.when(labyrinth.getHero()).thenReturn(hero);
        inventoryMenu.useExtraHealthPotion();
        Mockito.verify(labyrinth, Mockito.times(1)).getHero();
    }

    @Test
    public void addString() {
        int i;
        for(i = 0; i < items.size(); i++) {
            Assertions.assertEquals(items.get(i).getName() +
                            "(" +items.get(i).getQuantity() + ")"
                    , inventoryMenu.addString(i));
        }
        Assertions.assertEquals("Exit", inventoryMenu.addString(i));
    }

    @Test
    public void stringInventorySpaceTest() {
        Mockito.when(labyrinth.getHero()).thenReturn(hero);
        Mockito.when(hero.getInventorySize()).thenReturn(4);
        Mockito.when(hero.getInventoryMaxSize()).thenReturn(10);

        Assertions.assertEquals("Space:4/10", inventoryMenu.stringInventorySpace());
    }

    @Test
    public void stringHeroHealthTest() {
        Mockito.when(labyrinth.getHero()).thenReturn(hero);
        Mockito.when(hero.getHealth()).thenReturn(7);
        Mockito.when(hero.getMaxHealth()).thenReturn(10);

        Assertions.assertEquals("Lives:7/10", inventoryMenu.stringHeroHealth());
    }
}