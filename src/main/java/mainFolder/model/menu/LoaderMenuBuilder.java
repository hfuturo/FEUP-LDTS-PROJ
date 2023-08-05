package mainFolder.model.menu;

import mainFolder.model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderMenuBuilder extends MenuBuilder{

    private final List<String> lines = new ArrayList<>();

    public LoaderMenuBuilder() throws IOException{
        URL resource = LoaderMenuBuilder.class.getResource("/Menus/MainMenu");
        assert resource != null;

        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        for (String line;(line= br.readLine())!= null;)
            lines.add(line);
    }

    public List<Position> readMap(char c) {
        List<Position> list = new ArrayList<>();
        for (int y = 0; y< lines.size();y++){
            String line = lines.get(y);
            for(int x = 0; x<line.length();x++){
                if (line.charAt(x) == c)
                    list.add(new Position(x,y));
            }
        }
        return list;
    }

    public List<Position> createWhite() {
        return new ArrayList<>(readMap('@'));
    }

    public List<Position> createBlue() {
        return new ArrayList<>(readMap('$'));
    }

    public List<Position> createGreen() {
        return new ArrayList<>(readMap('-'));
    }

    public List<Position> createBrown() {
        return new ArrayList<>(readMap('#'));
    }

    public List<Position> createBorder() {
        return new ArrayList<>(readMap('*'));
    }

    public List<Position> createYellow() {
        return new ArrayList<>(readMap('?'));
    }
}
