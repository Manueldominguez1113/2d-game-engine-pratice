package com.tutorial.main;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private float life;
    private Handler handler;
    private Color color;
    private int width, height;

    //life = 0.01 - 0.1

    public Trail(int x, int y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
    }

    public void tick() {
        if (alpha > life) {
            if ((alpha - (life-0.01f)) <= 0.0f) {
                alpha = 0.0f;
            } else {
                alpha -= (life-0.01f);
            }
        } else handler.removeObj(this);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // only use composite with g2d
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x, y, width, height);

        g2d.setComposite(makeTransparent(1));//without this after our trail, the alpha will make other things transparent
    }

    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public Rectangle getBounds() {
        return null;
    }
}
