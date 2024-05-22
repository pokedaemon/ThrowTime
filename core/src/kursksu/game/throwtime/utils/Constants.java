package kursksu.game.throwtime.utils;


import com.badlogic.gdx.physics.box2d.BodyDef;

public class Constants {

    // Ball Fixture
    public static final float BALL_RESTITUTION = .75f;
    public static final float BALL_FRICTION    = .25f;
    public static final float BALL_DENSITY     = 2.5f;

    // Ball Body
    public static final BodyDef.BodyType BALL_TYPE = BodyDef.BodyType.KinematicBody;

    //
    public static final float WIDTH = 120 * (float)16 / 9;
    public static final float HEIGHT = 120;

}