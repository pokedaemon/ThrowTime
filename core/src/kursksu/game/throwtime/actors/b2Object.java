package kursksu.game.throwtime.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public abstract class b2Object {

    private BodyDef body;
    private FixtureDef fixture;

    private Sprite sprite;

    public b2Object() {
        body = setBody();
        fixture = setFixture();
        sprite = setPicture();
    }

    public BodyDef getBody() {
        return this.body;
    }

    public FixtureDef getFixture() {
        return this.fixture;
    }


    protected abstract Sprite setPicture();
    protected abstract BodyDef setBody();
    protected abstract FixtureDef setFixture();
}