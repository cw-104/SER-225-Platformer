package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.Bunker2Tileset;
import Tilesets.SecondTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class TitleScreenMap extends Map {

    private Sprite bed;
    private Sprite max;

    public TitleScreenMap() {
        super("title_map2.txt", new Bunker2Tileset());
        Point bedLocation = getMapTile(6, 9).getLocation().subtractX(220).subtractY(90);
        bed = new Sprite(ImageLoader.loadSubImage("Bed.png", Colors.MAGENTA, 0, 0, 30, 32));
        bed.setScale(5);
        bed.setLocation(bedLocation.x, bedLocation.y);
        Point maxLocation = getMapTile(6,8).getLocation().subtractX(255).subtractY(-20); 
        max = new Sprite(ImageLoader.loadSubImage("Max7.png", Colors.MAGENTA, 0, 260, 23, 35));
        max.setScale(4);
        max.setLocation(maxLocation.x,maxLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        bed.draw(graphicsHandler);
        max.draw(graphicsHandler);
    }

}
