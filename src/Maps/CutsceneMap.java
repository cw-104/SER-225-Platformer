package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.SecondTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class CutsceneMap extends Map {

    private Sprite max;
    private Sprite textBox;

    public CutsceneMap() {
        super("title_screen_map.txt", new SecondTileset());
        Point catLocation = getMapTile(6, 9).getLocation().subtractX(24).subtractY(250);
        max = new Sprite(ImageLoader.loadSubImage("cutScene1.png", Colors.MAGENTA, 0, 0, 30, 33));
        max.setScale(7);
        max.setLocation(catLocation.x, catLocation.y);
        Point textBoxLocation = getMapTile(2, 9).getLocation().subtractX(0).subtractY(23);
        textBox = new Sprite(ImageLoader.loadSubImage("textBox2.png", Colors.MAGENTA, 0, 0, 199, 49));
        textBox.setScale(3);
        textBox.setLocation(textBoxLocation.x, textBoxLocation.y);
        

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        max.draw(graphicsHandler);
        textBox.draw(graphicsHandler);
    }

}
