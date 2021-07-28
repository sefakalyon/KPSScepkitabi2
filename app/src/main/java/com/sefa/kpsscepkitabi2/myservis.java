package com.sefa.kpsscepkitabi2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class myservis extends Service {
    private Handler h;
    Context context;



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        h=new Handler();
        h.postDelayed(rn,10*1000*3);
        Toast.makeText(myservis.this,"servis basladi",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private final Runnable rn=new Runnable() {
        @Override
        public void run() {
            myservis.this.h.postDelayed(rn,10*1000*3);
            //Toast.makeText(context, "servis devam ediyor", Toast.LENGTH_SHORT).show();
            SharedPreferences sp=getSharedPreferences("sayacuygu",MODE_PRIVATE);
            SharedPreferences.Editor e=sp.edit();
            e.putInt("bilgigetirsayac",40);
            e.commit();
        }
    };
}
