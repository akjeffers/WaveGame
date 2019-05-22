package tutorial.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	
	
	/* Player Object & Enemy Object -- Both considered this class GameObject - they will inherit all the functions we will put in here */
	/* Protected can only be accessed by which object inherits the GameObject i.e. extends GameObject */
	
	protected int x, y;
	protected ID id;
	protected int velX, velY; // Control the speed //
	
	public GameObject (int x, int y, ID id){  // Creating the constructor // 
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds(); // Using this to handle all the collision //
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public ID getId() {
		return id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public int getVelX() {
		return velX;
	}
	public int getVelY() {
		return velY;
	}
	
}
