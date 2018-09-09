package com.exampleandroiddemottest.petagramrecyclerviewWear.restApi.model;

import com.exampleandroiddemottest.petagramrecyclerviewWear.pojo.Mascota;

import java.util.ArrayList;

public class MascotaResponse {

    ArrayList<Mascota> mascotas;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
