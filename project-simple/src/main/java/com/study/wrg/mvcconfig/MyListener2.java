package com.study.wrg.mvcconfig;

import org.springframework.core.annotation.Order;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

public class MyListener2 implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //System.out.println("进入MyListener2监听器了");
    }

}
