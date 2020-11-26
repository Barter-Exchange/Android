package com.esprit.barterexchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class Activity extends AppCompatActivity {
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    String[] names = {"john", "carley", "james", "rian"};
    String[] descriptions = {"some random text", "some random text", "some random text", "some random text"};
    String[] location = {"new orleans", "california", "washingnon", "texas"};
    int[] img = {R.drawable.john, R.drawable.carley, R.drawable.james, R.drawable.rian};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ProgramAdapter programAdapter = new ProgramAdapter(this, names, descriptions,location, img);

        recyclerView.setAdapter(programAdapter);

    }



}