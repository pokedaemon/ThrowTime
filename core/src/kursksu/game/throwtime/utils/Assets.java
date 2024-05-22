package kursksu.game.throwtime.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static Texture ball;
    public static Texture chalkin;
    public static Texture bandit;
    public static Texture basket;
    private final AssetManager manager;

    public Assets() {
        manager = new AssetManager();
        manager.load("ball.png", Texture.class);
        manager.load("chalkin.png", Texture.class);
        manager.load("bandit.png", Texture.class);
        manager.load("basket.png", Texture.class);

        manager.update();
    }

    public void dispose() {
        manager.dispose();
    }
}
