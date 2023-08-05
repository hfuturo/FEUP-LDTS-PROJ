package mainFolder.viewer.game;

import mainFolder.gui.GUI;
import mainFolder.model.game.elements.Coin;
import mainFolder.model.game.elements.Door;

public class CoinViewer implements ElementViewer<Coin>{

    @Override
    public void draw(Coin coin, GUI gui) {
        gui.drawCoin(coin.getPosition());
    }
}
