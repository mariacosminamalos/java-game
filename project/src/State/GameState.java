package State;

import Items.Enemy1;
import Items.Key;
import Items.Player;
import Tiles.Map;
import com.company.Handler;

import java.awt.*;

public class GameState extends State{

    private Map world;
  //  private Player player;

    public GameState(Handler handler){
      super(handler);
      world=new Map(handler,"src/worlds/world1.txt");
      handler.setWorld(world);
     // player=new Player(handler,200,250);


    }

    @Override
    public void tick() {
        world.tick();
       // player.tick();;


    }

    @Override
    public void render(Graphics g) {
        world.render(g);
      //  player.render(g);




    }



}
