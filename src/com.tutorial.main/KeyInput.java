package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObj = handler.object.get(i);
            if (tempObj.getId() == ID.Player) {
                //key events for player one
                if (key == KeyEvent.VK_W) {
//                    tempObj.setY(tempObj.getY() - 5);
                    tempObj.setVelY(-5);
                }
                if (key == KeyEvent.VK_S) {
                    tempObj.setVelY(5);
                }
                if (key == KeyEvent.VK_D) {
                    tempObj.setVelX(5);
                }
                if (key == KeyEvent.VK_A) {
                    tempObj.setVelX(-5);
                }
            }
/*            if (tempObj.getId() == ID.Player2) {
                //key events for player two
                if (key == KeyEvent.VK_UP) {
                    tempObj.setVelY(-5);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObj.setVelY(5);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObj.setVelX(5);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObj.setVelX(-5);
                }
            }*/
        }

        if(key == KeyEvent.VK_ESCAPE){ System.exit(1);}
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObj = handler.object.get(i);
            if (tempObj.getId() == ID.Player) {
                //key events for player one
                if (key == KeyEvent.VK_W) {
//                    tempObj.setY(tempObj.getY() - 5);
                    tempObj.setVelY(0);
                }
                if (key == KeyEvent.VK_S) {
                    tempObj.setVelY(0);
                }
                if (key == KeyEvent.VK_D) {
                    tempObj.setVelX(0);
                }
                if (key == KeyEvent.VK_A) {
                    tempObj.setVelX(0);
                }
            }
           /* if (tempObj.getId() == ID.Player2) {
                //key events for player two
                if (key == KeyEvent.VK_UP) {
                    tempObj.setVelY(0);
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObj.setVelY(0);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    tempObj.setVelX(0);
                }
                if (key == KeyEvent.VK_LEFT) {
                    tempObj.setVelX(0);
                }
            }*/
        }

    }
}
