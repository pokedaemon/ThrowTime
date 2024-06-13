package kursksu.game.throwtime.utils;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;

public class Constants {

    // TODO: Delete this box2d shit
    // ball fixture
    public static final float BALL_RESTITUTION = .75f;
    public static final float BALL_FRICTION    = .25f;
    public static final float BALL_DENSITY     = 2.5f;

    // ball body
    public static final BodyDef.BodyType BALL_TYPE = BodyDef.BodyType.KinematicBody;

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
}