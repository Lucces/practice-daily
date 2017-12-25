package com.kata.train;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by apple on 2017/2/14.
 */
public class TrainFunction {

    public static List<Long> sumDigPow (long a, long b){
        List<Long> results = new ArrayList<Long>();

        if (a > b){
            return results;
        }

        for (long i = a; i <= b; i++){
            int[] ints = Long.toString(i).chars().map(c -> c -= '0').toArray();
            int lenght = ints.length;
            double r = Math.pow(ints[lenght -1], lenght) / i;
            if (r <= 1 && r >= 0.90){
                System.out.println(i);
                long aa = 0;
                for(int j = 0; j < lenght; j++){
                    aa = (long) (aa + Math.pow(ints[j], j+1));
                }
                if (aa == i){
                    results.add(i);
                }
            }
        }


        return results;
    }

    public static String songDecoder(String song){
        String[] strings = song.split("WUB");
        for (String str: strings){
            System.out.println(str);
        }
        String[] strs =  Stream.of(song.split("WUB")).filter(a -> !a.equals("")).toArray(String[]::new);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs){
            stringBuilder.append(str + " ");
        }
        return stringBuilder.toString().substring(0, stringBuilder.toString().length() -1);
    }

    public static long findNb(long m) {

        long roughNum = (long) Math.pow(4 * m, 0.25);
        if (Long.compare(roughNum * (roughNum + 1) * roughNum * (roughNum +1), 4 * m) == 0){
            return roughNum;
        }

        return -1L;
    }

    public static int[] DataReverse(int[] data) {
        int lenght = data.length;
        int[] result = new int[lenght];
        int index = 0;
        for (int i = lenght-8; i>=0; i = i - 8){
            for (int j = 0; j < 8; j++){
                result[index] = data[i+j];
                index++;
            }
        }

        return result;
    }


    public static void main(String[] args) {

       // Double.()Math.sqrt(1231241)
        long m = 2304422822859502501l;
        long roughNum = 55100l;
        System.out.println(roughNum * (roughNum + 1) * roughNum * (roughNum +1));
        System.out.println(4 * m);
        System.out.println(Long.compare(roughNum * (roughNum + 1) * roughNum * (roughNum +1), 4 * m));

//        long m = 2304422822859502500L;
//        long m = 2304422822859492096L;
//        long roughNum = (long) (Math.pow(2304422822859502501L * 4, 0.25) + 1);
//        int thorhold = (int) Math.sqrt(roughNum);
//        System.out.println(roughNum);
//        System.out.println(thorhold);
//        System.out.println(Math.pow(55100L * 55101L / 2, 2));
//        long n = 0;
//        for (long i = 1; i < 55101; i++){
//            n = (long) (Math.pow(i, 3) + n);
//        }
//
//        System.out.println(n);
//        System.out.println(55100l*55101l *55100l*55101l*0.25);
//        System.out.println(Long.compare((long) Math.pow(55100L*55101L, 2)/4, n));

//        long a = 89L;
//        int[] ints = Long.toString(a).chars().map(c -> c -= '0').toArray();
//        int lenght = ints.length;
//        System.out.println((Math.pow(ints[lenght - 1], lenght) / a));
//        System.out.println(sumDigPow(1, 9));
    }
}
