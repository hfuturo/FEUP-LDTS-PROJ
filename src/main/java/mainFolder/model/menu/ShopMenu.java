package mainFolder.model.menu;

import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.items.ExtraHealthPotion;
import mainFolder.model.game.items.HealthPotion;
import mainFolder.model.game.items.Item;
import mainFolder.model.game.labyrinth.Labyrinth;

import java.util.Arrays;
import java.util.HashMap;

public class ShopMenu extends Menu {

    private final HashMap<String, Integer> shop;
    private final Hero hero;
    private final Labyrinth labyrinth;

    public ShopMenu(HashMap<String, Integer> shop, Labyrinth labyrinth, Hero hero) {
        super(Arrays.asList("Health Potion", "Extra Health Potion", "Exit"));
        this.hero = hero;
        this.labyrinth = labyrinth;
        this.shop = shop;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public boolean isSelectedHealthPotion() {
        return isSelected(0);
    }

    public void buyHealthPotion() {
        Item potion = new HealthPotion(hero);
        buyPotion(potion);
    }

    public void buyExtraHealthPotion() {
        Item potion = new ExtraHealthPotion(hero);
        buyPotion(potion);
    }

    public void buyPotion(Item potion) {
        int potionPrice = shop.get(potion.getName());
        boolean hasCoins = hero.getScore() >= shop.get(potion.getName());
        boolean inventoryHasSpace = hero.inventoryHasSpace();

        if(hasCoins && inventoryHasSpace) {
            hero.addItem(potion);
            hero.setScore(hero.getScore() - potionPrice);
        }
    }

    public boolean isSelectedExtraHealthPotion() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public String addString(int i) {
        if(i == getNumberEntries() - 1)
            return getEntry(i);
        return getEntry(i) + "(" + shop.get(getEntry(i)) + "c)";
    }

    public String stringCoins() {
        return "Coins:" + hero.getScore() + "c";
    }

    public String stringInventorySpace() {
        return "Inventory:" + hero.getInventorySize() + "/" + hero.getInventoryMaxSize();
    }

    public String stringHeroHealth() {
        return "Lives:" + hero.getHealth() + "/" + hero.getMaxHealth();
    }
}
