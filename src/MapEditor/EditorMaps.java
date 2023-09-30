package MapEditor;

import Level.Map;
import Maps.TestEnvironment;
import Maps.TestMap;
import Maps.TitleScreenMap;

import java.util.ArrayList;

public class EditorMaps {
    public static ArrayList<String> getMapNames() {
        return new ArrayList<String>() {
            {
                add("TestMap");
                add("TitleScreen");
                add("TestEnvironment");
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
            default:
                throw new RuntimeException("Unrecognized map name");
        }
    }
}
