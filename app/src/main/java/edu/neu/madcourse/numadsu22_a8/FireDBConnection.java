package edu.neu.madcourse.numadsu22_a8;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        super.onCreate(savedInstanceState);//connection started at log in page

        SERVER_KEY = "key=AAAAuqkZ0v4:APA91bEuftlK6bcSKv7W5OpyKjGuWAYZsBJCXW-0Kzikv9_2e0avTtiDeOneAlpfFBVQLMOJpajMmGls7yoTY4YHNriQ8ez0DElAEiG7kn78CSqHM4Ytmiczd1-gLHK2JKj5Uz5QzLc-"; //Add key

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(FireDBConnection.this, "Something is wrong!", Toast.LENGTH_SHORT).show();
                } else {
                    if (CLIENT_REGISTRATION_TOKEN == null) {
                        CLIENT_REGISTRATION_TOKEN = task.getResult();
                    }
                    Log.e("CLIENT_REGISTRATION_TOKEN", CLIENT_REGISTRATION_TOKEN);
                    Toast.makeText(FireDBConnection.this, "CLIENT_REGISTRATION_TOKEN Existed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
