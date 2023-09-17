package Tiles;
import Graphics.Assets;

public class Rock8 extends Tile {
    public Rock8(int id)
    {
        super(Assets.rock8, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
