package com.demo.mayixuan.myapplication;

import android.media.Image;

/**
 * Created by mayixuan on 2018/7/28.
 */

public class Message {
    private String title;
    private String from;
    private String time;

    public Message(String title, String from,String time) {
        this.title = title;
        this.from = from;
        this.time=time;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
