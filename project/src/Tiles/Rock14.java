package Tiles;
import Graphics.Assets;

public class Rock14 extends Tile {
    public Rock14(int id)
    {
        super(Assets.rock14, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
