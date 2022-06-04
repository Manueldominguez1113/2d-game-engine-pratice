package com.tutorial.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import static java.awt.Font.PLAIN;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r = new Random();

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == Game.STATE.Menu) {
            // play button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = Game.STATE.Game;
                handler.addObj(new Player(game.WIDTH / 2 - 32, game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObj(new BasicEnemy(r.nextInt(game.WIDTH - 20), r.nextInt(game.HEIGHT - 20), ID.BasicEnemy, handler));
            }

            //Help button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Help;

            }

            // quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }
        }
        //back button for help screen
        if (game.gameState == Game.STATE.Help) {
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                game.gameState = Game.STATE.Menu;
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) { //maths to check if mouse is over menu option
        if (mx > x && mx < x + width) {
            return my > y && my < y + height;
        } else return false;
    }

    public void tick() {

    }

    public void render(Graphics g) {

        if (game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", Font.BOLD, 50);
            Font fnt2 = new Font("arial", Font.BOLD, 30);


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 80); //menu screen text

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 275, 190); // first button + word "play"


            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 275, 290); // second button

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 275, 390); //third
        } else if (game.gameState == Game.STATE.Help) {
            Font fnt = new Font("arial", Font.BOLD, 50);
            Font fnt2 = new Font("arial", Font.PLAIN, 20);
            Font fnt3 = new Font("arial", Font.BOLD, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 240, 80); //menu screen text

            g.setFont(fnt2);
            g.drawString("Use WASD to move the player and dodge enemies!", 70, 200); // back button

            g.setFont(fnt3);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 275, 390); // back button
        }

    }
}
