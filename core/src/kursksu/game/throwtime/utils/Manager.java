package kursksu.game.throwtime.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

import static kursksu.game.throwtime.utils.Constants.musicPath;
import static kursksu.game.throwtime.utils.Constants.soundPath;
import static kursksu.game.throwtime.utils.Constants.picturesPath;

public class Manager {

    private static final AssetManager manager = new AssetManager();

    public static void init() {
        // sound
        manager.load(soundPath + "button_sound.mp3", Sound.class);

        // music
        manager.load(musicPath + "cool.mp3", Music.class);

        // pictures
        manager.load(picturesPath + "pixil-frame.png", Texture.class);
        manager.load(picturesPath + "Background_mini.png", Texture.class);

        // skin
        manager.load("skin/skin.json", Skin.class);


        manager.finishLoading();
    }

    public static Music getMusic(String path) {
        return manager.get(musicPath + path);
    }

    public static Sound getSound(String path) {
        return manager.get(soundPath + path);
    }

    public static Texture getTexture(String path) {
        return manager.get(picturesPath + path);
    }

    public static Skin getSkin() {
        return manager.get("skin/skin.json");
    }

    public static boolean update() {
        return manager.update();
    }

    public static float getProgress() {
        return manager.getProgress();
    }

    public static void dispose() {
        manager.dispose();
    }
}
