package kursksu.game.throwtime.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class Ball extends b2Object {

    public Ball() {
        super();
    }

    @Override
    protected Sprite setPicture() {
        return new Sprite(Manager.getTexture("Ball"));
    }

    @Override
    protected BodyDef setBody() {
        BodyDef bodyDef = new BodyDef();

        return bodyDef;
    }

    @Override
    protected FixtureDef setFixture() {
        return null;
    }
}