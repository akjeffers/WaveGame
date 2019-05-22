package tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -7652399833422083103L;
	
	// This class is just created to create the actual window the game will be housed in //
	
	public Window(int width, int height, String title, Game game){
		// The frame of our window, an in-built library in JRE //
		JFrame frame = new JFrame(title); 
		
		// We set the dimensions of the window here // 
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		// Think of this of having the X button working, having this will stop the thread of the game //
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// This allows us to either set the window to be resized, set to false //
		frame.setResizable(false);
		// Our window will start in the middle of the screen //
		frame.setLocationRelativeTo(null);
		// This is adding our game class into our actual frame // 
		frame.add(game);
		// Setting the frame to visible so we can see it //
		frame.setVisible(true);
		// Now we are setting the start method we created in Game Class //
		game.start();
	}

}
