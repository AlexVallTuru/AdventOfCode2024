// package Day3;

import java.util.regex.Pattern;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Day3part1 {
    
    public static void main(String[] args) {
        System.out.println("Hello LeetCoder!!");
        Day3part1 d = new Day3part1();
        try {
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

    public static int findTheRegex(String sentence){
        int result = 0;
        // This regex matches the pattern "mul(" followed by one or more digits, a comma, one or more digits, and a closing parenthesis.
        // - "mul\\(" matches the literal string "mul(".
        // - "\\d+" matches one or more digits.
        // - "," matches the literal comma.
        // - "\\d+" matches one or more digits.
        // - "\\)" matches the literal closing parenthesis.
        String regex = "mul\\(\\d+,\\d+\\)";
        Pattern myPattern = Pattern.compile(regex);

        Matcher myMattcher = myPattern.matcher(sentence);
        while(myMattcher.find()){
            String match = myMattcher.group().replace("mul(", "").replace(")", "");
            String[] parts = match.split(",");
            int left = Integer.parseInt(parts[0]);
            int right = Integer.parseInt(parts[1]);
            result += left * right;
        }
        return result;
    }
}
