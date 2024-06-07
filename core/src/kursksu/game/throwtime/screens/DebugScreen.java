package kursksu.game.throwtime.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;

import static kursksu.game.throwtime.utils.Constants.SCREEN_WIDTH;
import static kursksu.game.throwtime.utils.Constants.SCREEN_HEIGHT;

public class DebugScreen implements Screen {
    private final SpriteBatch batch;
    FreeTypeFontGenerator generator;
    BitmapFont font;
    private ThrowTime parent;
    private Stage stage;
    private Skin skin;
    private Music music;

    Sprite background;

    public DebugScreen(ThrowTime parent, SpriteBatch batch) {
        this.batch = batch;
        this.parent = parent;
        this.stage = new Stage();
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

    public void show() {
        music = Gdx.audio.newMusic(Gdx.files.internal("cool.mp3"));
        music.play();

        parent.getSettings().all();
        generator = new FreeTypeFontGenerator(Gdx.files.internal("yoster2.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 120;
        parameter.shadowOffsetX = 1;
        parameter.shadowOffsetY = 1;
        font = generator.generateFont(parameter);
        Gdx.input.setInputProcessor(stage);

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = font;
        labelStyle.fontColor = Color.ORANGE;

        Label title = new Label("Throw Time", labelStyle);

        Table name_game = new Table();

        name_game.setDebug(true);
        name_game.setFillParent(true);

        name_game.top().pad(300);
        name_game.add(title);

        SpriteBatch spriteBatch = new SpriteBatch();
        Texture background = new Texture(Gdx.files.internal("pixil-frame.png"));


        spriteBatch.begin();
        spriteBatch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        spriteBatch.end();


        background.dispose();

        skin = new Skin(Gdx.files.internal("skin.json"));
        Gdx.input.setInputProcessor(stage);

        Table exit_table = new Table();
        exit_table.setDebug(true);
        exit_table.setFillParent(true);

        ImageButton exit = new ImageButton(skin, "sound");

        exit_table.top().right();
        exit_table.add(exit).width(150).height(150);
        exit_table.row();


        Table main_table = new Table();
        main_table.setDebug(true);
        main_table.setFillParent(true);


        TextButton button1 = new TextButton("PLAY", skin, "play");
        TextButton button2 = new TextButton("SETTINGS", skin);
        TextButton button3 = new TextButton("EXIT", skin);

        main_table.center();
        main_table.add(button1).width(650).height(150);  // Add button 1, expand to fill height
        main_table.row();                // Add a new row
        main_table.add(button2).width(650).height(150).pad(40);             // Add button 2
        main_table.row();                // Add another new row
        main_table.add(button3).width(650).height(150);  // Add button 3, expand to fill height

        // Add the button table to the root table, centered vertically and horizontally


        main_table.row();

        stage.addActor(exit_table);
        stage.addActor(name_game);
        stage.addActor(main_table);

        Sound buttonSound = Gdx.audio.newSound(Gdx.files.internal("button_sound.mp3"));
        button1.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
            }
        });

        button2.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
            }
        });

        button3.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
            }
        });

        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
                toggleMusic();
            }
        });
    }

    @Override
    public void render(float delta) {
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    private void toggleMusic() {
        if (music.isPlaying()) {
            music.pause();
        } else {
            music.play();
        }
    }
}