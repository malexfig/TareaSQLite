package com.curso.android.tareamascotasc3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotas;

    Button botonFavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle("");

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        if(getIntent().getParcelableArrayListExtra("mascotas") != null)
            mascotas = getIntent().getParcelableArrayListExtra("mascotas");
        else
            cargarMascotas();

        if(getIntent().getParcelableArrayListExtra("mascotasFavoritas") != null)
            mascotasFavoritas = getIntent().getParcelableArrayListExtra("mascotasFavoritas");
        else
            mascotasFavoritas = new ArrayList<>();

        inicializarAdaptador();

        botonFavorito = (Button)findViewById(R.id.btnFavorito);
        botonFavorito.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent actividadFavoritas = new Intent(MainActivity.this, Main2Activity.class);
                actividadFavoritas.putExtra("mascotas", mascotas);
                actividadFavoritas.putExtra("mascotasFavoritas", mascotasFavoritas);
                startActivity(actividadFavoritas);
            }
        });

    }

    private void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, mascotasFavoritas);
        listaMascotas.setAdapter(adaptador);
    }

    private void cargarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.m1, "perrito", 0, R.drawable.hueso, R.drawable.huesoamarillo));
        mascotas.add(new Mascota(R.drawable.m2, "cachorro", 0, R.drawable.hueso, R.drawable.huesoamarillo));
        mascotas.add(new Mascota(R.drawable.m3, "doberman", 0, R.drawable.hueso, R.drawable.huesoamarillo));
        mascotas.add(new Mascota(R.drawable.m4, "caballo", 0, R.drawable.hueso, R.drawable.huesoamarillo));
        mascotas.add(new Mascota(R.drawable.m5, "gato", 0, R.drawable.hueso, R.drawable.huesoamarillo));
    }
}
