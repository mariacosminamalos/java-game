package Items;

import com.company.Handler;

import java.awt.*;
import java.util.LinkedList;

public class Controler {
    public LinkedList<bullet> b = new LinkedList<>();

    Handler handler;

    public Controler(Handler handler){
        this.handler=handler;

    }

    public void tick(){
        for (bullet a : b)
        {
            if (a.getX() < 0 || a.getX() > handler.getWidth())
                b.remove(a);
            else
                a.tick();
        }

    }


    public void render(Graphics g){
        for (bullet a : b)
            a.render(g);
    }

    public void addBullet(bullet block){
        b.add(block);
    }



    public void removeBullet(bullet block){
        b.remove(block);
    }
}
