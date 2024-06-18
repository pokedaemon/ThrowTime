package kursksu.game.throwtime.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Constants {

    // world phys units
    public static final float PHYS_W = 1;
    public static final float PHYS_H = 2;

    // world units
    public static final float WIDTH = 108;
    public static final float HEIGHT = 192;

    // size to pixels
    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    // paths
    public static final String musicPath = "music/";
    public static final String soundPath = "sound/";
    public static final String picturesPath = "pic/";

    // ext
    public static final String png = ".png";
    public static final String mp3 = ".mp3";

    // in code we use
    public static final String background = "Background_mini";
    public static final String bando = "bando_mini";
    public static final String chalkin = "chalkin_mini";
    public static final String chubik = "chubik";
    public static final String ground = "ground_mini1";
}