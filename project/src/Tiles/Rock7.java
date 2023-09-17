package Tiles;
import Graphics.Assets;

public class Rock7 extends Tile {
    public Rock7(int id)
    {
        super(Assets.rock7, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
