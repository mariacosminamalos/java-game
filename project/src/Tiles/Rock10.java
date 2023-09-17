package Tiles;
import Graphics.Assets;

public class Rock10 extends Tile {
    public Rock10(int id)
    {
        super(Assets.rock10, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
