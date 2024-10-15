package com.db.singleton;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EagerSingleton eagerSingleton=EagerSingleton.getInstance();
		EagerSingleton eagerSingleton2=EagerSingleton.getInstance();
		System.out.println(eagerSingleton == eagerSingleton2);
		LazySingleton lazySingleton = LazySingleton.getInstance();
		LazySingleton lazySingleton2 = LazySingleton.getInstance();
		System.out.println(lazySingleton == lazySingleton2);
		
	}

}
