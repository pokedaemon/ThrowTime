package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.actors.Background;
import kursksu.game.throwtime.utils.Constants;

public abstract class State implements Screen {

    protected ThrowTime parent;
    protected final SpriteBatch batch;
    protected final OrthographicCamera camera;
    private final Viewport viewport;
    protected Background background;

    protected State(ThrowTime parent, SpriteBatch batch) {
        this.parent = parent;
        this.batch = batch;
        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.WIDTH, Constants.HEIGHT, camera);
        viewport.apply(true);
    }

    protected abstract void update(float delta);

    @Override
    public void render(float delta) {
        update(delta);

        ScreenUtils.clear(0, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}