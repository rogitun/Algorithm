package Algo_2022.TT5_MAY;

import java.util.HashMap;

public class Pgs_위장 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
        int sum = 1;
        for (Integer value : map.values()) {
            sum *= (value + 1);
        }
        return sum - 1;
    }
}
