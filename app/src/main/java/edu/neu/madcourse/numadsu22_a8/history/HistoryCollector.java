package edu.neu.madcourse.numadsu22_a8.history;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;
import edu.neu.madcourse.numadsu22_a8.friendlist.FriendAdaptor;
import edu.neu.madcourse.numadsu22_a8.stickerlist.StickerAdaptor;

public class HistoryCollector extends AppCompatActivity {
    private DatabaseReference fireBase;
    private List<ChatHistory> historyList = new ArrayList<>();
    RecyclerView chatHistoryRecyclerView;
    private HistoryAdaptor historyAdaptor;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_history);
        currentUser = (User)getIntent().getSerializableExtra("user");
        fireBase = FirebaseDatabase.getInstance().getReference().child("users").child(currentUser.username).child("history");

        initHistoryList();

        chatHistoryRecyclerView = findViewById(R.id.recycleViewHistory);
        chatHistoryRecyclerView.setHasFixedSize(true);
        chatHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        historyAdaptor = new HistoryAdaptor(historyList, this);
        chatHistoryRecyclerView.setAdapter(historyAdaptor);
    }

    public void initHistoryList() {
        fireBase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                snapshot.getChildren().forEach(child->{
                    historyList.add(child.getValue(ChatHistory.class));
                });

                historyAdaptor = new HistoryAdaptor(historyList, chatHistoryRecyclerView.getContext());
                chatHistoryRecyclerView.setAdapter(historyAdaptor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
