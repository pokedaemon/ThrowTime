package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.ui.LabelPanel;
import kursksu.game.throwtime.utils.Manager;

public class SettingsScreen extends State {

    private Stage stage;
    private LabelPanel label;

    public SettingsScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
        background = new Sprite(Manager.getTexture("Background_mini"));
        stage = new Stage();
        label = new LabelPanel();
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
        batch.begin();
        background.draw(batch);
        batch.end();
        stage.draw();
    }

    @Override
    public void create() {

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        label.setX((float) Gdx.graphics.getWidth() / 2);
        label.setY((float) Gdx.graphics.getHeight() / (4.05f / 4f));

        stage.addActor(label);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

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
}