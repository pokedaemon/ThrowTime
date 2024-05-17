package kursksu.game.throwtime;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import kursksu.game.throwtime.screens.MenuScreen;
import kursksu.game.throwtime.screens.GameScreen;
import kursksu.game.throwtime.screens.SettingsScreen;

/**
 * Main class of a game.
 * Uses for changing screens and containing some param.
 */
public class ThrowTime extends Game {

	private Settings gameSettings;

	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	private SettingsScreen settingsScreen;

	public static final int MENU     = 0;
	public static final int GAME     = 1;
	public static final int SETTINGS = 2;

	/**
	 * First call in a game
	 */
	@Override
	public void create() {
		gameSettings = new Settings();
		changeScreen(MENU);
	}

	/**
	 * DEBUG: MenuScreen - BLACK
	 * 		  GameScreen - WHITE
	 * 		  SettingsScreen - BROWN
	 */
	public void changeScreen(int screen) {
		switch(screen) {
			case MENU:
				if(menuScreen == null)
					menuScreen = new MenuScreen(this);
				this.setScreen(menuScreen);
				break;
			case GAME:
				if(gameScreen == null)
					gameScreen = new GameScreen(this);
				this.setScreen(gameScreen);
				break;
			case SETTINGS:
				if(settingsScreen == null)
					settingsScreen = new SettingsScreen(this);
				this.setScreen(settingsScreen);
				break;
		}
	}

	public Settings getSettings() {
		return this.gameSettings;
	}
}