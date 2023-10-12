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
import Engine.ImageLoader;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;

public class Lab extends Map {

    public Lab() {
        super("lab.txt", new LabTileset());
        this.playerStartPosition = getMapTile(1, 9).getLocation();
    }

    // Enahnced Map Tile Setup
    // @Override
    // public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
    // ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

    // HorizontalMovingPlatform hmp = new HorizontalMovingPlatform(
    // ImageLoader.load("GreenPlatform.png"),
    // getMapTile(15, 7).getLocation(),
    // getMapTile(19, 7).getLocation(),
    // TileType.JUMP_THROUGH_PLATFORM,
    // 3,
    // new Rectangle(0, 6, 16, 4),
    // Direction.RIGHT);
    // enhancedMapTiles.add(hmp);

    // EndLevelBox endLevelBox = new EndLevelBox(getMapTile(85, 8).getLocation());
    // enhancedMapTiles.add(endLevelBox);

    // return enhancedMapTiles;
    // }

    // @Override
    // public ArrayList<Enemy> loadEnemies() {
    // ArrayList<Enemy> enemies = new ArrayList<>();

    // DogEnemy DogEnemy = new DogEnemy(getMapTile(60,
    // 10).getLocation().subtractY(25), Direction.LEFT);
    // enemies.add(DogEnemy);

    // DogEnemy DogEnemy2 = new DogEnemy(getMapTile(70,
    // 10).getLocation().subtractY(25), Direction.LEFT);
    // enemies.add(DogEnemy2);

    // /*
    // * DinosaurEnemy dinosaurEnemy = new DinosaurEnemy(getMapTile(19,
    // * 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2),
    // * Direction.RIGHT);
    // * enemies.add(dinosaurEnemy);
    // */

    // return enemies;
    // }

}
