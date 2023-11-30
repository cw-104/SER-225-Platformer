//Jason J
// Making tiles was driving me insane and this was the product of that insanity

package Tilesets;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FrameTileGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean repeat = true;

        while (repeat) {
            // Get user input
            System.out.print("Enter Frame Name (e.g., SpaceFrame_0): ");
            String frameName = scanner.next();

            System.out.print("Enter Frame X coordinate(row): ");
            int xCoordinate = scanner.nextInt();

            System.out.print("Enter Frame Y coordinate(col): ");
            int yCoordinate = scanner.nextInt();

            System.out.print("Enter MapTileBuilder Name: ");
            String mapTileName = scanner.next();

            System.out.print("Enter TileType: ");
            String tileType = scanner.next();

            // Get user input for copies
            System.out.print("Do you want to create multiple copies ? (yes/no): ");
            String autoCopyInput = scanner.next().toLowerCase();

            if (autoCopyInput.equals("yes")) {
                System.out.print("Enter the number of copies to create (1-100): ");
                int numberOfCopies = Math.min(Math.max(scanner.nextInt(), 1), 100);

                // Generate and print code for each copy
                for (int i = 0; i < numberOfCopies; i++) {
                    String autoFrameName = frameName + "_" + (i + 1);
                    String autoMapTileName = mapTileName + "_" + (i + 1);
                    int autoYCoordinate = yCoordinate + i;

                    String autoCode = generateCode(autoFrameName, xCoordinate, autoYCoordinate, autoMapTileName,
                            tileType);
                    System.out.println("\nGenerated Code:\n" + autoCode);

                    // Write code to a text file
                    writeToFile(autoCode);
                }
            } else {
                // Generate and print code for a single instance
                String code = generateCode(frameName, xCoordinate, yCoordinate, mapTileName, tileType);
                System.out.println("\nGenerated Code:\n" + code);

                // Write code to a text file
                writeToFile(code);
            }

            // Ask if the user wants to repeat
            System.out.print("\nDo you want to enter another set of values? (yes/no): ");
            String repeatInput = scanner.next().toLowerCase();
            repeat = repeatInput.equals("yes");
        }

        System.out.println("Program terminated.");
        scanner.close();
    }

    private static String generateCode(String frameName, int xCoordinate, int yCoordinate, String mapTileName,
            String tileType) {
        return "Frame " + frameName + " = new FrameBuilder(getSubImage(" + xCoordinate + ", " + yCoordinate + "))"
                + "\n                                .withScale(tileScale)"
                + "\n                                .build();\n\n"
                + "MapTileBuilder " + mapTileName + " = new MapTileBuilder(" + frameName + ")"
                + "\n                                .withTileType(TileType." + tileType + ");\n\n"
                + "mapTiles.add(" + mapTileName + ");";
    }

    private static void writeToFile(String code) {
        try (FileWriter fileWriter = new FileWriter("GeneratedCode.txt", true)) {
            fileWriter.write("\n \n" + code + "\n\n");
            System.out.println("Generated frames written to 'GeneratedCode.txt'");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
