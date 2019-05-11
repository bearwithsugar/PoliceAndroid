package com.demo.mayixuan.myapplication;

/**
 * Created by mayixuan on 2018/7/28.
 */

public class Apply {
    private String title;
    private String process;
    private String time;
    private int isnew;

    public Apply(String title, String process, String time,int isnew) {
        this.title = title;
        this.process = process;
        this.time=time;
        this.isnew=isnew;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getIsnew() {
        return isnew;
    }

    public void setIsnew(int isnew) {
        this.isnew = isnew;
    }
}
