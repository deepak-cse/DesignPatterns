package com.db.singleton;

public class EagerSingleton {

	private static String name = "deepak";
	
	private EagerSingleton () {
		System.out.println("inside constructor");
	}
	
	private static final EagerSingleton eagerSingleton = new EagerSingleton ();
	
	public static EagerSingleton getInstance() {
		return eagerSingleton;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
