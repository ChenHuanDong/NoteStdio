package com.example.dllo.notestudio.DemoEventBus;

/**
 * Created by dllo on 16/11/17.
 */

public class DemoEventBean {
    private String str;

    public DemoEventBean(String str) {
        this.str = str;
    }

    public DemoEventBean() {
    }

    public String getStr() {
        return str;
    }

    public DemoEventBean setStr(String str) {
        this.str = str;
        return this;
    }
}
