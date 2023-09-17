package Items;

import java.awt.*;

import Graphics.Assets;
import com.company.Handler;

public class bullet {

    private double x;
    private double y;


    public bullet(Handler handler,double x, double y){
        this.x=x;
        this.y=y;


    }

    public void tick() {

      //  if (p.stanga)
            x -= 10;

       // if(p.dreapta)
       //     x+=10;
    }

    public void render(Graphics g){
        g.drawImage(Assets.Lbullet,(int) x,(int) y,null);

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

   public Rectangle getBulletR(){
        return new Rectangle((int) (x), (int) (y), (int)32, (int) 32);
    }
}


