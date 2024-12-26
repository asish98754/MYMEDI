package com.example.mymedi;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class PharmacyLogin extends AppCompatActivity {


    Button login_btn, callSignUp;
    ImageView image;
    TextView logoText,sloganText;
    EditText regUsername,regPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy_login);


        getSupportActionBar().hide();


        callSignUp = findViewById(R.id.signup_screen);
        image = findViewById(R.id.logo_image);
        logoText = findViewById(R.id.logo_name);
        sloganText = findViewById(R.id.slogan_name);
        regUsername = findViewById(R.id.reg_username);
        regPassword = findViewById(R.id.reg_password);
        login_btn = findViewById(R.id.login_btn);



        callSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (PharmacyLogin.this, PharmacyRegister.class);


                Pair[] pairs = new Pair[7];

                pairs[0]= new Pair<View,String>(image,"logo_image");
                pairs[1]= new Pair<View,String>(logoText,"logo_Text");
                pairs[2]= new Pair<View,String>(sloganText,"logo_desc");
                pairs[3]= new Pair<View,String>(regUsername,"username_trans");
                pairs[4]= new Pair<View,String>(regPassword,"password_trans");
                pairs[5]= new Pair<View,String>(login_btn,"button_trans");
                pairs[6]= new Pair<View,String>(callSignUp,"login_signup_trans");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(PharmacyLogin.this,pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });


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

    public void loginPharmacist (View view){
        //validate login info
        if (!validateUsername() | !validatePassword()){
            return;
        }else {
            isPharmacist();
        }
    }

    private void isPharmacist() {

        final String userEnteredUsername = regUsername.getText().toString().trim();
        final String userEnteredPassword = regPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("pharmacist");

        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){

                    regUsername.setError(null);


                    String passwordFromDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userEnteredPassword)){

                        regPassword.setError(null);

                        Intent intent = new Intent(getApplicationContext(), DashboardPharmacy.class);
                        startActivity(intent);
                    }
                    else{
                        regPassword.setError("Wrong Password");
                        regPassword.requestFocus();
                    }

                }
                else {
                    regUsername.setError("No such user exist");
                    regUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}