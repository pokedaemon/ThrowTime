package kursksu.game.throwtime.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public abstract class b2Object {

    private Body body;

    private BodyDef bodydef;
    private FixtureDef fixture;

    private Sprite sprite;

    public b2Object(float x, float y) {
        bodydef = setBodyDef(x, y);
        fixture = setFixture();
        sprite = setPicture();
    }

    public Sprite getSprite() { return this.sprite; }
    public BodyDef getBodyDef() {
        return this.bodydef;
    }
    public FixtureDef getFixture() {
        return this.fixture;
    }
    public Body getBody() {
        return this.body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
    protected abstract Sprite setPicture();
    protected abstract BodyDef setBodyDef(float x, float y);
    protected abstract FixtureDef setFixture();
}