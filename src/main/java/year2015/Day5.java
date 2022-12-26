package year2015;

import java.io.IOException;

public class Day5 {

    public enum NAUGHTY{
        ad("ab"), cd("cd"),pg("pq"),xy("xy") ;

        private final String value;
        NAUGHTY(String xy) {
            this.value = xy;
        }
        public String getValue(){
            return this.value;
        }
        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }
    public static void run() throws IOException {
        String[] inputs = Utils.Utils.readFileAsSeparateLines("Day5input.txt");

        int totalNice = 0;

        for(String input : inputs){
            boolean naughty = false;
            int vowels = 0;
            boolean doubleLetters = false;

            char[] inputArray = input.toCharArray();
            for(int i = 0;i<input.length()-1;i++){
                String together = String.valueOf(inputArray[i]) + String.valueOf(inputArray[i+1]);
                for(NAUGHTY naughtyEnum : NAUGHTY.values()){
                    if(together.equals(naughtyEnum.toString())){
                        naughty =true;
                        break;
                    }
                }
            }
            for(int i = 0;i<input.length()-1;i++){
                if(String.valueOf(inputArray[i]).equals(String.valueOf(inputArray[i+1]))){
                    doubleLetters=true;
                    break;
                }
            }

            for(Character ch : inputArray){
                for(VOWELS v : VOWELS.values()){
                    if(String.valueOf(ch).equals(v.toString())){
                        vowels++;
                    }
                }
            }
            System.out.format("%s %d %s %s\n", input, vowels, naughty, doubleLetters);
            if((vowels>=3)&&!naughty&&doubleLetters){
                totalNice++;
            }
        }

        System.out.format("%d are nice!", totalNice);
    }

    public enum VOWELS{
        A('a'), E('e'), I('i'), O('o'), U('u');

        private final char value;
        VOWELS(char a) {
            this.value = a;
        }
        public char getChar(){
            return this.value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }
}
