// package Day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5part1 {

    public static void main(String[] args) {

        System.out.println("Hello LeetCoder!!");

        Map<Integer, Integer> rules = new HashMap<>();
        rules.put(47, 53);
        rules.put(97, 13);
        rules.put(97, 61);
        rules.put(97, 47);
        rules.put(75, 29);
        rules.put(61, 13);
        rules.put(75, 53);
        rules.put(29, 13);
        rules.put(97, 29);
        rules.put(53, 29);
        rules.put(61, 53);
        rules.put(97, 53);
        rules.put(61, 29);
        rules.put(47, 13);
        rules.put(75, 47);
        rules.put(97, 75);
        rules.put(47, 61);
        rules.put(75, 61);
        rules.put(47, 29);
        rules.put(75, 13);
        rules.put(53, 13);

        // Inicializar las listas de números
        List<List<Integer>> numsLists = new ArrayList<>();
        numsLists.add(List.of(75, 47, 61, 53, 29));
        numsLists.add(List.of(97, 61, 53, 29, 13));
        numsLists.add(List.of(75, 29, 13));
        numsLists.add(List.of(75, 97, 47, 61, 53));
        numsLists.add(List.of(61, 13, 29));
        numsLists.add(List.of(97, 13, 75, 29, 47));

        for (List<Integer> nums : numsLists) {
            boolean result = sorterAdventofCode(rules, nums);
            System.out.println("Resultado para " + nums + ": " + result);
        }
    }

    public static boolean sorterAdventofCode(Map<Integer, Integer> rules, List<Integer> nums) {

        List<Integer> numsDels = new ArrayList<>(nums);
        int len = nums.size();
        for (int i = len-1; i >= 0; i--) {
            int actualNumber = nums.get(i);
            List<Integer> keys = getKeysByValue(rules, actualNumber);
            if(numsDels.containsAll(keys)) return false;
            numsDels.remove(i);
        }
        return false;
    }

    public static List<Integer> getKeysByValue(Map<Integer, Integer> map, Integer value) {
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}
