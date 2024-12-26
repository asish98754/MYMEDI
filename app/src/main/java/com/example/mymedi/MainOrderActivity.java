package com.example.mymedi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.mymedi.Adapters.RecommendedAdapter;
import com.example.mymedi.Domain.RecommendDomain;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainOrderActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewRecommendedList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_order);
        getSupportActionBar().hide();

        recyclerViewRecommended();
        bottomNavigation();




    }


    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout dashBoardBtn = findViewById(R.id.dashBoardBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainOrderActivity.this, CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainOrderActivity.this, MainOrderActivity.class));
            }
        });
        dashBoardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainOrderActivity.this, Dashboard.class));
            }
        });
    }


    private void recyclerViewRecommended() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerViewRecommendedList = findViewById(R.id.rv);
        recyclerViewRecommendedList.setLayoutManager(linearLayoutManager);

        ArrayList<RecommendDomain> itemList = new ArrayList<>();
        itemList.add(new RecommendDomain("Panadol Soluble Tablet(4 Pieces)", "panadoltablet", "500mg,Relief of fever and aches related to cold and flu",3.55));
        itemList.add(new RecommendDomain("Eno Lemon Fruit Salt", "eno", "Lemon Fruit Salt For Relief Of Indigestion",3.05));
        itemList.add(new RecommendDomain("Glaxo Smith Kline ENO Fruit Salt (100g)", "enobotol", "Fruit Salt For Relief Of Indigestion",11.30));
        itemList.add(new RecommendDomain("Panadol Paracetamol 1Pack", "panadolpacket", "500mg, Paracetamol,Relief of fever and aches related to cold and flu",12.40));
        itemList.add(new RecommendDomain("KF94 Protective Face Mask 6's", "facemask", "KF94 can effectively block the common carrier of viruses: droplets.",10.90));



        adapter = new RecommendedAdapter(itemList);
        recyclerViewRecommendedList.setAdapter(adapter);



    }
}