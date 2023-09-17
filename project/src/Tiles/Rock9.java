package Tiles;
import Graphics.Assets;

public class Rock9 extends Tile {
    public Rock9(int id)
    {
        super(Assets.rock9, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
