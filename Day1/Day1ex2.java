package Day1;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day1ex2 {
    
    public static void main(String[] args) {

        int[][] arrays;
        try {
            arrays = Utils.readArraysFromFile("data.txt");
            int[] arr1 = arrays[0];
            int[] arr2 = arrays[1];
            // int[] arr1 = new int[]{3,4,2,1,3,3};
            // int[] arr2 = new int[]{4,3,5,3,9,3};
            int result = part2(arr1, arr2);
            System.out.println("Result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int part2(int[] arr1, int[] arr2){

        Map<Integer, Integer> counter = new HashMap<>();
        int len = arr1.length;
        Arrays.stream(arr1).forEach(element -> counter.put(element, 0));

        for (int i = 0; i < len; i++) {
            counter.put(arr2[i], counter.getOrDefault(arr2[i], 0) + 1);
        }
        int result = 0;
        for(int num: arr1){
            result += num * counter.get(num);
        }

        return result;
    }

}
