package kursksu.game.throwtime.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class Basket extends b2Object {

    public Basket(float x, float y) {
        super(x, y);
    }

    @Override
    protected Sprite setPicture() {
        return new Sprite(Manager.getTexture(Constants.backboard));
    }

    @Override
    protected BodyDef setBodyDef(float x, float y) {
        BodyDef body = new BodyDef();

        body.position.set(x, y);
        body.type = BodyDef.BodyType.KinematicBody;
        body.fixedRotation = true;

        return body;
    }

    @Override
    protected FixtureDef setFixture() {
        FixtureDef fixture = new FixtureDef();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(65 / 2f / Constants.PPM, 50 / 2f / Constants.PPM);

        fixture.shape = shape;

        shape.dispose();

        return fixture;
    }

    @Override
    public boolean isChain() {
        return false;
    }

    @Override
    public boolean isCircle() {
        return false;
    }

    @Override
    public boolean isPolygon() {
        return true;
    }
}