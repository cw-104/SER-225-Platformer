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
    private Sprite max_icon;

    public CutsceneMap() {
        super("black_screen.txt", new SecondTileset());
        Point maxLocation = getMapTile(6, 9).getLocation().subtractX(24).subtractY(250);
        max = new Sprite(ImageLoader.loadSubImage("cutScene1.png", Colors.MAGENTA, 0, 0, 30, 33));
        max.setScale(7);
        max.setLocation(maxLocation.x, maxLocation.y);
        Point textBoxLocation = getMapTile(2, 9).getLocation().subtractX(0).subtractY(38);
        textBox = new Sprite(ImageLoader.loadSubImage("textBox2.png", Colors.MAGENTA, 0, 0, 199, 49));
        textBox.setScale(3);
        textBox.setLocation(textBoxLocation.x, textBoxLocation.y);
        Point maxIconLocation = getMapTile(3,11).getLocation().subtractX(52).subtractY(138);
        max_icon = new Sprite (ImageLoader.loadSubImage("Max_Speech.png", Colors.MAGENTA, 0, 0, 25, 22));
        max_icon.setScale(3);
        max_icon.setLocation(maxIconLocation.x, maxIconLocation.y);

    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        max.draw(graphicsHandler);
        textBox.draw(graphicsHandler);
        max_icon.draw(graphicsHandler);
    }

}
