package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class TestPaddle extends TennisObject {

	public TestPaddle(int x, int y, ID id) {
		super(x, y, id);
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 20, 80);
		g.setColor(Color.red);
		g.drawOval((int)x, (int)y, 10, 10);
		g.drawOval(x2, (int)y, 10, 10);
		g.drawOval(x2, y2, 10, 10);
		
		g.drawOval((int)x, y2, 10, 10);
	}

	@Override
	public void move() {
		if(upAccel) {
			yVel -= 2;
		}
		else if(downAccel) {
			yVel += 2;
		}
		
		else if(!upAccel && !downAccel) {
			yVel  *= GRAVITY;
		}
		
		if(yVel >= 3) {
			yVel = 3;
		}
		else if(yVel <= -3) {
			yVel = -3;
		}
		
		//y += yVel;
		setY(y + yVel);
		
		
		if (y < 0) {
			setY(1);
		}
		if (y > 420) {
			setY(419);
		}
		
	}
	
	

}
