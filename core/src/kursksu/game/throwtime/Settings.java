package kursksu.game.throwtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Settings {

    /**
     * DEBUG MODE: True - true
     *             False - false
     */
    private static boolean MODE = false;
    Preferences settings;

    public Settings() {
        settings = Gdx.app.getPreferences("ThrowTimeSettings");
    }

    public void all() {
        if(MODE)
            System.out.println(settings.get());
    }
}
