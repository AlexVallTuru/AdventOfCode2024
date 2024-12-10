// package Day5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day5part1 {

    public static void main(String[] args) {
        try {
            int result = 0;
            Map<Integer, Integer> rules = Utils.getOrder("Data.txt");
            List<List<Integer>> numsLists = Utils.getNumsLists("Data.txt");
            int count = 0;
            for (List<Integer> nums : numsLists) {
                boolean resultBool = sorterAdventofCode(rules, nums);
                if (resultBool) {
                    count++;
                    if (nums.size() % 2 != 0) {
                        int midd = nums.size() / 2;
                        result += nums.get(midd);
                    }
                }
            }
            System.out.println("Resultado: " + result + "\n Contador: " + count);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean sorterAdventofCode(Map<Integer, Integer> rules, List<Integer> nums) {
        List<Integer> numsDels = new ArrayList<>(nums);
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            int actualNumber = nums.get(i);
            Set<Integer> keys = getKeysByValue(rules, actualNumber);
            for (Integer key : keys) {
                if (numsDels.contains(key)) {
                    return false;
                }
                if (numsDels.size() == 1) return true;
            }
            numsDels.remove(Integer.valueOf(actualNumber)); // Ensures that the value, not the index, is deleted
        }
        return true;
    }

    public static Set<Integer> getKeysByValue(Map<Integer, Integer> map, Integer value) {
        Set<Integer> keys = new LinkedHashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}
