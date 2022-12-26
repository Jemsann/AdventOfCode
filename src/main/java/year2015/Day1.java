package year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws IOException {
        System.out.println("Day 1 Not Quite Lisp");

        int initialFloor = 0;
        int basementPosition = 0;

        String input = getPuzzleInput();

        char[] inputArray = input.toCharArray();
        for (int i = 0;i<inputArray.length;i++) {
            if(inputArray[i]=='('){
                initialFloor++;
            }else if (inputArray[i]==')'){
                initialFloor--;
            }
            if(initialFloor==-1 && basementPosition==0){
                basementPosition = i+1;
            }
        }

        System.out.println("Santa is on floor "+initialFloor);
        System.out.println("Basement position is " + basementPosition);

    }

    private static String getPuzzleInput() throws IOException {
        String puzzleInput = "src/main/resources/Day1input.txt";
        File puzzleDirectory = new File(puzzleInput);
        Path filePath = Path.of(puzzleDirectory.getAbsolutePath());
        return Files.readString(filePath);
    }
}
