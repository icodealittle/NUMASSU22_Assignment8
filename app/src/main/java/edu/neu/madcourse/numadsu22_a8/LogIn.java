package edu.neu.madcourse.numadsu22_a8;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;

public class LogIn extends AppCompatActivity {

    private static String SERVER_KEY;
    private static String CLIENT_REGISTRATION_TOKEN;
    private DatabaseReference fireBase;

    private EditText userNameInput;
    private Button login;
    private String userName;
    private static String TAG = "ShowPermActivity";
    private static final int DEV_ID = 1;
    private static final int PHOTO_PERMISSION = 15;

    private ImageView imageView;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

//        String statePermission = android.Manifest.permission.READ_PHONE_STATE;
//        CheckPermission(statePermission);

        SERVER_KEY = "key=AAAAuqkZ0v4:APA91bEuftlK6bcSKv7W5OpyKjGuWAYZsBJCXW-0Kzikv9_2e0avTtiDeOneAlpfFBVQLMOJpajMmGls7yoTY4YHNriQ8ez0DElAEiG7kn78CSqHM4Ytmiczd1-gLHK2JKj5Uz5QzLc-"; //Add key

        // Save token
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(LogIn.this, "Something is wrong!", Toast.LENGTH_SHORT).show();
                } else {
                    if (CLIENT_REGISTRATION_TOKEN == null) {
                        CLIENT_REGISTRATION_TOKEN = task.getResult();
                    }
                    Log.e("CLIENT_REGISTRATION_TOKEN", CLIENT_REGISTRATION_TOKEN);
                    //Toast.makeText(LogIn.this, "CLIENT_REGISTRATION_TOKEN Existed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fireBase = FirebaseDatabase.getInstance().getReference();

        fireBase.child("users").addChildEventListener(
                new ChildEventListener() {

                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                }
        );

        login = findViewById(R.id.login_btn);
        userNameInput = findViewById(R.id.username);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("test", "onclick");
                userName = userNameInput.getText().toString();

                fireBase.child("users").child(userName).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists())
                        {
                            User user = snapshot.getValue(User.class);
                            if(user.token != CLIENT_REGISTRATION_TOKEN)
                            {
                                snapshot.child("token").getRef().setValue(CLIENT_REGISTRATION_TOKEN);
                                user.token = CLIENT_REGISTRATION_TOKEN;
                            }

                            Intent i = new Intent(LogIn.this, HomePageActivity.class);
                            i.putExtra("user", user);
                            startActivity(i);
                        }
                        else
                        {
                            User user = new User(userName, CLIENT_REGISTRATION_TOKEN);
                            Task t1 = fireBase.child("users").child(user.username).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.e("test", "finish");
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), ("Unable to reset " + userName + " !"), Toast.LENGTH_SHORT).show();
                                    } else {
                                        Log.e("adduser", "succeed");
                                        Intent i = new Intent(LogIn.this, HomePageActivity.class);
                                        i.putExtra("user", user);
                                        startActivity(i);
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

        });
    }

//    private void CheckPermission(String statePermission) {
//        Log.v(TAG, "About to check permissions");
//        int permissionCheck = ContextCompat.checkSelfPermission(this, statePermission);
//
//        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//            Log.i(TAG, "Already have permission-- groovy!");
//            Toast.makeText(getApplicationContext(), "Already have READ_PHONE_STATE permission!", Toast.LENGTH_SHORT).show();
//        } else {
//            Log.e(TAG, "Don't have permissions yet, gotta ask the user");
//
//            // This updates the TextView with our info
//            Toast.makeText(getApplicationContext(), "Please allow the permission for notification!", Toast.LENGTH_SHORT).show();
//
//            // This launches the permissions dialog
//            ActivityCompat.requestPermissions(this,
//                    new String[]{statePermission}, DEV_ID);
//        }
//    }
}
