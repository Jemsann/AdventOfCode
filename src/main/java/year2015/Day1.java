package year2015;

import java.io.IOException;

import Utils.Utils;

public class Day1 {
    public static void run() throws IOException {
        System.out.println("Day 1 Not Quite Lisp");

        int initialFloor = 0;
        int basementPosition = 0;

        String input = Utils.readFileAsSingleString("Day1input.txt");

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
