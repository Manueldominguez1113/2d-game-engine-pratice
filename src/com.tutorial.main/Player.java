package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);

//        velX = r.nextInt(5)+1;
//        velY = r.nextInt(5)+1;
        // velX =1;
    }

    public void tick() {
        x += velX;
        y += velY;

    }

    public void render(Graphics g) {
        if (id == ID.Player) {
            g.setColor(Color.white);
        } else if (id == ID.Player2) {
            g.setColor(Color.blue);
        }
        g.fillRect(x, y, 32, 32);
    }


}
