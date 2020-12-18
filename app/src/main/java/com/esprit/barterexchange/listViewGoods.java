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
import com.esprit.barterexchange.Classes.User;
import com.esprit.barterexchange.Services.GoodsService;

import java.util.ArrayList;

public class listViewGoods extends AppCompatActivity {
    GoodsService gs = new GoodsService();


    ArrayList<Goods> arrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_goods);


        ListView listView=(ListView)findViewById(R.id.listview);


        arrayList = gs.getAllGoods();


        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);


        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog.Builder alert = new AlertDialog.Builder(listViewGoods.this);
                alert.setTitle("ADMIN Barte Exchange");
                alert.setMessage("You want to DELETE this good !!!");
                alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gs.deleteOfAdmin(arrayList.get(i).getId());
                        Toast.makeText(listViewGoods.this,"Good with the Id :"+arrayList.get(i).getId()+" "+"is deleted",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(listViewGoods.this,"refused",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();
            }
        });
    }
}