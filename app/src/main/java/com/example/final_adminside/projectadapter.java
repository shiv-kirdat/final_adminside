package com.example.final_adminside;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class projectadapter extends FirebaseRecyclerAdapter<projectmodel,projectadapter.myviewHolder> {

    public projectadapter(@NonNull FirebaseRecyclerOptions<projectmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, int position, @NonNull projectmodel model) {
        holder.projectname.setText(model.getProjectname());
    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projectrow, parent, false);
        return new myviewHolder(view);
    }

    class myviewHolder extends RecyclerView.ViewHolder {
        TextView projectname;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            projectname = (TextView) itemView.findViewById(R.id.projectname);

        }
    }
}
