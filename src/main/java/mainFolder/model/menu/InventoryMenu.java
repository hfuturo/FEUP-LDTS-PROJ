package mainFolder.model.menu;

import mainFolder.model.game.items.Item;
import mainFolder.model.game.labyrinth.Labyrinth;

import java.util.ArrayList;
import java.util.List;

public class InventoryMenu {
    private List<String> entries;
    private int currentEntry = 0;
    private List<String> quantities;
    private List<Item> items;

    private Labyrinth labyrinth;

    public InventoryMenu(List<Item> items, Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
        this.entries = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.items = items;
        fillEntries();
        fillQuantities();
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    private void fillEntries() {
        for(Item item : items) {
            this.entries.add(item.getName());
        }
        this.entries.add("Exit");
    }

    private void fillQuantities() {
        for(Item item : items) {
            this.quantities.add(Integer.toString(item.getQuantity()));
        }
    }

    public void nextEntry() {
        currentEntry++;
        if(currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if(currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public boolean isSelectedHealthPotion() {
        return entries.get(currentEntry).equals("Health Potion");
    }

    public boolean isSelectedExtraHealthPotion() {
        return entries.get(currentEntry).equals("Extra Health Potion");
    }

    public boolean isSelectedExit() {
        return entries.get(currentEntry).equals("Exit");
    }

    public void useHealthPotion() {
        labyrinth.getHero().useItem("Health Potion");
    }

    public void useExtraHealthPotion() {
        labyrinth.getHero().useItem("Extra Health Potion");
    }

    public String addString(int i) {
        String itemName = getEntry(i);
        if(i < quantities.size()) {
            for (Item item : items) {
                if (item.getName().equals(itemName))
                    return getEntry(i) + "(" + item.getQuantity() + ")";
            }
        }
        return getEntry(i);
    }

    public String stringInventorySpace() {
        return "Space:" + labyrinth.getHero().getInventorySize() + "/" + labyrinth.getHero().getInventoryMaxSize();
    }

    public String stringHeroHealth() {
        return "Lives:" + labyrinth.getHero().getHealth() + "/" + labyrinth.getHero().getMaxHealth();
    }
}
