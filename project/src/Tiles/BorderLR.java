package Tiles;
import Graphics.Assets;

import java.awt.image.BufferedImage;

public class BorderLR extends Tile {
    public BorderLR(int id)
    {
        super(Assets.borderLR, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }

}
