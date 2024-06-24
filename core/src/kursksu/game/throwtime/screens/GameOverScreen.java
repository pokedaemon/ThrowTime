package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.ui.AnimatedTable;
import kursksu.game.throwtime.ui.GameOverPanel;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class GameOverScreen extends State {

    private Stage stage;
    private GameOverPanel gameOverPanel;

    public GameOverScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
    }

    @Override
    public void update(float delta) {
        batch.begin();
        background.draw(batch);
        batch.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        gameOverPanel = new GameOverPanel(parent);
        background = new Sprite(Manager.getTexture(Constants.background));

        gameOverPanel.setX(Constants.SCREEN_WIDTH / 2);
        gameOverPanel.setY(Constants.SCREEN_HEIGHT / 2);

        gameOverPanel.setMaxTime(.0f);
        gameOverPanel.setOrientation(AnimatedTable.OrientationFrom.Bottom);
        gameOverPanel.hide();

        gameOverPanel.setMaxTime(.8f);
        gameOverPanel.show();

        stage.addActor(gameOverPanel);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}