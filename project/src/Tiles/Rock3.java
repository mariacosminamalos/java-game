package Tiles;
import Graphics.Assets;

public class Rock3 extends Tile {
    public Rock3(int id)
    {
        super(Assets.rock3, id);
    }

    @Override
    public boolean IsSolid()
    {
        return true;
    }

}
