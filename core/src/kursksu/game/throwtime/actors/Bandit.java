package kursksu.game.throwtime.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

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
        return null;
    }

    @Override
    protected FixtureDef setFixture() {
        return null;
    }
}