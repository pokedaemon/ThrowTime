package kursksu.game.throwtime.screens;

import static kursksu.game.throwtime.utils.Constants.PPM;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;

public class DebugScreen extends State {
    private Stage stage;
    private World world;
    private Box2DDebugRenderer renderer;

    public DebugScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
    }

    @Override
    public void update(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        world.step(1f/60f, 6, 2);
        renderer.render(world, camera.combined.scl(PPM));
    }

    @Override
    public void create() {
        world = new World(
                new Vector2(0, -9.81f), false
        );
        renderer = new Box2DDebugRenderer();
        stage = new Stage();

        // floor
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, 0);

        FixtureDef fixtureDef = new FixtureDef();
        ChainShape shape = new ChainShape();
        shape.createChain(new Vector2[] {
                new Vector2(0, 0), new Vector2(Constants.SCREEN_WIDTH / (float)PPM, 0)
        });

        shape.dispose();

        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        Body floor = world.createBody(bodyDef);
        floor.createFixture(fixtureDef);

        // ball
        BodyDef bodyDef1 = new BodyDef();
        bodyDef1.type = BodyDef.BodyType.DynamicBody;
        bodyDef1.position.set(Constants.SCREEN_WIDTH / PPM / 2f, Constants.SCREEN_HEIGHT / PPM / 2f);

        FixtureDef fixtureDef1 = new FixtureDef();
        CircleShape circle = new CircleShape();
        circle.setRadius(32f / PPM);
        fixtureDef1.shape = circle;
        fixtureDef1.density = .8f;
        fixtureDef1.restitution = .5f;
        fixtureDef1.friction = .25f;

        circle.dispose();

        Body ball = world.createBody(bodyDef1);
        ball.createFixture(fixtureDef1);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {}
}