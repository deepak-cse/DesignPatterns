package com.db.factorymethod;

public class JsonMessageCreator extends MessageCreator{

	@Override
	public Message createMessage() {
		// TODO Auto-generated method stub
		return new JsonMessage();
	}

}
