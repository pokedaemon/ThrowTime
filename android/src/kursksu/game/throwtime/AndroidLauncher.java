package kursksu.game.throwtime;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import kursksu.game.throwtime.ThrowTime;

public class AndroidLauncher extends AndroidApplication {

	private FirebaseDatabase firebaseDatabase;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		config.useAccelerometer = false;
		config.useCompass = false;

		firebaseDatabase = FirebaseDatabase.getInstance
				("https://throwtime-default-rtdb.europe-west1.firebasedatabase.app/");



		initialize(new ThrowTime(), config);
	}
}
