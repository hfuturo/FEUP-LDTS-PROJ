package mainFolder.model.game.elements;

import mainFolder.model.game.items.Item;

import java.util.HashMap;

public class Shop extends Element {

    private final HashMap<String, Integer> shop;

    public Shop(int x, int y) {
        super(x, y);
        this.shop = new HashMap<>();
        fillShop();
    }

    private void fillShop() {
        shop.put("Health Potion", 5);
        shop.put("Extra Health Potion", 10);
    }

    public HashMap<String, Integer> getShop() {
        return shop;
    }
}
