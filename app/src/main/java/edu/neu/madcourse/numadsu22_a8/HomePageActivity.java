package edu.neu.madcourse.numadsu22_a8;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        friendList = getFriendList();

        friendListRecyclerView = findViewById(R.id.recyclerView);
        friendListRecyclerView.setHasFixedSize(true);
        friendListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        friendListRecyclerView.setAdapter(new FriendAdaptor(friendList, this));
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

