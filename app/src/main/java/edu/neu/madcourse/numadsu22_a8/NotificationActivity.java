
package edu.neu.madcourse.numadsu22_a8;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.messaging.FirebaseMessaging;



//source: https://firebase.google.com/docs/cloud-messaging/android/topic-messaging#java_1
public class NotificationActivity extends AppCompatActivity {
    private User currentUser;
    private String username;
    private String token;
    private static final String TAG = "NotificationActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        currentUser = (User)getIntent().getSerializableExtra("user");
        username = currentUser.username;

        createNotificationChannel();
    }

    public void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel
                ("Notification_Channel", username, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Notifications for "+ username);
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
        subscribeToTopic();
    }

    private void subscribeToTopic() {
        FirebaseMessaging.getInstance().subscribeToTopic(username).addOnCompleteListener((task -> {
            String subscribeMsg = "Subscribed";
            if(!task.isSuccessful()) {
                Log.d(TAG, "Subscription Failed");
            } else {
                Log.d(TAG, subscribeMsg);
                Toast.makeText(NotificationActivity.this, subscribeMsg, Toast.LENGTH_SHORT).show();
            }
        }));

    }


}