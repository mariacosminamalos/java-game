package Items;

import Tiles.Tile;
import com.company.Handler;
import Graphics.Assets;

import java.awt.*;

public class door extends StaticEntity{

        public door(Handler handler, float x, float y)
        {
            super(handler, x, y, Tile.TILE_WIDTH , Tile.TILE_HEIGHT);

            bounds.x = 1;
            bounds.y = (int) (height / 2.5f);
            bounds.width = width + 1;
            bounds.height = (int)(height - height / 1.5f);
        }

        @Override
        public void tick()
        {

        }

        @Override
        public void die()
        {
        }
        @Override
        public void render(Graphics g)
        {
            g.drawImage(Assets.door, (int) x, (int) y,64,72, null);

        }
    }


