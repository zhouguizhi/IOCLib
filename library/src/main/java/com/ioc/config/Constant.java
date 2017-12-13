package com.ioc.config;
/**
 * Created by zhouguizhi on 2017/12/13.
 */
public enum Constant {
    SETCONTENTVIEW("setContentView"),FINDVIEWBYID("findViewById");
    String name;
    private Constant(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
