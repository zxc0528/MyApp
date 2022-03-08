package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Comment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener{

    private int mCurrentItemPosition;

//    ArrayList<ModelClass> lista_wpisow = new ArrayList<>();

//    int[] image = {R.drawable.car_assistance,R.drawable.car_blacharz, R.drawable.car_elektryka, R.drawable.car_lakiernik,
//            R.drawable.car_tyre, R.drawable.car_engine, R.drawable.car_skup, R.drawable.car_zawieszenie};

    MyDatabaseHelper myDB;
    ArrayList<String> wpis_id, wpis_co, wpis_gdzie, wpis_godz, wpis_zdj;
    CustomAdapter customAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

//        String message_x = getIntent().getStringExtra("myKey");
//        String message_y = getIntent().getStringExtra("myKey2");
//        int message_z = getIntent().getIntExtra("myKey3", 0);

        RecyclerView historia_wpisow = findViewById(R.id.historia_wpisow);
        historia_wpisow.setHasFixedSize(true);

        myDB = new MyDatabaseHelper(HistoryActivity.this);
        wpis_id = new ArrayList<>();
        wpis_co = new ArrayList<>();
        wpis_gdzie = new ArrayList<>();
        wpis_godz = new ArrayList<>();
        wpis_zdj = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(HistoryActivity.this,this, wpis_id, wpis_co, wpis_gdzie, wpis_godz, wpis_zdj);
//        adapter.setOnLongItemClickListener(new Adapter_history.onLongItemClickListener() {
//            public void ItemLongClicked(View v, int position) {
//                mCurrentItemPosition = position;
//                v.showContextMenu();
//            }
//        });
        customAdapter.setOnLongItemClickListener(new CustomAdapter.onLongItemClickListener() {
            public void ItemLongClicked(View v, int position) {
                mCurrentItemPosition = position;
                v.showContextMenu();
            }
        });

        historia_wpisow.setAdapter(customAdapter);
        historia_wpisow.setLayoutManager(new LinearLayoutManager(this));
        registerForContextMenu(historia_wpisow);
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "brak historii", Toast.LENGTH_LONG).show();
        }else{
            while (cursor.moveToNext()){
                wpis_id.add(cursor.getString(0));
                wpis_co.add(cursor.getString(1));
                wpis_gdzie.add(cursor.getString(2));
                wpis_godz.add(cursor.getString(3));
                wpis_zdj.add(cursor.getString(4));
            }
        }
    }

//    public void testClick(View view) {
//        Snackbar snackbar = Snackbar.make(view, "Wybrałeś: ", Snackbar.LENGTH_LONG)
//                .setAction("Wiem", new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Snackbar snackbar1 = Snackbar.make(view, "OK", Snackbar.LENGTH_SHORT);
//                        snackbar1.show();
//                    }
//                })
//                .setActionTextColor(Color.BLUE);
//        snackbar.show();
//    }

    public void onClick(View view) {

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.what_delete, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.select_one){
            AlertDialog dialog = new AlertDialog.Builder(this, R.style.AlertDialogStyle)
                    .setTitle("Usunąć wszystkie wpisy?")
                    .setPositiveButton("Tak", null)
                    .setNegativeButton("Nie", null)
                    .show();
            Button positiveButton = dialog.getButton(androidx.appcompat.app.AlertDialog.BUTTON_POSITIVE);
            positiveButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dialog.dismiss();
                    MyDatabaseHelper myDB = new MyDatabaseHelper(HistoryActivity.this);
                    myDB.deleteAllData();
                    //Refresh Activity
                    Intent intent = new Intent(HistoryActivity.this, HistoryActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }
}
