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
import Enemies.Alien;
import Enemies.DogEnemy;
import Enemies.DogEnemyLevel2;
import Enemies.Hunter;
import Enemies.PrisonGuardEnemy;
import Enemies.Robot;
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

                Alien alien_1 = new Alien(getMapTile(45, 54).getLocation().subtractY(98),
                                getMapTile(50, 54).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_1);

                Alien alien_2 = new Alien(getMapTile(53, 54).getLocation().subtractY(98),
                                getMapTile(57, 54).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_2);

                Alien alien_3 = new Alien(getMapTile(77, 54).getLocation().subtractY(98),
                                getMapTile(84, 54).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_3);

                Alien alien_4 = new Alien(getMapTile(92, 54).getLocation().subtractY(98),
                                getMapTile(96, 54).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_4);

                Alien alien_5 = new Alien(getMapTile(117, 45).getLocation().subtractY(98),
                                getMapTile(124, 45).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_5);

                Alien alien_6 = new Alien(getMapTile(109, 42).getLocation().subtractY(98),
                                getMapTile(115, 42).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_6);

                Alien alien_7 = new Alien(getMapTile(120, 35).getLocation().subtractY(98),
                                getMapTile(126, 35).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_7);

                Alien alien_8 = new Alien(getMapTile(134, 40).getLocation().subtractY(98),
                                getMapTile(139, 40).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_8);

                  Alien alien_9 = new Alien(getMapTile(43, 44).getLocation().subtractY(98),
                                getMapTile(47, 44).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_9);
                Alien alien_10= new Alien(getMapTile(53, 43).getLocation().subtractY(98),
                                getMapTile(56, 43).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_10);
                 Alien alien_11= new Alien(getMapTile(65, 43).getLocation().subtractY(98),
                                getMapTile(68, 43).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_11);
                Alien alien_12= new Alien(getMapTile(70, 47).getLocation().subtractY(98),
                                getMapTile(75, 47).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_12);
                Alien alien_13= new Alien(getMapTile(161, 40).getLocation().subtractY(98),
                                getMapTile(165, 40).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_13);
                 Alien alien_14= new Alien(getMapTile(157, 41).getLocation().subtractY(98),
                                getMapTile(160, 41).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_14);
                Alien alien_15= new Alien(getMapTile(166, 41).getLocation().subtractY(98),
                                getMapTile(169, 41).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_15);
                Alien alien_16= new Alien(getMapTile(130, 35).getLocation().subtractY(98),
                                getMapTile(134, 35).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_16);
                 Alien alien_17= new Alien(getMapTile(137, 34).getLocation().subtractY(98),
                                getMapTile(141, 34).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_17);
                Alien alien_18= new Alien(getMapTile(115, 39).getLocation().subtractY(98),
                                getMapTile(119, 39).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_18);



                // Robots
                Robot robot_1 = new Robot(getMapTile(111,
                                54).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_1);

                Robot robot_2 = new Robot(getMapTile(140,
                                54).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_2);

                Robot robot_3 = new Robot(getMapTile(58,
                                47).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_3);

                Robot robot_4 = new Robot(getMapTile(82,
                                48).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_4);

                Robot robot_5 = new Robot(getMapTile(91,
                                48).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_5);

                Robot robot_6 = new Robot(getMapTile(102,
                                35).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_6);

                Robot robot_7 = new Robot(getMapTile(121,
                                30).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_7);

                Robot robot_8 = new Robot(getMapTile(89,
                                39).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_8);
        
                 Robot robot_10 = new Robot(getMapTile(110,
                                27).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_10);
                 Robot robot_11= new Robot(getMapTile(110,
                                30).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_11);
              
                Robot robot_13= new Robot(getMapTile(134,
                                25).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_13);
                Robot robot_14= new Robot(getMapTile(137,
                                52).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_14);
                Robot robot_15= new Robot(getMapTile(130,
                                52).getLocation().subtractY(22), Direction.LEFT);
                enemies.add(robot_15);
                 Robot robot_16= new Robot(getMapTile(124,
                                52).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_16);
                 Robot robot_17= new Robot(getMapTile(117,
                                52).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_17);
                Robot robot_18= new Robot(getMapTile(98,
                                51).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_18);
                Robot robot_19= new Robot(getMapTile(87,
                                51).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_19);
                Robot robot_20= new Robot(getMapTile(72,
                                51).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_20);
                Robot robot_21= new Robot(getMapTile(166,
                                51).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_21);

        


                // Guards
                PrisonGuardEnemy Guard_1 = new PrisonGuardEnemy(getMapTile(8, 50).getLocation().subtractY(75),
                                getMapTile(12, 50).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_1);

                PrisonGuardEnemy Guard_2 = new PrisonGuardEnemy(getMapTile(14, 48).getLocation().subtractY(75),
                                getMapTile(18, 48).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_2);

                PrisonGuardEnemy Guard_3 = new PrisonGuardEnemy(getMapTile(15, 52).getLocation().subtractY(75),
                                getMapTile(17, 52).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_3);

                PrisonGuardEnemy Guard_4 = new PrisonGuardEnemy(getMapTile(20, 48).getLocation().subtractY(75),
                                getMapTile(24, 48).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_4);

                PrisonGuardEnemy Guard_5 = new PrisonGuardEnemy(getMapTile(24, 52).getLocation().subtractY(75),
                                getMapTile(28, 52).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_5);

                PrisonGuardEnemy Guard_6 = new PrisonGuardEnemy(getMapTile(32, 50).getLocation().subtractY(75),
                                getMapTile(36, 50).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_6);

                PrisonGuardEnemy Guard_7 = new PrisonGuardEnemy(getMapTile(62, 51).getLocation().subtractY(75),
                                getMapTile(66, 51).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_7);

                PrisonGuardEnemy Guard_8 = new PrisonGuardEnemy(getMapTile(159, 48).getLocation().subtractY(75),
                                getMapTile(162, 48).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_8);

                PrisonGuardEnemy Guard_9 = new PrisonGuardEnemy(getMapTile(166, 48).getLocation().subtractY(75),
                                getMapTile(169, 48).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_9);

                PrisonGuardEnemy Guard_10 = new PrisonGuardEnemy(getMapTile(156, 50).getLocation().subtractY(75),
                                getMapTile(158, 50).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_10);

                PrisonGuardEnemy Guard_11 = new PrisonGuardEnemy(getMapTile(172, 50).getLocation().subtractY(75),
                                getMapTile(175, 50).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_11);
                PrisonGuardEnemy Guard_12 = new PrisonGuardEnemy(getMapTile(134, 44).getLocation().subtractY(75),
                                getMapTile(138, 44).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_12);
                PrisonGuardEnemy Guard_13 = new PrisonGuardEnemy(getMapTile(141, 44).getLocation().subtractY(75),
                                getMapTile(144, 44).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_13);
                 PrisonGuardEnemy Guard_14 = new PrisonGuardEnemy(getMapTile(122, 40).getLocation().subtractY(75),
                                getMapTile(126, 40).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_14);
                

                return enemies;
        }

}
