package com.example.mymedi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GetStartOrder extends AppCompatActivity {

    Button getStart;
    ImageView deliveryIcon;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start_order);

        getSupportActionBar().hide();

        deliveryIcon = findViewById(R.id.deliveryicon);
        title = findViewById(R.id.orderTitle);
        getStart = findViewById(R.id.getStart);

        getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent r= new Intent(GetStartOrder.this,MainOrderActivity.class);
                startActivity(r);


            }
        });


    }
}