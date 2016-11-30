package com.evolutiondso.www.udemy_listview_gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GreedViewActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greed_view);

        //Primero hacemos el casting del listview con una referencia R
        gridView = (GridView) findViewById(R.id.GridView);

        //Generamos una lista de strings (para el ejemplo)
        names = new ArrayList<String>();
        names.add("Linux");
        names.add("Android");
        names.add("Windows");
        names.add("iOS");
        names.add("Linux");
        names.add("Android");
        names.add("Windows");
        names.add("iOS");
        names.add("Linux");
        names.add("Android");
        names.add("Windows");
        names.add("iOS");
        names.add("Linux");
        names.add("Android");
        names.add("Windows");
        names.add("iOS");

        //vamos a setear el onclick item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //cambie el i y l por position y id
                Toast.makeText(GreedViewActivity.this, "Click en pos: "+position+" id: "+id, Toast.LENGTH_SHORT).show();
                Toast.makeText(GreedViewActivity.this, "pos: "+names.get(position)+" asi hago referencia a la lista no al listview", Toast.LENGTH_LONG).show();
            }
        });

        //ESTO ES DONDE SE ENLAZA Y USA EL ADAPTER
        MyAdapter myAdapter = new MyAdapter(this,R.layout.list_item,names);
        gridView.setAdapter(myAdapter);
        //ESTO ES DONDE SE ENLAZA Y USA EL ADAPTER
        MyAdapterViewHolder myAdapterViewHolder = new MyAdapterViewHolder(this,R.layout.list_item,names);
        gridView.setAdapter(myAdapterViewHolder);



    }
}
