package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Manager;

public class MenuScreen extends State {

    private BitmapFont font;
    private Stage stage;
    private Skin skin;
    private Music music;

    boolean playPressed, settingsPressed;

    public MenuScreen(ThrowTime parent, SpriteBatch batch) {
        super(parent, batch);
        stage = new Stage();
        background = new Sprite(Manager.getTexture("Background_mini.png"));
        playPressed = settingsPressed = false;
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
    public void create() {}

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);

        Table main = new Table();
        Table label = new Table();

        main.setFillParent(true);
        label.setFillParent(true);

        music = Manager.getMusic("cool.mp3");
        music.play();

        // font settings
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
                Gdx.files.internal("yoster2.ttf")
        );
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.
                FreeTypeFontParameter();

        parameter.size = 120;
        parameter.color = Color.ORANGE;
        parameter.shadowOffsetX = 1;
        parameter.shadowOffsetY = 1;

        font = generator.generateFont(parameter);

        Label.LabelStyle styleLabel = new Label.LabelStyle();
        styleLabel.font = font;

        generator.dispose();
        // *****

        // title
        Label title = new Label("Throw Time", styleLabel);

        label.top().pad(300);
        label.add(title);
        // *****

        skin = Manager.getSkin();

        // buttons of menu
        TextButton playButton = new TextButton("PLAY", skin);
        TextButton settingsButton = new TextButton("SETTINGS", skin);
        TextButton exitButton = new TextButton("EXIT", skin);

        main.center();
        main.add(playButton).width(650).height(150);
        main.row();
        main.add(settingsButton).width(650).height(150).pad(40);
        main.row();
        main.add(exitButton).width(650).height(150);
        main.row();
        // *****

        // sounds of buttons
        Sound buttonSound = Manager.getSound("button_sound.mp3");

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
                main.addAction(Actions.moveBy(-(main.getX() + main.getWidth()), 0f, 1f, Interpolation.smooth2));
                playPressed = true;
            }
        });

        settingsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
                main.addAction(Actions.moveBy((main.getX() + main.getWidth()), 0f, 1f, Interpolation.smooth2));
                settingsPressed = true;
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
                Gdx.app.exit();
            }
        });

        stage.addActor(label);
        stage.addActor(main);
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
        font.dispose();
        skin.dispose();
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