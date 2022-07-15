package edu.neu.madcourse.numadsu22_a8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserStatusActivity extends AppCompatActivity {

    private DatabaseReference fireBase;
    private User currentUser;

    TextView userNameTV;
    TextView stickerSentTV;
    TextView titleTV;

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_stats);
        currentUser = (User)getIntent().getSerializableExtra("user");

        userNameTV = findViewById(R.id.my_username);
        stickerSentTV = findViewById(R.id.num_sticker_sent);
        titleTV = findViewById(R.id.user_stat);

        userNameTV.setText(currentUser.username);
        stickerSentTV.setText(String.valueOf(currentUser.stickerNum));
        titleTV.setText("Hi " + currentUser.username);

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserStatusActivity.this, HomePageActivity.class);
                i.putExtra("user", currentUser);
                startActivity(i);
            }
        });
    }
}
