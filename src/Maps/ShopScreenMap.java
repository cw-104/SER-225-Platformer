package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.LabCutsceneTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class ShopScreenMap extends Map {

    private Sprite textBox;
    private Sprite max_icon;
    private Sprite speedUpSprite;
    private Sprite healthUpSprite;
    private Sprite vending;

    public ShopScreenMap() {
        super("shop_hall.txt", new LabCutsceneTileset());

        Point vendingLocation = getMapTile(0,0).getLocation().subtractX(5).subtractY(0);
        vending = new Sprite(ImageLoader.loadSubImage("vending_close.png", Colors.MAGENTA, 0, 0, 263, 187));
        vending.setScale(3);
        vending.setLocation(vendingLocation.x, vendingLocation.y);

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
        Point speedLocation = getMapTile(1, 1).getLocation().subtractX(-10).subtractY(-30);
        speedUpSprite = new Sprite(ImageLoader.loadSubImage("soda2.png", Colors.MAGENTA, 0, 0, 25, 25));
        speedUpSprite.setScale(5);
        speedUpSprite.setLocation(speedLocation.x, speedLocation.y);
        //health up icon
        Point healthLocation = getMapTile(4, 1).getLocation().subtractX(5).subtractY(-30);
        healthUpSprite = new Sprite(ImageLoader.loadSubImage("soda2.png", Colors.MAGENTA, 25, 0, 25, 25));
        healthUpSprite.setScale(5);
        healthUpSprite.setLocation(healthLocation.x, healthLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        vending.draw(graphicsHandler);
        textBox.draw(graphicsHandler);
        max_icon.draw(graphicsHandler);
        speedUpSprite.draw(graphicsHandler);
        healthUpSprite.draw(graphicsHandler);
    }

}

