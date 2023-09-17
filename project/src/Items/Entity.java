package Items;

import com.company.Handler;

import java.awt.*;

public abstract class Entity  {

     protected float x,y ;
     protected int width, height;
     protected int health;
     protected Handler handler;
     protected Rectangle bounds;
     protected Rectangle normalBounds;
     protected Rectangle attackBounds;
     protected boolean active=true;
     protected int damage;


     public Entity(Handler handler, float x, float y, int width, int height){

         this.handler=handler;
         this.x=x;
         this.y=y;
         health = 10;
         this.width=width;
         this.height=height;


         bounds=new Rectangle(0,0, width,height);


     }
     public boolean isActive() {
        return active;
    }

     public void setActive(boolean active) {
        this.active = active;
    }

     public abstract void die();

     public abstract void tick();
     public abstract void render(Graphics g);
     public void setX(float x){
         this.x=x;
     }
     public void setY(float y){
        this.y=y;
    }
     public void setWidth(int width){
        this.width=width;
    }
     public void setHeight(int height){
        this.height=height;
    }

     public float getX(){
         return x;
    }

     public float getY() {
        return y;
    }
     public float getWidth() {
        return width;
    }
     public float getHeight() {
        return height;
    }


    public int hurt(int amt){
        health -= amt;
        if(health <= 0) {
            active = false;
            die();
        }
        return amt;
    }
    public Rectangle getCollisionBounds(float xOffset, float yOffset)
    {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for (Entity e: handler.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffset)))
                return true;
        }
        return false;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = (int) damage;
    }

    public Rectangle getRightViewBox() {
        return new Rectangle((int) (x + 64), (int) (y), (int) (width * 2), (int) (height));
    }

    public Rectangle getLeftViewBox() {
        return new Rectangle((int) (x - (width * 2)), (int) (y), (int) (width * 2), (int) (height));
    }

    public Rectangle getRightAttackBox(){
        return new Rectangle((int) (x), (int) (y), (int) 32, (int) 32);
    }

    public Rectangle getLeftAttackBox()
    {
        return new Rectangle((int)(x), (int)(y),(int)32, (int) 32);
    }

}
