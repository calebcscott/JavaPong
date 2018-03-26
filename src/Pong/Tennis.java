package Pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	Ball ball;
	AIPaddle p2;
	boolean GameStarted;
	
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		GameStarted = false;
		ball = new Ball();
		p1 = new HumanPaddle(1);
		p2 = new AIPaddle(2, ball);
		
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		if(ball.getX() < -10 || ball.getX() > 710) {
			g.setColor(Color.red);
			g.drawString("Game Over", WIDTH/2 -20, HEIGHT/2);
		}
		else {
			p1.draw(g);
			p2.draw(g);
			ball.draw(g);
		}
		
		if (!GameStarted) {
			g.setColor(Color.WHITE);
			g.drawString("Tennis", 340, 100);
			g.drawString("PressEnter to Begin...", 310, 130);
		}
	}
	
	
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(;;) {
			if (GameStarted) {
				p1.move();
				p2.move();
				ball.move();
				ball.checkPaddleCollision(p1, p2);
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_UP ) {
			p1.setUpAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
		else if (e.getKeyCode() ==KeyEvent.VK_ENTER) {
			GameStarted = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getKeyCode() == KeyEvent.VK_UP ) {
			p1.setUpAccel(false);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
