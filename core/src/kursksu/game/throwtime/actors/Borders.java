package kursksu.game.throwtime.actors;

import static kursksu.game.throwtime.utils.Constants.PPM;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;

import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class Borders extends b2Object {

    public Borders(float x, float y) {
        super(x, y);
    }

    @Override
    protected Sprite setPicture() {
        return null;
    }

    @Override
    protected BodyDef setBodyDef(float x, float y) {
        BodyDef bodyDef = new BodyDef();

        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(
                new Vector2(x, y)
        );
        bodyDef.angle = 55f;
        bodyDef.fixedRotation = false;

        return bodyDef;
    }

    @Override
    protected FixtureDef setFixture() {
        FixtureDef fixtureDef = new FixtureDef();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.WIDTH / PPM, 1 / PPM);


        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        shape.dispose();

        return fixtureDef;
    }

    @Override
    public boolean isChain() {
        return true;
    }

    @Override
    public boolean isCircle() {
        return false;
    }

    @Override
    public boolean isPolygon() {
        return false;
    }
}