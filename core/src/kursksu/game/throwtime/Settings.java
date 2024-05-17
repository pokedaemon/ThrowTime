package kursksu.game.throwtime;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Settings {

    Preferences settings;

    public Settings() {
        settings = Gdx.app.getPreferences("My Preferences");
    }

    public void result() {
        System.out.println("Settings:\n" + settings);
    }
}