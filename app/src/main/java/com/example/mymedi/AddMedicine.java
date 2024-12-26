package com.example.mymedi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddMedicine extends AppCompatActivity implements View.OnClickListener{

    private int notificationId=1;



    Button btnSet, btnCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medicine);

        getSupportActionBar().hide();





        findViewById(R.id.btnSet).setOnClickListener(this);
        findViewById(R.id.btnCancle).setOnClickListener(this);


        btnSet=findViewById(R.id.btnSet);
        btnCancle=findViewById(R.id.btnCancle);






    }
    @Override
    public void onClick(View view){
        EditText addMedicine=findViewById(R.id.addMedicineName);
        EditText doses=findViewById(R.id.addMedicineDoses);
        //TextView date=findViewById(R.id.addDate);
        TimePicker timePicker=findViewById(R.id.addTime);
        DatePicker datePicker=findViewById(R.id.addDate);


        Intent a = new Intent(AddMedicine.this, AlarmReceiver.class);
        a.putExtra("notificationId",notificationId);
        a.putExtra("todo", addMedicine.getText().toString());
        a.putExtra("todo", doses.getText().toString());
        //a.putExtra("todo", date.getText().toString());


        PendingIntent alarmIntent = PendingIntent.getBroadcast(AddMedicine.this,0, a, PendingIntent.FLAG_CANCEL_CURRENT );


        AlarmManager alarm= (AlarmManager) getSystemService(ALARM_SERVICE);


        DatePicker simpleDatePicker = (DatePicker)findViewById(R.id.addDate); // initiate a date picker

        simpleDatePicker.setSpinnersShown(false);

        switch (view.getId()){

            case R.id.btnSet:

                int hour=timePicker.getCurrentHour();
                int minute= timePicker.getCurrentMinute();


                int day = simpleDatePicker.getDayOfMonth();
                int month = simpleDatePicker.getMonth();
                int year = simpleDatePicker.getYear();


                Calendar startDate= Calendar.getInstance();
                startDate.set(Calendar.DAY_OF_MONTH,day);
                startDate.set(Calendar.MONTH,month);
                startDate.set(Calendar.YEAR,year);
                long alarmStartDate= startDate.getFirstDayOfWeek();

                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartDate,alarmIntent);

                Calendar startTime= Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY,hour);
                startTime.set(Calendar.MINUTE,minute);
                startTime.set(Calendar.SECOND,0);
                long alarmStartTime= startTime.getTimeInMillis();



                alarm.set(AlarmManager.RTC_WAKEUP,alarmStartTime,alarmIntent);

                Toast.makeText(this,"Alarm Set Done!",Toast.LENGTH_SHORT).show();
                Intent r1 = new Intent (AddMedicine.this, Dashboard.class);
                startActivity(r1);

                break;


            case R.id.btnCancle:

                Toast.makeText(this,"Canceled.",Toast.LENGTH_SHORT).show();
                Intent r2 = new Intent (AddMedicine.this, Dashboard.class);
                startActivity(r2);

                break;





        }




    }


}