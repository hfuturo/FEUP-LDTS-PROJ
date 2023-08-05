package mainFolder.model.game.items;

import mainFolder.model.game.elements.Hero;

public class ExtraHealthPotion extends Item {
    public ExtraHealthPotion(Hero hero) {
        super("Extra Health Potion");
        this.hero = hero;
    }

    public void useItem() {
        hero.increaseMaxHealth();
    }
}