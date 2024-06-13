package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.ui.AnimatedTable;
import kursksu.game.throwtime.ui.ButtonsPanel;

public class DebugScreen extends State {

    private Stage stage;
    private ButtonsPanel panel;

    public DebugScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
        stage = new Stage();
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
        stage.draw();
        if(panel.getStatus() == AnimatedTable.Status.Hided) {
            parent.changeScreen(ThrowTime.MENU);
        }
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
        Gdx.input.setInputProcessor(stage);
        panel = new ButtonsPanel();
        panel.setFillParent(true);
        panel.setX((float) Gdx.graphics.getWidth() / 2);
        panel.setY((float) Gdx.graphics.getHeight() / 2);
        panel.setMaxTime(0.6f);
        stage.addActor(panel);
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
