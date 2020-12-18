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

import com.esprit.barterexchange.Classes.Goods;
import com.esprit.barterexchange.Services.GoodsService;

import java.util.ArrayList;

public class listGoodsOfuser extends AppCompatActivity {

    GoodsService gs = new GoodsService();


    ArrayList<Goods> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_goods_ofuser);

        ListView listView=(ListView)findViewById(R.id.listview);


        arrayList = gs.getGoodsOfUser();


        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);


        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder alert = new AlertDialog.Builder(listGoodsOfuser.this);
                alert.setTitle(" Barte Exchange");
                alert.setMessage("You want to DELETE this good !!!");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gs.deleteOfAdmin(arrayList.get(i).getId());
                        Toast.makeText(listGoodsOfuser.this,"Good with the Id :"+arrayList.get(i).getId()+" "+"is deleted",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(listGoodsOfuser.this,"refused",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();
            }
        });
    }
}