package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle {
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double GRAVITY = 0.94;
	Ball ball;
	
	public AIPaddle(int player, Ball b) {
		upAccel = false; downAccel = false;
		ball = b;
		y = 210; yVel = 0;
		
		if(player == 1)
			x=20;
		else
			x = 660;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 20, 80);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
		y = ball.getY() -40;
		
		if (y < 0) {
			y = 1;
		}
		if (y > 420) {
			y = 419;
		}
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return (int)y;
	}
	


}
