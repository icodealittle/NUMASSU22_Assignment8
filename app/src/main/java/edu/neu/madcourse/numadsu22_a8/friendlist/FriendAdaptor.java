package edu.neu.madcourse.numadsu22_a8.friendlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;

public class FriendAdaptor  extends RecyclerView.Adapter<FriendViewHolder> {
    private final List<User> friendList;
    private final Context context;


    public FriendAdaptor(List<User> friendList, Context context) {
        this.friendList = friendList;
        this.context = context;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendViewHolder(LayoutInflater.from(context).inflate(R.layout.friend_item, null));
        // item_link layout!
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        holder.bindThisData(friendList.get(position));
//        holder.username.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open a new rv
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
