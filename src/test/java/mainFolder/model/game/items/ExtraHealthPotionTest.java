package mainFolder.model.game.items;

import mainFolder.model.game.elements.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ExtraHealthPotionTest {

    private Hero hero;
    private Item potion;

    @BeforeEach
    public void helper() {
        hero = Mockito.mock(Hero.class);
        potion = new ExtraHealthPotion(hero);
    }

    @Test
    public void getNameTest() {
        Assertions.assertEquals("Extra Health Potion", potion.getName());
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
        Mockito.when(hero.getMaxHealth()).thenReturn(10);
        Assertions.assertEquals(10, hero.getMaxHealth());

        potion.useItem();

        Mockito.when(hero.getMaxHealth()).thenReturn(11);
        Assertions.assertEquals(11, hero.getMaxHealth());
    }

    @Test
    public void equalsTrueDiffObject() {
        Item p = new ExtraHealthPotion(hero);
        Assertions.assertEquals(p, potion);
    }

    @Test
    public void equalsTrueSameObject() {
        Assertions.assertEquals(potion, potion);
    }

    @Test
    public void equalsFalseDiffObject() {
        Item p = new HealthPotion(hero);
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
