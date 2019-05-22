package tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	// default algorithm aspect ratio //

	private Thread thread;
	private boolean running = false;

	private Random r;
	private Handler handler;
	private HUD hud;

	// Creating new instance of our game class & call our constructor //
	public Game() {

		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));

		new Window(WIDTH, HEIGHT, "Wave Game!", this);

		hud = new HUD();

		r = new Random();

		handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
		for (int i = 0; i < 5; i++)
			handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));

	}

	// Method to Start //
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;

	}

	// This can stop the thread, *this game runs on one thread //
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to Run & Default Game Loop //

	public void run() {
		this.requestFocus(); // This just eliminates the need to click on the screen to control the player // 
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				// System.out.println("FPS: " + frames);
				frames = 0;
			}
		}

		stop();

	}
	// Creating Methods for Render & Tick //

	private void tick() {
		handler.tick();
		hud.tick();

	}

	// Creating the Buffer Strategy //
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3); // 3 is recommended for buffers //
			return;
		}
		// Creating the graphics & filling the screen with a black graphic //
		Graphics g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		handler.render(g);

		hud.render(g);

		g.dispose();
		bs.show();

	}

	// Room Width -- Making sure you can't leave the window //
	public static int clamp(int var, int min, int max) {
		if (var >= max)
			return var = max;
		else if (var <= min)
			return var = min;
		else
			return var;
	}

	public static void main(String args[]) {
		new Game();
		// *This is our main method class, everything starts from here* //

	}

}
