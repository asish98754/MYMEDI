package com.example.mymedi.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymedi.Domain.RecommendDomain;
import com.example.mymedi.R;
import com.example.mymedi.ShowDetailActivity;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {


    ArrayList<RecommendDomain> recommendedItem;

    public RecommendedAdapter(ArrayList<RecommendDomain> recommendedItem) {
        this.recommendedItem = recommendedItem;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommended, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(recommendedItem.get(position).getTitle());

        holder.fee.setText(String.valueOf(recommendedItem.get(position).getPrice()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(recommendedItem.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());



        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);


        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", recommendedItem.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recommendedItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, fee;
        ImageView pic;
        TextView addBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);



        }
    }
}
