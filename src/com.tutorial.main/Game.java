package com.tutorial.main;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Game() {
        new Window(WIDTH, HEIGHT, "lets build a game!", this);
    }

    public static void main(String[] args) {

    }

    public synchronized void start() {

    }

    @Override
    public void run() {

    }
}
