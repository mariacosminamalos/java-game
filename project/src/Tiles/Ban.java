package Tiles;
import Graphics.Assets;

public class Ban extends Tile {
    public Ban(int id)
    {
        super(Assets.ban, id);
    }

    @Override
    public boolean IsSolid()
    {
        return false;
    }



}
