package com.example.makanan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter <MenuAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Menu> menus ;


    public  MenuAdapter(Context mcontext, ArrayList <Menu> menumakanan){
        context = mcontext;
        menus= menumakanan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.item_menu,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Menu menubaru = menus.get(position);

    String gambarku= menubaru.getGambar();
    String deskripsi = menubaru.getDeskripsi();
    String Nama= menubaru.getNama();

    holder.tvnama.setText(Nama);
    holder.tvDes.setText(deskripsi);
//   Picasso.get().load(gambarku).fit().centerInside().into(holder.gambar);
        //Picasso.get().load(gambarku).into(holder.gambar);
      //  Glide.with().load("http://goo.gl/gEgYUd").into(holder.gambar);
        //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.gambar);
        Glide
                .with(context)
                .load(gambarku)
                .centerCrop()
               .into(holder.gambar);
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }

    public   class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvnama;
        public   TextView tvDes;
        public ImageView gambar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar=itemView.findViewById(R.id.image_view);
            tvDes=itemView.findViewById(R.id.tv_des);
            tvnama=itemView.findViewById(R.id.tv_menu);
        }
    }
}
