package com.curso.android.tareamascotasc3.db;

import android.content.Context;

import com.curso.android.tareamascotasc3.R;
import com.curso.android.tareamascotasc3.pojos.Foto;
import com.curso.android.tareamascotasc3.pojos.Mascota;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 13/06/2016.
 */
public class ConstructorFotosMascota {
    Context context;

    public ConstructorFotosMascota(Context context) {
        this.context = context;
    }

    public ArrayList<Foto> obtenerDatos() {

        ArrayList<Foto> fotos = new ArrayList<>();

        fotos.add(new Foto(3, R.drawable.m1));
        fotos.add(new Foto(8, R.drawable.m1));
        fotos.add(new Foto(10, R.drawable.m1));
        fotos.add(new Foto(2, R.drawable.m1));
        fotos.add(new Foto(1, R.drawable.m1));

        return fotos;
    }
}
