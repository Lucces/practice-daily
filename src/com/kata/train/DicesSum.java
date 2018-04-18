package com.kata.train;

import java.util.*;

/**
 * Created by dongmc on 2018/1/26.
 */
public class DicesSum {

    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {

        Map<Integer, Double> sumAndCount = new HashMap<Integer, Double>();
        int sum = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 6; j++) {
                sum += j;
                Double count = sumAndCount.containsKey(sum) ? sumAndCount.get(sum) : 0d;
                sumAndCount.put(sum, count + 1);
            }
        }

        List<Map.Entry<Integer, Double>> result = new ArrayList<>();
        for (Map.Entry<Integer, Double> map : sumAndCount.entrySet()) {
            map.setValue(map.getValue()/ Math.pow(6, n));
            result.add(map);
        }
        return result;
    }
}
