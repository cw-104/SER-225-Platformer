package Maps;

import java.util.ArrayList;

//import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
//import EnhancedMapTiles.HorizontalMovingPlatform;
//import GameObject.Rectangle;
import Level.*;
import Tilesets.TestTileset;

public class TestEnvironment extends Map {

    public TestEnvironment() {
        super("test_environment.txt", new TestTileset());
        this.playerStartPosition = getMapTile(2, 11).getLocation();
    }

    // Enahnced Map Tile Setup
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        // HorizontalMovingPlatform hmp = new HorizontalMovingPlatform(
        // ImageLoader.load("GreenPlatform.png"),
        // getMapTile(24, 6).getLocation(),
        // getMapTile(27, 6).getLocation(),
        // TileType.JUMP_THROUGH_PLATFORM,
        // 3,
        // new Rectangle(0, 6,16,4),
        // Direction.RIGHT
        // );
        // enhancedMapTiles.add(hmp);

        EndLevelBox endLevelBox = new EndLevelBox(getMapTile(32, 7).getLocation());
        enhancedMapTiles.add(endLevelBox);

        return enhancedMapTiles;
    }

}
