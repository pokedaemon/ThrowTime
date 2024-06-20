package kursksu.game.throwtime.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class Ball extends b2Object {

    public Ball(float x, float y) {
        super(x, y);
    }

    @Override
    protected Sprite setPicture() {
        return new Sprite(Manager.getTexture(Constants.ball));
    }

    @Override
    protected BodyDef setBodyDef(float x, float y) {
        BodyDef def = new BodyDef();

        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(x, y);
        def.fixedRotation = false;

        return def;
    }

    @Override
    protected FixtureDef setFixture() {
        FixtureDef fixtureDef = new FixtureDef();

        CircleShape shape = new CircleShape();
        shape.setRadius(8 / Constants.PPM);

        fixtureDef.density = 1f;
        fixtureDef.shape = shape;

        shape.dispose();

        return fixtureDef;
    }
}