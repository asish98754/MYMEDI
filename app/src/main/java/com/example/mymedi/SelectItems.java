package com.example.mymedi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SelectItems extends AppCompatActivity {





    Button btnr, btn2, btn3, btn4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_items);

        getSupportActionBar().hide();


        TextView textView=(TextView) findViewById(R.id.dashboardTitle) ;
        textView.setText("Select Items");
        TextView textView1=(TextView) findViewById(R.id.medicinelist1) ;

        TextView textView2=(TextView) findViewById(R.id.medicinelist2) ;

        TextView textView3=(TextView) findViewById(R.id.medicinelist3) ;

        TextView textView4=(TextView) findViewById(R.id.medicinelist4) ;

        TextView textView5=(TextView) findViewById(R.id.medicinelist5) ;

        TextView textView6=(TextView) findViewById(R.id.medicinelist6) ;


        TextView textView7=(TextView) findViewById(R.id.medidetails1) ;

        TextView textView8=(TextView) findViewById(R.id.medidetails2) ;

        TextView textView9=(TextView) findViewById(R.id.medidetails3) ;

        TextView textView10=(TextView) findViewById(R.id.medidetails4) ;

        TextView textView11=(TextView) findViewById(R.id.medidetails5) ;

        TextView textView12=(TextView) findViewById(R.id.medidetails6) ;

        TextView textView13=(TextView) findViewById(R.id.dashboardTSubtitle) ;
        textView13.setText("All Medicines");




        ImageView myImageView= (ImageView) findViewById(R.id.medicine1) ;
        myImageView.setImageResource(R.drawable.padadol);
        ImageView myImageView1= (ImageView) findViewById(R.id.medicine2) ;
        myImageView1.setImageResource(R.drawable.vitamin);
        ImageView myImageView2= (ImageView) findViewById(R.id.medicine3) ;
        myImageView2.setImageResource(R.drawable.painkiller);
        ImageView myImageView3= (ImageView) findViewById(R.id.medicine4) ;
        myImageView3.setImageResource(R.drawable.headache);
        ImageView myImageView4= (ImageView) findViewById(R.id.medicine5) ;
        myImageView4.setImageResource(R.drawable.mask);
        ImageView myImageView5= (ImageView) findViewById(R.id.medicine6) ;
        myImageView5.setImageResource(R.drawable.mymedii);










    }
}