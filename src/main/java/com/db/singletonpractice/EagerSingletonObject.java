package com.db.singletonpractice;

public class EagerSingletonObject {

//   private  static final EagerSingletonObject singleton = new EagerSingletonObject();

    private  static volatile EagerSingletonObject singleton = new EagerSingletonObject();

     private EagerSingletonObject(){

    }

    public static EagerSingletonObject getInstance(){
        return  singleton;
    }

    @Override
    public String toString() {
        return "SingletonObject{}";
    }
}
