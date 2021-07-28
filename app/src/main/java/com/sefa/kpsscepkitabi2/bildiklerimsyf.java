package com.sefa.kpsscepkitabi2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class bildiklerimsyf extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> bilgilerlist;
    private com.sefa.kpsscepkitabi2.adapter2 adapter2nesne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildiklerimsyf);
        recyclerView=findViewById(R.id.rv_for_bildiklerimsyf);
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


        adapter2nesne=new com.sefa.kpsscepkitabi2.adapter2(this,bilgilerlist);
        recyclerView.setAdapter(adapter2nesne);

    }
}