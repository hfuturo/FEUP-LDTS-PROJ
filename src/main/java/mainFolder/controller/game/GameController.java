package mainFolder.controller.game;

import mainFolder.controller.Controller;
import mainFolder.model.game.labyrinth.Labyrinth;

public abstract class GameController extends Controller<Labyrinth> {
    public GameController(Labyrinth labyrinth) {
        super (labyrinth);
    }
}
