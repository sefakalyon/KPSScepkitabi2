package com.sefa.kpsscepkitabi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.client.MongoCursor;

import org.bson.Document;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.mongodb.App;
import io.realm.mongodb.AppConfiguration;
import io.realm.mongodb.Credentials;
import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class MainActivity extends AppCompatActivity {
    private Button girisyapbtn,kayitolbtn;
    private EditText girissyfedittext1,girissyfedittext2;
    MongoClient mongoClient;
    MongoCollection mongoCollection;
    MongoDatabase mongoDatabase;
    MongoCursor mongoCursor;
    Button anasayfa_bilgi_kutusu,anasayfa_bilgigetir2;
    TextView metintut;
    Document document;
    User user;
    ArrayList<String> secilenuniteverileri=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String appid = "application-0-tchbh";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(MainActivity.this,myservis.class));

        SharedPreferences sp = getSharedPreferences("sayacuygu", MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        int unite1sayac = sp.getInt("unite1sayac", 0);


        girisyapbtn=findViewById(R.id.girisyapbtn);
        kayitolbtn=findViewById(R.id.kayitolbtn);
        girissyfedittext1=findViewById(R.id.girissyfedittext1);
        girissyfedittext2=findViewById(R.id.girissyfedittext2);

        Realm.init(this);
        girisyapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                App app1 = new App(new AppConfiguration.Builder(appid).build());

                Toast.makeText(MainActivity.this,app1.currentUser().getId().toString() , Toast.LENGTH_SHORT).show();
                app1.currentUser().getId();
                app1.loginAsync(Credentials.anonymous(), new App.Callback<User>() {
                    @Override
                    public void onResult(App.Result<User> result) {
                        if(result.isSuccess()){
                            Toast.makeText(MainActivity.this, "basarili giris", Toast.LENGTH_SHORT).show();

                        }else{

                        }

                    }
                });

                startActivity(new Intent(MainActivity.this,Anasayfa.class));
            }
        });



    }
}