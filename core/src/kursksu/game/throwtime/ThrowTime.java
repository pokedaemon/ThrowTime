package kursksu.game.throwtime;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import kursksu.game.throwtime.db.FirebaseInterface;
import kursksu.game.throwtime.screens.DebugScreen;
import kursksu.game.throwtime.screens.GameOverScreen;
import kursksu.game.throwtime.screens.LeaderboardsScreen;
import kursksu.game.throwtime.screens.LoadingScreen;
import kursksu.game.throwtime.screens.MenuScreen;
import kursksu.game.throwtime.screens.GameScreen;
import kursksu.game.throwtime.screens.SettingsScreen;
import kursksu.game.throwtime.utils.Manager;
import kursksu.game.throwtime.utils.Settings;

/**
 * Main class of a game.
 * Uses for changing screens and containing some param.
 */
public class ThrowTime extends Game {
	private FirebaseInterface firebase;

	private SpriteBatch batch;
	private Settings gameSettings;

	// screens
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	private SettingsScreen settingsScreen;
	private DebugScreen debugScreen;
	private LoadingScreen loadingScreen;
	private LeaderboardsScreen leaderboards;
	private GameOverScreen gameOverScreen;

	// const for screens
	public static final int MENU     = 0;
	public static final int GAME     = 1;
	public static final int SETTINGS = 2;
	public static final int LOADING  = 4;
	public static final int LEADERBOARDS = 5;
	public static final int OVER = 6;

	public static final int DEBUG    = 3;

	private boolean start;

	public ThrowTime(FirebaseInterface firebase) {
		this.firebase = firebase;
	}

	/**
	 * First call in a game(not actually how we know)
	 */
	@Override
	public void create() {
		start = true;
		batch = new SpriteBatch();
		gameSettings = new Settings();
        changeScreen(LOADING);
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
					menuScreen = new MenuScreen(this, batch);
				this.setScreen(menuScreen);
				break;
			case GAME:
				if(gameScreen == null)
					gameScreen = new GameScreen(this, batch);
				this.setScreen(gameScreen);
				break;
			case SETTINGS:
				if(settingsScreen == null)
					settingsScreen = new SettingsScreen(this, batch);
				this.setScreen(settingsScreen);
				break;
			case DEBUG:
				if(debugScreen == null)
					debugScreen = new DebugScreen(this, batch);
				this.setScreen(debugScreen);
				break;
			case LOADING:
				if(loadingScreen == null)
					loadingScreen = new LoadingScreen(this, batch);
				this.setScreen(loadingScreen);
				break;
			case LEADERBOARDS:
				if(leaderboards == null)
					leaderboards = new LeaderboardsScreen(this, batch);
				this.setScreen(leaderboards);
				break;
			case OVER:
				if(gameOverScreen == null)
					gameOverScreen = new GameOverScreen(this, batch);
				this.setScreen(gameOverScreen);
				break;
		}
	}

	// getters
	public Settings getSettings() {
		return this.gameSettings;
	}

	public boolean getStart() {
		return this.start;
	}

	public FirebaseInterface getFirebase() {
		return this.firebase;
	}

	// setters
	public void setStart(boolean value) {
		this.start = value;
	}

	@Override
	public void dispose() {
		super.dispose();
		Manager.dispose();
	}
}