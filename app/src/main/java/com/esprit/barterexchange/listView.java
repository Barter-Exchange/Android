package com.esprit.barterexchange;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.esprit.barterexchange.Classes.StaticUser;
import com.esprit.barterexchange.Classes.User;
import com.esprit.barterexchange.Services.UserServices;

import java.util.ArrayList;

public class listView extends AppCompatActivity {
    UserServices us = new UserServices();

    //create ArrayList of String
    ArrayList<User> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        ListView listView=(ListView)findViewById(R.id.listview);


        arrayList = us.getAllUser();


        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);


        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(listView.this);
                    alert.setTitle("ADMIN Barte Exchange");
                    alert.setMessage("You want to DELETE this user !!!");
                    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            us.deleteOfAdmin(arrayList.get(i).getID());
                            Toast.makeText(listView.this,"User with the Id :"+arrayList.get(i).getID()+" "+"is deleted",Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(listView.this,"refused",Toast.LENGTH_SHORT).show();
                        }
                    });
                    alert.create().show();
            }
        });
    }

}