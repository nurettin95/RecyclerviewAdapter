package com.nurettingorsoy.recyclerviewadapter.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.nurettingorsoy.recyclerviewadapter.Adapter.ManzaraAdapter;
import com.nurettingorsoy.recyclerviewadapter.Model.Manzara;
import com.nurettingorsoy.recyclerviewadapter.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    ManzaraAdapter manzaraAdapter;
    List<Manzara> manzara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        manzara = new ArrayList<>();
        /*
        int imageurl, String baslik, String tanim
         */
manzara.add(new Manzara("https://www.gezgez.net/wp-content/uploads/2019/05/Manavgat-S%CC%A7elalesi.jpg","Antalya","Manavgat Şelalesi"));
manzara.add(new Manzara("https://gezilmesigerekenyerler.com/wp-content/uploads/2014/04/kizkalesi-011-e1415779866200.jpg","Mersin","Kız Kulesi"));
manzara.add(new Manzara("https://gezimanya.com/sites/default/files/styles/800x600_/public/gezi-notu/2019-11/image-basliksiz-7.jpg","İstanbul","Galata kulesi"));
manzara.add(new Manzara("https://www.kulturportali.gov.tr/repoKulturPortali/large/02072013/15ac83b7-9ae7-47f5-8ac7-7902c57626c4.JPG?format=jpg&quality=50","İzmir","Saat kulesi"));
manzara.add(new Manzara("https://i4.hurimg.com/i/hurriyet/75/750x422/5b72d16dc03c0d1b60aa005c.jpg","Muğla","Akyaka"));
manzara.add(new Manzara("https://static.daktilo.com/sites/298/uploads/2018/06/21/19248-2.jpg","Aydın","KuşAdası"));

        manzaraAdapter = new ManzaraAdapter(manzara,this);
        recyclerView.setAdapter(manzaraAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        switch(id){
            case R.id.linearViewHorizontal:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                break;

            case R.id.linearViewVertical:
                LinearLayoutManager linearLayoutManagerVertical = new LinearLayoutManager(this);
                linearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManagerVertical);
                break;
            case R.id.gridView:
                GridLayoutManager mGridLayoutManager  = new GridLayoutManager(this,3);
                recyclerView.setLayoutManager(mGridLayoutManager);
            case R.id.stagferedeViewHorizontal:
                StaggeredGridLayoutManager mstaggeredHorizontalGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(mstaggeredHorizontalGridLayoutManager);
                break;
            case R.id.stagferedeViewVertical:
                StaggeredGridLayoutManager mstaggeredVerticalGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(mstaggeredVerticalGridLayoutManager);
                break;
                default:
        }


        return super.onOptionsItemSelected(item);
    }
}