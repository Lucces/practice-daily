package com.kata.projecteuler;

/**
 * Created by apple on 2017/11/15.
 */
public class ConsecutivePrimeSum {

    /**
     *
     *  Consecutive prime sum
     *  The prime 41, can be written as the sum of six consecutive primes:

        41 = 2 + 3 + 5 + 7 + 11 + 13
        This is the longest sum of consecutive primes that adds to a prime below one-hundred.

     *  The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

     *   Which prime, below one-million, can be written as the sum of the most consecutive primes?
     */

    public static int solve() {

        int result = 2 + 3;
        int i = 6;
        int ii = 1;
        while(result < 1000) {
            if (isPrime(i)) {
                result += i;
            }

            if (isPrime(i - 1)) {
                result = result + i - 1;
            }
            if (isPrime(i + 1)) {
                result = result + i + 1;
            }

            ii ++;
            i = 6 * ii;
        }

        i = 6 * (ii - 1);
        if (isPrime(i - 1)) {
            result = result - i;
        }
        if (isPrime(i) && result >= 1000) {
            result = result - i + 1;
        }
        if (isPrime(i + 1) && result >= 1000){
            result = result - i - 1;
        }
        return result;
    }

    private static boolean isPrime(int num) {

        if(num ==2|| num==3 ){
            return true;
        }

        if(num %6!= 1&&num %6!= 5) {
            return false;
        }

        int temp = (int) Math.sqrt(num);
        for (int i = 2; i <= temp; i ++){
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }



    public static int solve(int range) {
        int result = 5;

        int lastI = 6;
        for (int i = 6; i < range; i += 6) {
            if (result >= range) {
                lastI = i - 6;
                break;
            }
            if (isPrime(i)) {
                System.out.println(i);
                result += i;
            }
            if (isPrime(i - 1)) {
                System.out.println(i - 1);
                result = result + i - 1;
            }
            if (isPrime(i + 1)) {
                System.out.println(i + 1);
                result = result + i + 1;
            }
        }

        System.out.println(result + "\t" + lastI);
        for (int i = lastI; i > 0; i -= 6) {

            if (isPrime(i + 1)) {
                result = result - i - 1;
                if (isPrime(result) && result < range) {
                    break;
                }
            }

            if (isPrime(i )) {
                result = result - i;
                if (isPrime(result) && result < range) {
                    break;
                }
            }
            if (isPrime(i - 1)) {
                result = result - i + 1;
                if (isPrime(result) && result < range) {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long beigenTime = System.currentTimeMillis();
        System.out.println(String.format("结果：%d , 用时 %d 毫秒", solve(1000), System.currentTimeMillis() - beigenTime));
        System.out.println(isPrime(94));
    }

}
