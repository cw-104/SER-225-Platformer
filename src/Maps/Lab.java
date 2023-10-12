package Maps;

import java.util.ArrayList;

import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import Tilesets.TestTileset;
import Tilesets.LabTileset;
import Utils.Direction;
import Enemies.DogEnemy;
import Enemies.PrisonGuardEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;

public class Lab extends Map {

    public Lab() {
        super("lab.txt", new LabTileset());
        this.playerStartPosition = getMapTile(1, 9).getLocation();
    }

    // Enahnced Map Tile Setup
    @Override
    public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
        ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

        HorizontalMovingPlatform hmp = new HorizontalMovingPlatform(
                ImageLoader.load("GreenPlatform.png"),
                getMapTile(37, 21).getLocation(),
                getMapTile(34, 21).getLocation(),
                TileType.JUMP_THROUGH_PLATFORM,
                3,
                new Rectangle(0, 6, 16, 4),
                Direction.LEFT);
        enhancedMapTiles.add(hmp);

        EndLevelBox endLevelBox = new EndLevelBox(getMapTile(45, 27).getLocation());
        enhancedMapTiles.add(endLevelBox);

        return enhancedMapTiles;
    }

    @Override
    public ArrayList<Enemy> loadEnemies() {
        ArrayList<Enemy> enemies = new ArrayList<>();

        DogEnemy DogEnemy_1 = new DogEnemy(getMapTile(18,
                9).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(DogEnemy_1);

        DogEnemy DogEnemy_2 = new DogEnemy(getMapTile(23,
                9).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(DogEnemy_2);

        DogEnemy DogEnemy_3 = new DogEnemy(getMapTile(27,
                9).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(DogEnemy_3);

        DogEnemy DogEnemy_4 = new DogEnemy(getMapTile(13,
                20).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(DogEnemy_4);

        DogEnemy DogEnemy_5 = new DogEnemy(getMapTile(31,
                24).getLocation().subtractY(25), Direction.LEFT);
        enemies.add(DogEnemy_5);

        PrisonGuardEnemy Guard_1 = new PrisonGuardEnemy(getMapTile(10, 5).getLocation().subtractY(75),
                getMapTile(15, 5).getLocation().subtractY(75), Direction.RIGHT);
        enemies.add(Guard_1);

        PrisonGuardEnemy Guard_2 = new PrisonGuardEnemy(getMapTile(22, 5).getLocation().subtractY(75),
                getMapTile(26, 5).getLocation().subtractY(75), Direction.RIGHT);
        enemies.add(Guard_2);

        PrisonGuardEnemy Guard_3 = new PrisonGuardEnemy(getMapTile(39, 5).getLocation().subtractY(75),
                getMapTile(43, 5).getLocation().subtractY(75), Direction.LEFT);
        enemies.add(Guard_3);

        PrisonGuardEnemy Guard_4 = new PrisonGuardEnemy(getMapTile(34, 16).getLocation().subtractY(75),
                getMapTile(37, 16).getLocation().subtractY(75), Direction.RIGHT);
        enemies.add(Guard_4);

        PrisonGuardEnemy Guard_5 = new PrisonGuardEnemy(getMapTile(25, 16).getLocation().subtractY(75),
                getMapTile(28, 16).getLocation().subtractY(75), Direction.LEFT);
        enemies.add(Guard_5);

        PrisonGuardEnemy Guard_6 = new PrisonGuardEnemy(getMapTile(0, 16).getLocation().subtractY(75),
                getMapTile(5, 16).getLocation().subtractY(75), Direction.RIGHT);
        enemies.add(Guard_6);

        /*
         * DinosaurEnemy dinosaurEnemy = new DinosaurEnemy(getMapTile(19,
         * 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2),
         * Direction.RIGHT);
         * enemies.add(dinosaurEnemy);
         */

        return enemies;
    }

}
