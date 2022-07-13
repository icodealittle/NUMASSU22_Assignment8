package edu.neu.madcourse.numadsu22_a8;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotificationActivity extends AppCompatActivity {
    private String username;
    private String token;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference userReference;
    private DatabaseReference userHistoryReference;
    private DatabaseReference allUsersReference;

    //private static final String SERVER_KEY = "key=AAAAuqkZ0v4:APA91bEuftlK6bcSKv7W5OpyKjGuWAYZsBJCXW-0Kzikv9_2e0avTtiDeOneAlpfFBVQLMOJpajMmGls7yoTY4YHNriQ8ez0DElAEiG7kn78CSqHM4Ytmiczd1-gLHK2JKj5Uz5QzLc-";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get current username and token TODO

        createDatabaseResources();
        createNotificationChannel();
    }

    private void createDatabaseResources() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        userReference = firebaseDatabase.getReference("Users/"+username);
        userHistoryReference= firebaseDatabase.getReference("Users/"+username+"/received_history");
        allUsersReference = firebaseDatabase.getReference("Users");
    }

    private void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel
                ("A8_Channel", username, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Notifications for "+ username);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

}
