package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String Menu = "menu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView tvnama = findViewById(R.id.tv_nama);
        TextView tvdes =findViewById(R.id.tv_des);
        ImageView immenu=findViewById(R.id.img_menu);

        Menu menu = getIntent().getParcelableExtra(Menu);
        tvnama.setText(menu.getNama());
        tvdes.setText(menu.getDeskripsi());
       // immenu.setImageResource(menu.getGambar());
    }
}
