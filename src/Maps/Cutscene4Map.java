package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.Bunker2Tileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class Cutscene4Map extends Map {

    private Sprite maxReal;
    private Sprite textBox;
    private Sprite max_icon;

    public Cutscene4Map() {
        super("cutscene_map.txt", new Bunker2Tileset());
        Point maxRealLocation = getMapTile(2,9).getLocation().subtractX(70).subtractY(24);
        maxReal = new Sprite(ImageLoader.loadSubImage("Max7.png", Colors.MAGENTA, 0, 1, 36, 31));
        maxReal.setScale(3);
        maxReal.setLocation(maxRealLocation.x, maxRealLocation.y);
        Point textBoxLocation = getMapTile(2, 0).getLocation().subtractX(0).subtractY(-12);
        textBox = new Sprite(ImageLoader.loadSubImage("textBox2.png", Colors.MAGENTA, 0, 0, 199, 49));
        textBox.setScale(3);
        textBox.setLocation(textBoxLocation.x, textBoxLocation.y);
        Point intercomIconLocation = getMapTile(3,0).getLocation().subtractX(55).subtractY(-9);
        max_icon = new Sprite (ImageLoader.loadSubImage("Max_Speech.png", Colors.MAGENTA, 0, 0, 25, 22));
        max_icon.setScale(3);
        max_icon.setLocation(intercomIconLocation.x, intercomIconLocation.y);

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        maxReal.draw(graphicsHandler);
        textBox.draw(graphicsHandler);
        max_icon.draw(graphicsHandler);
    }

}
