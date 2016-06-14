package com.curso.android.tareamascotasc3.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.curso.android.tareamascotasc3.db.ConstructorMascotas;
import com.curso.android.tareamascotasc3.pojos.Mascota;
import com.curso.android.tareamascotasc3.R;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 30/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> mascotasFavoritas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, ArrayList<Mascota> mascotasFavoritas, Activity activity) {
        this.activity = activity;
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
                /*if (Integer.valueOf(mascotas.get(position).getVotos()) == 0) {
                    mascotas.get(position).setVotos();
                    mascotaViewHolder.tvCantidad.setText(mascota.getVotos());
                    insertarFavorita(mascotas.get(position));
                }*/
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                String likes = String.valueOf(constructorMascotas.obtenerLikesMascota(mascota));

                mascotaViewHolder.tvCantidad.setText(likes);
            }
        });

    }

    @Override
    public int getItemCount() {
        //return 0;
        return mascotas.size();
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
