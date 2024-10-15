package com.db.singleton;

public class LazySingleton {

	
	private LazySingleton () {
	
		System.out.println("inside constructor");
	}
	
	private static volatile LazySingleton LAZY_SINGLETON;
	
	public static LazySingleton getInstance () {
		
		if(LAZY_SINGLETON==null) {
			synchronized (LazySingleton.class) {
				if (LAZY_SINGLETON==null) {
					LAZY_SINGLETON = new LazySingleton();
				}
				
			}
		}
		
		return LAZY_SINGLETON;
	}
	
}
