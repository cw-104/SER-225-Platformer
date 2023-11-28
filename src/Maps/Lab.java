package Maps;

import java.util.ArrayList;

import javax.management.relation.Role;

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
import Enemies.DogEnemyLevel2;
import Enemies.Hunter;
import Enemies.Alien;
import Enemies.Robot;
import Enemies.PrisonGuardEnemy;
import Engine.ImageLoader;
import EnhancedMapTiles.HorizontalMovingPlatform;
import GameObject.Rectangle;
import GameObject.Coin;

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

                EndLevelBox endLevelBox = new EndLevelBox(getMapTile(98, 27).getLocation());
                enhancedMapTiles.add(endLevelBox);

                return enhancedMapTiles;
        }

        @Override
        public ArrayList<Enemy> loadEnemies() {
                ArrayList<Enemy> enemies = new ArrayList<>();

             /*     Hunter hunter = new Hunter(getMapTile(8 ,9).getLocation().subtractY(63), getMapTile(16, 9).getLocation().subtractY(63), Direction.RIGHT);
                enemies.add(hunter); */
/* 
             Robot robot_1 = new Robot(getMapTile(10,
                                9).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(robot_1);*/


             /*    Alien alien_1 = new Alien(getMapTile(8 ,9).getLocation().subtractY(63), getMapTile(16, 9).getLocation().subtractY(63), Direction.RIGHT);
                enemies.add(alien_1);*/
                 
               /* //use Alien alien_1 = new Alien(getMapTile(8 ,9).getLocation().subtractY(98), getMapTile(16, 9).getLocation().subtractY(98), Direction.RIGHT);
                enemies.add(alien_1);*/

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

                DogEnemy DogEnemy_6 = new DogEnemy(getMapTile(88,
                                13).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_6);
                
                DogEnemy DogEnemy_7 = new DogEnemy(getMapTile(26,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_7);


                DogEnemy DogEnemy_8 = new DogEnemy(getMapTile(27,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_8);

                DogEnemy DogEnemy_9 = new DogEnemy(getMapTile(29,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_9);
                
                
                DogEnemy DogEnemy_11 = new DogEnemy(getMapTile(30,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_11);

             
                DogEnemy DogEnemy_12 = new DogEnemy(getMapTile(31,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_12);
               

                DogEnemy DogEnemy_13 = new DogEnemy(getMapTile(32,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_13);
              

                DogEnemy DogEnemy_14 = new DogEnemy(getMapTile(33,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_14);

         
                DogEnemy DogEnemy_15 = new DogEnemy(getMapTile(34,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_15);

                 DogEnemy DogEnemy_16 = new DogEnemy(getMapTile(35,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_16);
 
                DogEnemy DogEnemy_17 = new DogEnemy(getMapTile(36,
                                24).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_17);

                DogEnemy DogEnemy_18 = new DogEnemy(getMapTile(86,
                                13).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_18);
                
                DogEnemy DogEnemy_19 = new DogEnemy(getMapTile(87,
                                13).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_19);

                 DogEnemy DogEnemy_20 = new DogEnemy(getMapTile(89,
                                13).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_20);
                
                DogEnemy DogEnemy_21 = new DogEnemy(getMapTile(90,
                                13).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_21);
                
                DogEnemy DogEnemy_22 = new DogEnemy(getMapTile(91,
                                13).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_22);
                
                DogEnemy DogEnemy_23 = new DogEnemy(getMapTile(92,
                                13).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_23);
                
                DogEnemy DogEnemy_24 = new DogEnemy(getMapTile(61,
                                9).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_24);

                DogEnemy DogEnemy_25 = new DogEnemy(getMapTile(83,
                                20).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_25);

                DogEnemy DogEnemy_26 = new DogEnemy(getMapTile(71,
                                20).getLocation().subtractY(25), Direction.LEFT);
                enemies.add(DogEnemy_26);

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

                PrisonGuardEnemy Guard_7 = new PrisonGuardEnemy(getMapTile(54, 5).getLocation().subtractY(75),
                                getMapTile(58, 5).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_7);

                PrisonGuardEnemy Guard_8 = new PrisonGuardEnemy(getMapTile(66, 6).getLocation().subtractY(75),
                                getMapTile(69, 6).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_8);

                PrisonGuardEnemy Guard_9 = new PrisonGuardEnemy(getMapTile(70, 5).getLocation().subtractY(75),
                                getMapTile(73, 5).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_9);

                PrisonGuardEnemy Guard_10 = new PrisonGuardEnemy(getMapTile(74, 6).getLocation().subtractY(75),
                                getMapTile(77, 6).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_10);

                PrisonGuardEnemy Guard_11 = new PrisonGuardEnemy(getMapTile(65, 9).getLocation().subtractY(75),
                                getMapTile(70, 9).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_11);

                PrisonGuardEnemy Guard_12 = new PrisonGuardEnemy(getMapTile(72, 9).getLocation().subtractY(75),
                                getMapTile(77, 9).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_12);

                PrisonGuardEnemy Guard_13 = new PrisonGuardEnemy(getMapTile(86, 18).getLocation().subtractY(75),
                                getMapTile(89, 18).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_13);

                PrisonGuardEnemy Guard_14 = new PrisonGuardEnemy(getMapTile(75, 19).getLocation().subtractY(75),
                                getMapTile(78, 19).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_14);

                PrisonGuardEnemy Guard_15 = new PrisonGuardEnemy(getMapTile(79, 20).getLocation().subtractY(75),
                                getMapTile(85, 20).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_15);

                PrisonGuardEnemy Guard_16 = new PrisonGuardEnemy(getMapTile(69, 17).getLocation().subtractY(75),
                                getMapTile(72, 17).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_16);

                PrisonGuardEnemy Guard_17 = new PrisonGuardEnemy(getMapTile(63, 17).getLocation().subtractY(75),
                                getMapTile(66, 17).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_17);

                PrisonGuardEnemy Guard_18 = new PrisonGuardEnemy(getMapTile(58, 17).getLocation().subtractY(75),
                                getMapTile(61, 17).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_18);

                PrisonGuardEnemy Guard_19 = new PrisonGuardEnemy(getMapTile(12, 17).getLocation().subtractY(75),
                                getMapTile(15, 17).getLocation().subtractY(75), Direction.RIGHT);
                enemies.add(Guard_19);

                /*
                 * DinosaurEnemy dinosaurEnemy = new DinosaurEnemy(getMapTile(19,
                 * 1).getLocation().addY(2), getMapTile(22, 1).getLocation().addY(2),
                 * Direction.RIGHT);
                 * enemies.add(dinosaurEnemy);
                 */

                return enemies;
        }

}
