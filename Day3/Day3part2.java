package Day3;

import java.util.regex.Pattern;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;

public class Day3part2 {

    private boolean doOrDont = true;

    public static void main(String[] args) {
        System.out.println("Hello LeetCoder!!");
        Day3part2 d = new Day3part2();
        try {
            boolean doOrDont = true;
            List<String> lines = Utils.readArraysFromFile("Data.txt");
            int result = 0;
            for (String line : lines) {
                result += d.findTheRegex(line);
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findTheRegex(String sentence){
        int result = 0;
        // This regex matches the pattern "mul(" followed by one or more digits, a comma, one or more digits, and a closing parenthesis.
        // - "mul\\(" matches the literal string "mul(".
        // - "\\d+" matches one or more digits.
        // - "," matches the literal comma.
        // - "\\d+" matches one or more digits.
        // - "\\)" matches the literal closing parenthesis.
        String regex = "mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)";
        Pattern myPattern = Pattern.compile(regex);

        Matcher myMattcher = myPattern.matcher(sentence);
        while(myMattcher.find()){
            String match = myMattcher.group();
            if(match.startsWith("mul") && doOrDont){
                String[] parts = match.replace("mul(", "").replace(")", "").split(",");
                int left = Integer.parseInt(parts[0]);
                int right = Integer.parseInt(parts[1]);
                result += left * right;
            } else if(match.equals("do()")){
                doOrDont = true;
            } else if(match.equals("don't()")){
                doOrDont = false;
            }
        }
        return result;
    }
}
