package com.ferdilan.javaarray;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    MediaPlayer realme, suarakuberharap, suratAnNas;
    String [] lagu = {"Realme", "SuaraKuBerharap", "SuratAnNas"};
    int urutanDiPilih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realme = MediaPlayer.create(this, R.raw.realme);
        suarakuberharap = MediaPlayer.create(this, R.raw.suarakuberharap);
        suratAnNas = MediaPlayer.create(this, R.raw.suratannas);


        Spinner spinLagu = findViewById(R.id.spinnerLagu);
        ArrayAdapter ada = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lagu);
        spinLagu.setDropDownWidth(350);
        spinLagu.setAdapter(ada);

        spinLagu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int urutan, long id) {
                urutanDiPilih = urutan;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        Button play = findViewById(R.id.btnPlay);
         play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (urutanDiPilih) {
                    case 1:
                        realme.start();
                        break;
                    case 2:
                        suarakuberharap.start();
                        break;
                    case 3:
                        suratAnNas.start();
                        break;
                }
            }
        });
    }
}