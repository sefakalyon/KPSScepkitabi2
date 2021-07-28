package com.sefa.kpsscepkitabi2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mongodb.client.MongoCursor;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import io.realm.mongodb.User;
import io.realm.mongodb.mongo.MongoClient;
import io.realm.mongodb.mongo.MongoCollection;
import io.realm.mongodb.mongo.MongoDatabase;

public class adapter2 extends RecyclerView.Adapter<adapter2.Cardviewtasarim> {
    private Context mContext;
    private List<String> disaridangelenveri;
    public String buradayim;
    ArrayList<String> secilenuniteverileri = new ArrayList<>();
    Button anasayfa_bilgigetir_btn;
    Button butonanasyfa;
    Button button2;
    MongoClient mongoClient;
    MongoCollection mongoCollection;
    MongoDatabase mongoDatabase;
    MongoCursor mongoCursor;
    Button bilgigetirbuton;
    TextView bilgigetirsyf_anatextview;
    TextView metintut;
    Document document;
    User user;

    public adapter2(Context mContext, List<String> disaridangelenveri) {
        this.mContext = mContext;
        this.disaridangelenveri = disaridangelenveri;
    }

    @NonNull

    @Override
    public Cardviewtasarim onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemviev = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.cardviewforunite2, parent, false);
        return new Cardviewtasarim(itemviev);
    }

    @Override
    public void onBindViewHolder(Cardviewtasarim holder, int position) {
        final String bilgi = disaridangelenveri.get(position);
        final int bilgi2 = position;
        holder.satiryazi.setText(bilgi);
        holder.satircardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(mContext, bilgi, Toast.LENGTH_SHORT).show();


                Intent gotobilgigetirsyfsi = new Intent(mContext, bildiklerim_syf_bilgigetir.class);
                gotobilgigetirsyfsi.putExtra("bilgi2",bilgi2);
                mContext.startActivity(gotobilgigetirsyfsi);


            }
        });

    }


    @Override
    public int getItemCount() {
        return disaridangelenveri.size();
    }

    public class Cardviewtasarim extends RecyclerView.ViewHolder {
        public TextView satiryazi;
        public CardView satircardview1;

        public Cardviewtasarim(View view) {
            super(view);
            satiryazi = view.findViewById(R.id.textView1);
            satircardview1 = view.findViewById(R.id.cardview1);

        }
    }
}
