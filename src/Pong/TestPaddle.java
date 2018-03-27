package Pong;

import java.awt.Color;
import java.awt.Graphics;

public class TestPaddle extends TennisObject {

	public TestPaddle(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}
	
	

}
