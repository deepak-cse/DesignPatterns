package com.db.factorymethod;

public abstract class MessageCreator {

	public Message getMessage () {
		Message msg=createMessage();
		msg.addDefaultHeaders();
		msg.encrypt();
		return msg;
	}
	//factory method
	public abstract Message createMessage();
	
	
}
