package com.example.mymedi;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    Button btnr, btno, btnnote, btnp, btnlogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        TextView textView=(TextView) findViewById(R.id.dashboardTitle) ;
        textView.setText("My Dashboard");
        TextView textView1=(TextView) findViewById(R.id.txtreminder) ;
        textView1.setText("Medicine Reminder");
        TextView textView2=(TextView) findViewById(R.id.txtorder) ;
        textView2.setText("Order Medicine");
        TextView textView3=(TextView) findViewById(R.id.txtfind) ;
        textView3.setText("Find Nearby Pharmacy");

        TextView textView4=(TextView) findViewById(R.id.txtnote) ;
        textView4.setText("Note Health Condition");

        TextView textView6=(TextView) findViewById(R.id.txtlogout) ;
        textView6.setText("Log Out");
        TextView textView5=(TextView) findViewById(R.id.dashboardTSubtitle) ;
        textView5.setText("All Items");


        ImageView myImageView= (ImageView) findViewById(R.id.mymedii) ;
        myImageView.setImageResource(R.drawable.mymedii);
        ImageView myImageView1= (ImageView) findViewById(R.id.reminder) ;
        myImageView1.setImageResource(R.drawable.reminder);
        ImageView myImageView2= (ImageView) findViewById(R.id.order) ;
        myImageView2.setImageResource(R.drawable.order);
        ImageView myImageView3= (ImageView) findViewById(R.id.find) ;
        myImageView3.setImageResource(R.drawable.find);
        ImageView myImageView4= (ImageView) findViewById(R.id.note) ;
        myImageView4.setImageResource(R.drawable.note);
        ImageView myImageView5= (ImageView) findViewById(R.id.logout) ;
        myImageView5.setImageResource(R.drawable.logout);

        btnr=findViewById(R.id.btnr);
        btno=findViewById(R.id.btno);
        btnp = findViewById(R.id.btnf);
        btnnote=findViewById(R.id.btnn);
        btnlogout=findViewById(R.id.btnlogout);


        btnr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent r= new Intent(Dashboard.this,AddMedicine.class);
                startActivity(r);


            }
        });
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent r2= new Intent(Dashboard.this,GetStartOrder.class);
                startActivity(r2);


            }
        });
        btnnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent r3= new Intent(Dashboard.this,AddNote.class);
                startActivity(r3);


            }
        });

        btnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent r4= new Intent(Dashboard.this,PermissionsActivity.class);
                startActivity(r4);


            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //finish();


                Intent r5= new Intent(Dashboard.this,Login.class);
                startActivity(r5);


            }
        });





    }
}