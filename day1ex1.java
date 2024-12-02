import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day1ex1 {

    public static void main(String[] args) {        
        try {
            int[][] arrays = readArraysFromFile("data.txt");
            int[] arr1 = arrays[0];
            int[] arr2 = arrays[1];
            int result = part1(arr1, arr2);
            System.out.println("Resultado: " + result);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int[][] readArraysFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            list1.add(Integer.parseInt(parts[0]));
            list2.add(Integer.parseInt(parts[1]));
        }
        reader.close();

        int[] arr1 = list1.stream().mapToInt(i -> i).toArray();
        int[] arr2 = list2.stream().mapToInt(i -> i).toArray();

        return new int[][] { arr1, arr2 };
    }

    public static int part1(int[] arr1, int[] arr2) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int len = arr1.length;
        int result = 0;

        for (int i = 0; i < len; i++) result += Math.max(arr1[i], arr2[i]) - Math.min(arr1[i], arr2[i]);
        return result;
    }

}