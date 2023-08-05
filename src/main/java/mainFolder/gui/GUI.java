package mainFolder.gui;

import mainFolder.model.Position;
import mainFolder.model.game.elements.Door;
import mainFolder.model.game.elements.Portal;

import java.io.IOException;
import java.util.List;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawCoin(Position position);

    void drawDoor(Position position);

    void drawHero(Position position);

    void drawWall(Position position);

    void drawMonster(Position position);

    void drawShop(Position position);


    void drawPortal(Position position);

    void drawKey(Position position);

    void drawText(Position position, String text, String color, String background);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, INVENTORY, GO_UP, SHOP}

    void drawBorder(List<Position> border);
    void drawBackground();
    void drawXeldaMenu(List<Position> white, List<Position> green, List<Position> blue, List<Position> brown,List<Position> yellow);
}
