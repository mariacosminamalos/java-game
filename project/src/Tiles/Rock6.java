package Tiles;
import Graphics.Assets;

public class Rock6 extends Tile {
    public Rock6(int id)
    {
        super(Assets.rock6, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
