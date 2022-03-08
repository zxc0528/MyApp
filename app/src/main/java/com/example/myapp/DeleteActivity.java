package com.example.myapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeleteActivity extends AppCompatActivity {

    TextView zaklad_input, phone_input;
    Button delete_button, phone_button;
    CircleImageView image_input;
    String co, phone;

    String[] tel = {"+11 111 111 11", "+22 222 222 222", "+33 333 333 333", "+44 444 444 444",
                    "+55 555 555 555", "+66 666 666 666", "+77 777 777 777", "+88 888 888 888"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        zaklad_input = findViewById(R.id.usluga_profile);
        phone_input = findViewById(R.id.phone_profile);
        image_input = findViewById(R.id.profile_image);
        delete_button = findViewById(R.id.delete_button);
        phone_button = findViewById(R.id.phone_button);

        co = getIntent().getStringExtra("co");
        zaklad_input.setText(co);
        if (co.equalsIgnoreCase("Assistance")){
            phone_input.setText(tel[0]);
            phone = tel[0];
            image_input.setImageResource(R.drawable.car_assistance);
        }
        else if (co.equalsIgnoreCase("Blacharz")){
            phone_input.setText(tel[1]);
            phone = tel[1];
            image_input.setImageResource(R.drawable.car_blacharz);
        }
        else if (co.equalsIgnoreCase("Elektryk")){
            phone_input.setText(tel[2]);
            phone = tel[2];
            image_input.setImageResource(R.drawable.car_elektryka);
        }
        else if (co.equalsIgnoreCase("Lakiernik")){
            phone_input.setText(tel[3]);
            phone = tel[3];
            image_input.setImageResource(R.drawable.car_lakiernik);
        }
        else if (co.equalsIgnoreCase("Wymiana opon")){
            phone_input.setText(tel[4]);
            phone = tel[4];
            image_input.setImageResource(R.drawable.car_tyre);
        }
        else if (co.equalsIgnoreCase("Silnik/skrzynia")){
            phone_input.setText(tel[5]);
            phone = tel[5];
            image_input.setImageResource(R.drawable.car_engine);
        }
        else if (co.equalsIgnoreCase("Skup złomu")){
            phone_input.setText(tel[6]);
            phone = tel[6];
            image_input.setImageResource(R.drawable.car_skup);
        }
        else if (co.equalsIgnoreCase("Zawieszenie")){
            phone_input.setText(tel[7]);
            phone = tel[7];
            image_input.setImageResource(R.drawable.car_zawieszenie);
        }

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(co);
        }
        ab.setDisplayHomeAsUpEnabled(true);

        delete_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                confirmDialog();
            }
        });

        phone_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });

    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
        builder.setTitle("Usunąć wpis " + co + " ?");
        builder.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(DeleteActivity.this);
                myDB.deleteOneRow(co);
//                Intent intent = new Intent(DeleteActivity.this, HistoryActivity.class);
//                startActivity(intent);
//                finish();
            }
        });
        builder.setNegativeButton("Może później", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    public void NavigateClick(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.maps");
        startActivity(launchIntent);
    }
}

