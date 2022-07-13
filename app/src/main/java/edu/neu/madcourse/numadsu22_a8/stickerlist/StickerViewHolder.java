package edu.neu.madcourse.numadsu22_a8.stickerlist;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;

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