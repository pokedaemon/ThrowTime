package kursksu.game.throwtime.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Manager;

public final class GameUIPanel extends AnimatedTable {

    private Integer result;

    public GameUIPanel(ThrowTime parent) {
        super(parent);
    }

    @Override
    protected Table prepareTable() {
        Table table = new Table();

        result = 0;

        Label count = new Label(result.toString(), Manager.getSkin());

        return table;
    }

}