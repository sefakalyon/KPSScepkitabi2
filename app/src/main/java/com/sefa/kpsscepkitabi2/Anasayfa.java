package com.sefa.kpsscepkitabi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Anasayfa extends AppCompatActivity {
    Button anasyfbilgigtrbtn,kayitliktlrmbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        anasyfbilgigtrbtn=findViewById(R.id.anasyfbilgigtrbtn);
        kayitliktlrmbtn=findViewById(R.id.kayitliktlrmbtn);

        kayitliktlrmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Anasayfa.this,kutularim.class));
            }
        });

        anasyfbilgigtrbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Anasayfa.this,unitesyf2.class));

            }
        });
    }
}