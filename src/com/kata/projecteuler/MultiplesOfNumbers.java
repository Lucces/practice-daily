package com.kata.projecteuler;

/**
 * Created by apple on 2017/11/15.
 */
public class MultiplesOfNumbers {


    /**
     * Multiples of 3 and 5
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    public static int solve(){

        int result = 0;
        for (int i = 2; i < 1000; i++) {
            if (i%15 == 0) {
                result += i;
            } else if (i%5 == 0) {
                result += i;
            } else if (i%3 == 0) {
                result += i;
            } else {
                continue;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long beigenTime = System.currentTimeMillis();
        System.out.print(String.format("结果：%d , 用时 %d 毫秒", solve(), System.currentTimeMillis() - beigenTime));
    }

}
