package com.curso.android.tareamascotasc3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.curso.android.tareamascotasc3.R;

public class AcercaDe extends AppCompatActivity {
    Button btnFavorito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        btnFavorito = (Button) actionBar.findViewById(R.id.btnFavorito);
        btnFavorito.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent activity = new Intent(AcercaDe.this, MainActivity.class);
                startActivity(activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
