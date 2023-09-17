package Tiles;
import Graphics.Assets;

public class Rock12 extends Tile {
    public Rock12(int id)
    {
        super(Assets.rock12, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
