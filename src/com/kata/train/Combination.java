package com.kata.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dongmc on 2018/3/30.
 */
public class Combination {

    public static void createCombinations(List<Integer> result, List<Integer> list, int n) {

        if (n < 0) {
            return;
        }

        if (n == 0) {
            for (Integer i : result) {

                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();

            return;
        }
        if (list.isEmpty()) {
            return;
        }


        result.add(list.get(0));
        createCombinations(result, list.subList(1, list.size()), n - 1);


        result.remove(result.size() - 1);
        createCombinations(result, list.subList(1, list.size()), n);

    }

    public static void main(String[] args) {
        createCombinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 2);
        createCombinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 9);
        createCombinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 0);
        createCombinations(new ArrayList<>(), Arrays.asList(), 2);
        createCombinations(new ArrayList<>(), Arrays.asList(), 0);
    }


}
