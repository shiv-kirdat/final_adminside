package com.example.final_adminside;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class donoradapter extends FirebaseRecyclerAdapter<donormodel,donoradapter.myviewHolder> {

    public donoradapter(@NonNull FirebaseRecyclerOptions<donormodel> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, int position, @NonNull donormodel model) {
        holder.name2.setText(model.getName2());
        holder.msg2.setText(model.getMsg2());
        holder.emil2.setText(model.getEmil2());
        //holder.donorpaid.setText(model.getAmount());


    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donorrow, parent, false);
        return new myviewHolder(view);
    }

    class myviewHolder extends RecyclerView.ViewHolder {
        TextView name2, msg2, emil2;


        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            name2 = (TextView) itemView.findViewById(R.id.donorname);
            msg2 = (TextView) itemView.findViewById(R.id.donorpaid);
            emil2 = (TextView) itemView.findViewById(R.id.donormail);
            //donorpaid = (TextView) itemView.findViewById(R.id.donorpaid);


        }
    }
}
