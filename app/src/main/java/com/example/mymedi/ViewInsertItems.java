package com.example.mymedi;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewInsertItems extends AppCompatActivity {

    RecyclerView recyclerView;

    MainAdapter mainAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_insert_items);




        recyclerView = (RecyclerView)findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //DatabaseReference reference = FirebaseDatabase.getInstance().getReference("items");


        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery (FirebaseDatabase.getInstance().getReference().child("items"), MainModel.class)
                        .build();


        mainAdapter = new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);


    }




    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {

                txtSearch(query);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str)
    {

        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery (FirebaseDatabase.getInstance().getReference().child("items").orderByChild("name").startAt(str).endAt(str+"~"), MainModel.class)
                        .build();


        mainAdapter = new MainAdapter(options);
        mainAdapter.startListening();
        recyclerView.setAdapter(mainAdapter);





    }



}