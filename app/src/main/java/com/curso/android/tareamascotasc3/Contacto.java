package com.curso.android.tareamascotasc3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.curso.android.tareamascotasc3.executables.Email;

public class Contacto extends AppCompatActivity {

    TextView tvMail;
    TextView tvNombre;
    TextView tvMensaje;
    Button btnFavorito;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        tvMail = (TextView) findViewById(R.id.tvCorreo);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        btnFavorito = (Button) actionBar.findViewById(R.id.btnFavorito);
        btnFavorito.setVisibility(View.INVISIBLE);
    }

    public void enviarMail(View view) {
        String email = tvMail.getText().toString().trim();
        String subject = tvNombre.getText().toString().trim();
        String message = tvMensaje.getText().toString().trim();

        Email mail = new Email(this, email, subject,message);
        mail.execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent activity = new Intent(Contacto.this, MainActivity.class);
                startActivity(activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
