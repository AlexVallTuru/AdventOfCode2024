package Day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day2part1 {
    
    public static void main(String[] args) throws IOException {
    
        List<List<Integer>> reports = Utils.readArraysFromFile("Data.txt");
        int result = part1(reports);
        System.out.println("Result: " + result);
    }

    public static int part1(List<List<Integer>> reports){
        
        int result = 0;
        
        for(List<Integer> report:reports ){

                List<Integer> sortedList = new ArrayList<>(report);
                List<Integer> reverseSortedList = new ArrayList<>(report);

                Collections.sort(sortedList);
                Collections.sort(reverseSortedList, Comparator.reverseOrder());

                    if (!report.equals(sortedList) && !report.equals(reverseSortedList)) {
                        result++;
                        continue;
                    }
                
                for (int i = 1; i < sortedList.size(); i++) {
                    if((sortedList.get(i) - sortedList.get(i-1)) > 3 || sortedList.get(i) == sortedList.get(i-1)) {
                        result++;
                        break;
                    }
                    
                }
        }

        result = reports.size() -  result; 
        return result;
    }

}
