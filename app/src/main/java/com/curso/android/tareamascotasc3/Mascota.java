package com.curso.android.tareamascotasc3;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DESARROLLO1 on 30/05/2016.
 */
public class Mascota implements Parcelable{
    private int fotoMascota;
    private int fotoHuesoBlanco;
    private int fotoHuesoAmarillo;
    private String nombre;
    private int votos;

    public Mascota(int foto, String nombre, int votos, int fotoHuesoBlanco, int fotoHuesoAmarillo){
        this.fotoMascota = foto;
        this.nombre = nombre;
        this.votos = votos;
        this.fotoHuesoBlanco = fotoHuesoBlanco;
        this.fotoHuesoAmarillo = fotoHuesoAmarillo;
    }

    protected Mascota(Parcel in) {
        nombre = in.readString();
        fotoMascota = in.readInt();
        fotoHuesoBlanco = in.readInt();
        fotoHuesoAmarillo = in.readInt();
        votos = in.readInt();
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVotos() {
        return String.valueOf(votos);
    }

    public void setVotos() {
        this.votos++;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int foto) {
        this.fotoMascota = foto;
    }

    public int getFotoHuesoBlanco() {
        return fotoHuesoBlanco;
    }

    public void setFotoHuesoBlanco(int fotoHuesoBlanco) {
        this.fotoHuesoBlanco = fotoHuesoBlanco;
    }

    public int getFotoHuesoAmarillo() {
        return fotoHuesoAmarillo;
    }

    public void setFotoHuesoAmarillo(int fotoHuesoAmarillo) {
        this.fotoHuesoAmarillo = fotoHuesoAmarillo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nombre);
        dest.writeInt(fotoMascota);
        dest.writeInt(fotoHuesoBlanco);
        dest.writeInt(fotoHuesoAmarillo);
        dest.writeInt(votos);
    }
}
