package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.ui.AnimatedTable;
import kursksu.game.throwtime.ui.LabelPanel;
import kursksu.game.throwtime.ui.SettingsPanel;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public class SettingsScreen extends State {
    private Stage stage;
    private LabelPanel label;
    private SettingsPanel settings;

    public SettingsScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
        batch.begin();
        background.draw(batch);
        batch.end();
        stage.draw();

        if(settings.isBackPressed()) {
            if(!settings.isAnimate()) {
                settings.setBackPressed(false);
                parent.changeScreen(ThrowTime.MENU);
            }
        }
    }

    @Override
    public void create() {

    }

    @Override
    public void show() {
        background = new Sprite(Manager.getTexture(Constants.background));
        stage = new Stage();
        label = new LabelPanel(parent);
        settings = new SettingsPanel(parent);

        Gdx.input.setInputProcessor(stage);


        label.setX(Constants.SCREEN_WIDTH / 2);
        label.setY(Constants.SCREEN_HEIGHT / (4.05f / 4f));

        settings.setX(Constants.SCREEN_WIDTH / 2);
        settings.setY(Constants.SCREEN_HEIGHT / 2);

        settings.setOrientation(AnimatedTable.OrientationFrom.Right);
        settings.setMaxTime(0.0f);
        settings.hide();

        settings.setMaxTime(0.6f);
        settings.show();

        stage.addActor(settings);
        stage.addActor(label);
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