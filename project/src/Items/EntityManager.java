package Items;

import com.company.Handler;
import com.company.KeyManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_D;

public class EntityManager {
    private Handler handler;
    private Player player;
    private Enemy1 enemy;
    private Enemy1 enemy2;
    private Key key;

    public Controler getC() {
        return c;
    }

    private Banut banut;
    private door door;
    private Controler c;

    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, Player player, Enemy1 enemy,Enemy1 enemy2,Key key, Banut banut, door door){
        this.handler = handler;
        this.player=player;
        this.banut=banut;
        this.enemy=enemy;
        this.enemy2=enemy2;
        this.key=key;
        this.door=door;
        entities = new ArrayList<Entity>();
        c=new Controler(handler);
        addEntity(player);
        addEntity(key);
        addEntity(door);



    }

    public void tick(){

        Iterator<Entity> it = entities.iterator();
        while(it.hasNext()){
            Entity e = it.next();
            e.tick();
            if(!e.isActive())
                it.remove();
        }
        if (KeyManager.keyJustPressed(VK_A)) {
            c.addBullet(new bullet(handler, player.getX(), player.getY()+27));}
        if (KeyManager.keyJustPressed(VK_D)) {
            c.addBullet(new bullet(handler, player.getX(), player.getY()));}

        player.tick();
        enemy.tick();
        enemy2.tick();
        c.tick();


    }

    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
        player.render(g);
        enemy.render(g);
        enemy2.render(g);
        c.render(g);
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    //GETTERS SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player=player;
    }
      public Enemy1 getEnemy1() {
        return enemy;
    }

    public void setEnemy1(Enemy1 enemy) {
        this.enemy=enemy;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

}


