package kursksu.game.throwtime.screens;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import kursksu.game.throwtime.ThrowTime;

public class DebugScreen extends State {

    private Box2DDebugRenderer renderer;
    private World world;

    public DebugScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
        renderer = new Box2DDebugRenderer();
        world = new World(
                new Vector2(0, -9.81f), false
        );

    }

    @Override
    public void update(float delta) {
        world.step(delta, 6, 2);
        renderer.render(world, camera.combined);
    }

    @Override
    public void create() {

    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        world.dispose();
        renderer.dispose();
    }
}
