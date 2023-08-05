package mainFolder.model.game.items;

import mainFolder.model.Position;
import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HealthPotionTest {
    private Hero hero;
    private Item potion;

    @BeforeEach
    public void helper() {
        hero = Mockito.mock(Hero.class);
        potion = new HealthPotion(hero);
    }

    @Test
    public void getNameTest() {
        Assertions.assertEquals("Health Potion", potion.getName());
    }

    @Test
    public void getQuantityTest() {
        Assertions.assertEquals(0, potion.getQuantity());
    }

    @Test
    public void incrementsQuantityTest() {
        Assertions.assertEquals(0, potion.getQuantity());
        potion.incrementsQuantity();
        Assertions.assertEquals(1, potion.getQuantity());
    }

    @Test
    public void decrementsQuantityTest() {
        Assertions.assertEquals(0, potion.getQuantity());
        potion.decrementsQuantity();
        Assertions.assertEquals(0, potion.getQuantity());
        potion.incrementsQuantity();
        potion.incrementsQuantity();
        Assertions.assertEquals(2, potion.getQuantity());
        potion.decrementsQuantity();
        Assertions.assertEquals(1, potion.getQuantity());
    }

    @Test
    public void useItemTest() {
        hero.decreaseHealth();
        hero.decreaseHealth();

        Mockito.when(hero.getHealth()).thenReturn(8);
        Assertions.assertEquals(8, hero.getHealth());

        potion.useItem();

        Mockito.when(hero.getHealth()).thenReturn(9);
        Assertions.assertEquals(9, hero.getHealth());
    }

    @Test
    public void equalsTrueDiffObject() {
        Item p = new HealthPotion(hero);
        Assertions.assertEquals(p, potion);
    }

    @Test
    public void equalsTrueSameObject() {
        Assertions.assertEquals(potion, potion);
    }

    @Test
    public void equalsFalseDiffObject() {
        Item p = new ExtraHealthPotion(hero);
        Assertions.assertNotEquals(potion,p);
    }

    @Test
    public void equalsFalseNull() {
        Assertions.assertNotEquals(null, potion);
    }

    @Test
    public void equalsFalseDiffClass() {
        Assertions.assertNotEquals(hero, potion);
    }
}
