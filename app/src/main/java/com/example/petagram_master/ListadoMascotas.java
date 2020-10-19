package com.example.petagram_master;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity {

    private ArrayList<DataSet> mascotas;
    private RecyclerView listadoMascotas;
    Toolbar toolbar;
    private TextView titleToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listado_mascotas);

        listadoMascotas = (RecyclerView) findViewById(R.id.rvMascotas1);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listadoMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
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
