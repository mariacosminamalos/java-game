package Items;

import State.MenuState;
import com.company.Game;
import com.company.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

import Graphics.Animation;
import Graphics.Assets;


import static Graphics.Assets.menustate;


public class Enemy1 extends  Enemy{
    private Animation fly;
    private bullet b;

    public Enemy1(Handler handler, float x, float y, int width, int height, int health, float damage) {
        super(handler, x, y, width,height,health,damage);
        this.b=b;

        bounds.x = 17;
        bounds.y = 10;
        bounds.width = 15;
        bounds.height = 27;
        speed = speed * 2;

        fly=new Animation(150, Assets.Enemy1);
        lastDamage = System.currentTimeMillis();
    }



    @Override
    public void tick() {

       // x+=3;
        if (!active) return;
        fly.tick();

        GetImput();
        Move();
        CollisionsWithEntities();

    }

    private void GetImput() {
        yMove = yVEL;
        xMove=xVEL;
        xVEL *= 0.9f;
        if (yVEL < yVelmax)
            yVEL += GRAVITY;

        if (this.getLeftViewBox().intersects(handler.getWorld().getEntityManager().getPlayer().getRightViewBox()))
            xVEL = -speed;
        if (this.getRightViewBox().intersects(handler.getWorld().getEntityManager().getPlayer().getLeftViewBox()))
            xVEL = speed;
        if(this.getCollisionBounds(0,0).intersects(handler.getWorld().getEntityManager().getPlayer().getLeftAttackBox()) ||
                this.getCollisionBounds(0,0).intersects(handler.getWorld().getEntityManager().getPlayer().getRightAttackBox())) {
            hurt(handler.getWorld().getEntityManager().getPlayer().hurt(5));
        }

        for (bullet e : handler.getWorld().getEntityManager().getC().b) {
            if (this.getCollisionBounds(0, 0).intersects(e.getBulletR())){
                die();
            }

        }
    }



    @Override
    public void die() {
        super.die();
    }


    @Override
    public void render(Graphics g) {
        if (active)
            g.drawImage(getCurrentAnimationFrame(),(int) x, (int) y,width, height,null);
    }

    private BufferedImage getCurrentAnimationFrame() {

        return fly.getCurrentFrame();
    }

    protected void CollisionsWithEntities()
    {

        if(checkEntityCollisions(0,0)){
            if(System.currentTimeMillis() - lastDamage > 500)
            {
                hurt((int) handler.getWorld().getEntityManager().getPlayer().getDamage());
                lastDamage = System.currentTimeMillis();
            }
        }
    }

    @Override
    public float getDamage() {
        return super.getDamage();
    }

}
