package edu.neu.madcourse.numadsu22_a8.stickerlist;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.neu.madcourse.numadsu22_a8.R;

public class StickerAdaptor extends RecyclerView.Adapter<StickerViewHolder> {
    private final Context context;
    public int row_index = -1;
    public int message = -1;
    public List<Integer> stickerList = new ArrayList<>();


    public StickerAdaptor(List<Integer> stickerList, Context context) {
        this.stickerList = stickerList;
        this.context = context;
//        images = new int[]{R.drawable.pokemon, R.drawable.drink1, R.drawable.drink2,
//                R.drawable.drink3, R.drawable.drink4, R.drawable.drink5, R.drawable.drink6};
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
            message = stickerList.get(row_index);
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#00000000"));
        }

    }

    @Override
    public int getItemCount() {
        return stickerList.size();
    }
}
