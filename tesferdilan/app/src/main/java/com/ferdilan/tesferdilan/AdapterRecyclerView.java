package com.ferdilan.tesferdilan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterRecyclerView  extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {
    private String[] SubjectValues;
    private Context context;

    AdapterRecyclerView(Context context1, String[] SubjectValues1){

        SubjectValues = SubjectValues1;
        context = context1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textview;

        ViewHolder(View v){
            super(v);
            textview = v.findViewById(R.id.textItem);
        }
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.textview.setText(SubjectValues[position]);
    }
    @Override
    public int getItemCount(){
        return SubjectValues.length;
    }
}
