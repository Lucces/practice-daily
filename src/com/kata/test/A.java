package com.kata.test;

import java.awt.*;
import java.util.EventListener;

/**
 * Created by dongmc on 2018/3/21.
 */

public class A{

    private final EventListener listener;

    private  A(){
        listener=new EventListener (){
            public void onEvent (Event e){
                //doSomething（e）；
            }
        };
    }

}
