package kursksu.game.throwtime.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import kursksu.game.throwtime.utils.Manager;

public class SettingsPanel extends AnimatedTable {

    @Override
    protected Table prepareTable() {
        Table table = new Table();
        Skin skin = Manager.getSkin();

//        final Slider musicVolume = new Slider();
//
//        final Slider soundVolume = new Slider();

        return table;
    }
}