package tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	
	Random r = new Random();
	Handler handler;

	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	

	}

	public void tick() {
		x += velX;
		y += velY;
	
		// Making sure player can't leave window // 
		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 50);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.05f, handler));
		
		collision();
		
	}

	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
		
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy) { // tempObject is now Basic Enemy 
				
				if(getBounds().intersects(tempObject.getBounds())) {
					// Collision Code for Enemy // 
					HUD.HEALTH -= 2;
				}
			}
		}
	}
	public void render(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g; // This library has the method we need for the collision // 
		
		g.setColor(Color.green);
		g2d.draw(getBounds());
				
		g.setColor(Color.white);
		g.fillRect(x,  y, 32, 32);
	
		
	}


}
