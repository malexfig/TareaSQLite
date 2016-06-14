package com.curso.android.tareamascotasc3.presentador;

import android.content.Context;

import com.curso.android.tareamascotasc3.db.ConstructorFotosMascota;
import com.curso.android.tareamascotasc3.pojos.Foto;
import com.curso.android.tareamascotasc3.vista.fragments.IRVFotosMascotaFragment;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 13/06/2016.
 */
public class RVFotosMascotaFragmentPresentador implements IRVFotosMascotaFragmentPresentador {

    private IRVFotosMascotaFragment irvFotosMascotaFragment;
    private Context context;
    private ConstructorFotosMascota constructorFotosMascota;
    private ArrayList<Foto> fotosMascota;

    public RVFotosMascotaFragmentPresentador(IRVFotosMascotaFragment irvPerfilMascotaFragment, Context context){
        this.irvFotosMascotaFragment = irvPerfilMascotaFragment;
        this.context = context;
        obtenerPerfilMascotaBD();
    }

    @Override
    public void obtenerPerfilMascotaBD() {
        constructorFotosMascota = new ConstructorFotosMascota(context);
        fotosMascota = constructorFotosMascota.obtenerDatos();

        mostrarPerfilMascotasRV();
    }

    @Override
    public void mostrarPerfilMascotasRV() {
        irvFotosMascotaFragment.inicializarAdaptadorRV(irvFotosMascotaFragment.crearAdaptador(fotosMascota));
        irvFotosMascotaFragment.generarLinearLayoutGrid();
    }
}
