package edu.neu.madcourse.numadsu22_a8.stickerlist;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.madcourse.numadsu22_a8.R;

public class StickerViewHolder extends RecyclerView.ViewHolder {

    public ImageView stickerIV;

    public StickerViewHolder(@NonNull View itemView) {
        super(itemView);
        this.stickerIV = itemView.findViewById(R.id.stickerIV);
    }

    public void bindThisData(int imagePath) {
        stickerIV.setImageResource(imagePath);
    }
}