package mainFolder.model.menu;

import mainFolder.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class LoaderMenuBuilderTest {

    private LoaderMenuBuilder loaderMenuBuilder;

    private List<Position> positions;
    @BeforeEach
    public void helper() throws IOException {
        loaderMenuBuilder = new LoaderMenuBuilder();
    }

    @Test
    public void readMapTest() {
        positions = loaderMenuBuilder.readMap('-');
        Assertions.assertFalse(positions.isEmpty());
        positions = loaderMenuBuilder.readMap('g');
        Assertions.assertTrue(positions.isEmpty());
    }

    @Test
    public void createWhiteTest() {
        positions = loaderMenuBuilder.createWhite();
        Assertions.assertFalse(positions.isEmpty());
    }

    @Test
    public void createBlueTest() {
        positions = loaderMenuBuilder.createBlue();
        Assertions.assertFalse(positions.isEmpty());
    }

    @Test
    public void createGreenTest() {
        positions = loaderMenuBuilder.createGreen();
        Assertions.assertFalse(positions.isEmpty());
    }

    @Test
    public void createBrownTest() {
        positions = loaderMenuBuilder.createBrown();
        Assertions.assertFalse(positions.isEmpty());
    }

    @Test
    public void createBorderTest() {
        positions = loaderMenuBuilder.createBorder();
        Assertions.assertTrue(positions.isEmpty());
    }

    @Test
    public void createYellowTest() {
        positions = loaderMenuBuilder.createYellow();
        Assertions.assertFalse(positions.isEmpty());
    }

    @Test
    public void createMenuTest() {
        MainMenu mainMenu = loaderMenuBuilder.createMenu();
        Assertions.assertNotNull(mainMenu);
    }
}
