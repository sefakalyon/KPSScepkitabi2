package com.sefa.kpsscepkitabi2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mongodb.DBRef;
import com.mongodb.client.MongoCursor;

import org.bson.Document;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.RealmResultTask;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class bilgigetirsyf extends AppCompatActivity {

    private ArrayList<String> bilgilerlist2;
    public String buradayim;
    public ArrayList<Integer> bildiklerimlist=new ArrayList<>();
    //userlists userlists=new userlists();
    ArrayList<String> secilenuniteverileri=new ArrayList<>();
    Button anasayfa_bilgigetir_btn;
    Button butonanasyfa;
    Button button2;
    private veritabaniyardim vt;
    MongoClient mongoClient;
    MongoCollection mongoCollection;
    MongoDatabase mongoDatabase;
    MongoCursor mongoCursor;
    Button bilgigetirbuton;
    TextView bilgigetirsyf_anatextview;
    TextView metintut,textView4,textView6;
    Document document;
    User user;
    Button bilgigetirsyfbaslabuton,bilgisyfbilgigetirbtn,bildigimeklebtn;

    public int sayac=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgigetirsyf);


        bilgilerlist2=new ArrayList<>();
        bilgilerlist2.add("İslamiyet öncesi Türk Tarihi");
        bilgilerlist2.add("İlk Türk İslam Devletleri");
        bilgilerlist2.add("Türkiye(Anadolu) Selçuklu devleti");
        bilgilerlist2.add("Osmanlı Devleti Kuruluş Dönemi");
        bilgilerlist2.add("Osmanlı Devleti Yükselme Dönemi");
        bilgilerlist2.add("Osmanlı Devleti Duraklama Dönemi");
        bilgilerlist2.add("Osmanlı Devleti Gerileme Dönemi");
        bilgilerlist2.add("Osmanlı Devleti Dağılma Dönemi");
        bilgilerlist2.add("Osmanlı Devleti Kültür ve Uygarlık");
        bilgilerlist2.add("İnkılap Tarihi");
        bilgilerlist2.add("Atatürk İlkeleri");
        bilgilerlist2.add("Atatürk Dönemi Türk Dış Politikası");
        bilgilerlist2.add("Cumhuriyet Dönemi Kültür ve Medeniyet");
        bilgilerlist2.add("Çağdaş Türk ve Dünya Tarihi");
        int gelenmesaj=getIntent().getIntExtra("bilgi2",0);
        textView6=findViewById(R.id.textView6);
        textView6.setText("Konu: "+bilgilerlist2.get(gelenmesaj));
        bilgigetirsyf_anatextview=findViewById(R.id.bilgigetirsyf_anatextview);
        bilgigetirsyfbaslabuton=findViewById(R.id.bilgigetirsyfbaslabuton);
        String appid = "application-0-tchbh";
        bilgisyfbilgigetirbtn=findViewById(R.id.bilgisyfbilgigetirbtn);
        textView4=findViewById(R.id.textView4);
        bildigimeklebtn=findViewById(R.id.bildigimeklebtn);

        //
        // bilgisyfbilgigetirbtn.setVisibility(View.INVISIBLE);
        //userlists=new userlists(userlists.getKesinbildiklerimlist2());
        Realm.init(bilgigetirsyf.this);
        App app1 = new App(new AppConfiguration.Builder(appid).build());
        //Credentials cred = Credentials.emailPassword("sefakalyon5555@gmail.com", "Sefa12345!");

        app1.loginAsync(Credentials.anonymous(), new App.Callback<User>() {
            @Override
            public void onResult(App.Result<User> result) {
                if (result.isSuccess()) {
                    Toast.makeText(bilgigetirsyf.this, "basarili giris", Toast.LENGTH_SHORT).show();
                    user = app1.currentUser();
                    mongoClient=user.getMongoClient("mongodb-atlas");
                    mongoDatabase = mongoClient.getDatabase("deneme_veriseti");
                    //mongoCollection = mongoDatabase.getCollection("İlk_Türk_İslam_devletleri");

                } else {
                    Toast.makeText(bilgigetirsyf.this, "basarisiz giriş", Toast.LENGTH_SHORT).show();

                }

            }

        });

        //Toast.makeText(bilgigetirsyf.this,gelenmesaj,Toast.LENGTH_SHORT).show();
        bilgigetirsyfbaslabuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Document queryfilter=new Document();
                if(gelenmesaj==0){
                    mongoCollection = mongoDatabase.getCollection("deneme_collection");
                    queryfilter=new Document().append("_unite","islamiyet_oncesi");


                }
                else if(gelenmesaj==1){
                    mongoCollection = mongoDatabase.getCollection("İlk_Türk_İslam_devletleri");
                    queryfilter=new Document().append("_unite","ilk_Türk_islam_Devletleri");

                }
                else if(gelenmesaj==2){
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



                    }else{
                        Toast.makeText(bilgigetirsyf.this,"failed",Toast.LENGTH_SHORT).show();

                    }

                });
                //textView4.setText("("+secilenuniteverileri.size()+")");
                //bilgigetirsyfbaslabuton.setVisibility(View.INVISIBLE);
                //bilgisyfbilgigetirbtn.setVisibility(View.VISIBLE);
            }
        });


        bilgisyfbilgigetirbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp = getSharedPreferences("sayacuygu", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                int ss = sp.getInt("bilgigetirsayac", 0);
                if (ss == 0) {
                    Toast.makeText(bilgigetirsyf.this, "Günlük kullanım hakkınızı doldurdunuz. Bu sınırlamanın asıl sebebi uygulamayı daha efektif bi şekilde kullanmanızı istememizdir.", Toast.LENGTH_LONG).show();

                } else {



                    e.putInt("bilgigetirsayac", --ss);
                    e.commit();

                    textView4.setText("günlük kalan hak "+((Integer) sp.getInt("bilgigetirsayac", 0)).toString());


                    //sayac++;
                    if(gelenmesaj==0){



                        int unite1sayac = sp.getInt("unite1sayac", 0);
                        unite1sayac=unite1sayac%secilenuniteverileri.size();
                        bilgigetirsyf_anatextview.setText(secilenuniteverileri.get(unite1sayac));

                        e.putInt("unite1sayac",++unite1sayac);
                        e.commit();
                        bilgisyfbilgigetirbtn.setText("BİLGİ GETİR  "+"("+((Integer) sp.getInt("bilgigetirsayac", 0)).toString()+")");
                        textView6.setText(bilgilerlist2.get(gelenmesaj)  +" "+"("+unite1sayac+"/"+secilenuniteverileri.size()+")");
                        int unite1tamamlanantur = sp.getInt("unite1tamamlanantur", 0);
                        if (unite1sayac==secilenuniteverileri.size()){
                            e.putInt("unite1tamamlanantur",++unite1tamamlanantur);
                            e.commit();

                        }

                        sp.getInt("unite1toplambilgi",0);
                        e.putInt("unite1toplambilgi",secilenuniteverileri.size());
                        e.commit();


                    }
                    if(gelenmesaj==1){

                        int unite2sayac = sp.getInt("unite2sayac", 0);
                        unite2sayac=unite2sayac%secilenuniteverileri.size();
                        bilgigetirsyf_anatextview.setText(secilenuniteverileri.get(unite2sayac));
                        e.putInt("unite2sayac",++unite2sayac);
                        e.commit();
                        bilgisyfbilgigetirbtn.setText("BİLGİ GETİR  "+"("+((Integer) sp.getInt("bilgigetirsayac", 0)).toString()+")");
                        textView6.setText(bilgilerlist2.get(gelenmesaj)  +" "+"("+unite2sayac+"/"+secilenuniteverileri.size()+")");


                    }
                    //textView6.setText(((Integer) sp.getInt("unite1sayac", 0)).toString());
                    /*if(sayac==secilenuniteverileri.size()){

                    }*/
                }
            }
        });

        bildigimeklebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sayac2= ((Integer) sayac).toString();
                Toast.makeText(bilgigetirsyf.this, sayac2, Toast.LENGTH_SHORT).show();
                bildiklerimlist.add(sayac);
                //userlists.setUserint(sayac);
                vt=new veritabaniyardim(bilgigetirsyf.this);
                new verilerdao().kelimeekle(vt,0,gelenmesaj,bilgigetirsyf_anatextview.getText().toString());

                SharedPreferences sp = getSharedPreferences("sayacuygu", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                if(gelenmesaj==0){

                    int ss2=sp.getInt("bildiklerim_kts_toplam_unite1",0);
                    e.putInt("bildiklerim_kts_toplam_unite1",++ss2);
                    e.commit();

                }
                if(gelenmesaj==1){

                    int ss2=sp.getInt("bildiklerim_kts_toplam_unite2",0);
                    e.putInt("bildiklerim_kts_toplam_unite2",++ss2);
                    e.commit();

                }

            }
        });




    }

}