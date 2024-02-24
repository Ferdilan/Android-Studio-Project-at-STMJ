package com.ferdilan.tesferdilan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

public class SettingActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    String[] subjects = {
            "Instagram","WhatsApp","Line","Gojek","Bibit","Ajaib","Stockbit",
            "Doulingo","Traveloka","Pinterest","Paper Plane","BBRI","BBNI","DMAS",
            "ADHI","BUMI","UTJY","GOTO","","PUPR","WIKA",
            "Taruna","STMJ","Sterida","Smea","Smaza","Smada","Smaga"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        context = getApplicationContext();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new AdapterRecyclerView(context, subjects);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}