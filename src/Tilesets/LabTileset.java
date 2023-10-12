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
public class LabTileset extends Tileset {

        public LabTileset() {
                super(ImageLoader.load("BunkerTileset.png"), 25, 25, 3);
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

                // Background Walls
                Frame wallFrame_1 = new FrameBuilder(getSubImage(0, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder wallTile_1 = new MapTileBuilder(wallFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(wallTile_1);

                Frame wallFrame_2 = new FrameBuilder(getSubImage(0, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder wallTile_2 = new MapTileBuilder(wallFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(wallTile_2);

                Frame wallFrame_3 = new FrameBuilder(getSubImage(1, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder wallTile_3 = new MapTileBuilder(wallFrame_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(wallTile_3);

                Frame wallFrame_4 = new FrameBuilder(getSubImage(1, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder wallTile_4 = new MapTileBuilder(wallFrame_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(wallTile_4);

                Frame wallFrame_5 = new FrameBuilder(getSubImage(2, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder wallTile_5 = new MapTileBuilder(wallFrame_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(wallTile_5);

                Frame wallFrame_6 = new FrameBuilder(getSubImage(2, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder wallTile_6 = new MapTileBuilder(wallFrame_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(wallTile_6);

                // Vents
                Frame ventFrame_1 = new FrameBuilder(getSubImage(0, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ventTile_1 = new MapTileBuilder(ventFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ventTile_1);

                Frame ventFrame_2 = new FrameBuilder(getSubImage(0, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ventTile_2 = new MapTileBuilder(ventFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(ventTile_2);

                // Floor

                Frame floorFrame_1 = new FrameBuilder(getSubImage(0, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder floorTile_1 = new MapTileBuilder(floorFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(floorTile_1);

                Frame floorFrame_2 = new FrameBuilder(getSubImage(0, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder floorTile_2 = new MapTileBuilder(floorFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(floorTile_2);

                Frame floorFrame_3 = new FrameBuilder(getSubImage(0, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder floorTile_3 = new MapTileBuilder(floorFrame_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(floorTile_3);

                Frame floorFrame_4 = new FrameBuilder(getSubImage(0, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder floorTile_4 = new MapTileBuilder(floorFrame_4)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(floorTile_4);

                Frame floorFrame_5 = new FrameBuilder(getSubImage(0, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder floorTile_5 = new MapTileBuilder(floorFrame_5)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(floorTile_5);

                // Ceiling

                Frame ceilingFrame_1 = new FrameBuilder(getSubImage(1, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ceilingTile_1 = new MapTileBuilder(ceilingFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ceilingTile_1);

                Frame ceilingFrame_2 = new FrameBuilder(getSubImage(1, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ceilingTile_2 = new MapTileBuilder(ceilingFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ceilingTile_2);

                Frame ceilingFrame_3 = new FrameBuilder(getSubImage(1, 6))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ceilingTile_3 = new MapTileBuilder(ceilingFrame_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ceilingTile_3);

                Frame ceilingFrame_4 = new FrameBuilder(getSubImage(1, 7))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ceilingTile_4 = new MapTileBuilder(ceilingFrame_4)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ceilingTile_4);

                Frame ceilingFrame_5 = new FrameBuilder(getSubImage(1, 8))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder ceilingTile_5 = new MapTileBuilder(ceilingFrame_5)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(ceilingTile_5);

                // Platform 1
                Frame platform1Frame_1 = new FrameBuilder(getSubImage(1, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder platform1Tile_1 = new MapTileBuilder(platform1Frame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(platform1Tile_1);

                Frame platform1Frame_2 = new FrameBuilder(getSubImage(1, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder platform1Tile_2 = new MapTileBuilder(platform1Frame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(platform1Tile_2);

                // Crates

                Frame crateFrame_1 = new FrameBuilder(getSubImage(0, 9))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder crateTile_1 = new MapTileBuilder(crateFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(crateTile_1);

                Frame crateFrame_2 = new FrameBuilder(getSubImage(0, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder crateTile_2 = new MapTileBuilder(crateFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(crateTile_2);

                Frame crateFrame_3 = new FrameBuilder(getSubImage(0, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder crateTile_3 = new MapTileBuilder(crateFrame_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(crateTile_3);

                Frame crateFrame_4 = new FrameBuilder(getSubImage(1, 9))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder crateTile_4 = new MapTileBuilder(crateFrame_4)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(crateTile_4);

                Frame crateFrame_5 = new FrameBuilder(getSubImage(1, 10))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder crateTile_5 = new MapTileBuilder(crateFrame_5)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(crateTile_5);

                // Terminal
                Frame terminalFrame_1 = new FrameBuilder(getSubImage(0, 12))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder terminalTile_1 = new MapTileBuilder(terminalFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(terminalTile_1);

                Frame terminalFrame_2 = new FrameBuilder(getSubImage(0, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder terminalTile_2 = new MapTileBuilder(terminalFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(terminalTile_2);

                Frame terminalFrame_3 = new FrameBuilder(getSubImage(0, 14))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder terminalTile_3 = new MapTileBuilder(terminalFrame_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(terminalTile_3);
                // Term Bottom
                Frame terminalFrame_4 = new FrameBuilder(getSubImage(1, 12))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder terminalTile_4 = new MapTileBuilder(terminalFrame_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(terminalTile_4);

                Frame terminalFrame_5 = new FrameBuilder(getSubImage(1, 13))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder terminalTile_5 = new MapTileBuilder(terminalFrame_5)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(terminalTile_5);

                Frame terminalFrame_6 = new FrameBuilder(getSubImage(1, 14))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder terminalTile_6 = new MapTileBuilder(terminalFrame_6)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(terminalTile_6);

                // Security Camera

                Frame secCamFrame_1 = new FrameBuilder(getSubImage(3, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder secCamTile_1 = new MapTileBuilder(secCamFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(secCamTile_1);

                // Caution Tile

                Frame cautFrame_1 = new FrameBuilder(getSubImage(2, 2))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder cautTile_1 = new MapTileBuilder(cautFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(cautTile_1);

                Frame cautFrame_2 = new FrameBuilder(getSubImage(2, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder cautTile_2 = new MapTileBuilder(cautFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(cautTile_2);

                // Sideways Floor/Ceiling Tiles

                Frame floorWallFrame_1 = new FrameBuilder(getSubImage(2, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder floorWallTile_1 = new MapTileBuilder(floorWallFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(floorWallTile_1);

                Frame floorWallFrame_2 = new FrameBuilder(getSubImage(2, 5))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder floorWallTile_2 = new MapTileBuilder(floorWallFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(floorWallTile_2);

                // Black Pipes

                Frame bPipeFrame_1 = new FrameBuilder(getSubImage(0, 15))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder bPipeTile_1 = new MapTileBuilder(bPipeFrame_1)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(bPipeTile_1);

                Frame bPipeFrame_2 = new FrameBuilder(getSubImage(0, 16))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder bPipeTile_2 = new MapTileBuilder(bPipeFrame_2)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(bPipeTile_2);

                Frame bPipeFrame_3 = new FrameBuilder(getSubImage(1, 15))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder bPipeTile_3 = new MapTileBuilder(bPipeFrame_3)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(bPipeTile_3);

                Frame bPipeFrame_4 = new FrameBuilder(getSubImage(1, 16))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder bPipeTile_4 = new MapTileBuilder(bPipeFrame_4)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(bPipeTile_4);

                // Intercom

                Frame intercomFrame_1 = new FrameBuilder(getSubImage(1, 11))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder intercomTile_1 = new MapTileBuilder(intercomFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(intercomTile_1);

                // Bed

                Frame bedFrame_1 = new FrameBuilder(getSubImage(3, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder bedTile_1 = new MapTileBuilder(bedFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(bedTile_1);

                Frame bedFrame_2 = new FrameBuilder(getSubImage(3, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder bedTile_2 = new MapTileBuilder(bedFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(bedTile_2);

                // Doors
                Frame doorFrame_1 = new FrameBuilder(getSubImage(3, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder doorTile_1 = new MapTileBuilder(doorFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(doorTile_1);

                Frame doorFrame_2 = new FrameBuilder(getSubImage(4, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder doorTile_2 = new MapTileBuilder(doorFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(doorTile_2);

                // Elevator shaft
                Frame elevatorFrame_1 = new FrameBuilder(getSubImage(5, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder elevatorTile_1 = new MapTileBuilder(elevatorFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(elevatorTile_1);

                Frame elevatorFrame_2 = new FrameBuilder(getSubImage(5, 1))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder elevatorTile_2 = new MapTileBuilder(elevatorFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(elevatorTile_2);

                // Sludge
                Frame sludgeFrame_1 = new FrameBuilder(getSubImage(4, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder sludgeTile_1 = new MapTileBuilder(sludgeFrame_1)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(sludgeTile_1);

                Frame sludgeFrame_2 = new FrameBuilder(getSubImage(4, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder sludgeTile_2 = new MapTileBuilder(sludgeFrame_2)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(sludgeTile_2);

                Frame sludgeFrame_3 = new FrameBuilder(getSubImage(5, 3))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder sludgeTile_3 = new MapTileBuilder(sludgeFrame_3)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(sludgeTile_3);

                Frame sludgeFrame_4 = new FrameBuilder(getSubImage(5, 4))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder sludgeTile_4 = new MapTileBuilder(sludgeFrame_4)
                                .withTileType(TileType.PASSABLE);

                mapTiles.add(sludgeTile_4);

                return mapTiles;

        }
}