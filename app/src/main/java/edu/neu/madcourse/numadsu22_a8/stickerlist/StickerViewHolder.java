package edu.neu.madcourse.numadsu22_a8.stickerlist;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;

public class StickerViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTV;

    public StickerViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameTV = itemView.findViewById(R.id.stickerNameTV);
    }

    public void bindThisData(String name) {
        // sets the name of the person to the name textview of the viewholder.
        nameTV.setText(name);
    }


}