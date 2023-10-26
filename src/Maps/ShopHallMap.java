package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.Bunker2Tileset;
import Tilesets.LabCutsceneTileset;
import Tilesets.SecondTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the main menu and credits menu screen
public class ShopHallMap extends Map {

    private Sprite max;
    private Sprite textBox;
    private Sprite max_icon;
    private Sprite vending_machine;

    public ShopHallMap() {
        super("shop_hall.txt", new LabCutsceneTileset());
        Point maxLocation = getMapTile(1, 7).getLocation().subtractX(24).subtractY(235);
        max = new Sprite(ImageLoader.loadSubImage("Max7.png", Colors.MAGENTA, 0, 1, 36, 31));
        max.setScale(3);
        max.setLocation(maxLocation.x, maxLocation.y);
        Point textBoxLocation = getMapTile(1, 0).getLocation().subtractX(-20).subtractY(-12);
        textBox = new Sprite(ImageLoader.loadSubImage("textBox2.png", Colors.MAGENTA, 0, 0, 199, 49));
        textBox.setScale(3);
        textBox.setLocation(textBoxLocation.x, textBoxLocation.y);
        Point maxIconLocation = getMapTile(2,0).getLocation().subtractX(54).subtractY(-8);
        max_icon = new Sprite (ImageLoader.loadSubImage("Max_Speech.png", Colors.MAGENTA, 0, 0, 25, 22));
        max_icon.setScale(3);
        max_icon.setLocation(maxIconLocation.x, maxIconLocation.y);
        Point vendingMachineLocation = getMapTile(7,3).getLocation().subtractX(24).subtractY(-15);
        vending_machine = new Sprite (ImageLoader.loadSubImage("vending_machine.png", Colors.MAGENTA, 0, 0, 80, 90));
        vending_machine.setScale(2);
        vending_machine.setLocation(vendingMachineLocation.x, vendingMachineLocation.y);
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        max.draw(graphicsHandler);
        textBox.draw(graphicsHandler);
        max_icon.draw(graphicsHandler);
        vending_machine.draw(graphicsHandler);
    }

}

