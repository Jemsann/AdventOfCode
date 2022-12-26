package year2015;

import java.io.IOException;
import java.util.*;

public class Day3 {
    public static void run() throws IOException{
       String inputString = Utils.Utils.readFileAsSingleString("Day3input.txt");
       char[] inputs = inputString.toCharArray();

       Set<Position> SantaPosition = new HashSet<>();
       Set<Position> RoboSantaPosition = new HashSet<>();
       boolean santa = false;
       int santaX=0;
       int santaY=0;
       int roboX = 0;
       int roboY=0;
       SantaPosition.add(new Position(santaX,santaY));
       RoboSantaPosition.add(new Position(roboX,roboY));
       int i = 0;
        while (i< inputs.length){
            santa=!santa;
            char currentInput = inputs[i];
            switch (currentInput){
                case '^':
                    if(santa){
                        santaY++;
                    }else{
                        roboY++;
                    }
                    break;
                case '>':
                    if(santa){
                        santaX++;
                    }else{
                        roboX++;
                    }
                    break;
                case 'v':
                    if(santa){
                        santaY--;
                    }else{
                        roboY--;
                    }
                    break;
                case '<':
                    if(santa){
                        santaX--;
                    }else{
                        roboX--;
                    }
                    break;
            }
            if(santa){
                if(!SantaPosition.equals(new Position(santaX,santaY))){
                    SantaPosition.add(new Position(santaX,santaY));
                }
            }else{
                if(!RoboSantaPosition.equals(new Position(roboX,roboY))){
                    RoboSantaPosition.add(new Position(roboX,roboY));
                }
            }
            RoboSantaPosition.removeAll(SantaPosition);
            i++;
        }
        System.out.format("%d got a present", SantaPosition.size()+ RoboSantaPosition.size());
    }

    private static class Position{
        int x;
        int y;

        public Position(int currentX, int currentY) {
            x=currentX;
            y=currentY;
        }

        @Override
        public boolean equals(Object o) {
           if(o instanceof Position){
               Position current = (Position) o;
               if(this.x==current.x&&this.y==current.y){
                   return true;
               }
           }else{
               return false;
           }
           return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Position{" + x +":" + y +'}';
        }
    }
}
