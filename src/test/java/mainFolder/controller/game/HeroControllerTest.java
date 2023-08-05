package mainFolder.controller.game;

import mainFolder.model.Position;
import mainFolder.model.game.elements.Hero;
import mainFolder.model.game.labyrinth.Labyrinth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HeroControllerTest {
    private Labyrinth labyrinth;
    private Hero hero;
    private HeroController controller;

    @BeforeEach
    void setUp() {
        labyrinth = mock(Labyrinth.class);
        hero = mock(Hero.class);
        controller = new HeroController(labyrinth);
    }

    @Test
    void testMoveHeroLeft() {
        when(labyrinth.canHeroMove(any(Position.class))).thenReturn(true);
        when(hero.getPosition()).thenReturn(new Position(1, 1));
        when(labyrinth.getHero()).thenReturn(hero);

        controller.moveHeroLeft();

        verify(hero).setPosition(new Position(0, 1));
    }

    @Test
    void testMoveHeroRight() {
        when(labyrinth.canHeroMove(any(Position.class))).thenReturn(true);
        when(hero.getPosition()).thenReturn(new Position(1, 1));
        when(labyrinth.getHero()).thenReturn(hero);

        controller.moveHeroRight();

        verify(hero).setPosition(new Position(2, 1));
    }

    @Test
    void testMoveHeroUp() {
        when(labyrinth.canHeroMove(any(Position.class))).thenReturn(true);
        when(hero.getPosition()).thenReturn(new Position(1, 1));
        when(labyrinth.getHero()).thenReturn(hero);

        controller.moveHeroUp();

        verify(hero).setPosition(new Position(1, 0));
    }

    @Test
    void testMoveHeroDown() {
        when(labyrinth.canHeroMove(any(Position.class))).thenReturn(true);
        when(hero.getPosition()).thenReturn(new Position(1, 1));
        when(labyrinth.getHero()).thenReturn(hero);

        controller.moveHeroDown();

        verify(hero).setPosition(new Position(1, 2));
    }
}