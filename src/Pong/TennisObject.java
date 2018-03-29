package Pong;

import java.awt.Graphics;

public abstract class TennisObject {
	double x, y, xVel, yVel;
	boolean upAccel, downAccel;
	ID id;
	final double GRAVITY = 0.94;
	int x2, y2;
	
	
	public TennisObject(int x,int y, ID id) {
		setX(x);
		setY(y);
		this.id = id;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void move();
	
	public void setX(int x) {
		this.x = x;
		this.x2 = x + 20;
	}
	
	public void setY(double y) {
		this.y = y;
		this.y2 = (int)(y + 80);
	}
	
	public int getX() {
		return (int)this.x;
	}
	public int getX2() {
		return this.x2;
	}
	public int getY() {
		return (int)this.y;
	}
	public int getY2() {
		return this.y2;
	}
	
	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	public void setDownAccel(boolean input) {
		downAccel = input;
	}
}
