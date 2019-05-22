package tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

	// This class is going to handle, render, and update all of our objects within
	// in the game //
	// Loop through all the objects in the game, individually update & render them
	// to the screen //

	LinkedList<GameObject> object = new LinkedList<GameObject>();

	public void tick() { // Looping through objects //
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);

			tempObject.tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
			
			// Loops, Renders all Objects, and updates tick's object //
			
		}

	}
	// Adding and removing game objects // 
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
}