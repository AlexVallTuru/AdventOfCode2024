package Day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2part2 {

    public static void main(String[] args) throws IOException {

        List<List<Integer>> reports = Utils.readArraysFromFile("Data.txt");
        int result = part2(reports);
        System.out.println("Result: " + result + " <------ \n");
    }

    public static int part2(List<List<Integer>> reports) {

        int result = 0;

        for (List<Integer> report : reports) {
            int err = isSafeDiff(report, 0);
            if (err >= 2)
                result++;
        }
        return result;
    }

    public static int isSafeDiff(List<Integer> report, int err) {
        if (err >= 2) {
            return err;
        }

        int len = report.size();
        if (len < 2) {
            return 0;
        }

        boolean isIncreasing = true, isDecreasing = true;

        for (int i = 1; i < len; i++) {
            int diff = report.get(i) - report.get(i - 1);
            if (Math.abs(diff) > 3 || diff == 0) {
                List<Integer> reportClone = new ArrayList<>(report);
                reportClone.remove(i);
                err = isSafeDiff(reportClone, err + 1);
                return err;
            }

            if (diff > 0)
                isDecreasing = false;
            if (diff < 0)
                isIncreasing = false;
        }

        if (!isIncreasing && !isDecreasing) {
            List<Integer> reportClone = new ArrayList<>(report);
            reportClone.remove(0);
            err = isSafeDiff(reportClone, err + 1);
        }

        return err;
    }
}
