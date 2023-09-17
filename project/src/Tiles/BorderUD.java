package Tiles;
import Graphics.Assets;

import java.awt.image.BufferedImage;

class BorderUD extends Tile {
    public BorderUD(int id)
    {
        super(Assets.borderUD, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }

}
