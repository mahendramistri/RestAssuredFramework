package com.rest;

public class MyClassImpl implements MyInterface{
    private MyInterface MyInterface;

    public MyInterface printMe() {
        System.out.println("I'm me");
        return MyInterface;
    }
    
    public MyInterface helpMe() {
        System.out.println("helpMe :)");
        return MyInterface;
    }
}
