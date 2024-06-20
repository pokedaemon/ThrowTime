package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.ui.LoadingPanel;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class LoadingScreen extends State {

    private LoadingPanel loading;
    private Stage stage;
    private Thread thread;

    public LoadingScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
        stage = new Stage(getViewport());
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
        loading.setProgress(Manager.getProgress());
        stage.draw();

        if(Manager.getProgress() == 1f && !thread.isAlive()) {
            parent.changeScreen(ThrowTime.MENU);
            thread.interrupt();
        }
    }

    @Override
    public void create() {

    }

    @Override
    public void show() {
        this.getViewport().setWorldWidth(Constants.LOAD_WIDTH);
        this.getViewport().setWorldHeight(Constants.LOAD_HEIGHT);
        this.getViewport().apply(true);

        Gdx.input.setInputProcessor(stage);

        loading = new LoadingPanel(parent);
        loading.setX(Constants.LOAD_WIDTH / 2);
        loading.setY(Constants.LOAD_HEIGHT / 2);

        stage.addActor(loading);

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Manager.init();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.run();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}