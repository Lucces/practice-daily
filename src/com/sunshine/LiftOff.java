package com.sunshine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2017/5/10.
 */
public class LiftOff implements  Runnable{
    protected  int countDown = 100;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff () {

    }

    public LiftOff (int countDown) {
        this.countDown = countDown;
    }

    public String print() {
        return "#" + id + "(" + (countDown) + ")";
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (countDown > 0) {
            countDown = countDown - 1;
            print();
//            Thread.yield();
        }
        System.out.println("process time is : " + (System.currentTimeMillis() - startTime) + "ms");
    }

    public static void main(String[] args) throws InterruptedException {

//        for (int i = 0; i < 2; i++) {
//            Thread t = new Thread(new LiftOff());
//            t.start();
//        }
//        List<String> list = new ArrayList<String>();

        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(System.currentTimeMillis() / 1000 + 24* 60* 60) ;


    }
}
