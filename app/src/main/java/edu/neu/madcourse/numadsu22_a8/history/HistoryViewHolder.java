package edu.neu.madcourse.numadsu22_a8.history;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;

public class HistoryViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTV;
    public TextView dateTV;
    public TextView message;

    public HistoryViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameTV = itemView.findViewById(R.id.usernameTV);

    }

    public void bindThisData(User user) {
        // sets the name of the person to the name textview of the viewholder.
        nameTV.setText(user.username);
    }


}
