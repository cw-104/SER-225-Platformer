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
import Tilesets.SpaceTileset;
import Utils.Direction;
import Enemies.DogEnemy;
import Enemies.DogEnemyLevel2;
import Enemies.Hunter;
import Enemies.PrisonGuardEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import GameObject.Coin;

public class Space extends Map {

        public Space() {
                super("space.txt", new SpaceTileset());
                this.playerStartPosition = getMapTile(1, 54).getLocation();
        }

        // Enahnced Map Tile Setup
        @Override
        public ArrayList<EnhancedMapTile> loadEnhancedMapTiles() {
                ArrayList<EnhancedMapTile> enhancedMapTiles = new ArrayList<>();

                HorizontalMovingPlatform hmp = new HorizontalMovingPlatform(
                                ImageLoader.load("GreenPlatform.png"),
                                getMapTile(57, 44).getLocation(),
                                getMapTile(64, 44).getLocation(),
                                TileType.JUMP_THROUGH_PLATFORM,
                                3,
                                new Rectangle(0, 6, 16, 4),
                                Direction.RIGHT);
                enhancedMapTiles.add(hmp);

                HorizontalMovingPlatform hmp2 = new HorizontalMovingPlatform(
                                ImageLoader.load("GreenPlatform.png"),
                                getMapTile(90, 38).getLocation(),
                                getMapTile(100, 38).getLocation(),
                                TileType.JUMP_THROUGH_PLATFORM,
                                3,
                                new Rectangle(0, 6, 16, 4),
                                Direction.RIGHT);
                enhancedMapTiles.add(hmp2);

                EndLevelBox endLevelBox = new EndLevelBox(getMapTile(176, 53).getLocation());
                enhancedMapTiles.add(endLevelBox);

                return enhancedMapTiles;
        }

        @Override
        public ArrayList<Enemy> loadEnemies() {
                ArrayList<Enemy> enemies = new ArrayList<>();

                /*
                 * Hunter hunter = new Hunter(getMapTile(8 ,9).getLocation().subtractY(63),
                 * getMapTile(16, 9).getLocation().subtractY(63), Direction.RIGHT);
                 * enemies.add(hunter);
                 */

                /*
                 * DinosaurEnemy dinosaurEnemy = new DinosaurEnemy(getMapTile(19,
                 * 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2),
                 * Direction.RIGHT);
                 * enemies.add(dinosaurEnemy);
                 */

                return enemies;
        }

}
