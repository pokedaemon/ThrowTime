package kursksu.game.throwtime.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public abstract class b2Object {

    // for b2body
    protected BodyDef bDef;
    protected FixtureDef fDef;

    // img of object
    protected Sprite sprite;

    public b2Object() {
        bDef = new BodyDef();
        fDef = new FixtureDef();
        sprite = new Sprite();
    }

    public BodyDef getBody() {
        return this.bDef;
    }
    public FixtureDef getFixture() {
        return this.fDef;
    }
    public Sprite getSprite() {
        return this.sprite;
    }

    protected abstract void setBody();
    protected abstract void setBody(float pos_x, float pos_y);
    protected abstract void setFixture();
    protected abstract void setSprite();
}