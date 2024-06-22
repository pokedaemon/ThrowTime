package kursksu.game.throwtime.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class Chubik extends b2Object {

    public Chubik(float x, float y) {
        super(x, y);
    }

    @Override
    protected Sprite setPicture() {
        return new Sprite(Manager.getTexture(Constants.chubik));
    }

    @Override
    protected BodyDef setBodyDef(float x, float y) {
        BodyDef body = new BodyDef();

        body.type = BodyDef.BodyType.KinematicBody;
        body.position.set(x, y);
        body.fixedRotation = true;

        return body;
    }

    @Override
    protected FixtureDef setFixture() {
        FixtureDef fixture = new FixtureDef();

        CircleShape shape = new CircleShape();
        shape.setRadius(18f / Constants.PPM);

        fixture.shape = shape;
        fixture.density = 1f;

        return fixture;
    }

    @Override
    public boolean isChain() {
        return false;
    }

    @Override
    public boolean isCircle() {
        return true;
    }

    @Override
    public boolean isPolygon() {
        return false;
    }
}