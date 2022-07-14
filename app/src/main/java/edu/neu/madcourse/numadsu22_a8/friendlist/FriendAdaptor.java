package edu.neu.madcourse.numadsu22_a8.friendlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.neu.madcourse.numadsu22_a8.HomePageActivity;
import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;

public class FriendAdaptor extends RecyclerView.Adapter<FriendViewHolder> {
    private final List<User> friendList;
    private final Context context;
    public String senderName;
    private int row_index = -1;
    private HomePageActivity controller;


    public FriendAdaptor(List<User> friendList, Context context) {
        this.friendList = friendList;
        this.context = context;
        this.controller = (HomePageActivity) context;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendViewHolder(LayoutInflater.from(context).inflate(R.layout.friend_item, null));
        // item_link layout!
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindThisData(friendList.get(position));
//        holder.username.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Open a new rv
//            }
//        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                notifyDataSetChanged();
                controller.stickerAdaptor.row_index = -1;
                controller.stickerAdaptor.notifyDataSetChanged();
            }
        });
        if (row_index == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#567845"));
            holder.nameTV.setTextColor(Color.parseColor("#ffffff"));
            senderName = friendList.get(row_index).username;
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.nameTV.setTextColor(Color.parseColor("#000000"));
        }

    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
