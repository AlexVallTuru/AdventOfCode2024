package Day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day2part2 {

    public static void main(String[] args) throws IOException {

        List<List<Integer>> reports = Utils.readArraysFromFile("Data.txt");
        int result = part1(reports);
        System.out.println("Result: " + result);
    }

    public static int part1(List<List<Integer>> reports) {

        int result = 0;

        outerLoop: for (List<Integer> report : reports) {
            
            List<Integer> sortedList = new ArrayList<>(report);
            List<Integer> reverseSortedList = new ArrayList<>(report);

            Collections.sort(sortedList);
            Collections.sort(reverseSortedList, Comparator.reverseOrder());
            int count = 0;
            // 1 3 2 4 5
            
            if (!report.equals(sortedList) && !report.equals(reverseSortedList)) {
                if(contarNumerosDesordenados(report) > 1){
                    continue outerLoop;
                }
            }

            for (int i = 1; i < sortedList.size(); i++) {
                if ((sortedList.get(i) - sortedList.get(i - 1)) > 3 || sortedList.get(i) == sortedList.get(i - 1)) {
                    if (count != 0) {
                        continue outerLoop;
                    } else {
                        count++;
                        sortedList.remove(i);
                        i = 0;
                    }
                }
            }
            result++;
        }

        return result;
    }

    public static int contarNumerosDesordenados(List<Integer> reverseSortedList){

        int len = reverseSortedList.size();
        int result = 0;

        //TODO Identificar si la lista esta ordenada acendientmente o decendientemente.


        boolean ascOrDesc = true;
        //Si esta hacendiente hacer esto
        for (int i = 1; i < len; i++) {
            if(ascOrDesc) {
                if (reverseSortedList.get(i) > reverseSortedList.get(i-1)) {
                    result++;
                 }
            } else {
                if (reverseSortedList.get(i) < reverseSortedList.get(i-1)) {
                    result++;
                 }
            }

        }


        return result;
    }
}
