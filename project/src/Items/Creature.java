package Items;


import Tiles.Ban;
import Tiles.Rock5;
import Tiles.Rock6;
import Tiles.Tile;
import com.company.Game;
import com.company.Handler;

import java.awt.*;

public abstract class Creature extends Entity {
    //public static final int DEFAULT_HEALTH=5;
    //public static final float DEFAULT_SPEED=3.0f;
    public static final int DEFAULT_CREATURE_WIDTH=64;
    public static final int DEFAULT_CREATURE_HEIGHT=64;
    public static final float GRAVITY = 0.5f;

    protected double jumpspeed = 7;
   // protected int health;
    protected float speed=1f;
    protected float xMove;
    protected float yMove;
    protected float xVEL;
    protected float yVEL, yVelmax = 10f;
    protected boolean jumping = true;
    protected float lastDamage = 30;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler,x, y, width,height);

        xMove   = 0;
        yMove   = 0;
        xVEL = 0;
        yVEL = 0;
    }

    public void setHealth(int health){
        this.health=health;
    }
    public void setSpeed(float speed){
        this.speed=speed;
    }

    public float getHealth(){
        return health;
    }

    public float getSpeed() {
        return speed;
    }

    public void Move()
    {
        if(!checkEntityCollisions(xVEL, 0f))
        MoveX();
        if(!checkEntityCollisions(0f,yVEL))
        MoveY();
    }

    public void MoveX()
    {
        if(xMove>0){
            int tx=(int) (x+xMove+bounds.x+bounds.width)/ Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int)(y+ bounds.y)/Tile.TILE_HEIGHT)&& !collisionWithTile(tx, (int) (y+ bounds.y +bounds.height)/Tile.TILE_HEIGHT)){
                x+=xMove;
            }else{
                x=tx*Tile.TILE_WIDTH-bounds.x-bounds.width-1;
            }

        }else if(xMove<0){
            int tx=(int) (x+xMove+bounds.x)/ Tile.TILE_WIDTH;
            if(!collisionWithTile(tx,(int)(y+ bounds.y)/Tile.TILE_HEIGHT)&& !collisionWithTile(tx, (int) (y+ bounds.y +bounds.height)/Tile.TILE_HEIGHT)){
                x+=xMove;
            }else{
                x=tx*Tile.TILE_WIDTH-bounds.x+Tile.TILE_WIDTH- bounds.x;
            }

        }
    }


    public void MoveY()
    {
        if(yMove<0){
            int ty=(int) (y+yMove+bounds.y)/ Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+ bounds.x)/Tile.TILE_WIDTH,ty)&& !collisionWithTile((int) (x+ bounds.x +bounds.width)/Tile.TILE_WIDTH,ty)){
                y+=yMove;
            }else{
                y=ty*Tile.TILE_HEIGHT+Tile.TILE_HEIGHT- bounds.y;
            }

        }else if(yMove>0){
            int ty=(int) (y+yMove+bounds.y+bounds.height)/ Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+ bounds.x)/Tile.TILE_WIDTH,ty)&& !collisionWithTile((int) (x+ bounds.x +bounds.width)/Tile.TILE_WIDTH,ty)) {
                y += yMove;
            }else{
                y=ty*Tile.TILE_HEIGHT- bounds.y- bounds.height-1;
                yVEL = 0;


                }
            }
        }



    public float GetXMove()
    {
        return xMove;
    }
    public float GetYMove()
    {
        return yMove;
    }
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }


    public Rectangle getLeftViewBox() {
        return new Rectangle((int) (x - (width * 2)), (int) (y), (int) (width * 2), (int) (height));
    }

    public Rectangle getRightViewBox() {
        return new Rectangle((int) (x + width), (int) (y), (int) (width * 2), (int) (height));
    }

    public Rectangle getRightAttackBox(){
        return new Rectangle((int) (x), (int) (y), (int)64, (int) 64);
    }

    public Rectangle getLeftAttackBox()
    {
        return new Rectangle((int)(x), (int)(y),(int)64, (int) 64);
    }



    protected boolean collisionWithTile(int x, int y)
    {
        return handler.getWorld().getTile(x,y).IsSolid();
    }
    public int GetLife()
    {
        return health;
    }
    public float GetSpeed()
    {
        return speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    public float getXMove()
    {
        return xMove;
    }
    public float getYMove()
    {
        return yMove;
    }
    public void setXMove(float xMove)
    {
        this.xMove = xMove;
    }
    public void setYMove(float yMove)
    {
        this.yMove = yMove;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = (int) damage;
    }

    //Interactiune cu inamici
    public abstract void die();
    public void hurt(float damage) {

        health -= damage;
        if (health <= 0) {
            active = false;
            die();
        }
    }
}
