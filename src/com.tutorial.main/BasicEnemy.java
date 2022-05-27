package com.tutorial.main;

import java.awt.*;

public class BasicEnemy extends GameObject {
    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler=handler;
        velX = 5;
        velY = 5;

    }


    public Rectangle getBounds(){
        return new Rectangle(x,y,16,16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        if (y <= 0 || y >= Game.HEIGHT - 32) {
            velY *= -1;
        }
        if (x <= 0 || x >= Game.WIDTH - 16) {
            velX *= -1;
        }

        handler.addObj(new Trail(x, y, id.Trail ,Color.red, 16, 16, 0.02f, handler));
    }

    @Override
    public void render(Graphics g) {
//        Graphics2D g2d = (Graphics2D) g;
//        g.setColor(Color.green);;
//        g2d.draw(getBounds());  shows collision value;

        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
}
