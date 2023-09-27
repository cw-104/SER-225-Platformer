package Maps;

import java.util.ArrayList;

//import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
//import EnhancedMapTiles.HorizontalMovingPlatform;
//import GameObject.Rectangle;
import Level.*;
import Tilesets.TestTileset;
import Utils.Direction;
import Enemies.DogEnemy;

public class TestEnvironment extends Map {

    public TestEnvironment() {
        super("test_environment.txt", new TestTileset());
        this.playerStartPosition = getMapTile(2, 10).getLocation();
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

        EndLevelBox endLevelBox = new EndLevelBox(getMapTile(65, 8).getLocation());
        enhancedMapTiles.add(endLevelBox);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        DogEnemy DogEnemy = new DogEnemy(getMapTile(60, 10).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(DogEnemy);

        /*
         * DinosaurEnemy dinosaurEnemy = new DinosaurEnemy(getMapTile(19,
         * 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2),
         * Direction.RIGHT);
         * enemies.add(dinosaurEnemy);
         */

        return enemies;
    }

}
