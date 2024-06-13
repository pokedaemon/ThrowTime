package kursksu.game.throwtime.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import kursksu.game.throwtime.utils.Manager;

public class ButtonsPanel extends AnimatedTable {

    @Override
    protected Table prepareTable() {
        Skin skin = Manager.getSkin();
        Table main = new Table();

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

        Sound buttonSound = Manager.getSound("button_sound.mp3");
        final AnimatedTable buttonsPanel = this;

        playButton.addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        buttonSound.play();
                        buttonsPanel.hide();
                    }
                }
        );

        settingsButton.addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        buttonSound.play();
                    }
                }
        );

        exitButton.addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        buttonSound.play();
                        Gdx.app.exit();
                    }
                }
        );

        return main;
    }

    public void setFillParent(boolean value) {
        table.setFillParent(value);
    }
}