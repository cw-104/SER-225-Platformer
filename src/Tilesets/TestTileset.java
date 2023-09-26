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

//Tileset used for the test environment level 
public class TestTileset extends Tileset {

        public TestTileset() {
                super(ImageLoader.load("TestTileset.png"), 16, 16, 3);
        }

        @Override
        public ArrayList<MapTileBuilder> defineTiles() {
                ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

                // green
                Frame greenFrame = new FrameBuilder(getSubImage(0, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder greenTile = new MapTileBuilder(greenFrame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(greenTile);

                // light blue tile
                Frame lightBlueFrame = new FrameBuilder(getSubImage(0, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder lightBlueTile = new MapTileBuilder(lightBlueFrame);

                mapTiles.add(lightBlueTile);

                // dirt
                Frame dirtFrame = new FrameBuilder(getSubImage(0, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder dirtTile = new MapTileBuilder(dirtFrame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(dirtTile);

                // sun
                Frame[] sunFrames = new Frame[] {
                                new FrameBuilder(getSubImage(2, 0), 50)
                                                .withScale(tileScale)
                                                .build(),
                                new FrameBuilder(getSubImage(2, 1), 50)
                                                .withScale(tileScale)
                                                .build()
                };

                MapTileBuilder sunTile = new MapTileBuilder(sunFrames);

                mapTiles.add(sunTile);

                // tree trunk with full hole
                Frame treeTrunkWithFullHoleFrame = new FrameBuilder(getSubImage(2, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder treeTrunkWithFullHoleTile = new MapTileBuilder(treeTrunkWithFullHoleFrame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(treeTrunkWithFullHoleTile);

                // left end branch
                Frame leftEndBranchFrame = new FrameBuilder(getSubImage(1, 5))
                                .withScale(tileScale)
                                .withBounds(0, 6, 16, 4)
                                .build();

                MapTileBuilder leftEndBranchTile = new MapTileBuilder(leftEndBranchFrame)
                                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

                mapTiles.add(leftEndBranchTile);

                // right end branch
                Frame rightEndBranchFrame = new FrameBuilder(getSubImage(1, 5))
                                .withScale(tileScale)
                                .withBounds(0, 6, 16, 4)
                                .withImageEffect(ImageEffect.FLIP_HORIZONTAL)
                                .build();

                MapTileBuilder rightEndBranchTile = new MapTileBuilder(rightEndBranchFrame)
                                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

                mapTiles.add(rightEndBranchTile);

                // tree trunk
                Frame treeTrunkFrame = new FrameBuilder(getSubImage(1, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder treeTrunkTile = new MapTileBuilder(treeTrunkFrame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(treeTrunkTile);

                // tree top leaves
                Frame treeTopLeavesFrame = new FrameBuilder(getSubImage(1, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder treeTopLeavesTile = new MapTileBuilder(treeTopLeavesFrame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(treeTopLeavesTile);

                // yellow flower
                Frame[] yellowFlowerFrames = new Frame[] {
                                new FrameBuilder(getSubImage(1, 2), 65)
                                                .withScale(tileScale)
                                                .build(),
                                new FrameBuilder(getSubImage(1, 3), 65)
                                                .withScale(tileScale)
                                                .build(),
                                new FrameBuilder(getSubImage(1, 2), 65)
                                                .withScale(tileScale)
                                                .build(),
                                new FrameBuilder(getSubImage(1, 4), 65)
                                                .withScale(tileScale)
                                                .build()
                };

                MapTileBuilder yellowFlowerTile = new MapTileBuilder(yellowFlowerFrames);

                mapTiles.add(yellowFlowerTile);

                // purple flower
                Frame[] purpleFlowerFrames = new Frame[] {
                                new FrameBuilder(getSubImage(0, 3), 65)
                                                .withScale(tileScale)
                                                .build(),
                                new FrameBuilder(getSubImage(0, 4), 65)
                                                .withScale(tileScale)
                                                .build(),
                                new FrameBuilder(getSubImage(0, 3), 65)
                                                .withScale(tileScale)
                                                .build(),
                                new FrameBuilder(getSubImage(0, 5), 65)
                                                .withScale(tileScale)
                                                .build()
                };

                MapTileBuilder purpleFlowerTile = new MapTileBuilder(purpleFlowerFrames);

                mapTiles.add(purpleFlowerTile);

                // middle branch
                Frame middleBranchFrame = new FrameBuilder(getSubImage(2, 3))
                                .withScale(tileScale)
                                .withBounds(0, 6, 16, 4)
                                .build();

                MapTileBuilder middleBranchTile = new MapTileBuilder(middleBranchFrame)
                                .withTileType(TileType.JUMP_THROUGH_PLATFORM);

                mapTiles.add(middleBranchTile);

                // tree trunk hole top
                Frame treeTrunkHoleTopFrame = new FrameBuilder(getSubImage(2, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder treeTrunkHoleTopTile = new MapTileBuilder(treeTrunkHoleTopFrame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(treeTrunkHoleTopTile);

                // tree trunk hole bottom
                Frame treeTrunkHoleBottomFrame = new FrameBuilder(getSubImage(2, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder treeTrunkHoleBottomTile = new MapTileBuilder(treeTrunkHoleBottomFrame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(treeTrunkHoleBottomTile);

                // top water
                Frame topWaterFrame = new FrameBuilder(getSubImage(3, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder topWaterTile = new MapTileBuilder(topWaterFrame);

                mapTiles.add(topWaterTile);

                // blue tile
                Frame waterFrame = new FrameBuilder(getSubImage(3, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder waterTile = new MapTileBuilder(waterFrame)
                                .withTileType(TileType.WATER);

                mapTiles.add(waterTile);

                // grey tile
                Frame greyFrame = new FrameBuilder(getSubImage(3, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder greyTile = new MapTileBuilder(greyFrame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(greyTile);

                // left 45 degree slope
                Frame leftSlopeFrame = new FrameBuilder(getSubImage(3, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder leftSlopeTile = new MapTileBuilder(leftSlopeFrame)
                                .withTileType(TileType.SLOPE)
                                .withTileLayout(SlopeTileLayoutUtils.createLeft45SlopeLayout(spriteWidth,
                                                (int) tileScale));

                mapTiles.add(leftSlopeTile);

                // right 45 degree slope
                Frame rightSlopeFrame = new FrameBuilder(getSubImage(3, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder rightSlopeTile = new MapTileBuilder(rightSlopeFrame)
                                .withTileType(TileType.SLOPE)
                                .withTileLayout(SlopeTileLayoutUtils.createRight45SlopeLayout(spriteWidth,
                                                (int) tileScale));

                mapTiles.add(rightSlopeTile);

                // left 30 degree slope bottom
                Frame leftStairsBottomFrame = new FrameBuilder(getSubImage(4, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder leftStairsBottomTile = new MapTileBuilder(leftStairsBottomFrame)
                                .withTileType(TileType.SLOPE)
                                .withTileLayout(SlopeTileLayoutUtils.createBottomLeft30SlopeLayout(spriteWidth,
                                                (int) tileScale));

                mapTiles.add(leftStairsBottomTile);

                // left 30 degree slope top
                Frame leftStairsTopFrame = new FrameBuilder(getSubImage(4, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder leftStairsTopTile = new MapTileBuilder(leftStairsTopFrame)
                                .withTileType(TileType.SLOPE)
                                .withTileLayout(SlopeTileLayoutUtils.createTopLeft30SlopeLayout(spriteWidth,
                                                (int) tileScale));

                mapTiles.add(leftStairsTopTile);

                // red tile
                Frame redFrame = new FrameBuilder(getSubImage(4, 2))
                                .withScale(tileScale)
                                .build();
                MapTileBuilder redTile = new MapTileBuilder(redFrame)
                                .withTileType(TileType.NOT_PASSABLE);
                mapTiles.add(redTile);

                return mapTiles;
        }

}
