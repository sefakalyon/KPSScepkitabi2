package com.sefa.kpsscepkitabi2;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mongodb.client.MongoCursor;

import org.bson.Document;

import java.util.ArrayList;

import io.realm.mongodb.RealmResultTask;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class bildiklerim_syf_bilgigetir extends AppCompatActivity {
    ArrayList<String> secilenuniteverileri=new ArrayList<>();
    bilgigetirsyf b1=new bilgigetirsyf();

    Button anasayfa_bilgigetir_btn;
    Button butonanasyfa;
    Button button2;
    MongoClient mongoClient;
    MongoCollection mongoCollection;
    MongoDatabase mongoDatabase;
    MongoCursor mongoCursor;
    Button bilgigetirbuton;
    TextView bilgigetirsyf_anatextview;
    TextView metintut,textView5;
    Document document;
    User user;

    //userlists u1=new userlists();
    Button bilgigetirforkesin,basla;
    private veritabaniyardim vt;

    public int sayac=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bildiklerim_syf_bilgigetir);

        int gelenmesaj=getIntent().getIntExtra("bilgi2",0);
        basla=findViewById(R.id.bildklrmdn_cikar);
        bilgigetirforkesin=findViewById(R.id.bilgigetirforkesin);
        String appid = "application-0-tchbh";
        textView5=findViewById(R.id.textView5);
        

        //Toast.makeText(bilgigetirsyf.this,gelenmesaj,Toast.LENGTH_SHORT).show();
        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vt=new veritabaniyardim(bildiklerim_syf_bilgigetir.this);
                new verilerdao().kelimesil(vt,0,gelenmesaj,textView5.getText().toString());

                SQLiteDatabase dbx=vt.getReadableDatabase();
                Cursor c2 =dbx.rawQuery("SELECT count(*)   FROM veriler2",null) ;
                Toast.makeText(bildiklerim_syf_bilgigetir.this, ((Integer) c2.getColumnCount()).toString(), Toast.LENGTH_SHORT).show();
                vt.close();

                /*                Document queryfilter=new Document();
                if(gelenmesaj==0){
                    mongoCollection = mongoDatabase.getCollection("deneme_collection");
                    queryfilter=new Document().append("_unite","islamiyet_oncesi");


                }
                if(gelenmesaj==1){
                    mongoCollection = mongoDatabase.getCollection("İlk_Türk_İslam_devletleri");
                    queryfilter=new Document().append("_unite","ilk_Türk_islam_Devletleri");

                }




                if(gelenmesaj==2){
                    queryfilter=new Document().append("_ders","Tarih");
                }

                RealmResultTask<MongoCursor<Document>> findtask=mongoCollection.find(queryfilter).iterator();
                findtask.getAsync(task->{
                    String currentresult2;
                    if(task.isSuccess()){

                        io.realm.mongodb.mongo.iterable.MongoCursor
                                <Document> results= (io.realm.mongodb.mongo.iterable.MongoCursor<Document>) task.get();
                        while (results.hasNext()){
                            Document currentresult=results.next();
                            currentresult2=currentresult.getString("_bilgiicerik");
                            //Toast.makeText(bilgigetirsyf.this,currentresult2,Toast.LENGTH_SHORT).show();
                            secilenuniteverileri.add(currentresult2);

                        }
                        textView5.setText("("+secilenuniteverileri.size()+")");


                    }else{
                        //Toast.makeText(bilgigetirsyf.this,"failed",Toast.LENGTH_SHORT).show();

                    }
                });

                basla.setVisibility(View.INVISIBLE);*/
            }
        });


        bilgigetirforkesin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                // Toast.makeText(bildiklerim_syf_bilgigetir.this, b1.bildiklerimlist.get(0).toString(), Toast.LENGTH_SHORT).show();
                // int a =.getUserint();
                // textView5.setText(((Integer) a).toString());
                vt=new veritabaniyardim(bildiklerim_syf_bilgigetir.this);
                //new verilerdao().kelimeekle(vt,);

                ArrayList<userlists>gelenveri= new verilerdao().tumbilgiler(vt);
                Toast.makeText(bildiklerim_syf_bilgigetir.this, ((Integer) gelenveri.size()).toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(b1,gelenveri.getBildiklerimlistsql() , Toast.LENGTH_SHORT).show();
                ArrayList<String> geciciekle=new ArrayList<>();
                for (userlists u:gelenveri){
                    if(gelenmesaj==u.getUnitesi() ){
                        geciciekle.add(u.getBilgi_kendi());
                    }


                    //Toast.makeText(bildiklerim_syf_bilgigetir.this, ((Integer) u.getBildiklerimlistsql()).toString(), Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(bildiklerim_syf_bilgigetir.this, u8.toString(), Toast.LENGTH_LONG).show();
                //textView5.setText(secilenuniteverileri.get(Integer.valueOf( u.getBildiklerimlistsql())-1));
                //userlists geciciu=gelenveri.get(sayac);
                //textView5.setText(geciciekle.get(sayac));
                //Toast.makeText(bildiklerim_syf_bilgigetir.this, ((Integer) geciciu.getBildiklerimlistsql()).toString(), Toast.LENGTH_SHORT).show();
                //gelenveri.get(sayac);
                //sayac++;

                SharedPreferences sp = getSharedPreferences("sayacuygu", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                //int ss2=sp.getInt("bildiklerim_kts_toplam_unite1",0);

                if(gelenmesaj==0){

                    int bildiklerim_kts_unite1_sayac=sp.getInt("bildiklerim_kts_unite1_sayac",0);
                    bildiklerim_kts_unite1_sayac=bildiklerim_kts_unite1_sayac%geciciekle.size();
                    textView5.setText(geciciekle.get(bildiklerim_kts_unite1_sayac));
                    e.putInt("bildiklerim_kts_unite1_sayac",++bildiklerim_kts_unite1_sayac);
                    e.commit();

                }
                if(gelenmesaj==1){

                    int bildiklerim_kts_unite2_sayac=sp.getInt("bildiklerim_kts_unite2_sayac",0);
                    bildiklerim_kts_unite2_sayac=bildiklerim_kts_unite2_sayac%geciciekle.size();
                    textView5.setText(geciciekle.get(bildiklerim_kts_unite2_sayac));
                    e.putInt("bildiklerim_kts_unite2_sayac",++bildiklerim_kts_unite2_sayac);
                    e.commit();

                }




            }
        });



    }
}