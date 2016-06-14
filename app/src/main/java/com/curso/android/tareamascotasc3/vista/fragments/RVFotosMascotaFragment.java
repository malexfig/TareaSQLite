package com.curso.android.tareamascotasc3.vista.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.curso.android.tareamascotasc3.R;
import com.curso.android.tareamascotasc3.adapters.FotoAdaptador;
import com.curso.android.tareamascotasc3.pojos.Foto;
import com.curso.android.tareamascotasc3.presentador.IRVFotosMascotaFragmentPresentador;
import com.curso.android.tareamascotasc3.presentador.RVFotosMascotaFragmentPresentador;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RVFotosMascotaFragment extends Fragment implements IRVFotosMascotaFragment {

    ArrayList<Foto> fotos;
    RecyclerView rvFotos;
    IRVFotosMascotaFragmentPresentador presentador;
    Context context;

    public RVFotosMascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rvperfil, container, false);
        rvFotos = (RecyclerView) view.findViewById(R.id.rvFotos);
        presentador = new RVFotosMascotaFragmentPresentador(this, context);
        return view;
    }

    @Override
    public void generarLinearLayoutGrid() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvFotos.setLayoutManager(glm);
    }

    @Override
    public FotoAdaptador crearAdaptador(ArrayList<Foto> fotos) {
        FotoAdaptador fotoAdaptador = new FotoAdaptador(fotos, getActivity());
        return fotoAdaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FotoAdaptador adaptador) {
        rvFotos.setAdapter(adaptador);
    }

}
