package com.sefa.kpsscepkitabi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kutularim extends AppCompatActivity {

    private Button bildiklerim_kutusu_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kutularim);

        bildiklerim_kutusu_btn=findViewById(R.id.bildiklerim_kutusu_btn);
        bildiklerim_kutusu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(kutularim.this,bildiklerimsyf.class));

            }
        });
    }
}