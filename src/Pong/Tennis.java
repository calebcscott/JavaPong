package Pong;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {
	final int WIDTH = 700, HEIGHT = 500;
	Thread thread;
	HumanPaddle p1;
	Ball ball;
	AIPaddle p2;
	boolean GameStarted;
	Graphics gfx;
	Image img;
	TennisObject testpaddle;
	TennisObject player;
	Handler Handler = new Handler();
	
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		GameStarted = false;
		ball = new Ball();
		p1 = new HumanPaddle(1);
		p2 = new AIPaddle(2, ball);
		testpaddle = Handler.createObject(ID.AI);
		player = Handler.createObject(ID.Player);
		img = createImage(WIDTH, HEIGHT);
		gfx = img.getGraphics();
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void paint(Graphics g) {
		gfx.setColor(Color.BLACK);
		gfx.fillRect(0, 0, WIDTH, HEIGHT);
		Handler.paint(gfx);
		/*
		if(ball.getX() < -10 || ball.getX() > 710) {
			gfx.setColor(Color.red);
			gfx.drawString("Game Over", WIDTH/2 -20, HEIGHT/2);
		}
		else {
			p1.draw(gfx);
			p2.draw(gfx);
			ball.draw(gfx);
		}
		
		if (!GameStarted) {
			gfx.setColor(Color.WHITE);
			gfx.drawString("Tennis", 340, 100);
			gfx.drawString("PressEnter to Begin...", 310, 130);
		}
		*/
		g.drawImage(img, 0, 0, this);
	}
	
	
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {
		
		for(;;) {
			if (GameStarted) {
				Handler.move();
				//p1.move();
				//p2.move();
				//ball.move();
				//ball.checkPaddleCollision(p1, p2);
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP ) {
			//p1.setUpAccel(true);
			player.setUpAccel(true);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			//p1.setDownAccel(true);
			player.setDownAccel(true);
		}
		else if (e.getKeyCode() ==KeyEvent.VK_ENTER) {
			GameStarted = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP ) {
			//p1.setUpAccel(false);
			player.setUpAccel(false);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			//p1.setDownAccel(false);
			player.setDownAccel(false);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
