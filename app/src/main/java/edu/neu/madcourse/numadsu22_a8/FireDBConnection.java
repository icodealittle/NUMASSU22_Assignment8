package edu.neu.madcourse.numadsu22_a8;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class FireDBConnection extends AppCompatActivity {
    private static String SERVER_KEY;
    private static String CLIENT_REGISTRATION_TOKEN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //connection started at log in

        SERVER_KEY = "key=AAAAuqkZ0v4:APA91bEuftlK6bcSKv7W5OpyKjGuWAYZsBJCXW-0Kzikv9_2e0avTtiDeOneAlpfFBVQLMOJpajMmGls7yoTY4YHNriQ8ez0DElAEiG7kn78CSqHM4Ytmiczd1-gLHK2JKj5Uz5QzLc-"; //Add key

    }
}
