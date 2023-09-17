package Tiles;
import Graphics.Assets;

public class Rock16 extends Tile {
    public Rock16(int id)
    {
        super(Assets.rock16, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
