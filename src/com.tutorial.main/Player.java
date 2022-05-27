package com.tutorial.main;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

//        velX = r.nextInt(5)+1;
//        velY = r.nextInt(5)+1;
        // velX =1;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x= Game.clamp(x,0,Game.WIDTH-37);
        y= Game.clamp(y,0,Game.HEIGHT-60);
    handler.addObj(new Trail(x,y,id.Trail,Color.white,32,32,0.07f,handler));

        collision();
    }

    private void collision(){
        for (int i =0; i< handler.object.size();i++){
            GameObject tempobject= handler.object.get(i);

            if(tempobject.getId()==id.BasicEnemy){
                if(getBounds().intersects(tempobject.getBounds())){
//                collision code
                    HUD.HEALTH -= 2;
                }
            }
        };
    }

    public void render(Graphics g) {
        if (id == ID.Player) {
            g.setColor(Color.white);
        } /*else if (id == ID.Player2) {
            g.setColor(Color.blue);
        }*/
        g.fillRect(x, y, 32, 32);
    }




}
