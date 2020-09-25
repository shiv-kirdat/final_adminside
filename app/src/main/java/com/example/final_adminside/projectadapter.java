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

public class projectadapter extends FirebaseRecyclerAdapter<projectmodel,projectadapter.myviewHolder> {

    public projectadapter(@NonNull FirebaseRecyclerOptions<projectmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewHolder holder,final int position, @NonNull final projectmodel model) {
        holder.projectname.setText(model.getProjectname());



        //view
        holder.viewproject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.projectname.getContext())
                        .setContentHolder(new ViewHolder(R.layout.view_project))
                        .setExpanded(true,1000)
                        .create();

                View myview=dialogPlus.getHolderView();

                final EditText name=myview.findViewById(R.id.pname);
                final EditText desc=myview.findViewById(R.id.pdesc);
                final EditText date=myview.findViewById(R.id.pdate);
                final EditText id=myview.findViewById(R.id.pid);
                final EditText place=myview.findViewById(R.id.place);


                name.setText(model.getProjectname());
                id.setText(model.getProjectid());
                desc.setText(model.getProjectdesc());
                date.setText(model.getProjectdate());
                place.setText(model.getProjectplace());

                dialogPlus.show();



            }
        });



        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.projectname.getContext())
                        .setContentHolder(new ViewHolder(R.layout.projectdialogcontent))
                        .setExpanded(true, 1600)
                        .create();

                View myview=dialogPlus.getHolderView();

                final EditText name=myview.findViewById(R.id.pname);
                final EditText desc=myview.findViewById(R.id.pdesc);
                final EditText date=myview.findViewById(R.id.pdate);
                final EditText id=myview.findViewById(R.id.pid);
                final EditText place=myview.findViewById(R.id.place);
                Button submit=myview.findViewById(R.id.usubmit);


                name.setText(model.getProjectname());
                id.setText(model.getProjectid());
                desc.setText(model.getProjectdesc());
                date.setText(model.getProjectdate());
                place.setText(model.getProjectplace());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("projectid",id.getText().toString());
                        map.put("projectname",name.getText().toString());
                        map.put("projectdescription",desc.getText().toString());
                        map.put("projectdate",date.getText().toString());
                        map.put("projectplace",place.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("projectDetails")
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
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.projectname.getContext());
                builder.setTitle("Delete Project");
                builder.setMessage("Do you want to delete Project?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("projectDetails")
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

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.projectrow, parent, false);
        return new myviewHolder(view);

    }

    class myviewHolder extends RecyclerView.ViewHolder {
        TextView projectname;

        ImageView edit,delete,viewproject;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);

            projectname = (TextView) itemView.findViewById(R.id.projectname);

            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
            viewproject=(ImageView)itemView.findViewById(R.id.viewicon);


        }
    }
}
