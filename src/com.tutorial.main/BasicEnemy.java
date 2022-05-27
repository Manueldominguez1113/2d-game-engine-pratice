package com.tutorial.main;

import java.awt.*;

public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
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
