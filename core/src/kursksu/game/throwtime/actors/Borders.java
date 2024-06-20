package kursksu.game.throwtime.actors;

import static kursksu.game.throwtime.utils.Constants.PPM;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class Borders extends b2Object {

    private final boolean isVertical;

    public Borders(boolean isVertical, float x, float y) {
        super(x, y);
        this.isVertical = isVertical;
    }

    @Override
    protected Sprite setPicture() {
        return new Sprite(Manager.getTexture(Constants.ground));
    }

    @Override
    protected BodyDef setBodyDef(float x, float y) {
        BodyDef bodyDef = new BodyDef();

        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(x, y);
        bodyDef.fixedRotation = true;

        return bodyDef;
    }

    @Override
    protected FixtureDef setFixture() {
        FixtureDef fixtureDef = new FixtureDef();

        PolygonShape shape = new PolygonShape();
        float width, height;
        if(!isVertical) {
            width = Constants.WIDTH;
            height = 3f;
        }
        else {
            width = 3f;
            height = Constants.HEIGHT;
        }
        shape.setAsBox(width / PPM, height / PPM);

        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        shape.dispose();

        return fixtureDef;
    }
}