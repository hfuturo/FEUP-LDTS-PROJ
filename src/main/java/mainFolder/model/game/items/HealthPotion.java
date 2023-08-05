package mainFolder.model.game.items;

import mainFolder.model.game.elements.Hero;

public class HealthPotion extends Item {
    public HealthPotion(Hero hero) {
        super("Health Potion");
        this.hero = hero;
    }

    public void useItem() {
        hero.increaseHealth();
    }
}
