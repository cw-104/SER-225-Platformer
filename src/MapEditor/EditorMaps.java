package MapEditor;

import Level.Map;
import Maps.TestEnvironment;
import Maps.TestMap;
import Maps.TitleScreenMap;
import Maps.CutsceneLev3Map;
import Maps.FinalCutsceneMap;
import Maps.ShopHallMap;
import Maps.Lab;
import Maps.Lab_copy;
import Maps.Space;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {
            {
                add("TestMap");
                add("TitleScreen");
                add("TestEnvironment");
                add("Lab");
                add("Lab_copy");
                add("ShopHallMap");
                add("CutsceneLev3Map");
                add("Space");
                add("FinalCutsceneMap");
            }
        };
    }

    public static Map getMapByName(String mapName) {
        switch (mapName) {
            case "TestMap":
                return new TestMap();
            case "TitleScreen":
                return new TitleScreenMap();
            case "TestEnvironment":
                return new TestEnvironment();
            case "Lab":
                return new Lab();
            case "Lab_copy":
                return new Lab_copy();
            case "CutsceneLev3Map":
                return new CutsceneLev3Map();
            case "ShopHallMap":
                return new ShopHallMap();
            case "Space":
                return new Space();
            case "FinalCutsceneMap":
                return new FinalCutsceneMap();
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
