package year2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        System.out.println("Day 1 Not Quite Lisp");

        int initialFloor = 0;
        int basementPosition = 0;
        String input = "";
        ClassLoader classLoader = Day1.class.getClassLoader();

        File Day1Input = new File(classLoader.getResource("Day1input.txt").getFile());
        try {
            Scanner myReader = new Scanner(Day1Input);
            while (myReader.hasNext()){
               input += myReader.next();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

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
}
