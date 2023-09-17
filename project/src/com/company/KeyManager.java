package com.company;

import Items.Controler;
import Items.Player;
import Items.bullet;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class KeyManager implements KeyListener {
    private static boolean[] keys;
    private static boolean[] justPressed;
    private boolean[] cantPress;
    public boolean up;
    public boolean left;
    public boolean right;
    public boolean Leftattack, Rightattack;
    public Handler handler;
    // ;
    private Controler c;
    private Player p;

    public KeyManager() {
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
        c = new Controler(handler);
        p=new Player(handler,20,20);
    }

    public void tick() {

        for (int i = 0; i < keys.length; i++) {
            if (cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            } else if (justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if (!cantPress[i] && keys[i]) {
                justPressed[i] = true;
            }
        }

        up = keys[VK_UP];
        left = keys[VK_LEFT];
        right = keys[VK_RIGHT];
        Leftattack = keys[VK_A];
        Rightattack = keys[VK_D];


    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // keys[e.getKeyCode()] = false;

    }

    public static boolean keyJustPressed(int keyCode) {
        if (keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()] = true;


        }
    }



