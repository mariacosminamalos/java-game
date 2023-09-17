package Tiles;


import Inventory.Inventory;
import Items.*;
import com.company.Game;
import com.company.Handler;
import com.company.Utils;
import Graphics.Assets;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Map {


    private  Handler handler;
    private int width;
    private int height;
    private int spawnX, spawnY;
    private int[][] tiles;

    private EntityManager entityManager;
    private ItemManager itemManager;
    private Inventory i;

    //private ItemManager itemManager;

    public Map(Handler handler, String path) {
        this.handler=handler;
        entityManager = new EntityManager(handler, new Player(handler, 700, 300), new Enemy1(handler,100,400, 128,64,2,0),new Enemy1(handler,150,150,128,64,2,0),new Key(handler,-50,5),new Banut(handler,0,0), new door(handler,700,60));
        itemManager=new ItemManager(handler);
        loadWorld(path);


        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);

        entityManager.getEnemy1().setX(100);
        entityManager.getEnemy1().setX(200);
        itemManager.addItem(Item.keyItem.createNew(60,30));
        itemManager.addItem(Item.heart.createNew(25,120));

        itemManager.addItem(Item.banut.createNew(120,35));
        itemManager.addItem(Item.banut.createNew(150,35));
        itemManager.addItem(Item.banut.createNew(100,450));
        itemManager.addItem(Item.banut.createNew(100,420));
        itemManager.addItem(Item.banut.createNew(100,390));
        itemManager.addItem(Item.banut.createNew(75,390));
        itemManager.addItem(Item.banut.createNew(50,390));
        itemManager.addItem(Item.banut.createNew(25,390));
        itemManager.addItem(Item.banut.createNew(0,390));
        itemManager.addItem(Item.banut.createNew(0,450));
        itemManager.addItem(Item.banut.createNew(0,420));
        itemManager.addItem(Item.banut.createNew(0,420));
        itemManager.addItem(Item.banut.createNew(0,390));
        itemManager.addItem(Item.banut.createNew(510,350));
        itemManager.addItem(Item.banut.createNew(525,330));
        itemManager.addItem(Item.banut.createNew(545,315));
        itemManager.addItem(Item.banut.createNew(565,305));
        itemManager.addItem(Item.banut.createNew(587,305));
        itemManager.addItem(Item.banut.createNew(609,305));
        itemManager.addItem(Item.banut.createNew(627,318));
        itemManager.addItem(Item.banut.createNew(643,334));
        itemManager.addItem(Item.banut.createNew(660,353));
        if(Item.keyItem.isPickedUp()){
            itemManager.addItem(Item.keyItem.createNew(5,0));
        }


    }


    private void loadWorld(String path){
         String file= Utils.loadFileAsString(path);
         String[] tokens=file.split("\\s+");
         width=Utils.parseInt(tokens[0]);
         height=Utils.parseInt(tokens[1]);
         spawnX=Utils.parseInt(tokens[2]);
         spawnY=Utils.parseInt(tokens[3]);

         tiles=new int[width][height];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
            }
        }

        if(Item.keyItem.isPickedUp()){
            itemManager.addItem(Item.keyItem.createNew(5,0));
        }

    }

    public void tick() {
        itemManager.tick();
        entityManager.tick();
        if(Item.keyItem.isPickedUp()){
            itemManager.addItem(Item.keyItem.createNew(5,0));
        }
    }

    public void render(Graphics g){

        g.drawImage(Assets.backgr,0,0,null);
        g.drawImage(Assets.apa,126,512,null);
        g.drawImage(Assets.apa,574,480,null);
        g.drawImage(Assets.apa,542,480,null);
        g.drawImage(Assets.apa,734,490,null);

        int xStart=0;
        int xEnd=width;
        int yStart=0;
        int yEnd=height;

        for(int y=yStart;y<yEnd;y++){
            for(int x=xStart;x<xEnd;x++) {
                getTile(x,y).render(g,x*Tile.TILE_WIDTH,y*Tile.TILE_HEIGHT);
            }}
        itemManager.render(g);
        entityManager.render(g);
        if(Item.keyItem.isPickedUp()){
            itemManager.addItem(Item.keyItem.createNew(5,0));
        }

        for(int i=0;i<entityManager.getPlayer().getHealth();i++){
            itemManager.addItem(Item.heart.createNew(760,10));
            itemManager.addItem(Item.heart.createNew(730,10));
            itemManager.addItem(Item.heart.createNew(700,10));

        }
    }

    public Tile getTile(int x,int y) {
        if(x<0 || y<0 || x>=width ||y>=  height)
            return Tile.no_tile;
        Tile t=Tile.tiles[tiles[x][y]];
        if(t==null) {
            return Tile.no_tile;
        }
        return t;
        }


    public Rectangle getBounds(){
        return new Rectangle(2,0,600,1);

    }


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}