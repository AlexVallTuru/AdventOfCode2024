// package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static char[][] getMatrix(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        int numRows = lines.size();
        int numCols = lines.get(0).length();
        char[][] wordSearch = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            wordSearch[i] = lines.get(i).toCharArray();
        }

        return wordSearch;
    }
}