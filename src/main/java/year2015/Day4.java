package year2015;


public class Day4 {
    public static void run()  {
        System.out.println("Day4: The Ideal Stocking Stuffer");

        String input = "";
        long index = 1;
        String output;
        do {
            String key = String.format("%s%d", input, index++);
            output = org.apache.commons.codec.digest.DigestUtils.md5Hex(key).toUpperCase();
        } while (!output.startsWith("000000"));
        System.out.println(output);
        System.out.printf("%d%n", index-1);
    }
}
