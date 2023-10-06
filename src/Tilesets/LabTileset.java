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
                super(ImageLoader.load("LabTileset.png"), 50, 50, 3);
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

                // floor tile 1
                Frame floor1Frame = new FrameBuilder(getSubImage(0, 0))
                                .withScale(tileScale)
                                .build();

                MapTileBuilder floor1Tile = new MapTileBuilder(floor1Frame)
                                .withTileType(TileType.NOT_PASSABLE);

                mapTiles.add(floor1Tile);

                Frame blueFrame = new FrameBuilder(getSubImage(0, 1))
                                .withScale(tileScale)
                                .build();
                MapTileBuilder blueTile = new MapTileBuilder(blueFrame)
                                .withTileType(TileType.NOT_PASSABLE);
                mapTiles.add(blueTile);

                return mapTiles;
        }
}