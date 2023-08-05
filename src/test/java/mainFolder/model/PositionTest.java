package mainFolder.model;

import mainFolder.model.game.elements.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PositionTest {
    private Position position;

    @BeforeEach
    public void helper() {
        position = new Position(5, 10);
    }

    @Test
    public void getLeftTest() {
        Assertions.assertEquals(new Position(4,10), position.getLeft());
    }

    @Test
    public void getRight() {
        Assertions.assertEquals(new Position(6,10), position.getRight());
    }

    @Test
    public void getUp() {
        Assertions.assertEquals(new Position(5,9), position.getUp());
    }

    @Test
    public void getDown() {
        Assertions.assertEquals(new Position(5,11), position.getDown());
    }

    @Test
    public void getRandomNeighbourTest() {
        Position p0 = new Position(5, 9);
        int count0 = 0;
        Position p1 = new Position(6, 10);
        int count1 = 0;
        Position p2 = new Position(5, 11);
        int count2 = 0;
        Position p3 = new Position(4, 10);
        int count3 = 0;
        int countError = 0;

        for(int i = 0; i < 1000; i++) {
            Position pos = position.getRandomNeighbour();

            if(pos.equals(p0))
                count0++;
            else if(pos.equals(p1))
                count1++;
            else if (pos.equals(p2))
                count2++;
            else if(pos.equals(p3))
                count3++;
            else
                countError++;
        }

        Assertions.assertNotEquals(0, count0);
        Assertions.assertNotEquals(0, count1);
        Assertions.assertNotEquals(0, count2);
        Assertions.assertNotEquals(0, count3);
        Assertions.assertEquals(0, countError);
    }

    @Test
    public void getXTest() {
        Assertions.assertEquals(5, position.getX());
    }

    @Test
    public void getYTest() {
        Assertions.assertEquals(10, position.getY());
    }

    @Test
    public void setXTest() {
        position.setX(1);
        Assertions.assertEquals(1, position.getX());
    }

    @Test
    public void setYTest() {
        position.setY(2);
        Assertions.assertEquals(2, position.getY());
    }

    @Test
    public void equalsTrueDiffObject() {
        Position p = new Position(5, 10);
        Assertions.assertEquals(position, p);
    }

    @Test
    public void equalsTrueSameObject() {
        Assertions.assertEquals(position, position);
    }

    @Test
    public void equalsFalseDiffObject() {
        Position position2 = new Position(5, 20);
        Assertions.assertNotEquals(position, position2);
        Position position3 = new Position(20, 10);
        Assertions.assertNotEquals(position, position3);
    }

    @Test
    public void equalsFalseNull() {
        Assertions.assertNotEquals(position, null);
    }

    @Test
    public void equalsFalseDiffClass() {
        Wall wall = new Wall(5,10);
        Assertions.assertNotEquals(position, wall);
    }

    @Test
    public void hashCodeTest() {
        Position p = new Position(5, 10);
        Assertions.assertNotSame(position, p);
        Assertions.assertEquals(p.hashCode(), position.hashCode());
    }
}

