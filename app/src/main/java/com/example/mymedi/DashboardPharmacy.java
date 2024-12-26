package com.example.mymedi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardPharmacy extends AppCompatActivity {



    Button btna,btnl,btnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_pharmacy);

        getSupportActionBar().hide();


        TextView textView=(TextView) findViewById(R.id.welcome) ;
        textView.setText("Welcome To MYMEDI");
        TextView textView1=(TextView) findViewById(R.id.sale) ;
        textView1.setText("Sale Your Items Here!");



        TextView textView2=(TextView) findViewById(R.id.txtaddItems) ;
        textView2.setText("Add Products");
        TextView textView3=(TextView) findViewById(R.id.txtlogout) ;
        textView3.setText("Log Out");

        TextView textView4=(TextView) findViewById(R.id.txtviewItems) ;
        textView4.setText("View Products");

        ImageView myImageView= (ImageView) findViewById(R.id.mymedii) ;
        myImageView.setImageResource(R.drawable.mymedii);

        ImageView myImageView1= (ImageView) findViewById(R.id.addItems) ;
        myImageView1.setImageResource(R.drawable.ic_add_black_add);
        ImageView myImageView2= (ImageView) findViewById(R.id.logout) ;
        myImageView2.setImageResource(R.drawable.ic_delete_black_24dp);
        ImageView myImageView3= (ImageView) findViewById(R.id.viewInventory) ;
        myImageView3.setImageResource(R.drawable.viewproducticon);



        btna=findViewById(R.id.btnadd);
        btnl=findViewById(R.id.btnlogout);
        btnv=findViewById(R.id.btnview);



        //firebaseAuth = FirebaseAuth.getInstance();


        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent r= new Intent(DashboardPharmacy.this,AddActivity.class);
                startActivity(r);


            }
        });
        btnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent r1= new Intent(DashboardPharmacy.this,ViewInsertItems.class);
                startActivity(r1);


            }
        });

        btnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();


                //Intent r2= new Intent(DashboardPharmacy.this,PharmacyLogin.class);
                //startActivity(r2);


            }
        });

    }
}