package com.kata.train.singleinstance;

/**
 * Created by dongmc on 2018/1/2.
 */


/**
 * 使用枚举实现单例模式，例子一：
 * 目的：想要实现类PeopleID的单例
 * 步骤：创建一个枚举类
 *      枚举类中添加一个实例，该实例在调用时有私有的构造方法产生，私有构造方法中为该实例添加了PeopleID的单例
 *
 * 原理：枚举类内的实例都会有私有的构造方法构造一次，即PeopleID的instance只会有一个；
 *      单例会在枚举类实例新建是产生，并不是严格意义上的懒汉模式
 */
public enum SingleInstance {

    SingleInstance;

    private PeopleID instance;

    SingleInstance() {
        instance = new PeopleID();
    }

    public PeopleID getInstance() {
        return this.instance;
    }

    enum insideEnum {
        test1{
            @Override
            void method1(int a) {
                a = 10;
            }

            public void method(int a, int b) {
                a = b;
            }
        };

        abstract void method1(int a);
    }

}
