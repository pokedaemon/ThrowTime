package kursksu.game.throwtime.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Chalkin extends b2Object {

    public Chalkin(float x, float y) {
        super(x, y);
    }

    @Override
    protected Sprite setPicture() {
        return null;
    }

    @Override
    protected BodyDef setBodyDef(float x, float y) {
        return null;
    }

    @Override
    protected FixtureDef setFixture() {
        return null;
    }
}