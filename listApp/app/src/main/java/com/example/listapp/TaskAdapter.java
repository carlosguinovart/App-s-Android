package com.example.listapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> data;

    OnItemClickListener listener;
    public TaskAdapter(ArrayList<Task> data){
        this.data=data;
    }

    public void setClickListener(OnItemClickListener itemClickListener){
        this.listener = itemClickListener;
    }


    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        ViewHolder vh=new ViewHolder(v,listener);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        Task t= data.get(position);

        holder.tvId.setText(String.valueOf(t.getId()));
        holder.tvTask.setText(t.getTask());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        OnItemClickListener onItemClickListener;
        TextView tvId,tvTask;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onClickListener){
            super(itemView);
            tvId=itemView.findViewById(R.id.tvId);
            tvTask=itemView.findViewById(R.id.tvTask);
            this.onItemClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClick(view, getAdapterPosition(), data.get(getAdapterPosition()).getTask());
        }
    }



    public interface OnItemClickListener{
        public void onItemClick(View view, int position, String task);
    }


}
