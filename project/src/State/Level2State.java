package State;

import Tiles.Map;
import com.company.Handler;

import java.awt.*;

public class Level2State extends State{
    private Map world2;

    public Level2State(Handler handler) {
        super(handler);
        world2=new Map(handler,"src/worlds/world2.txt");
        handler.setWorld(world2);
    }

    @Override
    public void tick() {
        world2.tick();
    }

    @Override
    public void render(Graphics g) {
        world2.render(g);

    }
}
