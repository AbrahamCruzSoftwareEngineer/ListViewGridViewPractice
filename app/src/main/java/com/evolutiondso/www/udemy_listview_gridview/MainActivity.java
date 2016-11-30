package com.evolutiondso.www.udemy_listview_gridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    private Button btnGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Primero hacemos el casting del listview con una referencia R
        listView = (ListView) findViewById(R.id.MyListView);

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
        names.add("ELDANIII");
        //Necesitamos un adaptador en este caso como es un array ya hay uno definido en android ArrayAdapter
        //Este era para un caso sencillo sin xml layout
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);

        //Ahora unimos el listview con el adapter
        //Este era para un caso sencillo sin xml layout
        //listView.setAdapter(adapter);

        //vamos a setear el onclick item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //cambie el i y l por position y id
                Toast.makeText(MainActivity.this, "Click en pos: "+position+" id: "+id, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "pos: "+names.get(position)+" asi hago referencia a la lista no al listview", Toast.LENGTH_LONG).show();
            }
        });

        //ESTO ES DONDE SE ENLAZA Y USA EL ADAPTER
        MyAdapter myAdapter = new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);
        //ESTO ES DONDE SE ENLAZA Y USA EL ADAPTER
        MyAdapterViewHolder myAdapterViewHolder = new MyAdapterViewHolder(this,R.layout.list_item,names);
        listView.setAdapter(myAdapterViewHolder);

        btnGrid = (Button) findViewById(R.id.goGridViewBtn);
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, GreedViewActivity.class);
                startActivity(i);
            }
        });

    }
}

//como truco para generar adaptador escribi esto: public class MyAdapter extends BaseAdapter{ en el mainactivity