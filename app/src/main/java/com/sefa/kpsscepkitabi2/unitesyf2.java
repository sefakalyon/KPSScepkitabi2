package com.sefa.kpsscepkitabi2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class unitesyf2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> bilgilerlist;
    private adapter1 adapter1nesne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitesyf2);
        recyclerView=findViewById(R.id.rv_for_2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bilgilerlist=new ArrayList<>();
        bilgilerlist.add("İslamiyet öncesi Türk Tarihi");
        bilgilerlist.add("İlk Türk İslam Devletleri");
        bilgilerlist.add("Türkiye(Anadolu) Selçuklu devleti");
        bilgilerlist.add("Osmanlı Devleti Kuruluş Dönemi");
        bilgilerlist.add("Osmanlı Devleti Yükselme Dönemi");
        bilgilerlist.add("Osmanlı Devleti Duraklama Dönemi");
        bilgilerlist.add("Osmanlı Devleti Gerileme Dönemi");
        bilgilerlist.add("Osmanlı Devleti Dağılma Dönemi");
        bilgilerlist.add("Osmanlı Devleti Kültür ve Uygarlık");
        bilgilerlist.add("İnkılap Tarihi");
        bilgilerlist.add("Atatürk İlkeleri");
        bilgilerlist.add("Atatürk Dönemi Türk Dış Politikası");
        bilgilerlist.add("Cumhuriyet Dönemi Kültür ve Medeniyet");
        bilgilerlist.add("Çağdaş Türk ve Dünya Tarihi");

        adapter1nesne=new adapter1(this,bilgilerlist);
        recyclerView.setAdapter(adapter1nesne);


    }
}