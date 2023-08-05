package mainFolder.model.menu;

import mainFolder.model.Position;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {
    private List<Position> White;
    private List<Position> Yellow;
    private List<Position> Green;
    private List<Position> Blue;
    private List<Position> Brown;
    private List<Position> Border;

    public MainMenu() {
        super(Arrays.asList("Start", "Exit"));
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public List<Position> getWhite() {return White;}
    public List<Position> getGreen() {return Green;}
    public List<Position> getBlue() {return Blue;}
    public List<Position> getBrown() {return Brown;}
    public List<Position> getBorder() {return Border;}
    public List<Position> getYellow() {return Yellow;}

    public void setWhite(List<Position> White) {this.White = White;}
    public void setGreen(List<Position> Green) {this.Green = Green;}
    public void setBlue(List<Position> Blue) {this.Blue = Blue;}
    public void setBrown(List<Position> Brown) {this.Brown = Brown;}
    public void setBorder(List<Position> Border) {this.Border = Border;}
    public void setYellow(List<Position> Yellow) {this.Yellow = Yellow;}
}
