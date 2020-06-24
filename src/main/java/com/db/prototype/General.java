package com.db.prototype;

//do not support cloning

public abstract class General extends GameUnit{
	
	private String state = "idle";
	
	public void boostMorale() {
		this.state = "MoralBoost";
	}

	@Override
	public String toString() {
		return "General [state=" + state + ", getPosition()=" + getPosition() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	@Override
	protected GameUnit clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("generals are unique");
	}

	@Override
	protected void reset() {
		throw new UnsupportedOperationException("reset not possible");
		
	}
	
	
}
