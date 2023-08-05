package mainFolder.model.game.labyrinth;


import mainFolder.model.game.battle.Battle;
import mainFolder.model.game.elements.*;
import mainFolder.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {

    private List<Coin> coins;

    private int level;
    private final int maxLevel;
    private List<Door> doors;
    private Key key;
    private int width;
    private int height;
    private Hero hero;

    private Portal portal;

    private Shop shop;
    private List<Monster> monsters;

    private Battle battle;

    private List<Wall> walls;

    public Labyrinth(int width, int height, int level, int maxLevel) {
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.level = level;
        this.maxLevel = maxLevel;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public Portal getPortal() {
        return portal;
    }

    public void setPortal(Portal portal) {
        this.portal = portal;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }
    public boolean canHeroMove(Position position) {
        for(Wall wall : walls) {
            if (wall.getPosition().equals(position))
                return false;
        }
     
        for(Door door: doors) {
            if(door.getPosition().equals(position))
                return false;
        }
        
        return !shop.getPosition().equals(position);
    }

    public Hero getHero() {
        return hero;
    }

    public boolean inRangeShop() {
        int distanceX = hero.getPosition().getX() - shop.getPosition().getX();
        int distanceY = hero.getPosition().getY() - shop.getPosition().getY();
        double totalDistance = Math.sqrt(Math.pow(distanceX,2) + Math.pow(distanceY, 2));
        return totalDistance <= 1.5;
    }
    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }

    public Monster getMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return monster;
        return null;
    }

    public void removeMonster(Position position) {
        for(Monster monster: monsters)
            if(monster.getPosition().equals(position)){
                monsters.remove(monster);
                break;
            }
    }

    public void openDoors() {
        doors.clear();
    }

    public List<Door> getDoors() {return doors;}

    public void setDoors(List<Door> doors) {this.doors = doors;}

    public List<Coin> getCoins(){return coins;}

    public void setCoins(List<Coin> coins) {this.coins = coins;}

    public boolean isCoins(Position position){
        for(Coin coin: coins){
            if (coin.getPosition().equals(position)) return true;
        }
        return false;
    }

    public List<Coin> collectCoins(Position position) {
        for (Coin coin : coins) {
            if (coin.getPosition().equals(position)) {
                coins.remove(coin);
                break;
            }
        }
        return coins;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public boolean isKey(Position position) {
        if(key == null) return false;
        return key.getPosition().equals(position);
    }

    public void createBattle(Hero hero, Monster monster) {
        this.battle = new Battle(hero, monster, this);
    }
}
