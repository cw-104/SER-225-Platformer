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
public class SpaceTileset extends Tileset {

        public SpaceTileset() {
                super(ImageLoader.load("SpaceTileset.png"), 25, 25, 3);
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

                // Space
                Frame SpaceFrame_0_1 = new FrameBuilder(getSubImage(0, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_0_1 = new MapTileBuilder(SpaceFrame_0_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_0_1);

                Frame SpaceFrame_0_2 = new FrameBuilder(getSubImage(0, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_0_2 = new MapTileBuilder(SpaceFrame_0_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_0_2);

                Frame SpaceFrame_0_3 = new FrameBuilder(getSubImage(0, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_0_3 = new MapTileBuilder(SpaceFrame_0_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_0_3);

                Frame SpaceFrame_0_4 = new FrameBuilder(getSubImage(0, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_0_4 = new MapTileBuilder(SpaceFrame_0_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_0_4);

                Frame SpaceFrame_0_5 = new FrameBuilder(getSubImage(0, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_0_5 = new MapTileBuilder(SpaceFrame_0_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_0_5);

                Frame SpaceFrame_0_6 = new FrameBuilder(getSubImage(0, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_0_6 = new MapTileBuilder(SpaceFrame_0_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_0_6);

                Frame SpaceFrame_0_7 = new FrameBuilder(getSubImage(0, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_0_7 = new MapTileBuilder(SpaceFrame_0_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_0_7);

                Frame SpaceFrame_1_1 = new FrameBuilder(getSubImage(1, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_1_1 = new MapTileBuilder(SpaceFrame_1_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_1_1);

                Frame SpaceFrame_1_2 = new FrameBuilder(getSubImage(1, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_1_2 = new MapTileBuilder(SpaceFrame_1_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_1_2);

                Frame SpaceFrame_1_3 = new FrameBuilder(getSubImage(1, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_1_3 = new MapTileBuilder(SpaceFrame_1_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_1_3);

                Frame SpaceFrame_1_4 = new FrameBuilder(getSubImage(1, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_1_4 = new MapTileBuilder(SpaceFrame_1_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_1_4);

                Frame SpaceFrame_1_5 = new FrameBuilder(getSubImage(1, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_1_5 = new MapTileBuilder(SpaceFrame_1_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_1_5);

                Frame SpaceFrame_1_6 = new FrameBuilder(getSubImage(1, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_1_6 = new MapTileBuilder(SpaceFrame_1_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_1_6);

                Frame SpaceFrame_1_7 = new FrameBuilder(getSubImage(1, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_1_7 = new MapTileBuilder(SpaceFrame_1_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_1_7);

                Frame SpaceFrame_1_8 = new FrameBuilder(getSubImage(1, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_1_8 = new MapTileBuilder(SpaceFrame_1_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_1_8);

                Frame SpaceFrame_2_1 = new FrameBuilder(getSubImage(2, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_2_1 = new MapTileBuilder(SpaceFrame_2_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_2_1);

                Frame SpaceFrame_2_2 = new FrameBuilder(getSubImage(2, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_2_2 = new MapTileBuilder(SpaceFrame_2_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_2_2);

                Frame SpaceFrame_2_3 = new FrameBuilder(getSubImage(2, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_2_3 = new MapTileBuilder(SpaceFrame_2_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_2_3);

                Frame SpaceFrame_2_4 = new FrameBuilder(getSubImage(2, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_2_4 = new MapTileBuilder(SpaceFrame_2_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_2_4);

                Frame SpaceFrame_2_5 = new FrameBuilder(getSubImage(2, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_2_5 = new MapTileBuilder(SpaceFrame_2_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_2_5);

                Frame SpaceFrame_2_6 = new FrameBuilder(getSubImage(2, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_2_6 = new MapTileBuilder(SpaceFrame_2_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_2_6);

                Frame SpaceFrame_2_7 = new FrameBuilder(getSubImage(2, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_2_7 = new MapTileBuilder(SpaceFrame_2_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_2_7);

                Frame SpaceFrame_2_8 = new FrameBuilder(getSubImage(2, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_2_8 = new MapTileBuilder(SpaceFrame_2_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_2_8);

                Frame SpaceFrame_3_1 = new FrameBuilder(getSubImage(3, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_3_1 = new MapTileBuilder(SpaceFrame_3_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_3_1);

                Frame SpaceFrame_3_2 = new FrameBuilder(getSubImage(3, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_3_2 = new MapTileBuilder(SpaceFrame_3_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_3_2);

                Frame SpaceFrame_3_3 = new FrameBuilder(getSubImage(3, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_3_3 = new MapTileBuilder(SpaceFrame_3_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_3_3);

                Frame SpaceFrame_3_4 = new FrameBuilder(getSubImage(3, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_3_4 = new MapTileBuilder(SpaceFrame_3_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_3_4);

                // adding tiles is the worst part of this

                Frame SpaceFrame_3_5 = new FrameBuilder(getSubImage(3, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_3_5 = new MapTileBuilder(SpaceFrame_3_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_3_5);

                Frame SpaceFrame_3_6 = new FrameBuilder(getSubImage(3, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_3_6 = new MapTileBuilder(SpaceFrame_3_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_3_6);

                Frame SpaceFrame_3_7 = new FrameBuilder(getSubImage(3, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_3_7 = new MapTileBuilder(SpaceFrame_3_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_3_7);

                Frame SpaceFrame_3_8 = new FrameBuilder(getSubImage(3, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_3_8 = new MapTileBuilder(SpaceFrame_3_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_3_8);

                Frame SpaceFrame_4_1 = new FrameBuilder(getSubImage(4, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_4_1 = new MapTileBuilder(SpaceFrame_4_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_4_1);

                Frame SpaceFrame_4_2 = new FrameBuilder(getSubImage(4, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_4_2 = new MapTileBuilder(SpaceFrame_4_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_4_2);

                Frame SpaceFrame_4_3 = new FrameBuilder(getSubImage(4, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_4_3 = new MapTileBuilder(SpaceFrame_4_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_4_3);

                Frame SpaceFrame_4_4 = new FrameBuilder(getSubImage(4, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_4_4 = new MapTileBuilder(SpaceFrame_4_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_4_4);

                Frame SpaceFrame_4_5 = new FrameBuilder(getSubImage(4, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_4_5 = new MapTileBuilder(SpaceFrame_4_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_4_5);

                Frame SpaceFrame_4_6 = new FrameBuilder(getSubImage(4, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_4_6 = new MapTileBuilder(SpaceFrame_4_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_4_6);

                Frame SpaceFrame_4_7 = new FrameBuilder(getSubImage(4, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_4_7 = new MapTileBuilder(SpaceFrame_4_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_4_7);

                Frame SpaceFrame_4_8 = new FrameBuilder(getSubImage(4, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder SpaceTile_4_8 = new MapTileBuilder(SpaceFrame_4_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(SpaceTile_4_8);

                // Ship Exterior Tiles
                Frame ShipeExteriorsFrame_0_1 = new FrameBuilder(getSubImage(7, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_1 = new MapTileBuilder(ShipeExteriorsFrame_0_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_1);

                Frame ShipeExteriorsFrame_0_2 = new FrameBuilder(getSubImage(7, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_2 = new MapTileBuilder(ShipeExteriorsFrame_0_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_2);

                Frame ShipeExteriorsFrame_0_3 = new FrameBuilder(getSubImage(7, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_3 = new MapTileBuilder(ShipeExteriorsFrame_0_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_3);

                Frame ShipeExteriorsFrame_0_4 = new FrameBuilder(getSubImage(7, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_4 = new MapTileBuilder(ShipeExteriorsFrame_0_4)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_4);

                Frame ShipeExteriorsFrame_0_5 = new FrameBuilder(getSubImage(7, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_5 = new MapTileBuilder(ShipeExteriorsFrame_0_5)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_5);

                Frame ShipeExteriorsFrame_0_6 = new FrameBuilder(getSubImage(7, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_6 = new MapTileBuilder(ShipeExteriorsFrame_0_6)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_6);

                Frame ShipeExteriorsFrame_0_7 = new FrameBuilder(getSubImage(7, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_7 = new MapTileBuilder(ShipeExteriorsFrame_0_7)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_7);

                Frame ShipeExteriorsFrame_0_8 = new FrameBuilder(getSubImage(7, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_8 = new MapTileBuilder(ShipeExteriorsFrame_0_8)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_8);

                Frame ShipeExteriorsFrame_0_9 = new FrameBuilder(getSubImage(7, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_9 = new MapTileBuilder(ShipeExteriorsFrame_0_9)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_9);

                Frame ShipeExteriorsFrame_0_10 = new FrameBuilder(getSubImage(7, 9))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_10 = new MapTileBuilder(ShipeExteriorsFrame_0_10)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_10);

                Frame ShipeExteriorsFrame_0_11 = new FrameBuilder(getSubImage(7, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_11 = new MapTileBuilder(ShipeExteriorsFrame_0_11)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_11);

                Frame ShipeExteriorsFrame_0_12 = new FrameBuilder(getSubImage(7, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_12 = new MapTileBuilder(ShipeExteriorsFrame_0_12)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_12);

                Frame ShipeExteriorsFrame_0_13 = new FrameBuilder(getSubImage(7, 12))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_0_13 = new MapTileBuilder(ShipeExteriorsFrame_0_13)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_0_13);

                Frame ShipExteriorsFrame_1_1 = new FrameBuilder(getSubImage(8, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_1 = new MapTileBuilder(ShipExteriorsFrame_1_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_1);

                Frame ShipExteriorsFrame_1_2 = new FrameBuilder(getSubImage(8, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_2 = new MapTileBuilder(ShipExteriorsFrame_1_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_2);

                Frame ShipExteriorsFrame_1_3 = new FrameBuilder(getSubImage(8, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_3 = new MapTileBuilder(ShipExteriorsFrame_1_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_3);

                Frame ShipExteriorsFrame_1_4 = new FrameBuilder(getSubImage(8, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_4 = new MapTileBuilder(ShipExteriorsFrame_1_4)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_4);

                Frame ShipExteriorsFrame_1_5 = new FrameBuilder(getSubImage(8, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_5 = new MapTileBuilder(ShipExteriorsFrame_1_5)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_5);

                Frame ShipExteriorsFrame_1_6 = new FrameBuilder(getSubImage(8, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_6 = new MapTileBuilder(ShipExteriorsFrame_1_6)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_6);

                Frame ShipExteriorsFrame_1_7 = new FrameBuilder(getSubImage(8, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_7 = new MapTileBuilder(ShipExteriorsFrame_1_7)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_7);

                Frame ShipExteriorsFrame_1_8 = new FrameBuilder(getSubImage(8, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_8 = new MapTileBuilder(ShipExteriorsFrame_1_8)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_8);

                Frame ShipExteriorsFrame_1_9 = new FrameBuilder(getSubImage(8, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_9 = new MapTileBuilder(ShipExteriorsFrame_1_9)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_9);

                Frame ShipExteriorsFrame_1_10 = new FrameBuilder(getSubImage(8, 9))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_10 = new MapTileBuilder(ShipExteriorsFrame_1_10)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_10);

                Frame ShipExteriorsFrame_1_11 = new FrameBuilder(getSubImage(8, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_11 = new MapTileBuilder(ShipExteriorsFrame_1_11)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_11);

                Frame ShipExteriorsFrame_1_12 = new FrameBuilder(getSubImage(8, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_12 = new MapTileBuilder(ShipExteriorsFrame_1_12)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_12);

                Frame ShipExteriorsFrame_1_13 = new FrameBuilder(getSubImage(8, 12))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipExteriorsTile_1_13 = new MapTileBuilder(ShipExteriorsFrame_1_13)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ShipExteriorsTile_1_13);

                Frame ShipInteriorsFrame_0_1 = new FrameBuilder(getSubImage(10, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_1 = new MapTileBuilder(ShipInteriorsFrame_0_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_1);

                Frame ShipInteriorsFrame_0_2 = new FrameBuilder(getSubImage(10, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_2 = new MapTileBuilder(ShipInteriorsFrame_0_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_2);

                Frame ShipInteriorsFrame_0_3 = new FrameBuilder(getSubImage(10, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_3 = new MapTileBuilder(ShipInteriorsFrame_0_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_3);

                Frame ShipInteriorsFrame_0_4 = new FrameBuilder(getSubImage(10, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_4 = new MapTileBuilder(ShipInteriorsFrame_0_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_4);

                Frame ShipInteriorsFrame_0_5 = new FrameBuilder(getSubImage(10, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_5 = new MapTileBuilder(ShipInteriorsFrame_0_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_5);

                Frame ShipInteriorsFrame_0_6 = new FrameBuilder(getSubImage(10, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_6 = new MapTileBuilder(ShipInteriorsFrame_0_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_6);

                Frame ShipInteriorsFrame_0_7 = new FrameBuilder(getSubImage(10, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_7 = new MapTileBuilder(ShipInteriorsFrame_0_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_7);

                Frame ShipInteriorsFrame_0_8 = new FrameBuilder(getSubImage(10, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_8 = new MapTileBuilder(ShipInteriorsFrame_0_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_8);

                Frame ShipInteriorsFrame_0_9 = new FrameBuilder(getSubImage(10, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_9 = new MapTileBuilder(ShipInteriorsFrame_0_9)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_9);

                Frame ShipInteriorsFrame_0_10 = new FrameBuilder(getSubImage(10, 9))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_10 = new MapTileBuilder(ShipInteriorsFrame_0_10)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_10);

                Frame ShipInteriorsFrame_0_11 = new FrameBuilder(getSubImage(10, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_11 = new MapTileBuilder(ShipInteriorsFrame_0_11)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_11);

                Frame ShipInteriorsFrame_0_12 = new FrameBuilder(getSubImage(10, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_0_12 = new MapTileBuilder(ShipInteriorsFrame_0_12)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_0_12);

                Frame ShipInteriorsFrame_1_1 = new FrameBuilder(getSubImage(11, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_1 = new MapTileBuilder(ShipInteriorsFrame_1_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_1);

                Frame ShipInteriorsFrame_1_2 = new FrameBuilder(getSubImage(11, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_2 = new MapTileBuilder(ShipInteriorsFrame_1_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_2);

                Frame ShipInteriorsFrame_1_3 = new FrameBuilder(getSubImage(11, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_3 = new MapTileBuilder(ShipInteriorsFrame_1_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_3);

                Frame ShipInteriorsFrame_1_4 = new FrameBuilder(getSubImage(11, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_4 = new MapTileBuilder(ShipInteriorsFrame_1_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_4);

                Frame ShipInteriorsFrame_1_5 = new FrameBuilder(getSubImage(11, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_5 = new MapTileBuilder(ShipInteriorsFrame_1_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_5);

                Frame ShipInteriorsFrame_1_6 = new FrameBuilder(getSubImage(11, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_6 = new MapTileBuilder(ShipInteriorsFrame_1_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_6);

                Frame ShipInteriorsFrame_1_7 = new FrameBuilder(getSubImage(11, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_7 = new MapTileBuilder(ShipInteriorsFrame_1_7)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_7);

                Frame ShipInteriorsFrame_1_8 = new FrameBuilder(getSubImage(11, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_8 = new MapTileBuilder(ShipInteriorsFrame_1_8)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_8);

                Frame ShipInteriorsFrame_1_9 = new FrameBuilder(getSubImage(11, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_9 = new MapTileBuilder(ShipInteriorsFrame_1_9)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_9);

                Frame ShipInteriorsFrame_1_10 = new FrameBuilder(getSubImage(11, 9))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_10 = new MapTileBuilder(ShipInteriorsFrame_1_10)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_10);

                Frame ShipInteriorsFrame_1_11 = new FrameBuilder(getSubImage(11, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_11 = new MapTileBuilder(ShipInteriorsFrame_1_11)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_11);

                Frame ShipInteriorsFrame_1_12 = new FrameBuilder(getSubImage(11, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ShipInteriorsTile_1_12 = new MapTileBuilder(ShipInteriorsFrame_1_12)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ShipInteriorsTile_1_12);

                return mapTiles;

        }
}