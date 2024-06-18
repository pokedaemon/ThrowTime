package kursksu.game.throwtime.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class LabelPanel extends AnimatedTable {

    @Override
    protected Table prepareTable() {
        Table label = new Table();

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

        Label title = new Label("Throw Time", styleLabel);

        label.top().pad(300);
        label.add(title);

        this.setOrientation(AnimatedTable.OrientationFrom.Top);
        this.setMaxTime(3.1f);

        generator.dispose();

        return label;
    }
}