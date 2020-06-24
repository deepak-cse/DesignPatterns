package com.db.prototype;

import javafx.geometry.Point3D;

public class Client {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Swordsman swordsman = new Swordsman();
		swordsman.move(new Point3D(-10,0,0),10);
		swordsman.attack();
		System.out.println(swordsman);
		Swordsman swordsman2 = (Swordsman) swordsman.clone();
		System.out.println(swordsman2);
		
		
	}

}
