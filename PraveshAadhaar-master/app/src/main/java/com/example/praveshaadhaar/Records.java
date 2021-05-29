package com.example.praveshaadhaar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Records extends AppCompatActivity {

    List<FetchData> fetchData;
    RecyclerView recyclerView;
    RecordAdapter adapter;
    DatabaseReference dbr;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        recyclerView = findViewById(R.id.rv_record);

        fetchData = new ArrayList<>();
        dbr = FirebaseDatabase.getInstance().getReference().child("Cameras");
        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){

                    FetchData data = new FetchData(ds.child("NoMask").getValue().toString(),ds.child("Mask").getValue().toString(),ds.child("CamNo").getValue().toString());
                    //data = ds.getValue(FetchData.class);
                    Log.e("ds",ds.toString());
                    fetchData.add(data);
                }
                adapter = new RecordAdapter(fetchData);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(Records.this));
                dialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Records.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }
    }
