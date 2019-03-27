package com.study.wrg.mvcconfig;

import org.springframework.core.annotation.Order;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

@WebListener(value = "MyListener")
public class MyListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //System.out.println("进入MyListener监听器了");
    }

}
