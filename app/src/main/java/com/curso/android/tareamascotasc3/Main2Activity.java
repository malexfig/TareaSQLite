package com.curso.android.tareamascotasc3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    Button btnFavorito;
    private RecyclerView listaMascotasFavorias;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> mascotasFavoritas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        btnFavorito = (Button) actionBar.findViewById(R.id.btnFavorito);
        btnFavorito.setVisibility(View.INVISIBLE);

        listaMascotasFavorias = (RecyclerView) findViewById(R.id.rvMascotas2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        llm.setReverseLayout(true);
        llm.setStackFromEnd(true);

        listaMascotasFavorias.setLayoutManager(llm);

        mascotas = getIntent().getParcelableArrayListExtra("mascotas");
        mascotasFavoritas = getIntent().getParcelableArrayListExtra("mascotasFavoritas");

        if (mascotasFavoritas != null)
            inicializarAdaptador();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent activity = new Intent(Main2Activity.this, MainActivity.class);
                activity.putExtra("mascotas", mascotas);
                activity.putExtra("mascotasFavoritas", mascotasFavoritas);
                startActivity(activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarAdaptador() {
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotasFavoritas, mascotasFavoritas);
        listaMascotasFavorias.setAdapter(mascotaAdaptador);
    }

}
