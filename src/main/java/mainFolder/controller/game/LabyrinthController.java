package mainFolder.controller.game;

import mainFolder.Start;
import mainFolder.gui.GUI;
import mainFolder.model.Position;
import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.items.Item;
import mainFolder.model.game.labyrinth.Labyrinth;
import mainFolder.model.game.labyrinth.LoaderLabyrinthBuilder;
import mainFolder.model.menu.*;
import mainFolder.model.game.battle.BattleMenu;
import mainFolder.states.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LabyrinthController extends GameController{

    private final HeroController heroController;
    private final MonsterController monsterController;
    public LabyrinthController(Labyrinth labyrinth) {
        super(labyrinth);

        this.heroController = new HeroController(labyrinth);
        this.monsterController = new MonsterController(labyrinth);
    }

    public void step(Start game, GUI.ACTION action, long time) throws IOException {
        if(quitGame(action)) exitGame(game);
        else if(isHeroDead()) gameOver(game);
        else if(goToInventory(action)) inventoryPopUp(game);
        else if(goToShop(action) && inRangeShop()) shopPopUp(game);
        else if(winGame()) winGameMenu(game);
        else if(goToNextLevel()) loadNextLevel(game);
        else if(goToBattle() && heroOnMonster()) startBattle(game);
        else if(goToBattle() && !heroOnMonster()) cancelBattle();
        else resume(game, action, time);
    }

    private boolean quitGame(GUI.ACTION action) {
        return action == GUI.ACTION.QUIT;
    }

    private void exitGame(Start game) {
        game.setState(null);
    }

    private boolean isHeroDead() {
        return getModel().getHero().getHealth() == 0;
    }

    private void gameOver(Start game) {
        int score = getModel().getHero().getScore();
        GameOverMenu gameOverMenu = new GameOverMenu(score);
        GameOverMenuState gameOverMenuState = new GameOverMenuState(gameOverMenu);
        game.setState(gameOverMenuState);
    }

    private boolean goToInventory(GUI.ACTION action) {
        return action == GUI.ACTION.INVENTORY;
    }

    private void inventoryPopUp(Start game) {
        List<Item> items = getModel().getHero().getItems();
        Labyrinth labyrinth = getModel();
        InventoryMenu inventoryMenu = new InventoryMenu(items, labyrinth);
        InventoryState inventoryState = new InventoryState(inventoryMenu);
        game.setState(inventoryState);
    }

    private boolean goToShop(GUI.ACTION action) {
        return action == GUI.ACTION.SHOP;
    }

    private boolean inRangeShop() {
        return getModel().inRangeShop();
    }
    private void shopPopUp(Start game) {
        HashMap<String, Integer> shop = getModel().getShop().getShop();
        Labyrinth labyrinth = getModel();
        Hero hero = getModel().getHero();
        ShopMenu shopMenu = new ShopMenu(shop, labyrinth, hero);
        ShopState shopState = new ShopState(shopMenu);
        game.setState(shopState);
    }

    public boolean nextLevel() {
        Position portalPosition = getModel().getPortal().getPosition();
        Position heroPosition = getModel().getHero().getPosition();
        return heroPosition.equals(portalPosition);
    }

    private boolean winGame() {
        boolean isMaxLevel = getModel().getLevel() == getModel().getMaxLevel();
        return nextLevel() && isMaxLevel;
    }

    private void winGameMenu(Start game) {
        int score = getModel().getHero().getScore();
        WinMenu winMenu = new WinMenu(score);
        WinMenuState winMenuState = new WinMenuState(winMenu);
        game.setState(winMenuState);
    }

    private boolean goToNextLevel() {
        return nextLevel();
    }

    private void loadNextLevel(Start game) throws IOException {
        int level = getModel().getLevel();
        Hero hero = getModel().getHero();
        Labyrinth labyrinth = new LoaderLabyrinthBuilder(level + 1).createLabyrinth(hero);
        GameState gameState = new GameState(labyrinth);
        game.setState(gameState);
    }

    private boolean goToBattle() {
        return getModel().getHero().getBattle();
    }

    private boolean heroOnMonster() {
        return getModel().getMonster(getModel().getHero().getPosition()) != null;
    }

    private void startBattle(Start game) {
        Hero hero = getModel().getHero();
        Labyrinth labyrinth = getModel();
        Position heroPosition = getModel().getHero().getPosition();
        Monster monster = getModel().getMonster(heroPosition);
        BattleMenu battleMenu = new BattleMenu(hero, monster, labyrinth);
        BattleMenuState battleMenuState = new BattleMenuState(battleMenu);
        game.setState(battleMenuState);
    }

    private void cancelBattle() {
        getModel().getHero().initBattle(false);
    }

    private void resume(Start game, GUI.ACTION action, long time) throws IOException {
        heroController.step(game, action, time);
        monsterController.step(game, action, time);
    }
}

