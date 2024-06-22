package kursksu.game.throwtime.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public final class LeaderboardsPanel extends AnimatedTable {

    public LeaderboardsPanel(ThrowTime parent) {
        super(parent);
    }

    @Override
    protected Table prepareTable() {
        Table table = new Table();
        Skin skin = Manager.getSkin();

        BitmapFont font;

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

        Label label = new Label("Coming soon!", styleLabel);
        TextButton back = new TextButton("BACK", skin);

        table.add(label);
        table.row();
        table.add(back).width(650).height(100).padTop(300);

        generator.dispose();

        Sound buttonSound = Manager.getSound(Constants.sound);

        back.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                buttonSound.play();
                parent.changeScreen(ThrowTime.MENU);
            }
        });

        return table;
    }
}