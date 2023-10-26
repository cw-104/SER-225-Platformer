package Maps;

import java.awt.Color;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import Engine.ScreenManager;
import GameObject.Sprite;
import Level.Map;
import Tilesets.Bunker2Tileset;
import Tilesets.LabCutsceneTileset;
import Tilesets.SecondTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class ShopScreenMap extends Map {

    private Sprite max;
    private Sprite textBox;
    private Sprite max_icon;
    private Sprite vending_machine;
    private Sprite speedUpSprite;

    public ShopScreenMap() {
        super("shop_hall.txt", new LabCutsceneTileset());
        //text box
        Point textBoxLocation = getMapTile(1, 5).getLocation().subtractX(-15).subtractY(-12);
        textBox = new Sprite(ImageLoader.loadSubImage("textBox2.png", Colors.MAGENTA, 0, 0, 199, 49));
        textBox.setScale(3);
        textBox.setLocation(textBoxLocation.x, textBoxLocation.y);
        //max talking icon
        Point maxIconLocation = getMapTile(2,5).getLocation().subtractX(60).subtractY(-8);
        max_icon = new Sprite (ImageLoader.loadSubImage("Max_Speech.png", Colors.MAGENTA, 0, 0, 25, 22));
        max_icon.setScale(3);
        max_icon.setLocation(maxIconLocation.x, maxIconLocation.y);
        //speed up icon
        Point sodaLocation = getMapTile(1, 3).getLocation().subtractX(-15).subtractY(-5);
        speedUpSprite = new Sprite(ImageLoader.loadSubImage("soda.png", Colors.MAGENTA, 0, 0, 25, 25));
        speedUpSprite.setScale(3);
        speedUpSprite.setLocation(sodaLocation.x, sodaLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        //graphicsHandler.drawFilledRectangle(0, 0, ScreenManager.getScreenWidth(), ScreenManager.getScreenHeight(), Color.darkGray);
        graphicsHandler.drawFilledRectangle(20,220, 750, 130, Color.lightGray);
        textBox.draw(graphicsHandler);
        max_icon.draw(graphicsHandler);
        speedUpSprite.draw(graphicsHandler);
    }

}

