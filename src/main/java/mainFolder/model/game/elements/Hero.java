package mainFolder.model.game.elements;

import mainFolder.model.game.Inventory;
import mainFolder.model.game.items.Item;

import java.util.List;


public class Hero extends Element{
    private int maxHealth;
    private int health;
    private int score;
    private Inventory inventory;
    private boolean isBattle = false;
    private boolean hasKey = false;

    public Hero(int x, int y) {
        super(x, y);
        this.health = 10;
        this.maxHealth = 10;
        this.inventory = new Inventory(this);
    }

    public void killedMonster() {
        score += 5;
    }
    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    
    public void increaseMaxHealth() {
        maxHealth++;
    }
    public void decreaseHealth() {
        health--;
    }
    
    public void increaseHealth() {
        health++;
    }

    public void addItem(Item item) {
        inventory.addItem(item);
    }

    public void useItem(String itemName) {
        inventory.useItem(itemName);
    }

    public int getInventorySize() {
        return inventory.getSize();
    }

    public int getInventoryMaxSize() {
        return inventory.getMaxSize();
    }
    
    public List<Item> getItems() {
        return inventory.getAllItems();
    }

    public void initBattle(Boolean bool) {
        this.isBattle = bool;
    }

    public boolean getBattle() {return isBattle;}

    public void addScore(){ this.score += 10; }

    public int getScore(){return score;}

    public void setScore(int score) {
        this.score = score;
    }

    public boolean inventoryHasSpace() {
        return inventory.hasSpace();
    }
    
    public void setKey(Boolean bool) {
        this.hasKey = bool;
    }
}
