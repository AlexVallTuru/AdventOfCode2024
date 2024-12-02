package Day1;
import java.io.IOException;
import java.util.Arrays;


public class Day1ex1 {
    public static void main(String[] args) {        
        try {
            int[][] arrays = Utils.readArraysFromFile("data.txt");
            int[] arr1 = arrays[0];
            int[] arr2 = arrays[1];
            int result = part1(arr1, arr2);
            System.out.println("Resultado: " + result);
        } catch (IOException e){
            e.printStackTrace();
        }
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