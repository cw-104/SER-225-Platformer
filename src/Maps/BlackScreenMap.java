package Maps;

import Engine.GraphicsHandler;
import Level.Map;
import Tilesets.SecondTileset;

// Represents the map that is used as a background for the main menu and credits menu screen
public class BlackScreenMap extends Map {


    public BlackScreenMap() {
        super("black_screen.txt", new SecondTileset());
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
    }

}
