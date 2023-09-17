package com.company;


import Items.Controler;
import Items.Player;
import State.State;
import State.GameState;
import State.MenuState;
import State.Level2State;
import Window.Display;
import Graphics.*;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{

    private Display display;

     public int width,height;
     public String title;

     private boolean running=false;
     private Thread thread;

     private BufferStrategy bs;
     private Graphics g;




    private SpriteSheet sheet;


    //states
    public State gameState;
    public State menuState;
    public State level2State;

    private KeyManager keyManager;
    private MouseManager mouseManager;

    private Handler handler;

    private Controler c;



     public Game(String title, int width, int height){
         this.width=width;
         this.height=height;
         this.title=title;
         keyManager=new KeyManager();
         mouseManager=new MouseManager();

     }
     public void init(){
         display=new Display(title,width,height);
         display.getFrame().addKeyListener(keyManager);

         display.getFrame().addMouseListener(mouseManager);
         display.getFrame().addMouseMotionListener(mouseManager);

         display.getCanvas().addMouseListener(mouseManager);
         display.getCanvas().addMouseMotionListener(mouseManager);


         Assets.init();

         handler=new Handler(this);

         gameState=new GameState(handler);
         menuState=new MenuState(handler);
      //   level2State=new Level2State(handler);
         State.setState(menuState);




     }




    public void tick() {




        keyManager.tick();


        if (State.getState() != null) {
            State.getState().tick();



        }
    }


    public void render(){
         bs=display.getCanvas().getBufferStrategy();
         if(bs==null){
             display.getCanvas().createBufferStrategy(3);
             return;
         }
         g=bs.getDrawGraphics();
         g.clearRect(0,0,width,height);



         if(State.getState() != null){
             State.getState().render(g);
         }


         bs.show();
         g.dispose();
     }





     public void run(){
         init();

         int fps = 60;
         double timePerTick=1000000000/fps;
         double delta=0;
         long lastTime = System.nanoTime();
         long now;
         long timer=0;
         int ticks=0;


         while(running){
             now=System.nanoTime();
             delta+=(now-lastTime)/timePerTick;
             timer +=now-lastTime;
             lastTime=now;

             if(delta>=1){

             tick();
             render();
             ticks++;
             delta--;}

             if(timer>= 1000000000) {
                // System.out.println("Ticks and Frames:" + ticks);
                 ticks = 0;
                 timer = 0;
             }



         }


         stop();


     }

     public KeyManager getKeyManager(){
         return keyManager;
     }

     public MouseManager getMouseManager(){
         return mouseManager;
     }

     public synchronized void start(){
         if(running)
             return;
         running=true;
         thread=new Thread(this);
         thread.start();

     }
     public synchronized void stop(){
         if(!running)
             return;
         running=false;
         try {
             thread.join();
         } catch (InterruptedException e) {
             e.printStackTrace();
         }

     }
    public int GetWidth()
    {
        return display.getDsWidth();
    }


    public int GetHeight()
    {
        return display.getDsHeight();
    }



}
