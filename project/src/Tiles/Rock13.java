package Tiles;
import Graphics.Assets;

public class Rock13 extends Tile {
    public Rock13(int id)
    {
        super(Assets.rock13, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
