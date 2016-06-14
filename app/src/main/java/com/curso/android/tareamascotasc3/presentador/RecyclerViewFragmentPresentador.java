package com.curso.android.tareamascotasc3.presentador;

import android.content.Context;

import com.curso.android.tareamascotasc3.db.ConstructorMascotas;
import com.curso.android.tareamascotasc3.pojos.Mascota;
import com.curso.android.tareamascotasc3.vista.fragments.IRecyclerViewFragment;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 13/06/2016.
 */
public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresentador{

    private IRecyclerViewFragment iRecyclerViewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresentador(IRecyclerViewFragment iRecyclerViewFragment, Context context){
        this.iRecyclerViewFragment = iRecyclerViewFragment;
        this.context = context;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();

        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragment.inicializarAdaptadorRV(iRecyclerViewFragment.crearAdaptador(mascotas));
        iRecyclerViewFragment.generarLinearLayoutGrid();
    }
}
