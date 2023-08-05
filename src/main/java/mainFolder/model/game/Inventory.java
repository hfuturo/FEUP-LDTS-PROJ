package mainFolder.model.game;

import mainFolder.model.Position;
import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final static int MAX_SIZE = 10;
    private int size;
    private List<Item> items;

    private Hero hero;

    public Inventory(Hero hero) {
        this.hero = hero;
        this.items = new ArrayList<>();
        this.size = 0;
    }

    public boolean hasSpace() {
        return size < Inventory.MAX_SIZE;
    }

    public int getSize() {
        return this.size;
    }

    public int getMaxSize() {
        return Inventory.MAX_SIZE;
    }

    public void addItem(Item item) {
        if(size >= Inventory.MAX_SIZE)
            return;

        if(items.contains(item))
            addExistingItem(item);
        else
            addNewItem(item);

        size++;
    }

    public void addExistingItem(Item item) {
        for(Item it : items) {
            if(it.equals(item)) {
                it.incrementsQuantity();
            }
        }
    }

    public void addNewItem(Item item) {
        items.add(item);
        item.incrementsQuantity();
    }
    public Item getItem(String itemName) {
        for(Item i : items) {
            if(itemName.equals(i.getName()))
                return i;
        }
        return null;
    }

    public void useItem(String itemName) {
        Item it = getItem(itemName);
        if (it == null)
            return;
        if(itemName.equals("Health Potion"))
            if(hero.getHealth() == hero.getMaxHealth())
                return;
        it.useItem();
        if(it.getQuantity() == 1) {
            this.items.remove(it);
        }
        this.size--;
        it.decrementsQuantity();
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }
}