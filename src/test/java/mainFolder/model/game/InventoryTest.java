package mainFolder.model.game;

import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.items.ExtraHealthPotion;
import mainFolder.model.game.items.HealthPotion;
import mainFolder.model.game.items.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryTest {

    private Inventory inventory;

    private Item item;

    private Item healthPotion;

    private Item extraPotion;

    private Hero hero;
    @BeforeEach
    public void helper() {
        hero = Mockito.mock(Hero.class);
        item = Mockito.mock(Item.class);
        healthPotion = Mockito.mock(HealthPotion.class);
        extraPotion = Mockito.mock(ExtraHealthPotion.class);
        inventory = new Inventory(hero);
    }

    @Test
    public void hasSpaceTest() {
        Assertions.assertTrue(inventory.hasSpace());

        for(int i = 0; i < 5; i++) {
            inventory.addItem(item);
        }

        Assertions.assertTrue(inventory.hasSpace());

        for(int i = 0; i < 4; i++) {
            inventory.addItem(item);
        }

        Assertions.assertTrue(inventory.hasSpace());
    }

    @Test
    public void getSizeTest() {
        Assertions.assertEquals(0, inventory.getSize());
        inventory.addItem(item);
        Assertions.assertEquals(1, inventory.getSize());
    }

    @Test
    public void getMaxSizeTest() {
        Assertions.assertEquals(10, inventory.getMaxSize());
    }


    @Test
    public void addItemTest() {
        inventory.addItem(healthPotion);
        Assertions.assertEquals(1, inventory.getSize());

        inventory.addItem(extraPotion);
        Assertions.assertEquals(2, inventory.getSize());

        for(int i = 0; i < 7; i++) {
            inventory.addItem(healthPotion);
        }
        Assertions.assertEquals(9, inventory.getSize());

        inventory.addItem(extraPotion);
        Assertions.assertEquals(10, inventory.getSize());

        inventory.addItem(extraPotion);
        Assertions.assertEquals(10, inventory.getSize());
    }


    @Test
    public void addExistingItemTest() {
        inventory.addItem(healthPotion);
        Item newHealthPotion = new HealthPotion(hero);

        inventory.addExistingItem(newHealthPotion);
        Mockito.when(healthPotion.getQuantity()).thenReturn(2);

        Assertions.assertEquals(2, healthPotion.getQuantity());
    }


    //TODO: VERIFICAR SE ESTA BEM
    @Test
    public void addNewItemTest() {
        inventory.addItem(healthPotion);
        inventory.addItem(extraPotion);

        Mockito.when(healthPotion.getQuantity()).thenReturn(1);
        Mockito.when(extraPotion.getQuantity()).thenReturn(1);

        Assertions.assertEquals(1, healthPotion.getQuantity());
        Assertions.assertEquals(1, extraPotion.getQuantity());
    }

    @Test
    public void useItemTest() {
        Mockito.when(healthPotion.getName()).thenReturn("Health Potion");
        Mockito.when(hero.getMaxHealth()).thenReturn(10);
        Mockito.when(extraPotion.getName()).thenReturn("Extra Health Potion");

        // --- testa if -> null
        inventory.addItem(extraPotion);
        inventory.useItem(healthPotion.getName());
        Assertions.assertEquals(1, inventory.getSize());

       // --- testa if -> maxHealth
        inventory.addItem(healthPotion);
        Mockito.when(hero.getHealth()).thenReturn(10);
        inventory.useItem(healthPotion.getName());
        Assertions.assertEquals(2, inventory.getSize());

        // --- testa usa health potion e remove quando quantity == 1
        Mockito.when(hero.getHealth()).thenReturn(5);
        Mockito.when(healthPotion.getQuantity()).thenReturn(1);
        inventory.useItem(healthPotion.getName());
        Assertions.assertEquals(1, inventory.getSize());

        // --- testa quantity > 1
        inventory.addItem(extraPotion);
        inventory.useItem(extraPotion.getName());
        Assertions.assertEquals(1, inventory.getSize());
    }

    @Test
    public void getItemTest() {
        inventory.addItem(healthPotion);
        inventory.addItem(extraPotion);

        Mockito.when(healthPotion.getName()).thenReturn("Health Potion");
        Mockito.when(extraPotion.getName()).thenReturn("Extra Health Potion");

        Assertions.assertEquals(healthPotion, inventory.getItem("Health Potion"));
        Assertions.assertEquals(extraPotion, inventory.getItem("Extra Health Potion"));
        Assertions.assertNull(inventory.getItem("1234"));
    }

    @Test
    public void getAllItemsTest() {
        List<Item> expected = new ArrayList<>();
        Assertions.assertEquals(expected, inventory.getAllItems());

        inventory.addItem(healthPotion);
        expected.add(healthPotion);
        Assertions.assertEquals(expected, inventory.getAllItems());

        inventory.addItem(extraPotion);
        expected.add(extraPotion);
        Assertions.assertEquals(expected, inventory.getAllItems());

    }

}
