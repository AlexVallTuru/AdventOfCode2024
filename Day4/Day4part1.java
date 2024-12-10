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
                    //Miro si cap a la dreta el seguent caracter es 'M'
                    //Miro si cap a la esquerra el seguent caracter es una 'M'
                    //Miro si cap a baix el seguent caracter es una 'M'
                    //Miro si cap a dalt el seguent caracter es una 'M'
                    // Miro si la diagonal amunt dreta el seguent caracter es una 'M'
                    // Miro si la diagonal amunt esquerra el seguent caracter es una 'M'
                    // Miro si la diagonal abaix dreta el seguent caracter es una 'M'
                    // Miro si la diagonal abaix esquerra el seguent caracter es una 'M'
                }            
            
            }
            System.out.println();
        }
    }
}
