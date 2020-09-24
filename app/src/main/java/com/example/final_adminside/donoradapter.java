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
        holder.donor_name.setText(model.getDonor_name());
        holder.donorpaid.setText(model.getAmount());


    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donorrow, parent, false);
        return new myviewHolder(view);
    }

    class myviewHolder extends RecyclerView.ViewHolder {
        TextView donor_name, donorpaid;


        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            donor_name = (TextView) itemView.findViewById(R.id.donorname);
            donorpaid = (TextView) itemView.findViewById(R.id.donorpaid);


        }
    }
}
