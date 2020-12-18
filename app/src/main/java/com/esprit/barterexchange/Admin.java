package com.esprit.barterexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Admin extends AppCompatActivity {
     private Button u,g,su,sg;
     private TextView logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        u= findViewById(R.id.buttonUser);
        g= findViewById(R.id.buttonGoods);
        su = findViewById(R.id.buttonSu);
        sg=findViewById(R.id.buttonSg);

        logOut = findViewById(R.id.logOut);

        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Admin.this,listView.class);
                startActivity(go);

            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Admin.this,listViewGoods.class);
                startActivity(go);

            }
        });

        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        sg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(Admin.this,SignIn.class);
               startActivity(go);


            }
        });
    }
}