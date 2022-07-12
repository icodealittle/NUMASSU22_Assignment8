package edu.neu.madcourse.numadsu22_a8.stickerlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;
import edu.neu.madcourse.numadsu22_a8.friendlist.FriendViewHolder;

public class StickerAdaptor extends RecyclerView.Adapter<StickerViewHolder> {
    private final List<String> stickerList;
    private final Context context;
    public int row_index = -1;


    public StickerAdaptor(List<String> stickerList, Context context) {
        this.stickerList = stickerList;
        this.context = context;
    }

    @NonNull
    @Override
    public StickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StickerViewHolder(LayoutInflater.from(context).inflate(R.layout.sticker_item, null));
        // item_link layout!
    }

    @Override
    public void onBindViewHolder(@NonNull StickerViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindThisData(stickerList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index=position;
                notifyDataSetChanged();
            }
        });

        if(row_index==position){
            holder.itemView.setBackgroundColor(Color.parseColor("#567845"));
            holder.nameTV.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.nameTV.setTextColor(Color.parseColor("#000000"));
        }

    }

    @Override
    public int getItemCount() {
        return stickerList.size();
    }
}
