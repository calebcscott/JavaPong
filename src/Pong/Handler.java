package Pong;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<TennisObject> objects = new LinkedList<TennisObject>();
	
	public void paint(Graphics g) {
		for(int i =0; i < objects.size();i++) {
			TennisObject temp = objects.get(i);
			temp.draw(g);
		}
		
	}
	
	public void move() {
		
	}
	
	public void addObject(TennisObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(TennisObject object) {
		this.objects.remove(object);
	}
	
	public void createObject(String type) {
		if (type == "player") {
			TennisObject test = new TestPaddle(20, 210, ID.Player);
			addObject(test);
		}
	}
}
