package kursksu.game.throwtime.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class Bandit extends b2Object {

    public Bandit(float x, float y) {
        super(x, y);
    }

    @Override
    protected Sprite setPicture() {
        return new Sprite(Manager.getTexture(Constants.bando));
    }

    @Override
    protected BodyDef setBodyDef(float x, float y) {
        BodyDef body = new BodyDef();

        body.fixedRotation = true;
        body.type = BodyDef.BodyType.StaticBody;
        body.position.set(
                new Vector2(x, y)
        );

        return body;
    }

    @Override
    protected FixtureDef setFixture() {
        FixtureDef fixture = new FixtureDef();

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(15 / Constants.PPM, 45 / Constants.PPM);

        fixture.shape = shape;
        fixture.density = 1f;

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