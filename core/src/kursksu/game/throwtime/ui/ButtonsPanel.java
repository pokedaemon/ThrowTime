package kursksu.game.throwtime.ui;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public final class ButtonsPanel extends AnimatedTable {

    private boolean playPressed, settingsPressed, exitPressed, leaderboardsPressed;

    public ButtonsPanel(ThrowTime parent) {
        super(parent);
    }

    @Override
    protected Table prepareTable() {
        Skin skin = Manager.getSkin();
        Table main = new Table();

        playPressed = settingsPressed = exitPressed = leaderboardsPressed = false;

        TextButton playButton = new TextButton("PLAY", skin, "play");
        TextButton settingsButton = new TextButton("SETTINGS", skin, "play");
        TextButton exitButton = new TextButton("EXIT", skin, "play");
        TextButton leaderboards = new TextButton("LEADERBOARDS", skin, "play");

        main.center();
        main.add(playButton).width(650).height(150).pad(20);
        main.row();
        main.add(settingsButton).width(650).height(150).pad(20);
        main.row();
        main.add(leaderboards).width(650).height(150).pad(20);
        main.row();
        main.add(exitButton).width(650).height(150).pad(20);
        main.row();

        Sound buttonSound = Manager.getSound(Constants.sound);
        Sound playSound = Manager.getSound(Constants.playSound);
        final AnimatedTable buttonsPanel = this;

        playButton.addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        Manager.getMusic(Constants.music).stop();
                        playSound.play();
                        buttonsPanel.setOrientation(OrientationFrom.Top);
                        playPressed = true;
                        buttonsPanel.hide();
                    }
                }
        );

        settingsButton.addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        buttonSound.play();
                        buttonsPanel.setOrientation(OrientationFrom.Right);
                        settingsPressed = true;
                        buttonsPanel.hide();
                    }
                }
        );

        leaderboards.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
                buttonsPanel.setOrientation(OrientationFrom.Left);
                leaderboardsPressed = true;
                buttonsPanel.hide();
            }
        });

        exitButton.addListener(
                new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                        buttonSound.play();
                        buttonsPanel.setOrientation(OrientationFrom.Bottom);
                        exitPressed = true;
                        buttonsPanel.hide();
                    }
                }
        );

        return main;
    }

    public boolean isExitPressed() {
        return exitPressed;
    }

    public boolean isPlayPressed() {
        return playPressed;
    }

    public boolean isSettingsPressed() {
        return settingsPressed;
    }

    public boolean isLeaderboardsPressed() { return leaderboardsPressed; }

    public void setPlayPressed(boolean playPressed) {
        this.playPressed = playPressed;
    }

    public void setSettingsPressed(boolean settingsPressed) {
        this.settingsPressed = settingsPressed;
    }

    public void setExitPressed(boolean exitPressed) {
        this.exitPressed = exitPressed;
    }

    public void setLeaderboardsPressed(boolean leaderboardsPressed) {
        this.leaderboardsPressed = leaderboardsPressed;
    }
}