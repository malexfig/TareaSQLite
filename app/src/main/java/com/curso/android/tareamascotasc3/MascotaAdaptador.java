package com.curso.android.tareamascotasc3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 30/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotasFavoritas;
    //Constructor

    public MascotaAdaptador(ArrayList<Mascota> mascotas, ArrayList<Mascota> mascotasFavoritas) {

        this.mascotas = mascotas;
        this.mascotasFavoritas = mascotasFavoritas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        //return null;
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoMascota.setImageResource(mascota.getFotoMascota());
        mascotaViewHolder.imgHuesoBlanco.setImageResource(mascota.getFotoHuesoBlanco());
        mascotaViewHolder.imgHuesoAmarillo.setImageResource(mascota.getFotoHuesoAmarillo());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvCantidad.setText(mascota.getVotos());

        mascotaViewHolder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf(mascotas.get(position).getVotos()) == 0) {
                    mascotas.get(position).setVotos();
                    mascotaViewHolder.tvCantidad.setText(mascota.getVotos());
                    insertarFavorita(mascotas.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        //return 0;
        return mascotas.size();
    }

    private void insertarFavorita(Mascota mascota) {
        if (mascotasFavoritas.size() < 6) {
            mascotasFavoritas.add(mascota);
        } else {
            mascotasFavoritas.remove(0);
            mascotasFavoritas.add(mascota);
        }
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFotoMascota;
        private ImageView imgHuesoBlanco;
        private ImageView imgHuesoAmarillo;
        private TextView tvNombre;
        private TextView tvCantidad;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.imgFotoMascota);
            imgHuesoBlanco = (ImageView) itemView.findViewById(R.id.imgHuesoBlanco);
            imgHuesoAmarillo = (ImageView) itemView.findViewById(R.id.imgHuesoAmarillo);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvCantidad = (TextView) itemView.findViewById(R.id.tvCantidad);
        }
    }
}
