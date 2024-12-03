package Day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day2part2 {

    public static void main(String[] args) throws IOException {

        List<List<Integer>> reports = Utils.readArraysFromFile("Data.txt");
        int result = part2(reports);
        System.out.println("Result: " + result + "\n");
    }

    public static int part2(List<List<Integer>> reports) {


        int result = 0;
        outerLoop: for (List<Integer> report : reports) {

            List<Integer> sortedList = new ArrayList<>(report);
            List<Integer> reverseSortedList = new ArrayList<>(report);

            Collections.sort(sortedList);
            Collections.sort(reverseSortedList, Comparator.reverseOrder());
            // 1 3 2 4 5
            int count = 0;
            if (!report.equals(sortedList) && !report.equals(reverseSortedList)) {
                if (!procesarLista(new ArrayList<>(report))) {
                    continue outerLoop;
                } 
                 count++;
            }
            for (int i = 1; i < sortedList.size(); i++) {
                if ((sortedList.get(i) - sortedList.get(i - 1)) > 3 || sortedList.get(i) == sortedList.get(i - 1)) {
                    if (count > 1) {
                        continue outerLoop;
                    } else {
                        count++;
                        sortedList.remove(i);
                        i = 0;
                    }
                }
            }
            if(count <= 1){
                result++;
            }
        }

        return result;
    }

    public static boolean procesarLista(List<Integer> numeros) {
        if (numeros.size() < 2) {
            return true;
        }

        boolean ascendente = numeros.get(0) < numeros.get(1);
        int fueraOrdenCount = 0;

        for (int i = 1; i < numeros.size(); i++) {
            if ((ascendente && numeros.get(i) < numeros.get(i - 1)) ||
                    (!ascendente && numeros.get(i) > numeros.get(i - 1))) {
                fueraOrdenCount++;
                if (fueraOrdenCount > 1) {
                    return false;
                }
                numeros.remove(i);
                i--;
            }
        }
        return true;
    }
}
