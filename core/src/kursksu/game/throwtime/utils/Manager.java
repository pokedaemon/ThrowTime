package kursksu.game.throwtime.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import static kursksu.game.throwtime.utils.Constants.ball;
import static kursksu.game.throwtime.utils.Constants.musicPath;
import static kursksu.game.throwtime.utils.Constants.soundPath;
import static kursksu.game.throwtime.utils.Constants.picturesPath;
import static kursksu.game.throwtime.utils.Constants.png;
import static kursksu.game.throwtime.utils.Constants.mp3;
import static kursksu.game.throwtime.utils.Constants.background;
import static kursksu.game.throwtime.utils.Constants.bando;
import static kursksu.game.throwtime.utils.Constants.chalkin;
import static kursksu.game.throwtime.utils.Constants.chubik;
import static kursksu.game.throwtime.utils.Constants.ground;
import static kursksu.game.throwtime.utils.Constants.clock;

public class Manager {

    private static final AssetManager manager = new AssetManager();

    public static void init() throws InterruptedException {

        // pictures
        manager.load(picturesPath + background + png, Texture.class);
        manager.load(picturesPath + bando + png, Texture.class);
        manager.load(picturesPath + chalkin + png, Texture.class);
        manager.load(picturesPath + chubik + png, Texture.class);
        manager.load(picturesPath + ground + png, Texture.class);
        manager.load(picturesPath + ball + png, Texture.class);
        manager.load(picturesPath + clock + png, Texture.class);

        // sound
        manager.load(soundPath + Constants.sound + mp3, Sound.class);
        manager.load(soundPath + Constants.playSound + mp3, Sound.class);
        manager.load(soundPath + "ball_bounce" + mp3, Sound.class);
        manager.load(soundPath + "ball_net" + mp3, Sound.class);
        manager.load(soundPath + "ball_hit_bounce" + mp3, Sound.class);
        manager.load(soundPath + "pistol_fire" + mp3, Sound.class);

        // music
        manager.load(musicPath + Constants.music + Constants.mp3, Music.class);
        manager.load(musicPath + Constants.playMusic + Constants.mp3, Music.class);

        // skin
        manager.load("skin1/skin.json", Skin.class);
        if(manager.contains(picturesPath + background + png, Texture.class))
            manager.finishLoading();
        else {
            Gdx.app.log("Manager", "Background is not loaded!");
            Gdx.app.exit();
        }
    }

    public static Music getMusic(String path) {
        return manager.get(musicPath + path + mp3);
    }

    public static Sound getSound(String path) {
        return manager.get(soundPath + path + mp3);
    }

    public static Texture getTexture(String path) {
        return manager.get(picturesPath + path + png);
    }

    public static Skin getSkin() {
        return manager.get("skin1/skin.json");
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

    public static BitmapFont getFont(int size, Color color) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("yoster2.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

        parameter.size = size;
        parameter.color = color;

        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();

        return font;
    }
}
