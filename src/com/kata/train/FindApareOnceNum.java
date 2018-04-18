package com.kata.train;

/**
 * Created by dongmc on 2018/4/4.
 */
public class FindApareOnceNum {

    public static void findNumbersApareOnce(int[] array, int a, int b) {

        if (array.length < 2) {
            return;
        }

        int tempNum = array[0];
        for (int i = 1; i < array.length; i++) {
            tempNum = tempNum ^ array[i];
        }

        int positionNum = 1;
        while ((tempNum & positionNum) == 0) {
            positionNum = positionNum << 1;
        }

        a = 0;
        b = 0;

        for (int i : array) {
            if ((i & positionNum) == positionNum) {
                a = a ^ i;
            } else {
                b = b ^ i;
            }
        }

        System.out.println(String.format("a : %d ; b : %d", a, b));

    }


    public static void main(String[] args) {

        findNumbersApareOnce(new int[]{1, 1, 3, 3, 2, 4}, 0, 0);
    }


}
