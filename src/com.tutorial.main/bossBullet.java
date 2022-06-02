package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class bossBullet extends GameObject {
    private Handler handler;
    private Random r= new Random();

    public bossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX = r.nextInt(5-(-5))+(-5);
        velY = 5;

    }


    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,16,16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        /*if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 16) {
            velX *= -1;
        }*/

        if(y>= Game.HEIGHT){ handler.removeObj(this);
        }

        handler.addObj(new Trail((int)x, (int)y, ID.Trail ,Color.GRAY, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.green);;
//        g2d.draw(getBounds());  shows collision value;

        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);
    }
}
