package com.example.petagram_master;


import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<DataSet> mascotas;
    private RecyclerView listadoMascotas;
    Toolbar toolbar;
    private ImageButton estrella;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        listadoMascotas = (RecyclerView) findViewById(R.id.rvMascotas1);
        estrella = (ImageButton) findViewById(R.id.estrella);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listadoMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListadoMascotas.class);
                startActivity(intent);

            }
        });




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Proximamente add Fotos", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public MascotasAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotasAdaptador(mascotas,this);
        listadoMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<DataSet>();

        mascotas.add(new DataSet("Roco","3",R.drawable.perro2));
        mascotas.add(new DataSet("Floki","4",R.drawable.perro5));
        mascotas.add(new DataSet("Bella","15",R.drawable.perro3));
        mascotas.add(new DataSet("Roxi","4",R.drawable.perro4));
    }

}


