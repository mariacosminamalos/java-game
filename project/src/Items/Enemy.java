package Items;

import com.company.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

import Graphics.Animation;
import Graphics.Assets;

public abstract class Enemy extends  Creature{

    private float enemySpeed = 1.5f;

    public Enemy(Handler handler, float x, float y, int width, int height, float damage, float v) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        this.health=health;
        this.speed = enemySpeed;
        this.damage = (int) damage;


    }


    @Override
    public void die() {
        active=false;
    }

    @Override
    public void tick() {


    }

    @Override
    public void render(Graphics g) {
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
