package com.curso.android.tareamascotasc3.vista.fragments;

import com.curso.android.tareamascotasc3.adapters.FotoAdaptador;
import com.curso.android.tareamascotasc3.adapters.MascotaAdaptador;
import com.curso.android.tareamascotasc3.pojos.Foto;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 13/06/2016.
 */
public interface IRVFotosMascotaFragment {
    public void generarLinearLayoutGrid();
    public FotoAdaptador crearAdaptador(ArrayList<Foto> fotos);
    public void inicializarAdaptadorRV(FotoAdaptador adaptador);
}
