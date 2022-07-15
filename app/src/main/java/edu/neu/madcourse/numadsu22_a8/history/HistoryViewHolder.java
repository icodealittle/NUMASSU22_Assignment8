package edu.neu.madcourse.numadsu22_a8.history;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.madcourse.numadsu22_a8.R;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTV;
    public TextView dateTV;
    public ImageView stickerTV;

    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameTV = itemView.findViewById(R.id.senderNameTV);
        this.dateTV = itemView.findViewById(R.id.dateTV);
        this.stickerTV = itemView.findViewById(R.id.received);

    }

    public void bindThisData(ChatHistory record) {
        // sets the name of the person to the name textview of the viewholder.
        nameTV.setText("Sender: "+record.sender);
        dateTV.setText(record.date);
        stickerTV.setImageResource(record.message);
    }
}
