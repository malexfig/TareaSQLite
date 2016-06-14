package com.curso.android.tareamascotasc3.vista.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.curso.android.tareamascotasc3.Main2Activity;
import com.curso.android.tareamascotasc3.R;
import com.curso.android.tareamascotasc3.adapters.MascotaAdaptador;
import com.curso.android.tareamascotasc3.pojos.Mascota;
import com.curso.android.tareamascotasc3.presentador.IRecyclerViewFragmentPresentador;
import com.curso.android.tareamascotasc3.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragment {
    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView rvMascotas;
    private IRecyclerViewFragmentPresentador presentador;
    Button botonFavorito;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas);//Siempre debe ir antes del presentador
        inicializarDatos();//Siempre debe ir antes del presentador

        botonFavorito = (Button) getActivity().findViewById(R.id.btnFavorito);
        botonFavorito.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent actividadFavoritas = new Intent(getActivity(), Main2Activity.class);
                actividadFavoritas.putExtra("mascotas", mascotas);
                actividadFavoritas.putExtra("mascotasFavoritas", mascotasFavoritas);
                startActivity(actividadFavoritas);
            }
        });

        presentador = new RecyclerViewFragmentPresentador(this, getContext());

        // Inflate the layout for this fragment
        return view;
    }

    private void inicializarDatos(){
        if (getActivity().getIntent().getParcelableArrayListExtra("mascotas") != null)
            mascotas = getActivity().getIntent().getParcelableArrayListExtra("mascotas");
        /*else
            cargarMascotas();*/

        if (getActivity().getIntent().getParcelableArrayListExtra("mascotasFavoritas") != null)
            mascotasFavoritas = getActivity().getIntent().getParcelableArrayListExtra("mascotasFavoritas");
        else
            mascotasFavoritas = new ArrayList<>();
    }


    @Override
    public void generarLinearLayoutGrid() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, mascotasFavoritas, this.getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
