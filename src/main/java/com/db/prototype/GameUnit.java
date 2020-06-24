/**
 * 
 */
package com.db.prototype;

import java.awt.geom.Point2D;

import javafx.geometry.Point3D;

/**
 * @author Dell
 *
 */
public abstract class GameUnit implements Cloneable{

	private Point3D position;

	public GameUnit() {
		this.position = Point3D.ZERO;
	}

	public GameUnit(float x, float y, float z) {
		this.position = new Point3D(x, y, z);

	}

	@Override
	protected GameUnit clone() throws CloneNotSupportedException {
		GameUnit unit = (GameUnit) super.clone();
		unit.initialize();
		return unit;
	}

	protected void initialize () {
		this.position=Point3D.ZERO;
		reset();
	}
	
	protected abstract void reset();
	
	public void move(Point3D direction, float distance) {
		Point3D finalMove = direction.normalize();
		finalMove = finalMove.multiply(distance);
		this.position = this.position.add(finalMove);
	}
	
	public Point3D getPosition () {
		return position;
	}
	
}
