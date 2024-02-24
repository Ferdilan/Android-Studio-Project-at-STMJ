package com.ferdilan.perekam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ferdilan.perekam.Adapters.ViewPagerAdapter;
import com.ferdilan.perekam.Fragments.RecorderFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    MediaPlayer realme, suarakuberharap, suratAnNas;
    String [] lagu = {"Realme", "SuaraKuBerharap", "SuratAnNas"};
    int urutanDiPilih;

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        setSupportActionBar(toolbar);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        realme = MediaPlayer.create(this, R.raw.realme);
        suarakuberharap = MediaPlayer.create(this, R.raw.suarakuberharap);
        suratAnNas = MediaPlayer.create(this, R.raw.suratannas);

        ListView listLagu = findViewById(R.id.listLagu);
        ArrayAdapter ada = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lagu);

        Button play = findViewById(R.id.btnPlay);
        play.setOnClickListener(new View.onClickListener(){
            public void onClick(View v){

            }
        });


    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new RecorderFragment(), "Recorder");
        viewPagerAdapter.addFragment(new RecorderFragment(), "Recordings");
        viewPager.setAdapter(viewPagerAdapter);
    }
}