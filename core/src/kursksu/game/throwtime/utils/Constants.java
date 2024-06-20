package kursksu.game.throwtime.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;

public final class Constants {

    public static final float PPM = 32;

    // loading width
    public static final float LOAD_WIDTH = 1000;
    public static final float LOAD_HEIGHT = LOAD_WIDTH * ((float) 16 / 9);

    // size to pixels
    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    // world units
    public static final float WIDTH = 108;
    public static final float HEIGHT = WIDTH * (SCREEN_HEIGHT / SCREEN_WIDTH);

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
    public static final String ball = "Ball";

    // sounds and music
    public static final String music = "music";
    public static final String sound = "button_sound";
}