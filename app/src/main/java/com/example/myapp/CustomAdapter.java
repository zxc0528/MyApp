package com.example.myapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList wpis_id, wpis_co, wpis_gdzie, wpis_godz, wpis_zdj;

    int position;

    int[] image = {R.drawable.car_assistance,R.drawable.car_blacharz, R.drawable.car_elektryka, R.drawable.car_lakiernik,
            R.drawable.car_tyre, R.drawable.car_engine, R.drawable.car_skup, R.drawable.car_zawieszenie};

    CustomAdapter(Activity activity, Context context, ArrayList wpis_id, ArrayList wpis_co, ArrayList wpis_gdzie,
                  ArrayList wpis_godz, ArrayList wpis_zdj){
        this.activity = activity;
        this.context = context;
        this.wpis_id = wpis_id;
        this.wpis_co = wpis_co;
        this.wpis_gdzie = wpis_gdzie;
        this.wpis_godz = wpis_godz;
        this.wpis_zdj = wpis_zdj;
    }


    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.wpis_example, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)

    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.co.setText(String.valueOf(wpis_co.get(position)));
        holder.gdzie.setText(String.valueOf(wpis_gdzie.get(position)));
        String z = String.valueOf(wpis_zdj.get(position));
        int zz = Integer.parseInt(z);
        holder.imageview.setImageResource(image[zz]);
        holder.godzina.setText(String.valueOf(wpis_godz.get(position)));
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            public boolean onLongClick(View v) {
//                if (mOnLongItemClickListener != null) {
//                    mOnLongItemClickListener.ItemLongClicked(v, position);
//                }
//                return true;
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DeleteActivity.class);
                intent.putExtra("co", String.valueOf(wpis_co.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    public int getItemCount() {

        return wpis_co.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageview;
        TextView co, gdzie, godzina;
        RelativeLayout deleteLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.obrazek);
            co = itemView.findViewById(R.id.pole_co);
            gdzie = itemView.findViewById(R.id.pole_gdzie);
            godzina = itemView.findViewById(R.id.czas);
            deleteLayout = itemView.findViewById(R.id.deleteLayout);
            itemView.setOnClickListener(this);
        }

        public void onClick(View v) {

        }
    }

    onLongItemClickListener mOnLongItemClickListener;

    public void setOnLongItemClickListener(CustomAdapter.onLongItemClickListener onLongItemClickListener) {
        mOnLongItemClickListener = onLongItemClickListener;
    }

    public interface onLongItemClickListener {
        void ItemLongClicked(View v, int position);
    }

}

