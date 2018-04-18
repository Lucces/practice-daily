package com.kata.train;

/**
 * Created by apple on 2017/6/6.
 */
public class Test {
    public static void changeValue(int x){
        x = x *2;
        System.out.println(x);
    }

    public static void main(String[] args) throws InterruptedException {


        /**
         * Java里数字转字符串前面自动补0的实现。
         *
         */
        int youNumber = 1;
        String youNumberStr = "1";
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        String str = String.format("%010d", youNumber);
        System.out.println(str); // 0001


        Integer i1 = 13000;
        System.out.println(i1.equals(13000));
        System.out.println(i1 == 13000);

        //... ...
//        //调用该函数
//        int num = 5;
//        System.out.println(num);
//        changeValue(num);
//        System.out.println(num);
//        Thread t = new Thread();
//        t.join(100);
//        t.wait();
    }



    /**
     * Definition of TreeNode:
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left, right;
     *     public TreeNode(int val) {
     *         this.val = val;
     *         this.left = this.right = null;
     *     }
     * }
     */

}
