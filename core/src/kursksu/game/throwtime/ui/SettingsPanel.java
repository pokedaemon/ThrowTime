package kursksu.game.throwtime.ui;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public final class SettingsPanel extends AnimatedTable {

    boolean isBackPressed;

    public SettingsPanel(ThrowTime parent) {
        super(parent);
    }

    @Override
    protected Table prepareTable() {

        isBackPressed = false;
        final AnimatedTable settingsPanel = this;

        Table table = new Table();
        Skin skin = Manager.getSkin();

        BitmapFont font = Manager.getFont(50, Color.ORANGE);

        Label.LabelStyle labelstyle = new Label.LabelStyle();
        labelstyle.font = font;

        TextButton back = new TextButton("BACK", skin);

        Label musicLabel = new Label("Music", labelstyle);
        Label soundLabel = new Label("Sound", labelstyle);
        Label vibrateOnLabel = new Label("Vibrate", labelstyle);

        final Slider musicVolume = new Slider(0f, 1f, 0.05f, false, skin);
        final Slider soundVolume = new Slider(0f, 1f, 0.05f, false, skin);

        CheckBox vibrateOn = new CheckBox(null, skin);

        table.add(musicLabel);
        table.add(musicVolume).width(650f/1.5f).height(200).fill();
        table.row().pad(20);
        table.add(soundLabel);
        table.add(soundVolume).width(650f/1.5f).height(200).fill();
        table.row().pad(20);
        table.add(vibrateOnLabel);
        table.add(vibrateOn);
        table.row();
        table.add(back).colspan(2).width(650).height(200).pad(100);

        table.center();

        Sound sound = Manager.getSound(Constants.sound);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                sound.play();
                isBackPressed = true;
                settingsPanel.hide();
            }
        });

        musicVolume.setValue(parent.getSettings().getMusicVolume());
        musicVolume.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getSettings().setMusicVolume(musicVolume.getValue());
                return false;
            }
        });

        soundVolume.setValue(parent.getSettings().getSoundVolume());
        musicVolume.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                parent.getSettings().setSoundVolume(soundVolume.getValue());
                return false;
            }
        });

        return table;
    }

    public boolean isBackPressed() {
        return isBackPressed;
    }

    public void setBackPressed(boolean value) {
        this.isBackPressed = value;
    }
}