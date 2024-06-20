package kursksu.game.throwtime.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import kursksu.game.throwtime.ThrowTime;
import kursksu.game.throwtime.utils.Constants;
import kursksu.game.throwtime.utils.Manager;

public final class LoadingPanel extends AnimatedTable {

    private ProgressBar loadProgress;

    public LoadingPanel(ThrowTime parent) {
        super(parent);
    }

    @Override
    protected Table prepareTable() {
        Table table = new Table();
        Skin skin = new Skin(Gdx.files.internal("skin/skin.json"));

        loadProgress = new ProgressBar(0f, 1f, 0.01f, false, skin);
        table.add(loadProgress).width(Constants.LOAD_WIDTH - Constants.LOAD_WIDTH / 3);

        return table;
    }

    public void setProgress(float value) {
        loadProgress.setValue(value);
    }
}