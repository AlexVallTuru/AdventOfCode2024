package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<List<Integer>> readArraysFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        List<List<Integer>> report = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            // \\s+ para hacer split de distintos espacios
            String[] parts = line.trim().split("\\s+");
            List<Integer> integers = Arrays.stream(parts).map(Integer::parseInt).collect(Collectors.toList());
            report.add(integers);
        }
        reader.close();

        return report;
    }

}
