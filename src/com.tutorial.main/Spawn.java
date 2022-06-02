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
         if(hud.getLevel()==2) {
            handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
        } else if(hud.getLevel()==3){
            handler.addObj(new smartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.smartEnemy, handler));
        } else if(hud.getLevel()==4){
            handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
        } else if(hud.getLevel()==5){
             handler.addObj(new fastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.fastEnemy, handler));
         } else if(hud.getLevel()==6){
             handler.addObj(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
         } else if(hud.getLevel()==7){
             handler.addObj(new fastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.fastEnemy, handler));
         } else if(hud.getLevel()==10){
             handler.clearEnemies();
             handler.addObj(new Boss1((Game.WIDTH/2)-48, -120, ID.Boss1, handler));
         }



    }
    }

}
