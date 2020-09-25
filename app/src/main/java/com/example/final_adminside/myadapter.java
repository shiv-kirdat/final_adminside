package com.example.final_adminside;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;


public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewHolder> {

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewHolder holder,final int position, @NonNull final model model) {
        holder.e_name.setText(model.getE_name());

        //view
        holder.viewevent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.e_name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.view_event))
                        .setExpanded(true,1000)
                        .create();

                View myview=dialogPlus.getHolderView();

                final EditText name=myview.findViewById(R.id.ename);
                final EditText desc=myview.findViewById(R.id.edesc);
                final EditText date=myview.findViewById(R.id.edate);
                final EditText id=myview.findViewById(R.id.eid);


                name.setText(model.getE_name());
                id.setText(model.getE_id());
                desc.setText(model.getE_desc());
                date.setText(model.getE_date());

                dialogPlus.show();



            }
        });



        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.e_name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent))
                        .setExpanded(true, 1600)
                        .create();

                View myview=dialogPlus.getHolderView();

                final EditText name=myview.findViewById(R.id.ename);
                final EditText desc=myview.findViewById(R.id.edesc);
                final EditText date=myview.findViewById(R.id.edate);
                final EditText id=myview.findViewById(R.id.eid);
                // final EditText addr=myview.findViewById(R.id.eadd);
                Button submit=myview.findViewById(R.id.usubmit);


                name.setText(model.getE_name());
                desc.setText(model.getE_desc());
                date.setText(model.getE_date());
                id.setText(model.getE_id());
                //addr.setText(model.getE_add());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("e_id",id.getText().toString());
                        map.put("e_name",name.getText().toString());
                        map.put("e_desc",desc.getText().toString());
                        map.put("e_date",date.getText().toString());
                        //  map.put("e_addr",addr.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("event")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });

//delete
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.e_name.getContext());
                builder.setTitle("Delete Event");
                builder.setMessage("Do you want to delete event?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("event")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });



    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewHolder(view);
    }

    class myviewHolder extends RecyclerView.ViewHolder
    {
        TextView e_name;
        ImageView edit,delete,viewevent;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            e_name=(TextView)itemView.findViewById(R.id.eventname);

            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
            viewevent=(ImageView)itemView.findViewById(R.id.viewicon);


        }
    }
}
