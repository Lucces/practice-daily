package com.dreamwin;

/**
 * Created by dongmc on 2017/12/25.
 */
public class SynchornizedExecutor {

    public synchronized void execute1() throws InterruptedException {
        while (true) {
            System.out.println("execute1 method run ...");
            Thread.sleep(5000);
            execute2("execute1 execute2 method run ...");
        }

    }

    public synchronized void execute2(String string) {
        System.out.println(string);
    }

    public static void main(String[] args) throws InterruptedException {

        SynchornizedExecutor executor = new SynchornizedExecutor();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    executor.execute1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        Thread thread2 = new Thread() {
            @Override
            public void run() {
                executor.execute2("thread execute2 method run ...");
            }
        };
        thread1.start();
        thread2.start();

    }


}
