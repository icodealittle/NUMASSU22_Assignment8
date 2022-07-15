package edu.neu.madcourse.numadsu22_a8.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.neu.madcourse.numadsu22_a8.R;

public class HistoryAdaptor extends RecyclerView.Adapter<HistoryViewHolder> {
    private final List<ChatHistory> chatHistoryList;
    private final Context context;


    public HistoryAdaptor(List<ChatHistory> chatHistoryList, Context context) {
        this.chatHistoryList = chatHistoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.chat_item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.bindThisData(chatHistoryList.get(position));
    }


    @Override
    public int getItemCount() {
        return chatHistoryList.size();
    }
}
