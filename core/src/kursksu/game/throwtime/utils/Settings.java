package kursksu.game.throwtime.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Settings {

    /**
     * DEBUG MODE: True - true
     *             False - false
     */
    public static final boolean MODE = false;
    Preferences settings;

    public Settings() {
        settings = Gdx.app.getPreferences("ThrowTimeSettings");
    }

    public void all() {
        if(MODE)
            System.out.println(settings.get());
    }
}
