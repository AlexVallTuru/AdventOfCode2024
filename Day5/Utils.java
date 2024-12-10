// package Day3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    
    public Utils() {
    }

    public static Map<Integer, Integer> getOrder(String filePath) throws IOException {
        Map<Integer, Integer> orderMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if (line.contains("|")) {
                    String[] parts = line.split("\\|");
                    int key = Integer.parseInt(parts[0].trim());
                    int value = Integer.parseInt(parts[1].trim());
                    orderMap.put(key, value);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            reader.close();
        }
        return orderMap;
    }

    public static List<List<Integer>> getNumsLists(String filePath) throws IOException {
        List<List<Integer>> numsLists = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty() && !line.contains("|")) {
                    String[] parts = line.split(",");
                    List<Integer> numsList = new ArrayList<>();
                    for (String part : parts) {
                        numsList.add(Integer.parseInt(part.trim()));
                    }
                    numsLists.add(numsList);
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            reader.close();
        }
        return numsLists;
    }
}