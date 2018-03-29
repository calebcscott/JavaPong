package Pong;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<TennisObject> objects = new LinkedList<TennisObject>();
	TennisObject temp;
	
	public void paint(Graphics g) {
		for(int i =0; i < objects.size();i++) {
			TennisObject temp = objects.get(i);
			temp.draw(g);
		}
		
	}
	
	public void move() {
		for(int i =0; i < objects.size();i++) {
			TennisObject temp = objects.get(i);
			temp.move();
		}
	}
	
	public void addObject(TennisObject object) {
		this.objects.add(object);
	}
	
	public void removeObject(TennisObject object) {
		this.objects.remove(object);
	}
	
	public TennisObject createObject(ID id) {
		if (id == ID.Player) {
			temp = new TestPaddle(20, 210, id);
			
		} else {
			temp = new TestPaddle(660,210, ID.AI);
		}
		addObject(temp);
		return temp;
	}
}
