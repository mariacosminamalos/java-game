package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width=32, heigh=32;
    private static final int width2=64, heigh2=64;

    public static BufferedImage backgr;
    public static BufferedImage menustate;
    public static BufferedImage apa;
    public static BufferedImage ban;
    public static BufferedImage key;

    public static BufferedImage Leftattack;
    public static BufferedImage Rightattack;

    public static BufferedImage hero;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    public static BufferedImage []player_jump;
    public static BufferedImage player_jumpLeft;
    public static BufferedImage player_jumpRight;
    public  static BufferedImage[] btn_start;

    public static BufferedImage[] Enemy1;

    public static BufferedImage rock1;
    public static BufferedImage rock2;
    public static BufferedImage rock3;
    public static BufferedImage rock4;
    public static BufferedImage rock5;
    public static BufferedImage rock6;
    public static BufferedImage rock7;
    public static BufferedImage rock8;
    public static BufferedImage rock9;
    public static BufferedImage rock10;
    public static BufferedImage rock11;
    public static BufferedImage rock12;
    public static BufferedImage rock13;
    public static BufferedImage rock14;
    public static BufferedImage rock15;
    public static BufferedImage rock16;
    public static BufferedImage no_tile;
    public static BufferedImage borderUD;
    public static BufferedImage borderLR;
    public static BufferedImage door;
    public static BufferedImage Rbullet;
    public static BufferedImage Lbullet;
    public static BufferedImage heart;


    public static void init(){
        backgr = ImageLoader.loadImage("/textures/background.png");
        menustate=ImageLoader.loadImage("/textures/menustate.png");
        apa = ImageLoader.loadImage("/textures/apa.png");
        ban=ImageLoader.loadImage("/textures/banut.png");


        SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/Tiles.png"));
        rock1=sheet.crop(0,0,heigh,width);
        rock2=sheet.crop(32,0,heigh,width);
        rock3=sheet.crop(64,0,heigh,width);
        rock4=sheet.crop(96,0,heigh,width);
        rock5=sheet.crop(128,0,heigh,width);
        rock6=sheet.crop(160,0,heigh,width);
        rock7=sheet.crop(192,0,heigh,width);
        rock8=sheet.crop(224,0,heigh,width);
        rock9=sheet.crop(256,0,heigh,width);
        rock10=sheet.crop(288,0,heigh,width);
        rock11=sheet.crop(320,0,heigh,width);
        rock12=sheet.crop(352,0,heigh,width);
        rock13=sheet.crop(384,0,heigh,width);
        rock14=sheet.crop(416,0,heigh,width);
        rock15=sheet.crop(448,0,heigh,width);
        rock16=sheet.crop(480,0,heigh,width);
        no_tile=sheet.crop(512,0,heigh,width);
        borderUD=sheet.crop(512,0,1,32);
        borderLR=sheet.crop(512,0,32,1);

        SpriteSheet sheet2=new SpriteSheet(ImageLoader.loadImage("/textures/hero.png"));
        hero=sheet2.crop(0,0,width2,heigh2);

        player_left=new BufferedImage[2];
        player_left[0]=sheet2.crop(384,0,width2,heigh2);
        player_left[1]=sheet2.crop(320,0,width2,heigh2);

        player_right=new BufferedImage[2];
        player_right[0]=sheet2.crop(192,0,width2,heigh2);
        player_right[1]=sheet2.crop(256,0,width2,heigh2);

        player_jump=new BufferedImage[2];
        player_jump[0]=sheet2.crop(448,0,width2,heigh2);
        player_jump[1]=sheet2.crop(448,0,width2,heigh2);

        player_jumpLeft=sheet2.crop(704,0,width2,heigh2);
        player_jumpRight=sheet2.crop(640,0,width2,heigh2);

        Leftattack=sheet2.crop(384,0,width2,width2);
        Rightattack=sheet2.crop(192,0,width2,heigh2);

        SpriteSheet sheet3=new SpriteSheet(ImageLoader.loadImage("/textures/enemy1.png"));
        Enemy1=new BufferedImage[8];
        Enemy1[0]=sheet3.crop(0,0,50,64);
        Enemy1[1]=sheet3.crop(64,0,50,64);
        Enemy1[2]=sheet3.crop(128,0,50,64);
        Enemy1[3]=sheet3.crop(192,0,50,64);
        Enemy1[4]=sheet3.crop(256,0,50,64);
        Enemy1[5]=sheet3.crop(320,0,50,64);
        Enemy1[6]=sheet3.crop(384,0,50,64);
        Enemy1[7]=sheet3.crop(448,0,50,64);

        SpriteSheet sheet4=new SpriteSheet(ImageLoader.loadImage("/textures/comp.png"));
        heart=sheet4.crop(64,0,32,32);
        key=sheet4.crop(96,0,32,32);
        door=sheet4.crop(128,0,72,64);
        Rbullet=sheet4.crop(0,0,32,32);
        Lbullet=sheet4.crop(32,0,32,32);

        btn_start=new BufferedImage[2];
        btn_start[0]=ImageLoader.loadImage("/textures/Play.png");
        btn_start[1]=ImageLoader.loadImage("/textures/Play2.png");
    }

}
