package com.db.factorymethod;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMessage(new JsonMessageCreator());
		printMessage(new TextMessageCreator());
	}
	
	public static void printMessage (MessageCreator messageCreator) {
		Message msg=messageCreator.getMessage();
		System.out.println(msg);
	}

}
