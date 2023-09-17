package Tiles;
import Graphics.Assets;

public class Rock11 extends Tile {
    public Rock11(int id)
    {
        super(Assets.rock11, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
