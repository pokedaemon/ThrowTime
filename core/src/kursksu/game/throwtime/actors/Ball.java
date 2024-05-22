package kursksu.game.throwtime.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;

import kursksu.game.throwtime.utils.Constants;

public class Ball extends b2Object {

    public Ball() {
        super();
        setBody(0, 0);
        setFixture();
        setSprite();
    }

    @Override
    protected void setBody() {
        setBody(0, 0);
    }

    @Override
    protected void setBody(float pos_x, float pos_y) {
        this.bDef.type = Constants.BALL_TYPE;
        this.bDef.position.set(new Vector2(pos_x, pos_y));
    }

    @Override
    protected void setFixture() {
        CircleShape shape = new CircleShape();
        shape.setRadius(.75f);

        this.fDef.shape       = shape;
        this.fDef.restitution = Constants.BALL_RESTITUTION;
        this.fDef.friction    = Constants.BALL_FRICTION;
        this.fDef.density     = Constants.BALL_DENSITY;

        shape.dispose();
    }

    @Override
    protected void setSprite() {
        // this.sprite.setRegion(new Texture(Gdx.files.internal("img/ball.png")));
    }
}