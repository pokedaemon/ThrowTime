package kursksu.game.throwtime.ui;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public final class GameOverPanel extends AnimatedTable {

    private boolean isRetryPressed;

    public GameOverPanel(ThrowTime parent) {
        super(parent);
    }

    @Override
    protected Table prepareTable() {
        Table table = new Table();

        isRetryPressed = false;

        Skin skin = Manager.getSkin();
        Label.LabelStyle style = new Label.LabelStyle();
        style.font = Manager.getFont(100, Color.ORANGE);

        Label gameOver = new Label("Game Over!", style);
        TextButton retry = new TextButton("RETRY", skin);
        TextButton menu = new TextButton("MENU", skin);

        table.add(gameOver);
        table.row();
        table.add(retry).width(650).height(200).padTop(100);
        table.row();
        table.add(menu).width(650).height(200).padTop(20);

        Sound buttonSound = Manager.getSound(Constants.sound);
        Sound playSound = Manager.getSound(Constants.playSound);

        retry.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Manager.getMusic(Constants.playMusic).pause();
                playSound.play();
                parent.changeScreen(ThrowTime.GAME);
            }
        });

        menu.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Manager.getMusic(Constants.playMusic).stop();
                buttonSound.play();
                parent.changeScreen(ThrowTime.MENU);
            }
        });

        return table;
    }

    public void setRetryPressed(boolean retryPressed) {
        this.isRetryPressed = retryPressed;
    }

    public boolean getRetryPressed() {
        return isRetryPressed;
    }
}