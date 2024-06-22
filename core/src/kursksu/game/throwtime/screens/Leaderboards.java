package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.ui.LeaderboardsPanel;
import kursksu.game.throwtime.utils.Constants;

public class Leaderboards extends State {

    private LeaderboardsPanel leaderboardsPanel;
    private Stage stage;

    public Leaderboards(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
    }

    @Override
    public void update(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void create() {
        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        leaderboardsPanel = new LeaderboardsPanel(parent);
        leaderboardsPanel.setX(Constants.SCREEN_WIDTH / 2);
        leaderboardsPanel.setY(Constants.SCREEN_HEIGHT / 2);

        stage.addActor(leaderboardsPanel);
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