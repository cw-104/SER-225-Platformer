package Tilesets;

import Builders.FrameBuilder;
import Builders.MapTileBuilder;
import Engine.ImageLoader;
import GameObject.Frame;
import Level.Tileset;

import java.util.ArrayList;

// This class represents a "common" tileset of standard tiles defined in the CommonTileset.png file
public class LabCutsceneTileset extends Tileset {

    public LabCutsceneTileset() {
        super(ImageLoader.load("BunkerTiles2.png"), 25, 25, 3);
    }

    @Override
    public ArrayList<MapTileBuilder> defineTiles() {
        ArrayList<MapTileBuilder> mapTiles = new ArrayList<>();

        // wall 1
        Frame wall1Frame = new FrameBuilder(getSubImage(0, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall1Tile = new MapTileBuilder(wall1Frame);
                

        mapTiles.add(wall1Tile);

        // wall 2
        Frame wall2Frame = new FrameBuilder(getSubImage(0, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall2Tile = new MapTileBuilder(wall2Frame);
                

        mapTiles.add(wall2Tile);

        // wall 3
        Frame wall3Frame = new FrameBuilder(getSubImage(1, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall3Tile = new MapTileBuilder(wall3Frame);
                

        mapTiles.add(wall3Tile);

        // wall 4
        Frame wall4Frame = new FrameBuilder(getSubImage(1, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder wall4Tile = new MapTileBuilder(wall4Frame);
                

        mapTiles.add(wall4Tile);

        // vent left [5]
        Frame ventLFrame = new FrameBuilder(getSubImage(0, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder ventLTile = new MapTileBuilder(ventLFrame);
                

        mapTiles.add(ventLTile);

        // vent right 
        Frame ventRFrame = new FrameBuilder(getSubImage(0, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder ventRTile = new MapTileBuilder(ventRFrame);
               

        mapTiles.add(ventRTile);

        // cube panel left
        Frame borderCPLFrame = new FrameBuilder(getSubImage(1, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderCPLTile = new MapTileBuilder(borderCPLFrame);
                

        mapTiles.add(borderCPLTile);

         // cube panel right
        Frame borderCPRFrame = new FrameBuilder(getSubImage(1, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderCPRTile = new MapTileBuilder(borderCPRFrame);
                

        mapTiles.add(borderCPRTile);

        // border top left
        Frame borderTLFrame = new FrameBuilder(getSubImage(0, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderTLTile = new MapTileBuilder(borderTLFrame);
                

        mapTiles.add(borderTLTile);

        // border top left mid [10]
        Frame borderTLMFrame = new FrameBuilder(getSubImage(0, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderTLMTile = new MapTileBuilder(borderTLMFrame);
                

        mapTiles.add(borderTLMTile);

        // border top middle
        Frame borderTMFrame = new FrameBuilder(getSubImage(0, 6))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderTMTile = new MapTileBuilder(borderTMFrame);
                

        mapTiles.add(borderTMTile);

        // border top right mid
        Frame borderTRMFrame = new FrameBuilder(getSubImage(0, 7))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderTRMTile = new MapTileBuilder(borderTRMFrame);
                

        mapTiles.add(borderTRMTile);

        // border top right
        Frame borderTRFrame = new FrameBuilder(getSubImage(0, 8))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderTRTile = new MapTileBuilder(borderTRFrame);
                

        mapTiles.add(borderTRTile);

        // border bottom left
        Frame borderBLFrame = new FrameBuilder(getSubImage(1, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderBLTile = new MapTileBuilder(borderBLFrame);
                

        mapTiles.add(borderBLTile);

        // border bottom left mid [15]
        Frame borderBLMFrame = new FrameBuilder(getSubImage(1, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderBLMTile = new MapTileBuilder(borderBLMFrame);

        mapTiles.add(borderBLMTile);

        // border bottom middle
        Frame borderBMFrame = new FrameBuilder(getSubImage(1, 6))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderBMTile = new MapTileBuilder(borderBMFrame);
                

        mapTiles.add(borderBMTile);

          // border bottom right mid
        Frame borderBRMFrame = new FrameBuilder(getSubImage(1, 7))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderBRMTile = new MapTileBuilder(borderBRMFrame);
                

        mapTiles.add(borderBRMTile);

        // border bottom right 
        Frame borderBRFrame = new FrameBuilder(getSubImage(1, 8))
                .withScale(tileScale)
                .build();

        MapTileBuilder borderBRTile = new MapTileBuilder(borderBRFrame);
                

        mapTiles.add(borderBRTile);

        // cube panel 1
        Frame cube1Frame = new FrameBuilder(getSubImage(0, 9))
                .withScale(tileScale)
                .build();

        MapTileBuilder cube1Tile = new MapTileBuilder(cube1Frame);
                

        mapTiles.add(cube1Tile);

        // cube panel 2 [20]
        Frame cube2Frame = new FrameBuilder(getSubImage(0, 10))
                .withScale(tileScale)
                .build();

        MapTileBuilder cube2Tile = new MapTileBuilder(cube2Frame);
                

        mapTiles.add(cube2Tile);
        
        // cube panel 3
        Frame cube3Frame = new FrameBuilder(getSubImage(0, 11))
                .withScale(tileScale)
                .build();

        MapTileBuilder cube3Tile = new MapTileBuilder(cube3Frame);

        mapTiles.add(cube3Tile);

        // cube panel 4
        Frame cube4Frame = new FrameBuilder(getSubImage(1, 9))
                .withScale(tileScale)
                .build();

        MapTileBuilder cube4Tile = new MapTileBuilder(cube4Frame);
                

        mapTiles.add(cube4Tile);

        // cube panel 5
        Frame cube5Frame = new FrameBuilder(getSubImage(1, 10))
                .withScale(tileScale)
                .build();

        MapTileBuilder cube5Tile = new MapTileBuilder(cube5Frame);
                

        mapTiles.add(cube5Tile);

         // screen single panel
        Frame screenFrame = new FrameBuilder(getSubImage(1, 11))
                .withScale(tileScale)
                .build();

        MapTileBuilder screenTile = new MapTileBuilder(screenFrame);
                

        mapTiles.add(screenTile);

        // screen multi panel 1 [25]
        Frame screenM1Frame = new FrameBuilder(getSubImage(0, 12))
                .withScale(tileScale)
                .build();

        MapTileBuilder screenM1Tile = new MapTileBuilder(screenM1Frame);
                

        mapTiles.add(screenM1Tile);

        // screen multi panel 2
        Frame screenM2Frame = new FrameBuilder(getSubImage(0, 13))
                .withScale(tileScale)
                .build();

        MapTileBuilder screenM2Tile = new MapTileBuilder(screenM2Frame);
                

        mapTiles.add(screenM2Tile);

        // screen multi panel 3
        Frame screenM3Frame = new FrameBuilder(getSubImage(0, 14))
                .withScale(tileScale)
                .build();

        MapTileBuilder screenM3Tile = new MapTileBuilder(screenM3Frame);
                

        mapTiles.add(screenM3Tile);

        // screen multi panel 4
        Frame screenM4Frame = new FrameBuilder(getSubImage(1, 12))
                .withScale(tileScale)
                .build();

        MapTileBuilder screenM4Tile = new MapTileBuilder(screenM4Frame);
                

        mapTiles.add(screenM4Tile);

        // screen multi panel 5
        Frame screenM5Frame = new FrameBuilder(getSubImage(1, 13))
                .withScale(tileScale)
                .build();

        MapTileBuilder screenM5Tile = new MapTileBuilder(screenM5Frame);
                

        mapTiles.add(screenM5Tile);

        // screen multi panel 6 [30]
        Frame screenM6Frame = new FrameBuilder(getSubImage(1, 14))
                .withScale(tileScale)
                .build();

        MapTileBuilder screenM6Tile = new MapTileBuilder(screenM6Frame);
                

        mapTiles.add(screenM6Tile);

        // pipes 1
        Frame pipes1Frame = new FrameBuilder(getSubImage(0, 15))
                .withScale(tileScale)
                .build();

        MapTileBuilder pipes1Tile = new MapTileBuilder(pipes1Frame);
                

        mapTiles.add(pipes1Tile);

        // pipes 2
        Frame pipes2Frame = new FrameBuilder(getSubImage(0, 16))
                .withScale(tileScale)
                .build();

        MapTileBuilder pipes2Tile = new MapTileBuilder(pipes2Frame);
                

        mapTiles.add(pipes2Tile);

        // pipes 3
        Frame pipes3Frame = new FrameBuilder(getSubImage(1, 15))
                .withScale(tileScale)
                .build();

        MapTileBuilder pipes3Tile = new MapTileBuilder(pipes3Frame);
                

        mapTiles.add(pipes3Tile);

        // pipes 4
        Frame pipes4Frame = new FrameBuilder(getSubImage(1, 16))
                .withScale(tileScale)
                .build();

        MapTileBuilder pipes4Tile = new MapTileBuilder(pipes4Frame);
                

        mapTiles.add(pipes4Tile);

        // dark gray panel [35]
        Frame darkgreyFrame = new FrameBuilder(getSubImage(2, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder darkgreyTile = new MapTileBuilder(darkgreyFrame);
                

        mapTiles.add(darkgreyTile);

        // light gray panel
        Frame lightgreyFrame = new FrameBuilder(getSubImage(2, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder lightgreyTile = new MapTileBuilder(lightgreyFrame);
                

        mapTiles.add(lightgreyTile);

        // stripes left
        Frame stripesLFrame = new FrameBuilder(getSubImage(2, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder stripesLTile = new MapTileBuilder(stripesLFrame);
                

        mapTiles.add(stripesLTile);

        // stripes right
        Frame stripesRFrame = new FrameBuilder(getSubImage(2, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder stripesRTile = new MapTileBuilder(stripesRFrame);
                

        mapTiles.add(stripesRTile);

        // vertical left
        Frame verticalLFrame = new FrameBuilder(getSubImage(2, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder verticalLTile = new MapTileBuilder(verticalLFrame);
                

        mapTiles.add(verticalLTile);

        // vertical right [40]
        Frame verticalRFrame = new FrameBuilder(getSubImage(2, 5))
                .withScale(tileScale)
                .build();

        MapTileBuilder verticalRTile = new MapTileBuilder(verticalRFrame);
                

        mapTiles.add(verticalRTile);

        // camera
        Frame cameraFrame = new FrameBuilder(getSubImage(3, 0))
                .withScale(tileScale)
                .build();

        MapTileBuilder cameraTile = new MapTileBuilder(cameraFrame);
                

        mapTiles.add(cameraTile);

        // door top
        Frame doorTFrame = new FrameBuilder(getSubImage(3, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder doorTTile = new MapTileBuilder(doorTFrame);
                

        mapTiles.add(doorTTile);

        // door bottom
        Frame doorBFrame = new FrameBuilder(getSubImage(4, 1))
                .withScale(tileScale)
                .build();

        MapTileBuilder doorBTile = new MapTileBuilder(doorBFrame);
                

        mapTiles.add(doorBTile);

        // exit
        Frame exitFrame = new FrameBuilder(getSubImage(3, 2))
                .withScale(tileScale)
                .build();

        MapTileBuilder exitTile = new MapTileBuilder(exitFrame);
                

        mapTiles.add(exitTile);

        // bed 1 [45]
        Frame bed1Frame = new FrameBuilder(getSubImage(3, 3))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed1Tile = new MapTileBuilder(bed1Frame);
                

        mapTiles.add(bed1Tile);

        // bed 2
        Frame bed2Frame = new FrameBuilder(getSubImage(3, 4))
                .withScale(tileScale)
                .build();

        MapTileBuilder bed2Tile = new MapTileBuilder(bed2Frame);
                

        mapTiles.add(bed2Tile);

        return mapTiles;
    }
}

