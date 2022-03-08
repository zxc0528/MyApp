package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class ChoiseActivity extends AppCompatActivity  {
    private Spinner spinerlista1, spinerlista2;
    ArrayList<String> listawyboru1;
    ArrayAdapter lista2_adapter;

    String x, y;
    int z;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise);
        spinerlista1 = (Spinner)findViewById(R.id.spinner_lista1);
        spinerlista2 = (Spinner)findViewById(R.id.spinner_lista2);

        ArrayAdapter lista1_adapter = ArrayAdapter.createFromResource(this, R.array.Usluga, R.layout.color_spinner_layout);
        spinerlista1.setAdapter(lista1_adapter);


        spinerlista1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              if (position==0){
                  lista2_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Assistance, R.layout.color_spinner_layout);
                  x = getApplicationContext().getResources().getStringArray(R.array.Usluga)[position];
                  z = 0;
              }
              if (position==1){
                  lista2_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Blacharz, R.layout.color_spinner_layout);
                  x = getApplicationContext().getResources().getStringArray(R.array.Usluga)[position];
                  z = 1;
              }
              if (position==2){
                  lista2_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Elektryk, R.layout.color_spinner_layout);
                  x = getApplicationContext().getResources().getStringArray(R.array.Usluga)[position];
                  z = 2;
              }
              if (position==3){
                  lista2_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Lakiernik, R.layout.color_spinner_layout);
                  x = getApplicationContext().getResources().getStringArray(R.array.Usluga)[position];
                  z = 3;
              }
              if (position==4){
                  lista2_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Opony, R.layout.color_spinner_layout);
                  x = getApplicationContext().getResources().getStringArray(R.array.Usluga)[position];
                  z = 4;
              }
              if (position==5){
                  lista2_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Silnik, R.layout.color_spinner_layout);
                  x = getApplicationContext().getResources().getStringArray(R.array.Usluga)[position];
                  z = 5;
              }
              if (position==6){
                  lista2_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Skup, R.layout.color_spinner_layout);
                  x = getApplicationContext().getResources().getStringArray(R.array.Usluga)[position];
                  z = 6;
              }
              if (position==7){
                  lista2_adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.Zawieszenie, R.layout.color_spinner_layout);
                  x = getApplicationContext().getResources().getStringArray(R.array.Usluga)[position];
                  z = 7;
              }
              spinerlista2.setAdapter(lista2_adapter);

                spinerlista2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if (z==0){
                            if (position==0){
                                y = getApplicationContext().getResources().getStringArray(R.array.Assistance)[position];
                            }
                            if (position==1){
                                y = getApplicationContext().getResources().getStringArray(R.array.Assistance)[position];
                            }
                            if (position==2){
                                y = getApplicationContext().getResources().getStringArray(R.array.Assistance)[position];
                            }
                            if (position==3){
                                y = getApplicationContext().getResources().getStringArray(R.array.Assistance)[position];
                            }
                            if (position==4){
                                y = getApplicationContext().getResources().getStringArray(R.array.Assistance)[position];
                            }
                            if (position==5){
                                y = getApplicationContext().getResources().getStringArray(R.array.Assistance)[position];
                            }
                        }
                        if (z==1){
                            if (position==0){
                                y = getApplicationContext().getResources().getStringArray(R.array.Blacharz)[position];
                            }
                            if (position==1){
                                y = getApplicationContext().getResources().getStringArray(R.array.Blacharz)[position];
                            }
                            if (position==2){
                                y = getApplicationContext().getResources().getStringArray(R.array.Blacharz)[position];
                            }
                        }
                        if (z==2){
                            if (position==0){
                                y = getApplicationContext().getResources().getStringArray(R.array.Elektryk)[position];
                            }
                            if (position==1){
                                y = getApplicationContext().getResources().getStringArray(R.array.Elektryk)[position];
                            }
                            if (position==2){
                                y = getApplicationContext().getResources().getStringArray(R.array.Elektryk)[position];
                            }
                        }
                        if (z==3){
                            if (position==0){
                                y = getApplicationContext().getResources().getStringArray(R.array.Lakiernik)[position];
                            }
                            if (position==1){
                                y = getApplicationContext().getResources().getStringArray(R.array.Lakiernik)[position];
                            }
                            if (position==2){
                                y = getApplicationContext().getResources().getStringArray(R.array.Lakiernik)[position];
                            }
                        }
                        if (z==4){
                            if (position==0){
                                y = getApplicationContext().getResources().getStringArray(R.array.Opony)[position];
                            }
                            if (position==1){
                                y = getApplicationContext().getResources().getStringArray(R.array.Opony)[position];
                            }
                            if (position==2){
                                y = getApplicationContext().getResources().getStringArray(R.array.Opony)[position];
                            }
                            if (position==3){
                                y = getApplicationContext().getResources().getStringArray(R.array.Opony)[position];
                            }
                            if (position==4){
                                y = getApplicationContext().getResources().getStringArray(R.array.Opony)[position];
                            }
                        }
                        if (z==5){
                            if (position==0){
                                y = getApplicationContext().getResources().getStringArray(R.array.Silnik)[position];
                            }
                            if (position==1){
                                y = getApplicationContext().getResources().getStringArray(R.array.Silnik)[position];
                            }
                            if (position==2){
                                y = getApplicationContext().getResources().getStringArray(R.array.Silnik)[position];
                            }
                            if (position==3){
                                y = getApplicationContext().getResources().getStringArray(R.array.Silnik)[position];
                            }
                        }
                        if (z==6){
                            if (position==0){
                                y = getApplicationContext().getResources().getStringArray(R.array.Skup)[position];
                            }
                            if (position==1){
                                y = getApplicationContext().getResources().getStringArray(R.array.Skup)[position];
                            }
                        }
                        if (z==7){
                            if (position==0){
                                y = getApplicationContext().getResources().getStringArray(R.array.Zawieszenie)[position];
                            }
                            if (position==1){
                                y = getApplicationContext().getResources().getStringArray(R.array.Zawieszenie)[position];
                            }
                            if (position==2){
                                y = getApplicationContext().getResources().getStringArray(R.array.Zawieszenie)[position];
                            }
                            if (position==3){
                                y = getApplicationContext().getResources().getStringArray(R.array.Zawieszenie)[position];
                            }
                            if (position==4){
                                y = getApplicationContext().getResources().getStringArray(R.array.Zawieszenie)[position];
                            }
                        }

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void HistoryClick(View view) {
//        Intent intentChoise = new Intent(this, WpisyActivity.class);
        Intent intentChoise = new Intent(this, HistoryActivity.class);
        startActivity(intentChoise);
    }

    int[] image = {R.drawable.car_assistance,R.drawable.car_blacharz, R.drawable.car_elektryka, R.drawable.car_lakiernik,
            R.drawable.car_tyre, R.drawable.car_engine, R.drawable.car_skup, R.drawable.car_zawieszenie};

    public void OkClick(View view) {
        Intent intentChoise = new Intent(this, HistoryActivity.class);
        AlertDialog dialog = new AlertDialog.Builder(this, R.style.AlertDialogStyle)
                .setTitle("Potwierdzić wizytę w wybranym serwisie ?")
                .setMessage("to będzie trochę kosztować :( ")
                .setPositiveButton("Tak", null)
                .setNegativeButton("Jeszcze Nie", null)
                .show();
        Button positiveButton = dialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intentChoise.putExtra("myKey", x);
                intentChoise.putExtra("myKey2", y);
                intentChoise.putExtra("myKey3", z);
                dialog.dismiss();
                Calendar c = Calendar.getInstance();
                SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
                String formattedDate = df.format(c.getTime());
                MyDatabaseHelper myDB = new MyDatabaseHelper(ChoiseActivity.this);
                myDB.addBook(x, y, formattedDate, z);
                startActivity(intentChoise);
            }
        });
    }

    private long pressedTime;
    public void onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        } else {
            Toast.makeText(getBaseContext(), "Naciśnij ponownie by wyjść", Toast.LENGTH_SHORT).show();
        }
        pressedTime = System.currentTimeMillis();
    }
}