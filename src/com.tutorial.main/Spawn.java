package com.tutorial.main;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scorekeep=0;
    public Spawn(Handler handler, HUD hud){
        this.handler=handler;
        this.hud=hud;

    }
    public void tick(){
    scorekeep++;

    if(scorekeep>= 250){
        scorekeep=0;
        hud.setLevel(hud.getLevel()+1);
        if(hud.getLevel()%2==1) { //every other level
            handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
        }
        if(hud.getLevel()%5==1){ //every five levels
            handler.addObj(new fastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.fastEnemy, handler));
        }
        if(hud.getLevel()==2){ //at level five
            handler.addObj(new smartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.smartEnemy, handler));
        }
    }
    }

}
