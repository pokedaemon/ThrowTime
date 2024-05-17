package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

import kursksu.game.throwtime.ThrowTime;

public class MenuScreen implements Screen {

    ThrowTime parent;
    FreeTypeFontGenerator generator;
    BitmapFont font;
    Stage stage;

    public MenuScreen(ThrowTime parent) {
        this.parent = parent;
        stage = new Stage();
    }

    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {
        parent.getSettings().all();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("yoster.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 100;
        parameter.shadowOffsetX = 1;
        parameter.shadowOffsetY = 1;
        font = generator.generateFont(parameter);
        Gdx.input.setInputProcessor(stage);

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.WHITE;

        Label title = new Label("Throw Time", labelStyle);

        Table root = new Table();

        root.setDebug(true);
        root.setFillParent(true);

        root.top();
        root.add(title).padTop(100);

        parameter.size = 75;
        font = generator.generateFont(parameter);

        Table root2 = new Table();
        root2.center();

        root2.setFillParent(true);
        root2.setDebug(true);

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = font;
        textButtonStyle.fontColor = Color.WHITE;

        TextButton newGameButton = new TextButton("Play", textButtonStyle);
        TextButton settingsButton = new TextButton("Settings", textButtonStyle);
        TextButton exitButton = new TextButton("Exit", textButtonStyle);

        root2.add(newGameButton).pad(10);
        root2.row();
        root2.add(settingsButton).pad(10);
        root2.row();
        root2.add(exitButton).pad(10);

        stage.addActor(root);
        stage.addActor(root2);
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        stage.act(delta);
        stage.draw();
    }

    /**
     * @param width
     * @param height
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     *
     */
    @Override
    public void pause() {

    }

    /**
     *
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        generator.dispose();
        stage.dispose();
    }
}