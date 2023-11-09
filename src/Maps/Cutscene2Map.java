package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.Bunker2Tileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class Cutscene2Map extends Map {

    private Sprite maxReal;
    private Sprite textBox;
    private Sprite intercom_icon;

    public Cutscene2Map() {
        super("cutscene_map.txt", new Bunker2Tileset());
        Point maxRealLocation = getMapTile(2,9).getLocation().subtractX(70).subtractY(24);
        maxReal = new Sprite(ImageLoader.loadSubImage("Max7.png", Colors.MAGENTA, 0, 1, 36, 31));
        maxReal.setScale(3);
        maxReal.setLocation(maxRealLocation.x, maxRealLocation.y);
        Point textBoxLocation = getMapTile(2, 0).getLocation().subtractX(0).subtractY(-12);
        textBox = new Sprite(ImageLoader.loadSubImage("textBox2.png", Colors.MAGENTA, 0, 0, 199, 49));
        textBox.setScale(3);
        textBox.setLocation(textBoxLocation.x, textBoxLocation.y);
        Point intercomIconLocation = getMapTile(3,0).getLocation().subtractX(42).subtractY(-20);
        intercom_icon = new Sprite (ImageLoader.loadSubImage("camera_speech.png", Colors.MAGENTA, 0, 0, 21, 20));
        intercom_icon.setScale(2);
        intercom_icon.setLocation(intercomIconLocation.x, intercomIconLocation.y);

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        maxReal.draw(graphicsHandler);
        textBox.draw(graphicsHandler);
        intercom_icon.draw(graphicsHandler);
    }

}
