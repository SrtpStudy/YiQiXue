package com.cslaker.study.bean;

/**
 * Created by sdfgsdfgasdfa on 2017/5/1.
 */

public class Users {
    private String name;
    private int imageId;
    public Users (String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
