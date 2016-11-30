package com.example.dllo.notestudio.DemoListView;

/**
 * Created by dllo on 16/10/29.
 */

public class ListViewBean {
private String namebean ;
    private int picbean ;

    public ListViewBean(String namebean, int picbean) {
        this.namebean = namebean;
        this.picbean = picbean;
    }

    public String getNamebean() {
        return namebean;
    }

    public ListViewBean setNamebean(String namebean) {
        this.namebean = namebean;
        return this;
    }

    public int getPicbean() {
        return picbean;
    }

    public ListViewBean setPicbean(int picbean) {
        this.picbean = picbean;
        return this;
    }
}
