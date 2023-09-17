package Tiles;
import Graphics.Assets;

public class Rock4 extends Tile {
    public Rock4(int id)
    {
        super(Assets.rock4, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }

}
