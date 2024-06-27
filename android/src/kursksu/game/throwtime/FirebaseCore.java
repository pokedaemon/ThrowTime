package kursksu.game.throwtime;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kursksu.game.throwtime.db.FirebaseInterface;
import kursksu.game.throwtime.utils.Constants;

public class FirebaseCore implements FirebaseInterface {
    protected FirebaseDatabase db;
    protected DatabaseReference dbRef;

    public FirebaseCore() {
        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("message");
    }

    @Override
    public void test() {
        if(dbRef != null)
            dbRef.setValue("Fuck, you!");
        else
            Log.d("Firebase", "Error message!");
    }

    @Override
    public void setRecordToDatabase() {

    }

    @Override
    public void listenRecordsFromDatabase() {

    }

    @Override
    public void setNameToDatabase() {

    }
}