package com.db.singletonpractice;

public class LazySingleton {
    private static  LazySingleton singleton=null;

    private LazySingleton(){

    }

    private  static LazySingleton getInstance() {
        if(singleton==null) {
            singleton = new LazySingleton();
           // return singleton;
        }
        return singleton;
    }

    private static  synchronized  LazySingleton getInstanceSync() {
        if(singleton==null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                    //return singleton;
                }
            }
        }

        return singleton;
    }


}
