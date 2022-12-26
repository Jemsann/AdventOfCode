package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Utils {
    public static String readFileAsSingleString(String puzzleInput) throws IOException {
        //String puzzleInput = "src/main/resources/Day1input.txt";
        File puzzleDirectory = new File("src/main/resources/"+puzzleInput);
        Path filePath = Path.of(puzzleDirectory.getAbsolutePath());
        return Files.readString(filePath);
    }

    public static String[] readFileAsSeparateLines(String puzzleInput) throws IOException {
        File puzzleDirectory = new File("src/main/resources/"+puzzleInput);
        Path filePath = Path.of(puzzleDirectory.getAbsolutePath());
        return  Files.readAllLines(filePath).toArray(new String[0]);
    }
}
