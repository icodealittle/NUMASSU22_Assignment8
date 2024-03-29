package edu.neu.madcourse.numadsu22_a8.friendlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.neu.madcourse.numadsu22_a8.HomePageActivity;
import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;
import edu.neu.madcourse.numadsu22_a8.stickerlist.StickerAdaptor;

public class FriendAdaptor  extends RecyclerView.Adapter<FriendViewHolder> {
    private final List<User> friendList;
    private final Context context;
    private int row_index = -1;
    private HomePageActivity controller;
    public String senderName;


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
                row_index=position;
                notifyDataSetChanged();
                controller.stickerAdaptor.row_index = -1;
                controller.stickerAdaptor.notifyDataSetChanged();
                controller.stickerAdaptor.message = -1;
            }
        });
        if(row_index==position){
            holder.nameTV.setBackgroundColor(Color.parseColor("#44685044"));
            senderName = friendList.get(row_index).username;
        }
        else
        {
            holder.nameTV.setBackgroundColor(Color.parseColor("#44ffffff"));
        }

    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
