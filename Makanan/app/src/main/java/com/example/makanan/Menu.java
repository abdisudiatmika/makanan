package com.example.makanan;

import android.os.Parcel;
import android.os.Parcelable;

public class Menu  {
    private String gambar;
    private String nama;
    private String Deskripsi;

    public Menu(String datagambar, String datanama, String DataDeskripsi) {
        gambar = datagambar;
        nama = datanama;
        Deskripsi = DataDeskripsi;
    }

    public String getGambar() {
         return gambar;
     }


     public String getNama() {
         return nama;
     }


     public String getDeskripsi() {
         return Deskripsi;
     }


      }

