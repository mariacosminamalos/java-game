package Items;

import Graphics.Assets;
import Inventory.Inventory;
import State.State;
import Tiles.Map;
import Tiles.Tile;
import com.company.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.Animation;

import static Tiles.Tile.ban;


public class Player extends Creature{

    private Animation animLeft;
    private Animation animRight;
    private Animation animJump;
    private BufferedImage Leftattack, Rightattack;
    private long lastAttackTimer, attackCooldown = 200, attackTimer = attackCooldown;
    private Inventory inventory;
    private static int score=0;


    @Override
    public int hurt(int amt) {
        return super.hurt(amt);
    }

    public Player(Handler handler, float x, float y) {
        super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

        bounds.x=32;
        bounds.y=32;
        bounds.width=20;
        bounds.height=30;

        animLeft=new Animation(370,Assets.player_left);
        animRight=new Animation(370,Assets.player_right);
        animJump=new Animation(370,Assets.player_jump);



        lastDamage = System.currentTimeMillis();

        speed = speed*3 ;
        inventory = new Inventory(handler);

    }




    @Override
    public void tick() {

        animLeft.tick();
        animRight.tick();
        animJump.tick();

        GetInput();
        Move();


        checkAttacks();
        CollisionsWithEntities();
        inventory.tick();

    }

    private void checkAttacks(){
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if (attackTimer < attackCooldown)
            return;
        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

         if (handler.getKeyManager().Leftattack) {
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else if (handler.getKeyManager().Rightattack) {
            ar.x = cb.x - cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        } else {
            return;
        }

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(1);
                return;
            }

        }

    }






    private void GetInput()
    {

        yMove = yVEL;
        xMove = xVEL;
        xVEL *= 0.8f;


        if (yVEL < yVelmax) {
            yVEL += GRAVITY;
        }
        if(handler.getKeyManager().right)
        {
            xMove = speed;
        }
        if (handler.getKeyManager().up)
            yMove= - 3*speed;

        if(handler.getKeyManager().left)
        {
            xMove = -speed;}


        if (this.getLeftViewBox().intersects(handler.getWorld().getEntityManager().getPlayer().getRightViewBox()))
            xVEL = -speed;
        if (this.getRightViewBox().intersects(handler.getWorld().getEntityManager().getPlayer().getLeftViewBox()))
            xVEL = speed;




    }
    @Override
    protected boolean collisionWithTile(int x, int y) {
        return super.collisionWithTile(x, y);
    }
    @Override
    public void die() {
        System.out.println("You lose!");
        active = false;
        State.setState(handler.getGame().menuState);

    }


    private void Collision(Handler handler){

        if(getBounds().intersects(130,550,50,100)){
            State.setState(handler.getGame().menuState);
        }

    }


    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);

        Font font=new Font("Scor",Font.BOLD, 200);
        g.drawString("SCORE:" + score, 10,20);
        g.setColor(Color.YELLOW);


    }
    private void CollisionsWithEntities(){
        if(checkEntityCollisions(0,0)){
            ArrayList<Entity> enemies=handler.getWorld().getEntityManager().getEntities();
            for(Entity e:enemies) {
                if(e instanceof Enemy)
                    if(System.currentTimeMillis() - lastDamage > 1000) {
                        hurt(e.getDamage());
                        lastDamage = System.currentTimeMillis();
                    }
            }
        }
    }

    public static void addScore(int sc){
        score+=sc;
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x+width/2-width/2/2,(int)y+height/2,width/2,height/2);
    }

    public Rectangle getBoundsRight(){
        return new Rectangle((int)x,(int)y,width/2,height/2);
    }
    public Rectangle getBoundsLeft(){
        return new Rectangle((int)x,(int)y,width,height);
    }
    public Rectangle getBoundsTop(){
        return new Rectangle((int)x,(int)y,width,height);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            return animRight.getCurrentFrame();
        }else if(yMove<0){
            return animJump.getCurrentFrame();
        }else if(handler.getKeyManager().Leftattack){
            return Assets.Leftattack;

        }else if(handler.getKeyManager().Rightattack) {
            return Assets.Rightattack;
        }
            return Assets.hero;
    }
}
