package Tiles;
import Graphics.Assets;

public class Rock5 extends Tile {
    public Rock5(int id)
    {
        super(Assets.rock5, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
