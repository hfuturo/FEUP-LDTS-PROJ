package mainFolder.states;

import mainFolder.Start;
import mainFolder.controller.Controller;
import mainFolder.gui.GUI;
import mainFolder.viewer.Viewer;

import java.io.IOException;

public abstract class State<T>{

    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Start start, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(start, action, time);
        viewer.draw(gui);
    }
}
