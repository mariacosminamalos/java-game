package com.company;

import Tiles.Map;

import java.awt.event.MouseMotionListener;
import java.util.concurrent.ForkJoinWorkerThread;

public class Handler {
    private Game game;
    private Map world;

    public Handler(Game game){
        this.game=game;
    }

    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    public int getWidth(){
        return game.GetWidth();
    }

    public int getHeight(){
        return game.GetHeight();
    }

    public Game getGame(){
        return game;
    }

    public void setGame(Game game){
        this.game=game;
    }

    public Map getWorld(){
        return world;
    }

    public void setWorld(Map world){
        this.world=world;
    }
    public void setState(){
        this.setState();
    }


}
