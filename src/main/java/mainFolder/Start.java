package mainFolder;

import mainFolder.gui.LanternaGUI;
import mainFolder.model.menu.LoaderMenuBuilder;
import mainFolder.states.MenuState;
import mainFolder.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Start {
    private final LanternaGUI gui;
    private State state;

    public Start() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(31, 20);
        this.state = new MenuState(new LoaderMenuBuilder().createMenu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Start().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}