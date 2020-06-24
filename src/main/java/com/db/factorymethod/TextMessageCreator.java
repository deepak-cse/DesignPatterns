package com.db.factorymethod;

public class TextMessageCreator extends MessageCreator{

	@Override
	public Message createMessage() {
		// TODO Auto-generated method stub
		return new TextMessage();
	}
	
	
}
