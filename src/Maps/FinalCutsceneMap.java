package Maps;

import Engine.GraphicsHandler;
import Engine.ImageLoader;
import GameObject.Sprite;
import Level.Map;
import Tilesets.ForestTileset;
import Tilesets.LabCutsceneTileset;
import Tilesets.SpaceTileset;
import Utils.Colors;
import Utils.Point;

// Represents the map that is used as a background for the 1-2 cutscene
public class FinalCutsceneMap extends Map {

    private Sprite max;
    private Sprite textBox;
    private Sprite intercom_icon;
    
    

    public FinalCutsceneMap() {
        super("final_cutscene.txt", new SpaceTileset());
        Point maxLocation = getMapTile(1, 7).getLocation().subtractX(24).subtractY(135);
        max = new Sprite(ImageLoader.loadSubImage("Max7.png", Colors.MAGENTA, 0, 1, 36, 31));
        max.setScale(3);
        max.setLocation(maxLocation.x, maxLocation.y);
        Point textBoxLocation = getMapTile(1, 0).getLocation().subtractX(-20).subtractY(-12);
        textBox = new Sprite(ImageLoader.loadSubImage("textBox2.png", Colors.MAGENTA, 0, 0, 199, 49));
        textBox.setScale(3);
        textBox.setLocation(textBoxLocation.x, textBoxLocation.y);
        Point intercomIconLocation = getMapTile(2,0).getLocation().subtractX(43).subtractY(-22);
        intercom_icon = new Sprite (ImageLoader.loadSubImage("camera_speech.png", Colors.MAGENTA, 0, 0, 21, 20));
        intercom_icon.setScale(2);
        intercom_icon.setLocation(intercomIconLocation.x, intercomIconLocation.y);
       
    }

    @Override
    public void draw(GraphicsHandler graphicsHandler) {
        super.draw(graphicsHandler);
        max.draw(graphicsHandler);
        textBox.draw(graphicsHandler);
        intercom_icon.draw(graphicsHandler);
        
    }

}


