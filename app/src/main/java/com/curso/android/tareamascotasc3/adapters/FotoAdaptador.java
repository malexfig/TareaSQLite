package com.curso.android.tareamascotasc3.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.curso.android.tareamascotasc3.R;
import com.curso.android.tareamascotasc3.pojos.Foto;

import java.util.ArrayList;

/**
 * Created by admin on 12/06/2016.
 */
public class FotoAdaptador extends RecyclerView.Adapter<FotoAdaptador.FotoViewHolder> {

    ArrayList<Foto> fotosLista;
    Activity activity;

    public FotoAdaptador(ArrayList<Foto> fotos,Activity activity){
        this.fotosLista = fotos;
        this.activity = activity;
    }

    @Override
    public FotoAdaptador.FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto, parent, false);
        return new FotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FotoAdaptador.FotoViewHolder fotoViewHolder, int position) {
        final Foto foto = fotosLista.get(position);

        fotoViewHolder.imgFotoMascota.setImageResource(foto.getFoto());
        fotoViewHolder.tvLikes.setText(String.valueOf(foto.getLikes()));
    }

    @Override
    public int getItemCount() {
        return fotosLista.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoMascota;
        private TextView tvLikes;

        public FotoViewHolder(View itemView) {
            super(itemView);
            imgFotoMascota = (ImageView) itemView.findViewById(R.id.foto);
            tvLikes = (TextView) itemView.findViewById(R.id.likes);
        }
    }
}
