package com.example.makanan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   // private String [] dataMenu={"Sate", "Soto", "Nasi Goreng", "Bakso","Mie Goreng"};
private  MenuAdapter menuadapter;
private RecyclerView mRecyclerview;
private  ArrayList<Menu> menus;
private RequestQueue mrequest;
int jumData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview = findViewById(R.id.lv_list);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        menus = new ArrayList<>();
        mrequest = Volley.newRequestQueue(this);
        parseJSON();
    }

//        ListView lvlist= findViewById(R.id.lv_list);
//        adapter=new MenuAdapter(this);
//        lvlist.setAdapter(adapter);
//
//        prepare();
//        tambahitem();
//
//        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                Menu menu = new Menu();
//                menu.setNama(menus.get(i).getNama());
//                menu.setDeskripsi(menus.get(i).getDeskripsi());
//                menu.setGambar(menus.get(i).getGambar());
//
//
//               Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailActivity.class);
//                moveWithObjectIntent.putExtra(DetailActivity.Menu, menu);
//                startActivity(moveWithObjectIntent);




    private void parseJSON() {
        String url="https://jsonabdi.000webhostapp.com/koneksi.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jumData = response.length();
                        try {
                           // JSONObject jsonArray = new JSONObject(response);
                            for (int i = 0; i <jumData; i++) {
                                JSONObject hit = response.getJSONObject(i);
                                String gambarmenu = hit.getString("gambar");
                                String namamenu = hit.getString("nama");
                                String telpnmenu = hit.getString("harga");
                                menus.add(new Menu(gambarmenu, namamenu, telpnmenu));
                             //   Picasso.get().load(gambarmenu).fit().centerInside().into(.gambar);

                            }
                            menuadapter = new MenuAdapter(MainActivity.this, menus);
                            mRecyclerview.setAdapter(menuadapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        mrequest.add(request);
    }
    }

//    }
//    private void prepare(){
//        dataNama=getResources().getStringArray(R.array.data_menu);
//        dataDes=getResources().getStringArray(R.array.data_deskripsi);
//        dataGambar=getResources().obtainTypedArray(R.array.data_gambar);
//    }
//    private void tambahitem(){
//        menus = new ArrayList<>();
//
//        for (int i=0; i<dataNama.length; i++){
//            Menu menu =new Menu();
//            menu.setGambar(dataGambar.getResourceId(i, -1));
//            menu.setNama(dataNama[i]);
//            menu.setDeskripsi(dataDes[i]);
//            menus.add(menu);
//        }
//        adapter.setMenus(menus);
//    }
//}
