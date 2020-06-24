package com.db.prototype;

public class Swordsman extends GameUnit {

	private String state = "idle";

	public void attack() {
		this.state = "attacking";
	}

	@Override
	public String toString() {
		return "Swordsman [state=" + state + ", getPosition()=" + getPosition() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	

	@Override
	protected void reset() {
		this.state = "idle";
		
	}

	
	
}
