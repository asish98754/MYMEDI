package com.example.mymedi;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PharmacyRegister extends AppCompatActivity {


    TextView regName,regUsername,regRegNo,regAddress,regPhoneNo,regPassword;
    Button regBtn,regToLoginBtn;
    Dialog dialog;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_register);
        getSupportActionBar().hide();


        regName = findViewById(R.id.reg_name);
        regUsername = findViewById(R.id.reg_username);
        regRegNo = findViewById(R.id.reg_reg_no);
        regAddress = findViewById(R.id.reg_address);
        regPhoneNo = findViewById(R.id.reg_phoneNo);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);
        regToLoginBtn = findViewById(R.id.reg_login_btn);

        dialog = new Dialog(this);


    }

    //validation
    private Boolean validateName(){
        String val = regName.getText().toString();

        if(val.isEmpty()){
            regName.setError("Field cannot be empty");
            return false;
        }
        else{
            regName.setError(null);
            return true;
        }
    }
    private Boolean validateUsername(){
        String val = regUsername.getText().toString();


        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty");
            return false;
        }else if (val.length()>=15){
            regUsername.setError("Username too long");
            return false;
        }

        else{
            regUsername.setError(null);
            return true;
        }
    }

    private Boolean validateRegNo(){
        String val = regRegNo.getText().toString();


        if(val.isEmpty()){
            regRegNo.setError("Field cannot be empty");
            return false;
        }else if (val.length()>=25){
            regRegNo.setError("Reg.No too long");
            return false;
        }

        else{
            regRegNo.setError(null);
            return true;
        }
    }


    private Boolean validateAddress(){
        String val = regAddress.getText().toString();


        if(val.isEmpty()){
            regAddress.setError("Field cannot be empty");
            return false;
        }
        else if(val.length() >= 50){
            regAddress.setError("Invalid email address");
            return false;
        }
        else{
            regAddress.setError(null);
            return true;
        }
    }
    private Boolean validatePhoneNo(){
        String val = regPhoneNo.getText().toString();

        if(val.isEmpty()){
            regPhoneNo.setError("Field cannot be empty");
            return false;
        }
        else{
            regPhoneNo.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = regPassword.getText().toString();


        if(val.isEmpty()){
            regPassword.setError("Field cannot be empty");
            return false;
        }

        else{
            regPassword.setError(null);
            return true;
        }
    }


    public void registerUser(View view){

        if (!validateName() | !validateUsername() | !validateRegNo() | !validateAddress() | !validatePhoneNo() |!validatePassword()){
            return;
        }

        //save data in firebase
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("pharmacist");

        //get all the value
        String name = regName.getText().toString();
        String username = regUsername.getText().toString();
        String regNo = regRegNo.getText().toString();
        String address = regAddress.getText().toString();
        String phoneNo = regPhoneNo.getText().toString();
        String password = regPassword.getText().toString();


        UserHelperClassPharmacy helperClass = new UserHelperClassPharmacy(name,username,regNo,address,phoneNo,password);


        reference.child(username).setValue(helperClass);

        dialog.setContentView(R.layout.custom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnOK = dialog.findViewById(R.id.btnOK);



        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
        regName.setText("");
        regUsername.setText("");
        regRegNo.setText("");
        regAddress.setText("");
        regPhoneNo.setText("");
        regPassword.setText("");


    }

    public void have_account_btn(View view) {
        Intent intent = new Intent(PharmacyRegister.this,PharmacyLogin.class);
        startActivity(intent);
        finish();
    }

}