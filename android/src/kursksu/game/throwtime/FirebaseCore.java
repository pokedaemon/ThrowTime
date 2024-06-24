package kursksu.game.throwtime;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kursksu.game.throwtime.db.FirebaseInterface;

public class FirebaseCore implements FirebaseInterface {
    protected FirebaseDatabase db;
    protected DatabaseReference dbRef;
}