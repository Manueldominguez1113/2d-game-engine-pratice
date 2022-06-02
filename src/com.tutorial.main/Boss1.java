package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Boss1 extends GameObject {
    private Handler handler;
    private int timer = 80;
    private int timer2 = 50;
    private Random r = new Random();

    public Boss1(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 0;
        velY = 2;

    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 96, 96);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (timer <= 0) {
            velY = 0;
            timer2--;
        } else timer--;
        if (timer2 <= 0) {
            if (velX == 0) {
                velX += 3;
            }
            if (velX > 0) {
                velX += 0.005f;
            } else if (velX < 0) {
                velX -= 0.005f;
            }
            velX =Game.clamp(velX, -10,10);

            int spawn = r.nextInt(10);
            if (spawn == 0) {
                handler.addObj(new bossBullet((int) x + 48, (int) y + 48, ID.BasicEnemy, handler));
            }
        }


        if (x <= 0 || x >= Game.WIDTH - 96) {
            velX *= -1;
        }
        //handler.addObj(new Trail((int) x, (int) y, id.Trail, Color.red, 96, 96, 0.08f, handler));
    }

    @Override
    public void render(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.green);;
//        g2d.draw(getBounds());  shows collision value;

        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 96, 96);
    }
}
