package com.example.viewmodelvolley.view.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodelvolley.R;
import com.example.viewmodelvolley.model.User;

import java.util.ArrayList;

public class UserAdapter
        extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> data;
    OnItemClickListener listener;

    public UserAdapter(ArrayList<User> data) {
        this.data = data;
    }

    public void setClickListener(OnItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        ViewHolder vh = new ViewHolder(v,listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        User t = data.get(position);
        holder.tvId.setText(String.valueOf(t.getId()));
        holder.tvTask.setText(t.getEmail());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvId, tvTask;
        OnItemClickListener onItemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvTask = itemView.findViewById(R.id.tvTask);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getAdapterPosition(), data.get(getAdapterPosition()).getEmail());
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position, String task);
    }
}
