package com.example.mymedi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

public class PlaceOrder extends AppCompatActivity {
    TextView tv1,tv2;
    EditText ed1,ed2,ed3,ed4,ed5;


    CardForm cardForm;
    Button buy;

    AlertDialog.Builder alertBuilder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        getSupportActionBar().hide();

        tv1 = findViewById(R.id.cd);
        tv2 = findViewById(R.id.cardd);

        ed1 = findViewById(R.id.name);
        ed2 = findViewById(R.id.phone);
        ed3 = findViewById(R.id.city);
        ed4 = findViewById(R.id.street);
        ed5 = findViewById(R.id.unit);






        cardForm = findViewById(R.id.cardForm);
        buy = findViewById(R.id.placeOrder);

        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .setup(PlaceOrder.this);


        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (cardForm.isValid()) {
                    alertBuilder = new AlertDialog.Builder(PlaceOrder.this);
                    alertBuilder.setTitle("Confirm before purchase");
                    alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                            "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "Card CVV: " + cardForm.getCvv() + "\n" +
                            "Postal code: " + cardForm.getPostalCode() + "\n" +
                            "Phone number: " + cardForm.getMobileNumber());
                    alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(PlaceOrder.this, "Thank you for purchase." +
                                    "Your order has been Placed.", Toast.LENGTH_LONG).show();

                            Intent r= new Intent(PlaceOrder.this,MainOrderActivity.class);
                            startActivity(r);
                        }
                    });
                    alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(PlaceOrder.this, "Please complete the form", Toast.LENGTH_LONG).show();
                }
            }
        });








    }

    //validation
    private Boolean validateName(){
        String val = ed1.getText().toString();

        if(val.isEmpty()){
            ed1.setError("Field cannot be empty");
            return false;
        }
        else{
            ed1.setError(null);
            return true;
        }
    }

    private Boolean validateAddress(){
        String val = ed2.getText().toString();


        if(val.isEmpty()){
            ed2.setError("Field cannot be empty");
            return false;
        }else if (val.length()>=11){
            ed2.setError("Number too long");
            return false;
        }

        else{
            ed2.setError(null);
            return true;
        }
    }

    private Boolean validateCity(){
        String val = ed3.getText().toString();


        if(val.isEmpty()){
            ed3.setError("Field cannot be empty");
            return false;
        }else if (val.length()>=80){
            ed3.setError("City's Name too long");
            return false;
        }

        else{
            ed3.setError(null);
            return true;
        }
    }

    private Boolean validateStreet(){
        String val = ed4.getText().toString();


        if(val.isEmpty()){
            ed4.setError("Field cannot be empty");
            return false;
        }else if (val.length()>=80){
            ed4.setError("Street's Name is too long");
            return false;
        }

        else{
            ed4.setError(null);
            return true;
        }
    }

    private Boolean validateUnit(){
        String val = ed5.getText().toString();


        if(val.isEmpty()){
            ed5.setError("Field cannot be empty");
            return false;
        }else if (val.length()>=20){
            ed5.setError("Unit's Number is too long");
            return false;
        }

        else{
            ed5.setError(null);
            return true;
        }
    }

    public void customerDetails(View view) {

        if (!validateName() | !validateAddress() | !validateCity() | !validateStreet() | !validateUnit()) {
            return;
        }
    }

}