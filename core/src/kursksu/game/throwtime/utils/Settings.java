package kursksu.game.throwtime.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Settings {
    private static final String MUSIC_VOLUME = "volume";
    private static final String SOUND_VOLUME = "sound";
    private static final String VIBRATE = "vibrate";

    private static final String NAME = "throw-time";

    protected Preferences getPrefs() {
        return Gdx.app.getPreferences(NAME);
    }

    public float getMusicVolume() {
        return getPrefs().getFloat(MUSIC_VOLUME, 0.5f);
    }

    public void setMusicVolume(float volume) {
        getPrefs().putFloat(MUSIC_VOLUME, volume);
        Manager.getMusic(Constants.music).setVolume(volume);
        getPrefs().flush();
    }

    public float getSoundVolume() {
        return getPrefs().getFloat(SOUND_VOLUME, 0.5f);
    }

    public void setSoundVolume(float volume) {
        getPrefs().putFloat(SOUND_VOLUME, volume);
        getPrefs().flush();
    }
}
