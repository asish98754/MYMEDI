package com.example.mymedi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText name,description,quantity,price,surl;
    Button btnA,btnB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().hide();

        name = (EditText)findViewById(R.id.txtName);
        description = (EditText)findViewById(R.id.txtDescription);
        quantity = (EditText)findViewById(R.id.txtQuantity);
        price = (EditText)findViewById(R.id.txtPrice);
        surl = (EditText)findViewById(R.id.txtUrl);

        btnA = (Button)findViewById(R.id.btnAdd);
        btnB = (Button)findViewById(R.id.btnBack);

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             insertData();
             clearAll();


            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             finish();


            }
        });
    }

    private void insertData()

    {

        Map<String,Object> map = new HashMap<>();
        map.put("name",name.getText().toString());
        map.put ("description" ,description.getText().toString());
        map.put ("quantity" ,quantity.getText().toString());
        map.put ("price" ,price.getText().toString());
        map.put ("surl" ,surl.getText().toString());


        FirebaseDatabase.getInstance().getReference().child("items").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity.this, "Error while Insertion", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    private void clearAll(){

        name.setText("");
        description.setText("");
        quantity.setText("");
        price.setText("");
        surl.setText("");

    }



}