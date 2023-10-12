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
import Enemies.PrisonGuardEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;

public class TestEnvironment extends Map {

    public TestEnvironment() {
        super("test_map.txt", new TestTileset());
        this.playerStartPosition = getMapTile(2, 10).getLocation();
    }

    // Enahnced Map Tile Setup
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        HorizontalMovingPlatform hmp = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(15, 7).getLocation(),
                getMapTile(19, 7).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6, 16, 4),
                Direction.RIGHT);
        enhancedMapTiles.add(hmp);

        EndLevelBox endLevelBox = new EndLevelBox(getMapTile(85, 8).getLocation());
        enhancedMapTiles.add(endLevelBox);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        DogEnemy DogEnemy = new DogEnemy(getMapTile(60, 10).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(DogEnemy);

        PrisonGuardEnemy Guard_1 = new PrisonGuardEnemy(getMapTile(70, 10).getLocation().subtractY(85),
                getMapTile(80, 10).getLocation().subtractY(85), Direction.LEFT);
        enemies.add(Guard_1);

        return enemies;
    }

}
