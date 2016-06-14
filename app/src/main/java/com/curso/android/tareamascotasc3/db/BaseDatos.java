package com.curso.android.tareamascotasc3.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.curso.android.tareamascotasc3.pojos.Mascota;

import java.util.ArrayList;

/**
 * Created by DESARROLLO1 on 13/06/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {
    Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOBLANCO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTOHUESOAMARILLO + " INTEGER"
                + ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ")" +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")"
                + ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);

    }

    public ArrayList<Mascota> obtenerMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);//null en lugar de filtro

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFotoMascota(registros.getInt(2));
            mascotaActual.setFotoHuesoBlanco(registros.getInt(3));
            mascotaActual.setFotoHuesoAmarillo(registros.getInt(4));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ") as likes" +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registroLikes = db.rawQuery(queryLikes, null);
            if (registroLikes.moveToNext()) {
                mascotaActual.setVotos(registroLikes.getInt(0));
            } else
                mascotaActual.setVotos(0);

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "select * from("+"SELECT " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ", COUNT(" +ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +"), id"+
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " GROUP BY " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA +
                " ORDER BY " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID +
                " DESC LIMIT 5 "+") order by id asc";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);//null en lugar de filtro

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setVotos(registros.getInt(1));

            String queryMascotas = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                                    " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + mascotaActual.getId();

            Cursor registroMascota = db.rawQuery(queryMascotas, null);

            if(registroMascota.moveToNext()){
                mascotaActual.setNombre(registroMascota.getString(1));
                mascotaActual.setFotoMascota(registroMascota.getInt(2));
                mascotaActual.setFotoHuesoBlanco(registroMascota.getInt(3));
                mascotaActual.setFotoHuesoAmarillo(registroMascota.getInt(4));
            }

            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;
    }

    public int obtenerLikesMascota(Mascota mascota) {
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()) {
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public void insertarMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }
}
