package kursksu.game.throwtime;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.firebase.database.FirebaseDatabase;

public class AndroidLauncher extends AndroidApplication {

	private FirebaseDatabase firebaseDatabase;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		FirebaseCore firebaseCore = new FirebaseCore();

		config.useAccelerometer = false;
		config.useCompass = false;

		initialize(new ThrowTime(firebaseCore), config);
	}
}
