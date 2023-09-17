package Tiles;

import Graphics.Assets;

public class Apa extends Tile {
    public Apa(int id)
    {
        super(Assets.apa, id);
    }

    @Override
    public boolean IsSolid()
    {
        return false;
    }



}
