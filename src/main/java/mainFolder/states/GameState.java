package mainFolder.states;

import mainFolder.controller.Controller;
import mainFolder.controller.game.LabyrinthController;
import mainFolder.model.game.labyrinth.Labyrinth;
import mainFolder.viewer.Viewer;
import mainFolder.viewer.game.GameViewer;

public class GameState extends State<Labyrinth>{
    public GameState(Labyrinth labyrinth) {
        super(labyrinth);
    }

    @Override
    protected Viewer<Labyrinth> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Labyrinth> getController() {
        return new LabyrinthController(getModel());
    }
}
