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
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
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
