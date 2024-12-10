// package Day4;

import java.io.IOException;

public class Day4part1 {

    public static void main(String[] args) {
        Day4part1 d = new Day4part1();
        try {
            char[][] wordSearch = Utils.getMatrix("Data.txt");
            d.wordSearcher(wordSearch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void wordSearcher(char[][] wordSearch) {

        for (int i = 0; i < wordSearch.length; i++) {
            for (int j = 0; j < wordSearch[i].length; j++) {

                if(wordSearch[i][j] == 'X'){
                }            
            
            }
            System.out.println();
        }
    }
}
