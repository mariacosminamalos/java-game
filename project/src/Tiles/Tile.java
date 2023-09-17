package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //private static final int NO_TILES   = 32;
    public static Tile[] tiles = new Tile[256];

    public static Tile rock1=new Rock1(1);
    public static Tile rock2=new Rock2(2);
    public static Tile rock3=new Rock3(3);
    public static Tile rock4=new Rock4(4);
    public static Tile rock5=new Rock5(5);
    public static Tile rock6=new Rock6(6);
    public static Tile rock7=new Rock7(7);
    public static Tile rock8=new Rock8(8);
    public static Tile rock9=new Rock9(9);
    public static Tile rock10=new Rock10(10);
    public static Tile rock11=new Rock11(11);
    public static Tile rock12=new Rock12(12);
    public static Tile rock13=new Rock13(13);
    public static Tile rock14=new Rock14(14);
    public static Tile rock15=new Rock15(15);
    public static Tile rock16=new Rock16(16);
    public static Tile no_tile=new noTile(0);
    public static Tile ban=new Ban(17);
    public  static Tile borderUD=new BorderUD(18);
    public static Tile borderLR=new BorderLR(19);



    public static final int TILE_WIDTH  = 32;
    public static final int TILE_HEIGHT = 32;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id)
    {
        this.texture=texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick()
    {

    }

    public void render(Graphics g, int x, int y)
    {

        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }
    public boolean IsSolid()
    {
        return false;
    }

    public int GetId()
    {
        return id;
    }

}
