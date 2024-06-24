package kursksu.game.throwtime.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public final class GameUIPanel extends AnimatedTable {

    private Integer balls;
    private Integer time;

    private Label ballsLabel;
    private Label timeLabel;

    public GameUIPanel(ThrowTime parent) {
        super(parent);
    }

    @Override
    protected Table prepareTable() {
        Table table = new Table();

        table.setFillParent(true);
        table.setDebug(true);

        balls = 0;
        time = 5;

        Label.LabelStyle style = new Label.LabelStyle();

        style.font = Manager.getFont(14, Color.ORANGE);

        ballsLabel = new Label(balls.toString(), style);
        timeLabel = new Label(time.toString(), style);

        Image ballsImage = new Image(Manager.getTexture(Constants.ball));
        Image timeImage = new Image(Manager.getTexture(Constants.clock));

        table.add(ballsImage).width(17).height(17).padRight(5);
        table.add(ballsLabel).width(30).height(17);
        table.row();
        table.add(timeImage).width(17).height(17).padRight(5).padTop(2);
        table.add(timeLabel).width(30);

        return table;
    }

    public void takeBalls() {
        ballsLabel.setText((balls++).toString());
    }

    public void takeTime() {
        timeLabel.setText((time--).toString());
    }

    public Integer getTime() { return time; }
    public Integer getBalls() { return balls; }
}