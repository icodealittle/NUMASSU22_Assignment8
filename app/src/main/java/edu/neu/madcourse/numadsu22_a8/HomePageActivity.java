package edu.neu.madcourse.numadsu22_a8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.neu.madcourse.numadsu22_a8.friendlist.FriendAdaptor;
import edu.neu.madcourse.numadsu22_a8.stickerlist.StickerAdaptor;

public class HomePageActivity extends AppCompatActivity {
    RecyclerView friendListRecyclerView;
    RecyclerView stickerListRecyclerView;
    List<User> friendList;
    List<String> stickerList;
    public StickerAdaptor stickerAdaptor;
    public FriendAdaptor friendAdaptor;
    Button sendBtn;
    private static String CLIENT_REGISTRATION_TOKEN;
    private static String SERVER_KEY;
    private DatabaseReference fireBase;

    private User currentUser;
    private String sender;
    private String receiver;
    private String date;
    private String message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_activity);

        stickerList = getStickerList();

        stickerListRecyclerView = findViewById(R.id.recyclerViewSticker);
        stickerListRecyclerView.setHasFixedSize(true);
        stickerListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stickerAdaptor = new StickerAdaptor(stickerList, this);
        stickerListRecyclerView.setAdapter(stickerAdaptor);

        message = stickerAdaptor.message;

        friendList = getFriendList();

        friendListRecyclerView = findViewById(R.id.recyclerView);
        friendListRecyclerView.setHasFixedSize(true);
        friendListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        friendAdaptor = new FriendAdaptor(friendList, this);
        friendListRecyclerView.setAdapter(new FriendAdaptor(friendList, this));

        receiver = friendAdaptor.senderName;
        SERVER_KEY = "key=AAAAuqkZ0v4:APA91bEuftlK6bcSKv7W5OpyKjGuWAYZsBJCXW-0Kzikv9_2e0avTtiDeOneAlpfFBVQLMOJpajMmGls7yoTY4YHNriQ8ez0DElAEiG7kn78CSqHM4Ytmiczd1-gLHK2JKj5Uz5QzLc-"; //Add key

        currentUser = (User)getIntent().getSerializableExtra("user");
        sender = currentUser.username;
        // Save token
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(HomePageActivity.this, "Something is wrong!", Toast.LENGTH_SHORT).show();
                } else {
                    if (CLIENT_REGISTRATION_TOKEN == null) {
                        CLIENT_REGISTRATION_TOKEN = task.getResult();
                    }
                    Log.e("CLIENT_REGISTRATION_TOKEN", CLIENT_REGISTRATION_TOKEN);
                    Toast.makeText(HomePageActivity.this, "CLIENT_REGISTRATION_TOKEN Existed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fireBase = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser.username);

        fireBase.child("history").addChildEventListener(
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

        sendBtn = findViewById(R.id.sendSticker);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("test", "onclick");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                date = dtf.format(now);
                ChatHistory record = new ChatHistory(sender, receiver, date, message);
                Task t1 = fireBase.child("history").child("chat "+date).setValue(record).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.e("test", "finish");
                        if (!task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), ("Unable to send!"), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), ("Send your sticker to "+receiver+" !"), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

        });
    }

    public List<User> getFriendList() {
        User user1 = new User("test1", "token1");
        User user2 = new User("test2", "token2");
        User user3 = new User("test3", "token3");
        List<User> testList = new ArrayList<>();
        testList.add(user1);
        testList.add(user2);
        testList.add(user3);
        return testList;
    }

    public List<String> getStickerList() {
        List<String> testList = new ArrayList<>();
        testList.add("Test1");
        testList.add("TEst2");
        testList.add("Test3");
        return testList;
    }

}

