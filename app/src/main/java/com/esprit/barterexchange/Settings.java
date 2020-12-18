package com.esprit.barterexchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esprit.barterexchange.Classes.CurrentUser;
import com.esprit.barterexchange.Services.UserServices;

public class Settings extends AppCompatActivity {

    UserServices us =new UserServices();

    private EditText fname;
    private EditText lname;
    private EditText uname;
    private EditText mail;
    private EditText pass;
    private Button update;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fname=(EditText)findViewById(R.id.efname);
        lname=(EditText)findViewById(R.id.elname);
        uname=(EditText)findViewById(R.id.euname);
        mail=(EditText)findViewById(R.id.eemail);
        pass=(EditText)findViewById(R.id.epass);
        update= (Button) findViewById(R.id.update);
        delete= (Button) findViewById(R.id.delete);

        fname.setText(CurrentUser.getFirstName());
        lname.setText(CurrentUser.getLastName());
        uname.setText(CurrentUser.getUsername());
        mail.setText(CurrentUser.getEmail());
        pass.setText(CurrentUser.getPassword());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                us.update(fname.getText().toString(),lname.getText().toString(),uname.getText().toString(),mail.getText().toString(),pass.getText().toString());
                Intent g =new Intent(Settings.this,Profil.class);
                startActivity(g);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                us.delete();
                Intent g =new Intent(Settings.this,SignUp.class);
                startActivity(g);
            }
        });


    }






}