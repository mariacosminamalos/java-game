package Tiles;
import Graphics.Assets;

import java.awt.image.BufferedImage;

public class Rock1 extends Tile {
    public Rock1(int id)
    {
        super(Assets.rock1, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }

}
