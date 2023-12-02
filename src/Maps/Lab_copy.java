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
import Tilesets.ForestTileset;
import Tilesets.LabTileset;
import Utils.Direction;
import Enemies.DinosaurEnemy;
import Enemies.DogEnemy;
import Enemies.DogEnemyLevel2;
import Enemies.Hunter;
import Enemies.PrisonGuardEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import GameObject.Coin;
import Tilesets.ForestTileset;

public class Lab_copy extends Map {

        public Lab_copy() {
                super("lab_copy.txt", new ForestTileset());
                this.playerStartPosition = getMapTile(1, 47).getLocation();
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

                EndLevelBox endLevelBox = new EndLevelBox(getMapTile(99, 12).getLocation());
                enhancedMapTiles.add(endLevelBox);

                return enhancedMapTiles;
        }

        @Override
        public ArrayList<Enemy> loadEnemies() {
                ArrayList<Enemy> enemies = new ArrayList<>();

                DogEnemyLevel2 DogEnemy_1 = new DogEnemyLevel2(getMapTile(23,
                                36).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_1);

                DogEnemyLevel2 DogEnemy_2 = new DogEnemyLevel2(getMapTile(39,
                                47).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_2);

                DogEnemyLevel2 DogEnemy_3 = new DogEnemyLevel2(getMapTile(45,
                                47).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_3);

                DogEnemyLevel2 DogEnemy_4 = new DogEnemyLevel2(getMapTile(48,
                                47).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_4);

                DogEnemyLevel2 DogEnemy_5 = new DogEnemyLevel2(getMapTile(60,
                                47).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_5);

                 DogEnemyLevel2 DogEnemy_6 = new DogEnemyLevel2(getMapTile(66,
                                47).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_6);

                 DogEnemyLevel2 DogEnemy_7 = new DogEnemyLevel2(getMapTile(71,
                                47).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_7);

                 DogEnemyLevel2 DogEnemy_8 = new DogEnemyLevel2(getMapTile(85,
                                47).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_8);

                DogEnemyLevel2 DogEnemy_9 = new DogEnemyLevel2(getMapTile(95,
                                47).getLocation().subtractY(10), Direction.LEFT);
                enemies.add(DogEnemy_9);

                DogEnemyLevel2 DogEnemy_10 = new DogEnemyLevel2(getMapTile(66,
                                33).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_10);

                DogEnemyLevel2 DogEnemy_11 = new DogEnemyLevel2(getMapTile(69,
                                36).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_11);

                DogEnemyLevel2 DogEnemy_12 = new DogEnemyLevel2(getMapTile(53,
                                33).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_12);

                 DogEnemyLevel2 DogEnemy_13 = new DogEnemyLevel2(getMapTile(47,
                                36).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_13);

                 DogEnemyLevel2 DogEnemy_14 = new DogEnemyLevel2(getMapTile(41,
                                36).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_14);

                DogEnemyLevel2 DogEnemy_15 = new DogEnemyLevel2(getMapTile(22,
                                33).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_15);
                DogEnemyLevel2 DogEnemy_16 = new DogEnemyLevel2(getMapTile(3,
                                29).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_16);
                
                DogEnemyLevel2 DogEnemy_17 = new DogEnemyLevel2(getMapTile(6,
                                32).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_17);    
                
                DogEnemyLevel2 DogEnemy_18 = new DogEnemyLevel2(getMapTile(19,
                                23).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_18);

                 DogEnemyLevel2 DogEnemy_19 = new DogEnemyLevel2(getMapTile(33,
                                25).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_19);

                DogEnemyLevel2 DogEnemy_20 = new DogEnemyLevel2(getMapTile(66,
                                20).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_20);

                 DogEnemyLevel2 DogEnemy_21 = new DogEnemyLevel2(getMapTile(73,
                                15).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_21);

                DogEnemyLevel2 DogEnemy_22 = new DogEnemyLevel2(getMapTile(77,
                                12).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_22);

                DogEnemyLevel2 DogEnemy_23 = new DogEnemyLevel2(getMapTile(84,
                                11).getLocation().subtractY(10), Direction.RIGHT);
                enemies.add(DogEnemy_23);

                PrisonGuardEnemy Guard_1 = new PrisonGuardEnemy(getMapTile(11, 45).getLocation().subtractY(75),
                                getMapTile(17, 45).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_1);

                PrisonGuardEnemy Guard_2 = new PrisonGuardEnemy(getMapTile(26, 42).getLocation().subtractY(75),
                                getMapTile(31, 42).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_2);

                PrisonGuardEnemy Guard_3 = new PrisonGuardEnemy(getMapTile(42, 44).getLocation().subtractY(75),
                                getMapTile(45, 44).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_3);

                 PrisonGuardEnemy Guard_6 = new PrisonGuardEnemy(getMapTile(52, 45).getLocation().subtractY(75),
                                getMapTile(55, 45).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_6);

                PrisonGuardEnemy Guard_4 = new PrisonGuardEnemy(getMapTile(62, 43).getLocation().subtractY(75),
                                getMapTile(65, 43).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_4);

                PrisonGuardEnemy Guard_5 = new PrisonGuardEnemy(getMapTile(67, 43).getLocation().subtractY(75),
                                getMapTile(70, 43).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_5);

                PrisonGuardEnemy Guard_7 = new PrisonGuardEnemy(getMapTile(95, 36).getLocation().subtractY(75),
                                getMapTile(98, 36).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_7);

                PrisonGuardEnemy Guard_8 = new PrisonGuardEnemy(getMapTile(89, 33).getLocation().subtractY(75),
                                getMapTile(92, 33).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_8);

                PrisonGuardEnemy Guard_9 = new PrisonGuardEnemy(getMapTile(81, 31).getLocation().subtractY(75),
                                getMapTile(85, 31).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_9);

                PrisonGuardEnemy Guard_10 = new PrisonGuardEnemy(getMapTile(59, 29).getLocation().subtractY(75),
                                getMapTile(63, 29).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_10);

                PrisonGuardEnemy Guard_11 = new PrisonGuardEnemy(getMapTile(46, 31).getLocation().subtractY(75),
                                getMapTile(49, 31).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_11);

                PrisonGuardEnemy Guard_12 = new PrisonGuardEnemy(getMapTile(40, 31).getLocation().subtractY(75),
                                getMapTile(45, 31).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_12);

                PrisonGuardEnemy Guard_13 = new PrisonGuardEnemy(getMapTile(30, 30).getLocation().subtractY(75),
                                getMapTile(35, 30).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_13);

                Hunter Hunter_1 = new Hunter(getMapTile(30, 25).getLocation().subtractY(75),
                                getMapTile(38, 25).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Hunter_1);

                Hunter Hunter_2 = new Hunter(getMapTile(50, 15).getLocation().subtractY(75),
                                getMapTile(53, 15).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Hunter_2);

                Hunter Hunter_3 = new Hunter(getMapTile(86, 12).getLocation().subtractY(75),
                                getMapTile(99, 12).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Hunter_3);

                Hunter Hunter_4 = new Hunter(getMapTile(3, 25).getLocation().subtractY(75),
                                getMapTile(7, 25).getLocation().subtractY(75), Direction.LEFT);
                enemies.add(Hunter_4);

                Hunter Hunter_5 = new Hunter(getMapTile(22, 21).getLocation().subtractY(75),
                                getMapTile(26, 21).getLocation().subtractY(75), Direction.LEFT);
                enemies.add(Hunter_5);

               Hunter Hunter_6 = new Hunter(getMapTile(55, 17).getLocation().subtractY(75),
                                getMapTile(60, 17).getLocation().subtractY(75), Direction.LEFT);
                enemies.add(Hunter_6);

                Hunter Hunter_7 = new Hunter(getMapTile(63, 20).getLocation().subtractY(75),
                                getMapTile(69, 20).getLocation().subtractY(75), Direction.LEFT);
                enemies.add(Hunter_7);

                return enemies;
        }

}
