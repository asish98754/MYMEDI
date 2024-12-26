package com.example.mymedi.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.mymedi.Domain.RecommendDomain;
import com.example.mymedi.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {

    private Context context;
    private  TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB= new TinyDB(context);


    }

    public void insertItem(RecommendDomain item){

        ArrayList<RecommendDomain> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getTitle().equals(item.getTitle())) {
                existAlready = true;
                n = i;
                break;
            }
        }

        if (existAlready) {
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listFood.add(item);
        }
        tinyDB.putListObject("CartList", listFood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();


    }

    public ArrayList<RecommendDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }



    public void plusNumberFood(ArrayList<RecommendDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart() + 1);
        tinyDB.putListObject("CartList", listFood);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<RecommendDomain> listfood, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        if (listfood.get(position).getNumberInCart() == 1) {
            listfood.remove(position);
        } else {
            listfood.get(position).setNumberInCart(listfood.get(position).getNumberInCart() - 1);
        }
        tinyDB.putListObject("CartList", listfood);
        changeNumberItemsListener.changed();
    }
    public Double getTotalFee() {
        ArrayList<RecommendDomain> listfood = getListCart();
        double fee = 0;
        for (int i = 0; i < listfood.size(); i++) {
            fee = fee + (listfood.get(i).getPrice() * listfood.get(i).getNumberInCart());
        }
        return fee;
    }

}
