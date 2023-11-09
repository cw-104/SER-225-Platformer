package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import GameObject.ImageEffect;
import Level.TileType;
import Level.Tileset;
import Utils.SlopeTileLayoutUtils;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class ForestTileset extends Tileset {

        public ForestTileset() {
                super(ImageLoader.load("ForestTileset.png"), 25, 25, 3);
        }

        @Override
        public ArrayList<MapTileBuilder> defineTiles() {
                ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

                /*
                 * Frame Preset
                 * 
                 * Frame frameName = new FrameBuilder(getSubImage(0,0))
                 * .withScale(tileScale)
                 * .build();
                 * MapTileBuilder tileName = new MapTileBuilder(frameName)
                 * .withTileType(TileType.TYPE);
                 * mapTiles.add(tileName)
                 */

                // Cave Background 0,0 - 0,5 - 1,0 - 1, 5
                Frame CaveBackgroundFrame_0 = new FrameBuilder(getSubImage(0, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_0 = new MapTileBuilder(CaveBackgroundFrame_0)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_0);

                Frame CaveBackgroundFrame_1 = new FrameBuilder(getSubImage(0, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_1 = new MapTileBuilder(CaveBackgroundFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_1);

                Frame CaveBackgroundFrame_2 = new FrameBuilder(getSubImage(0, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_2 = new MapTileBuilder(CaveBackgroundFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_2);

                Frame CaveBackgroundFrame_3 = new FrameBuilder(getSubImage(0, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_3 = new MapTileBuilder(CaveBackgroundFrame_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_3);

                Frame CaveBackgroundFrame_4 = new FrameBuilder(getSubImage(0, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_4 = new MapTileBuilder(CaveBackgroundFrame_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_4);

                Frame CaveBackgroundFrame_5 = new FrameBuilder(getSubImage(0, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_5 = new MapTileBuilder(CaveBackgroundFrame_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_5);

                Frame CaveBackgroundFrame_6 = new FrameBuilder(getSubImage(1, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_6 = new MapTileBuilder(CaveBackgroundFrame_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_6);

                Frame CaveBackgroundFrame_7 = new FrameBuilder(getSubImage(1, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_7 = new MapTileBuilder(CaveBackgroundFrame_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_7);

                Frame CaveBackgroundFrame_8 = new FrameBuilder(getSubImage(1, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_8 = new MapTileBuilder(CaveBackgroundFrame_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_8);

                Frame CaveBackgroundFrame_9 = new FrameBuilder(getSubImage(1, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_9 = new MapTileBuilder(CaveBackgroundFrame_9)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_9);

                Frame CaveBackgroundFrame_10 = new FrameBuilder(getSubImage(1, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_10 = new MapTileBuilder(CaveBackgroundFrame_10)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_10);

                Frame CaveBackgroundFrame_11 = new FrameBuilder(getSubImage(1, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_11 = new MapTileBuilder(CaveBackgroundFrame_11)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_11);

                Frame CaveBackgroundFrame_12 = new FrameBuilder(getSubImage(1, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveBackgroundTile_12 = new MapTileBuilder(CaveBackgroundFrame_12)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(CaveBackgroundTile_12);

                // Cave Ground 0,7 - 0,8 - 0,10 - 0,11 - 1,7 - 1,8 - 1,10 - 1,11
                Frame CaveGroundFrame_0 = new FrameBuilder(getSubImage(0, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveGroundTile_0 = new MapTileBuilder(CaveGroundFrame_0)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(CaveGroundTile_0);

                Frame CaveGroundFrame_1 = new FrameBuilder(getSubImage(0, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveGroundTile_1 = new MapTileBuilder(CaveGroundFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(CaveGroundTile_1);

                Frame CaveGroundFrame_2 = new FrameBuilder(getSubImage(1, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveGroundTile_2 = new MapTileBuilder(CaveGroundFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(CaveGroundTile_2);

                Frame CaveGroundFrame_3 = new FrameBuilder(getSubImage(1, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveGroundTile_3 = new MapTileBuilder(CaveGroundFrame_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(CaveGroundTile_3);

                Frame CaveGroundFrame_4 = new FrameBuilder(getSubImage(0, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveGroundTile_4 = new MapTileBuilder(CaveGroundFrame_4)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(CaveGroundTile_4);

                Frame CaveGroundFrame_5 = new FrameBuilder(getSubImage(0, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveGroundTile_5 = new MapTileBuilder(CaveGroundFrame_5)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(CaveGroundTile_5);

                Frame CaveGroundFrame_6 = new FrameBuilder(getSubImage(1, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveGroundTile_6 = new MapTileBuilder(CaveGroundFrame_6)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(CaveGroundTile_6);

                Frame CaveGroundFrame_7 = new FrameBuilder(getSubImage(1, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder CaveGroundTile_7 = new MapTileBuilder(CaveGroundFrame_7)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(CaveGroundTile_7);

                // Forest Background 3,0 - 3,5 - 4,0 - 4,5
                Frame ForestBackgroundFrame_0 = new FrameBuilder(getSubImage(3, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_0 = new MapTileBuilder(ForestBackgroundFrame_0)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_0);

                Frame ForestBackgroundFrame_1 = new FrameBuilder(getSubImage(3, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_1 = new MapTileBuilder(ForestBackgroundFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_1);

                Frame ForestBackgroundFrame_2 = new FrameBuilder(getSubImage(3, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_2 = new MapTileBuilder(ForestBackgroundFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_2);

                Frame ForestBackgroundFrame_3 = new FrameBuilder(getSubImage(3, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_3 = new MapTileBuilder(ForestBackgroundFrame_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_3);

                Frame ForestBackgroundFrame_4 = new FrameBuilder(getSubImage(3, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_4 = new MapTileBuilder(ForestBackgroundFrame_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_4);

                Frame ForestBackgroundFrame_5 = new FrameBuilder(getSubImage(3, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_5 = new MapTileBuilder(ForestBackgroundFrame_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_5);

                Frame ForestBackgroundFrame_6 = new FrameBuilder(getSubImage(4, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_6 = new MapTileBuilder(ForestBackgroundFrame_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_6);

                Frame ForestBackgroundFrame_7 = new FrameBuilder(getSubImage(4, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_7 = new MapTileBuilder(ForestBackgroundFrame_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_7);

                Frame ForestBackgroundFrame_8 = new FrameBuilder(getSubImage(4, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_8 = new MapTileBuilder(ForestBackgroundFrame_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_8);

                Frame ForestBackgroundFrame_9 = new FrameBuilder(getSubImage(4, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_9 = new MapTileBuilder(ForestBackgroundFrame_9)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_9);

                Frame ForestBackgroundFrame_10 = new FrameBuilder(getSubImage(4, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_10 = new MapTileBuilder(ForestBackgroundFrame_10)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_10);

                Frame ForestBackgroundFrame_11 = new FrameBuilder(getSubImage(4, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_11 = new MapTileBuilder(ForestBackgroundFrame_11)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_11);

                Frame ForestBackgroundFrame_12 = new FrameBuilder(getSubImage(4, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestBackgroundTile_12 = new MapTileBuilder(ForestBackgroundFrame_12)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestBackgroundTile_12);

                // Forest Ground 6,0 - 6,4 - 7,0 - 7,4

                Frame ForestGroundFrame_0 = new FrameBuilder(getSubImage(6, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_0 = new MapTileBuilder(ForestGroundFrame_0)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_0);

                Frame ForestGroundFrame_1 = new FrameBuilder(getSubImage(6, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_1 = new MapTileBuilder(ForestGroundFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_1);

                Frame ForestGroundFrame_2 = new FrameBuilder(getSubImage(6, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_2 = new MapTileBuilder(ForestGroundFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_2);

                Frame ForestGroundFrame_3 = new FrameBuilder(getSubImage(6, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_3 = new MapTileBuilder(ForestGroundFrame_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_3);

                Frame ForestGroundFrame_4 = new FrameBuilder(getSubImage(6, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_4 = new MapTileBuilder(ForestGroundFrame_4)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_4);

                Frame ForestGroundFrame_5 = new FrameBuilder(getSubImage(7, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_5 = new MapTileBuilder(ForestGroundFrame_5)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_5);

                Frame ForestGroundFrame_6 = new FrameBuilder(getSubImage(7, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_6 = new MapTileBuilder(ForestGroundFrame_6)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_6);

                Frame ForestGroundFrame_7 = new FrameBuilder(getSubImage(7, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_7 = new MapTileBuilder(ForestGroundFrame_7)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_7);

                Frame ForestGroundFrame_8 = new FrameBuilder(getSubImage(7, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_8 = new MapTileBuilder(ForestGroundFrame_8)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_8);

                Frame ForestGroundFrame_9 = new FrameBuilder(getSubImage(7, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTile_9 = new MapTileBuilder(ForestGroundFrame_9)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTile_9);

                // Trunks 6,5 - 6,6 - 7,5 - 7,6

                Frame ForestGroundTrunkFrame_0 = new FrameBuilder(getSubImage(6, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTrunkTile_0 = new MapTileBuilder(ForestGroundTrunkFrame_0)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTrunkTile_0);

                Frame ForestGroundTrunkFrame_1 = new FrameBuilder(getSubImage(6, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTrunkTile_1 = new MapTileBuilder(ForestGroundTrunkFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTrunkTile_1);

                Frame ForestGroundTrunkFrame_2 = new FrameBuilder(getSubImage(7, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTrunkTile_2 = new MapTileBuilder(ForestGroundTrunkFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTrunkTile_2);

                Frame ForestGroundTrunkFrame_3 = new FrameBuilder(getSubImage(7, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundTrunkTile_3 = new MapTileBuilder(ForestGroundTrunkFrame_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ForestGroundTrunkTile_3);

                // Forest Ground Slope 6,7 - 6,9 - 7,7 - 7,9

                Frame ForestGroundSlopeFrame_0 = new FrameBuilder(getSubImage(6, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundSlopeTile_0 = new MapTileBuilder(ForestGroundSlopeFrame_0)
                                .withTileType(TileType.SLOPE);

                mapTiles.add(ForestGroundSlopeTile_0);

                Frame ForestGroundSlopeFrame_1 = new FrameBuilder(getSubImage(6, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundSlopeTile_1 = new MapTileBuilder(ForestGroundSlopeFrame_1)
                                .withTileType(TileType.SLOPE);

                mapTiles.add(ForestGroundSlopeTile_1);

                Frame ForestGroundSlopeFrame_2 = new FrameBuilder(getSubImage(6, 9))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundSlopeTile_2 = new MapTileBuilder(ForestGroundSlopeFrame_2)
                                .withTileType(TileType.SLOPE);

                mapTiles.add(ForestGroundSlopeTile_2);

                Frame ForestGroundSlopeFrame_3 = new FrameBuilder(getSubImage(7, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundSlopeTile_3 = new MapTileBuilder(ForestGroundSlopeFrame_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestGroundSlopeTile_3);

                Frame ForestGroundSlopeFrame_4 = new FrameBuilder(getSubImage(7, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundSlopeTile_4 = new MapTileBuilder(ForestGroundSlopeFrame_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestGroundSlopeTile_4);

                Frame ForestGroundSlopeFrame_5 = new FrameBuilder(getSubImage(7, 9))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ForestGroundSlopeTile_5 = new MapTileBuilder(ForestGroundSlopeFrame_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ForestGroundSlopeTile_5);

                // Log 6,6 - 7,5 - 7,6
                Frame LogFrame_0 = new FrameBuilder(getSubImage(6, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder LogTile_0 = new MapTileBuilder(LogFrame_0)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(LogTile_0);

                Frame LogFrame_1 = new FrameBuilder(getSubImage(7, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder LogTile_1 = new MapTileBuilder(LogFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(LogTile_1);

                Frame LogFrame_2 = new FrameBuilder(getSubImage(7, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder LogTile_2 = new MapTileBuilder(LogFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(LogTile_2);

                // Small Tree 7,11 - 7,12 - 10,11 - 10,12
                Frame SmallTreeFrame_0 = new FrameBuilder(getSubImage(7, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SmallTreeTile_0 = new MapTileBuilder(SmallTreeFrame_0)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SmallTreeTile_0);

                Frame SmallTreeFrame_1 = new FrameBuilder(getSubImage(7, 12))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SmallTreeTile_1 = new MapTileBuilder(SmallTreeFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SmallTreeTile_1);

                Frame SmallTreeFrame_2 = new FrameBuilder(getSubImage(8, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SmallTreeTile_2 = new MapTileBuilder(SmallTreeFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SmallTreeTile_2);

                Frame SmallTreeFrame_3 = new FrameBuilder(getSubImage(8, 12))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SmallTreeTile_3 = new MapTileBuilder(SmallTreeFrame_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SmallTreeTile_3);

                Frame SmallTreeFrame_4 = new FrameBuilder(getSubImage(9, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SmallTreeTile_4 = new MapTileBuilder(SmallTreeFrame_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SmallTreeTile_4);

                Frame SmallTreeFrame_5 = new FrameBuilder(getSubImage(9, 12))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SmallTreeTile_5 = new MapTileBuilder(SmallTreeFrame_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SmallTreeTile_5);

                Frame SmallTreeFrame_6 = new FrameBuilder(getSubImage(10, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SmallTreeTile_6 = new MapTileBuilder(SmallTreeFrame_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SmallTreeTile_6);

                Frame SmallTreeFrame_7 = new FrameBuilder(getSubImage(10, 12))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SmallTreeTile_7 = new MapTileBuilder(SmallTreeFrame_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SmallTreeTile_7);

                // Large Tree x13-17, y4-10
                Frame BigTreeFrame_0 = new FrameBuilder(getSubImage(5, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_0 = new MapTileBuilder(BigTreeFrame_0)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_0);

                Frame BigTreeFrame_1 = new FrameBuilder(getSubImage(5, 14))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_1 = new MapTileBuilder(BigTreeFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_1);

                Frame BigTreeFrame_2 = new FrameBuilder(getSubImage(5, 15))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_2 = new MapTileBuilder(BigTreeFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_2);

                Frame BigTreeFrame_3 = new FrameBuilder(getSubImage(5, 16))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_3 = new MapTileBuilder(BigTreeFrame_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_3);

                Frame BigTreeFrame_4 = new FrameBuilder(getSubImage(5, 17))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_4 = new MapTileBuilder(BigTreeFrame_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_4);

                Frame BigTreeFrame_5 = new FrameBuilder(getSubImage(6, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_5 = new MapTileBuilder(BigTreeFrame_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_5);

                Frame BigTreeFrame_6 = new FrameBuilder(getSubImage(6, 14))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_6 = new MapTileBuilder(BigTreeFrame_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_6);

                Frame BigTreeFrame_7 = new FrameBuilder(getSubImage(6, 15))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_7 = new MapTileBuilder(BigTreeFrame_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_7);

                Frame BigTreeFrame_8 = new FrameBuilder(getSubImage(6, 16))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_8 = new MapTileBuilder(BigTreeFrame_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_8);

                Frame BigTreeFrame_9 = new FrameBuilder(getSubImage(6, 17))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_9 = new MapTileBuilder(BigTreeFrame_9)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_9);

                Frame BigTreeFrame_10 = new FrameBuilder(getSubImage(7, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_10 = new MapTileBuilder(BigTreeFrame_10)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_10);

                Frame BigTreeFrame_11 = new FrameBuilder(getSubImage(7, 14))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_11 = new MapTileBuilder(BigTreeFrame_11)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_11);

                Frame BigTreeFrame_12 = new FrameBuilder(getSubImage(7, 15))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_12 = new MapTileBuilder(BigTreeFrame_12)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_12);

                Frame BigTreeFrame_13 = new FrameBuilder(getSubImage(7, 16))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_13 = new MapTileBuilder(BigTreeFrame_13)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_13);

                Frame BigTreeFrame_14 = new FrameBuilder(getSubImage(7, 17))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_14 = new MapTileBuilder(BigTreeFrame_14)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_14);

                Frame BigTreeFrame_15 = new FrameBuilder(getSubImage(8, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_15 = new MapTileBuilder(BigTreeFrame_15)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_15);

                Frame BigTreeFrame_16 = new FrameBuilder(getSubImage(8, 14))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_16 = new MapTileBuilder(BigTreeFrame_16)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_16);

                Frame BigTreeFrame_17 = new FrameBuilder(getSubImage(8, 15))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_17 = new MapTileBuilder(BigTreeFrame_17)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_17);

                Frame BigTreeFrame_18 = new FrameBuilder(getSubImage(8, 16))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_18 = new MapTileBuilder(BigTreeFrame_18)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_18);

                Frame BigTreeFrame_19 = new FrameBuilder(getSubImage(8, 17))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_19 = new MapTileBuilder(BigTreeFrame_19)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_19);

                Frame BigTreeFrame_20 = new FrameBuilder(getSubImage(9, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_20 = new MapTileBuilder(BigTreeFrame_20)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_20);

                Frame BigTreeFrame_21 = new FrameBuilder(getSubImage(9, 14))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_21 = new MapTileBuilder(BigTreeFrame_21)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_21);

                Frame BigTreeFrame_22 = new FrameBuilder(getSubImage(9, 15))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_22 = new MapTileBuilder(BigTreeFrame_22)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_22);

                Frame BigTreeFrame_23 = new FrameBuilder(getSubImage(9, 16))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_23 = new MapTileBuilder(BigTreeFrame_23)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_23);

                Frame BigTreeFrame_24 = new FrameBuilder(getSubImage(9, 17))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_24 = new MapTileBuilder(BigTreeFrame_24)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_24);

                Frame BigTreeFrame_25 = new FrameBuilder(getSubImage(10, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_25 = new MapTileBuilder(BigTreeFrame_25)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_25);

                Frame BigTreeFrame_26 = new FrameBuilder(getSubImage(10, 14))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_26 = new MapTileBuilder(BigTreeFrame_26)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_26);

                Frame BigTreeFrame_27 = new FrameBuilder(getSubImage(10, 15))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_27 = new MapTileBuilder(BigTreeFrame_27)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_27);

                Frame BigTreeFrame_28 = new FrameBuilder(getSubImage(10, 16))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_28 = new MapTileBuilder(BigTreeFrame_28)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_28);

                Frame BigTreeFrame_29 = new FrameBuilder(getSubImage(10, 17))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_29 = new MapTileBuilder(BigTreeFrame_29)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_29);

                Frame BigTreeFrame_30 = new FrameBuilder(getSubImage(10, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_30 = new MapTileBuilder(BigTreeFrame_30)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_30);

                Frame BigTreeFrame_31 = new FrameBuilder(getSubImage(14, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_31 = new MapTileBuilder(BigTreeFrame_31)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_31);

                Frame BigTreeFrame_32 = new FrameBuilder(getSubImage(15, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_32 = new MapTileBuilder(BigTreeFrame_32)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_32);

                Frame BigTreeFrame_33 = new FrameBuilder(getSubImage(16, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_33 = new MapTileBuilder(BigTreeFrame_33)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_33);

                Frame BigTreeFrame_34 = new FrameBuilder(getSubImage(17, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder BigTreeTile_34 = new MapTileBuilder(BigTreeFrame_34)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(BigTreeTile_34);

                return mapTiles;

        }
}