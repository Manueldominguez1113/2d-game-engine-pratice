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
        return new Rectangle((int)x,(int)y,32,32);
    }

    public void tick() {
        x += velX;
        y += velY;

        x= Game.clamp((int)x,0,Game.WIDTH-37);
        y= Game.clamp((int)y,0,Game.HEIGHT-60);
    handler.addObj(new Trail((int)x,(int)y,ID.Trail,Color.white,32,32,0.07f,handler));

        collision();
    }

    private void collision(){
        for (int i =0; i< handler.object.size();i++){
            GameObject tempobject= handler.object.get(i);

            if(tempobject.getId()==ID.BasicEnemy || tempobject.getId()==ID.fastEnemy || tempobject.getId()==ID.smartEnemy){
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
        g.fillRect((int)x, (int)y, 32, 32);
    }




}
