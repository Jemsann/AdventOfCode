package year2015;

import Utils.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import Utils.*;

public class Day2 {
    public static void run() throws IOException {
        System.out.println("Day 2: I was told there would be no math");

        String[] input = Utils.readFileAsSeparateLines("Day2input.txt");

        int totalPaper = 0;
        int ribbon = 0;
        for (String in: input){
            String[] sides = in.split("x");
            totalPaper += calculateSurfaceArea(Integer.parseInt(sides[0]),Integer.parseInt(sides[1]),Integer.parseInt(sides[2]));
            ribbon += calculateRibbonNeeded(Integer.parseInt(sides[0]),Integer.parseInt(sides[1]),Integer.parseInt(sides[2]));
        }

        System.out.format("Total paper is %d \n", totalPaper);
        System.out.format("Total ribbon is %d \n", ribbon);

    }

    private static int calculateSurfaceArea(int length, int width, int height){
        int sideA = length*width;
        int sideB = width*height;
        int sideC = height*length;

        int surface = (2*sideA) + (2*sideB) + (2*sideC);
        int smallestSide = Math.min(Math.min(sideA, sideB), sideC);

        return surface+smallestSide;
    }

    private static int calculateRibbonNeeded(int length, int width, int height){
        int smallest = Math.min(Math.min(length,width),height);//8
        int median = Math.max(Math.min(length,width),Math.min(Math.max(length,width),height));

        int ribbon = smallest+smallest+median+median;
        int bow = length*width*height;
//        System.out.format("Ribbon smallest is %d and median is %d\n", smallest,median);
        return ribbon+bow;
    }
}
