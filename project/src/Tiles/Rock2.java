package Tiles;
import Graphics.Assets;

public class Rock2 extends Tile {
    public Rock2(int id)
    {
        super(Assets.rock2, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }

}
