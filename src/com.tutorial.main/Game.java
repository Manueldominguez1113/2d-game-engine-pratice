package com.tutorial.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;
    private HUD hud;
    private Spawn spawner;

    public Game() {
        handler = new Handler(); // handler must be created before window or else random crashes can occur
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "lets build a game!", this);

        hud = new HUD();
        spawner=new Spawn(handler, hud);
        r = new Random();

        handler.addObj(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
//        for(int i=0; i<4; i++) {
            handler.addObj(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy, handler));
//        }
//        handler.addObj(new Player(WIDTH/2+64, HEIGHT/2-32, ID.Player2));
//        handler.addObj(new Player(100,100,ID.Player));
//        handler.addObj(new Player(200,200,ID.Player));
    }


    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();       // "the last time looped in nanoseconds"
        double amountOfTicks = 60.0;            // sets the ticks per frame
        double ns = 1000000000 / amountOfTicks; //nanoseconds, divided by amount of ticks(60) to determine time in seconds
        double delta = 0;                       // time since game last updated
        long timer = System.currentTimeMillis(); // current time in miliseconds
        int frames = 0;                          // will be used to get number of frames per second were actutally getting

        while (running) {
            long now = System.nanoTime();       // number of miliseconds since "lastTime"
            delta += (now - lastTime) / ns;     //(now - lasttime): by figuring out how much time has passed between(delta) divided by ns, we get time passed in seconds since now and lastime
            lastTime = now;                     // sets now to lasttime for the loop to continue
            while (delta >= 1) {                //while time between(delta) is less than 1 tick(meaning beginning of each loop), tick(), and minus 1 from delta
                tick();
                delta--;
            }
            if (running) {                      //if game is still running at this point, render images, add one to frames to compensate render
                render();
                frames++;
            }

            if (System.currentTimeMillis() - timer > 1000) {    // if the gap between when the timer was set to now is over 1000 milliseconds, add 1000 to the timer, print the frames out, then reset frames to recalculate
                timer += 1000;
//                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();                             // when running is no longer true, stop the game
    }

    private void tick() {
        handler.tick();
        hud.tick();
        spawner.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;

        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }

    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        }
        return var;
    }

    public static void main(String[] args) {
        new Game();
    }
}
