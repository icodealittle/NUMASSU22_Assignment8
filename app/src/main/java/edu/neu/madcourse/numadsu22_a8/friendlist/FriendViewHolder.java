package edu.neu.madcourse.numadsu22_a8.friendlist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import edu.neu.madcourse.numadsu22_a8.R;
import edu.neu.madcourse.numadsu22_a8.User;

public class FriendViewHolder extends RecyclerView.ViewHolder {

    private RelativeLayout oneRow;
    public TextView nameTV;

    public FriendViewHolder(@NonNull View itemView) {
        super(itemView);
        this.nameTV = itemView.findViewById(R.id.usernameTV);
        this.oneRow = (RelativeLayout) itemView.findViewById(R.id.friendItemRow);
    }

    public void bindThisData(User user) {
        // sets the name of the person to the name textview of the viewholder.
        nameTV.setText(user.username);
    }


}