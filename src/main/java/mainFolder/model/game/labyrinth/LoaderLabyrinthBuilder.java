package mainFolder.model.game.labyrinth;

import mainFolder.model.Position;
import mainFolder.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderLabyrinthBuilder extends LabyrinthBuilder{

    private final int level;

    private final int maxLevel = 3;

    private final List<String> lines;

    public LoaderLabyrinthBuilder(int level) throws IOException {
        this.level = level;

        URL resource = LoaderLabyrinthBuilder.class.getResource("/levels/level" + level + ".lvl");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected int getLevel() {
        return level;
    }

    @Override
    protected int getMaxLevel() {
        return maxLevel;
    }

    protected Position getMapPosition(char c) {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == c) return new Position(x,y);
        }
        return null;
    }

    protected List<Position> getMapPositions(char c) {
        List<Position> positions = new ArrayList<>();
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == c) positions.add(new Position(x,y));
        }
        return positions;
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        List<Position> positions = getMapPositions('#');

        for(Position position : positions)
            walls.add(new Wall(position.getX(), position.getY()));

        return walls;
    }

    @Override
    protected List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();
        List<Position> positions = getMapPositions('M');

        for(Position position : positions)
            monsters.add(new Monster(position.getX(), position.getY()));

        return monsters;
    }

    @Override
    protected Hero createHero() {
        Position position = getMapPosition('H');
        if(position != null)
            return new Hero(position.getX(), position.getY());
        return null;
    }

    @Override
    protected Position loadHeroPosition() {
        return getMapPosition('H');
    }

    @Override
    protected List<Coin> createCoins() {
        List<Coin> coins = new ArrayList<>();
        List<Position> positions = getMapPositions('c');

        for(Position position : positions)
            coins.add(new Coin(position.getX(), position.getY()));

        return coins;
    }

    @Override
    protected List<Door> createDoors() {
        List<Door> doors = new ArrayList<>();
        List<Position> positions = getMapPositions('|');

        for(Position position : positions)
            doors.add(new Door(position.getX(), position.getY()));

        return doors;
    }

    @Override
    protected Shop createShop() {
        Position position = getMapPosition('S');
        if(position != null)
            return new Shop(position.getX(), position.getY());
        return null;
    }

    @Override
    protected Portal createPortal() {
        Position position = getMapPosition('P');
        if(position != null)
            return new Portal(position.getX(), position.getY());
        return null;
    }

    @Override
    protected Key createKey() {
        Position position = getMapPosition('K');
        if(position != null)
            return new Key(position.getX(), position.getY());
        return null;
    }
}
