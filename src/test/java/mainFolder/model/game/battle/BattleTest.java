package mainFolder.model.game.battle;

import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.elements.Monster;
import mainFolder.model.game.labyrinth.Labyrinth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BattleTest {
    private Hero hero;
    private Monster monster;
    private Labyrinth labyrinth;
    private Battle battle;

    @BeforeEach
    public void setUp() {
        hero = mock(Hero.class);
        monster = mock(Monster.class);
        labyrinth = mock(Labyrinth.class);
        battle = new Battle(hero, monster, labyrinth);
    }

    @Test
    public void testBattleConstructor() {
        assertNotNull(battle);
        assertEquals(hero, battle.getHero());
        assertEquals(monster, battle.getMonster());
        assertEquals(labyrinth, battle.getLabyrinth());
    }

    @Test
    public void testBattleSettersAndGetters() {
        Hero newHero = mock(Hero.class);
        battle.setHero(newHero);
        assertEquals(newHero, battle.getHero());

        Labyrinth newLabyrinth = mock(Labyrinth.class);
        battle.setLabyrinth(newLabyrinth);
        assertEquals(newLabyrinth, battle.getLabyrinth());
    }
}