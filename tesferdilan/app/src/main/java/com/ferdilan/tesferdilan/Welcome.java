package com.ferdilan.tesferdilan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;

public class Welcome extends AppCompatActivity {

    Button btnKeluar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnKeluar = (Button) findViewById(R.id.btnKeluar);

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new
                        Intent(Welcome.this, MainActivity.class);
                Welcome.this.startActivity(intent);
                finish();
            }
        });
    }

    //UNTUK MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //untuk intent menu ditaruh disini
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.tentang) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (item.getItemId() == R.id.bantuan) {
            startActivity(new Intent(this, HelpActivity.class));
        } else if (item.getItemId() == R.id.pengaturan){
            startActivity(new Intent(this, SettingActivity.class));
        }
        return true;
    }
    //MENU SAMPAI SINI


}