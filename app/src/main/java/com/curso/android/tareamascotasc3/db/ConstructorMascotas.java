package com.curso.android.tareamascotasc3.db;

import android.content.ContentValues;
import android.content.Context;

import com.curso.android.tareamascotasc3.R;
import com.curso.android.tareamascotasc3.pojos.Mascota;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 13/06/2016.
 */
public class ConstructorMascotas {

    Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        /*mascotas.add(new Mascota(R.drawable.m1, "perrito", 0, R.drawable.hueso, R.drawable.huesoamarillo));
        mascotas.add(new Mascota(R.drawable.m2, "cachorro", 0, R.drawable.hueso, R.drawable.huesoamarillo));
        mascotas.add(new Mascota(R.drawable.m3, "doberman", 0, R.drawable.hueso, R.drawable.huesoamarillo));
        mascotas.add(new Mascota(R.drawable.m4, "caballo", 0, R.drawable.hueso, R.drawable.huesoamarillo));
        mascotas.add(new Mascota(R.drawable.m5, "gato", 0, R.drawable.hueso, R.drawable.huesoamarillo));*/

        BaseDatos db = new BaseDatos(context);
        insertar5Mascotas(db);
        mascotas = db.obtenerMascotas();

        return mascotas;

    }

    public ArrayList<Mascota> obtenerFavoritas(){
        ArrayList<Mascota> favoritas;

        BaseDatos db = new BaseDatos(context);
        favoritas = db.obtenerMascotasFavoritas();

        return favoritas;

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, mascota.getVotos());

        db.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public void insertar5Mascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "perrito");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.m1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOBLANCO, R.drawable.hueso);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOAMARILLO, R.drawable.huesoamarillo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "cachorro");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.m2);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOBLANCO, R.drawable.hueso);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOAMARILLO, R.drawable.huesoamarillo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "doberman");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.m3);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOBLANCO, R.drawable.hueso);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOAMARILLO, R.drawable.huesoamarillo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "caballo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.m4);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOBLANCO, R.drawable.hueso);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOAMARILLO, R.drawable.huesoamarillo);

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "gato");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.m5);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOBLANCO, R.drawable.hueso);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOAMARILLO, R.drawable.huesoamarillo);

        db.insertarMascota(contentValues);
    }
}
