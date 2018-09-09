package com.exampleandroiddemottest.petagramrecyclerviewWear.fragment;

import com.exampleandroiddemottest.petagramrecyclerviewWear.adapter.PetsAdapter;
import com.exampleandroiddemottest.petagramrecyclerviewWear.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public void generarGridLayout();

    public PetsAdapter crearAdaptador(ArrayList<Mascota> pets);

    public void inicializarOSetAdapterAlRecyclerView(PetsAdapter petsAdapter);
}
