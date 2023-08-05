package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Shop;

public class ShopViewer implements ElementViewer<Shop> {

    public void draw(Shop shop, GUI gui) {
        gui.drawShop(shop.getPosition());
    }
}
