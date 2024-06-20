package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.MassData;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.actors.b2Object;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.GameWorld;
import kursksu.game.throwtime.utils.Manager;

import static kursksu.game.throwtime.utils.Constants.SCREEN_WIDTH;
import static kursksu.game.throwtime.utils.Constants.SCREEN_HEIGHT;
import static kursksu.game.throwtime.utils.Constants.PPM;

public class GameScreen extends State {

    GameWorld world;
    Box2DDebugRenderer renderer;
    InputProcessor processor;

    public GameScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
    }

    @Override
    public void update(float delta) {
        world.render(delta);
        inputUpdate(delta);
        cameraUpdate(delta);
    }

    @Override
    public void create() {
        world = new GameWorld();
        world.init();

        batch.setProjectionMatrix(getViewport().getCamera().combined);
        processor = new InputProcessor() {
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
        };

        Gdx.input.setInputProcessor(processor);

        renderer = new Box2DDebugRenderer();
        background = new Sprite(Manager.getTexture(Constants.background));
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

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();

        for(b2Object p : world.getObjects()) {
            p.getSprite().setPosition(
                    p.getBody().getPosition().x * PPM - p.getSprite().getWidth() / 2,
                    p.getBody().getPosition().y * PPM - p.getSprite().getHeight() / 2
            );
        }

        background.draw(batch);
        world.getObjects().get(1).getSprite().draw(batch);
        batch.end();

        renderer.render(world.getWorld(), camera.combined.scl(PPM));
    }

    public void cameraUpdate(float delta) {
        camera.update();
    }

    public void inputUpdate(float delta) {
        if(Gdx.input.isTouched()) {
            world.getObjects().get(1).getBody().applyForceToCenter(
                    new Vector2(-10, 0), false
            );
        }
    }
}
