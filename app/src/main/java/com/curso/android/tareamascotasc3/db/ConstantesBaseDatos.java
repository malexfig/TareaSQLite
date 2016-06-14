package com.curso.android.tareamascotasc3.db;

/**
 * Created by DESARROLLO1 on 13/06/2016.
 */
public class ConstantesBaseDatos {
    public static final String DATABASE_NAME = "contactos";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS                   = "mascota";

    public static final String TABLE_MASCOTAS_ID                = "id";
    public static final String TABLE_MASCOTAS_NOMBRE            = "nombre";
    public static final String TABLE_MASCOTAS_FOTO              = "fotoMascota";
    public static final String TABLE_MASCOTAS_FOTOHUESOBLANCO   = "fotoHuesoBlanco";
    public static final String TABLE_MASCOTAS_FOTOHUESOAMARILLO = "fotoHuesoAmarillo";

    public static final String TABLE_LIKES_MASCOTA = "mascota_like";

    public static final String TABLE_LIKES_MASCOTA_ID           = "id";
    public static final String TABLE_LIKES_MASCOTA_ID_MASCOTA   = "id_mascota";
    public static final String TABLE_LIKES_MASCOTA_NUMERO_LIKES = "likes";
}
