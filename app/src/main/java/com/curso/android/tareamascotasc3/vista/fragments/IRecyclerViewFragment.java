package com.curso.android.tareamascotasc3.vista.fragments;

import com.curso.android.tareamascotasc3.adapters.MascotaAdaptador;
import com.curso.android.tareamascotasc3.pojos.Mascota;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 13/06/2016.
 */
public interface IRecyclerViewFragment {

    public void generarLinearLayoutGrid();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
