package Maps;

import java.util.ArrayList;

import Engine.ImageLoader;
import EnhancedMapTiles.EndLevelBox;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import Level.*;
import NPCs.Walrus;
import NPCs.Shop;
import Tilesets.TestTileset;
import Tilesets.LabTileset;
import Utils.Direction;
import Enemies.DogEnemy;
import Enemies.Hunter;
import Enemies.PrisonGuardEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import GameObject.Coin;

public class Lab_copy extends Map {

        public Lab_copy() {
                super("lab_copy.txt", new LabTileset());
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

                EndLevelBox endLevelBox = new EndLevelBox(getMapTile(98, 27).getLocation());
                enhancedMapTiles.add(endLevelBox);

                return enhancedMapTiles;
        }

        @Override
        public ArrayList<Enemy> loadEnemies() {
                ArrayList<Enemy> enemies = new ArrayList<>();

                Hunter hunter = new Hunter(getMapTile(6 ,25).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2), Direction.RIGHT);
                enemies.add(hunter);
                /*
                 * DinosaurEnemy dinosaurEnemy = new DinosaurEnemy(getMapTile(19,
                 * 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2),
                 * Direction.RIGHT);
                 * enemies.add(dinosaurEnemy);
                 */

                return enemies;
        }

}
