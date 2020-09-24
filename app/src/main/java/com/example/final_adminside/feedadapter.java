package com.example.final_adminside;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class feedadapter extends FirebaseRecyclerAdapter<feedmodel,feedadapter.myviewHolder> {

    public feedadapter(@NonNull FirebaseRecyclerOptions<feedmodel> options) {

        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, int position, @NonNull feedmodel model) {
        holder.name2.setText(model.getName());
        holder.emil2.setText(model.getMail());
        holder.msg2.setText(model.getMsg());

    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedrow, parent, false);
        return new myviewHolder(view);
    }

    class myviewHolder extends RecyclerView.ViewHolder {
        TextView name2,emil2,msg2;


        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            name2 = (TextView) itemView.findViewById(R.id.feedname);
            emil2 = (TextView) itemView.findViewById(R.id.feedmail);
            msg2 = (TextView) itemView.findViewById(R.id.feedmsg);


        }
    }
}
