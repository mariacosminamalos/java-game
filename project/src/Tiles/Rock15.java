package Tiles;
import Graphics.Assets;

public class Rock15 extends Tile {
    public Rock15(int id)
    {
        super(Assets.rock15, id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
